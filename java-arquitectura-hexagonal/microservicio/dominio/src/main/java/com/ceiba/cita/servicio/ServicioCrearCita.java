package com.ceiba.cita.servicio;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearCita {

    private static final String EL_CITA_YA_EXISTE_EN_EL_SISTEMA = "El cita ya existe en el sistema";

    private final RepositorioCita repositorioCita;

    public ServicioCrearCita(RepositorioCita repositorioCita) {
        this.repositorioCita = repositorioCita;
    }

    public Long ejecutar(Cita cita) {
        validarExistenciaPrevia(cita);
        return this.repositorioCita.crearCita(cita);
    }

    private void validarExistenciaPrevia(Cita cita) {
        boolean existe = this.repositorioCita.existe(cita.getIdCita());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_CITA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
