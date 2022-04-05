package com.ceiba.cita.servicio;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.utils.ConvertirUSDaCOP;
import com.ceiba.cita.servicio.utils.ValorCitaUSD;
import com.ceiba.doctor.puerto.dao.DaoDoctor;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tarifa.puerto.dao.DaoTarifa;

/**
 * @author nelson.garcia
 * Se crea la lógica de negocio para crer la cita
 * */

public class ServicioCrearCita {

    private static final String LA_CITA_YA_EXISTE_EN_EL_SISTEMA = "La cita ya existe en el sistema";

    private final RepositorioCita repositorioCita;
    private final DaoDoctor daoDoctor;
    private final DaoTarifa daoTarifa;

    public ServicioCrearCita(RepositorioCita repositorioCita, DaoDoctor daoDoctor, DaoTarifa daoTarifa) {
        this.repositorioCita = repositorioCita;
        this.daoDoctor = daoDoctor;
        this.daoTarifa = daoTarifa;
    }

    public Long ejecutar(Cita cita) {

        validarExistenciaPrevia(cita);

        //Calcula el valor de la cita en USD
        Double valorCita = obtenerValorCitaUSD(cita);
        cita.setValorUsd(valorCita);
        cita.setValorCop(obtenerValorCitaCOP(valorCita));

        return this.repositorioCita.crearCita(cita);
    }

    boolean validarExistenciaPrevia(Cita cita) {
        boolean existe = this.repositorioCita.existeCitaPorId(cita.getIdCita());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_CITA_YA_EXISTE_EN_EL_SISTEMA);
        }
        return existe;
    }

    Double obtenerValorCitaUSD(Cita cita){
        ValorCitaUSD valorCitaUSD = new ValorCitaUSD(daoDoctor, daoTarifa);
        return valorCitaUSD.obtenerValorCita(cita);
    }

    Double obtenerValorCitaCOP(Double valorCita){
        ConvertirUSDaCOP convertirUSDaCOP = new ConvertirUSDaCOP();
        return convertirUSDaCOP.obtenerValorCOP(valorCita);
    }

}
