package com.ceiba.cita.servicio.utils;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.doctor.modelo.dto.DtoDoctor;
import com.ceiba.doctor.puerto.dao.DaoDoctor;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.tarifa.modelo.dto.DtoTarifa;
import com.ceiba.tarifa.puerto.dao.DaoTarifa;
import java.util.List;

public class ValorCitaUSD {

    private static final String EL_DOCTOR_NO_SE_ENCUENTRA_EN_LA_BASE_DE_DATOS = "El doctor no se  en la base de datos";
    private static final String LA_TARIFA_DEL_DOCTOR_NO_SE_ENCUENTRA_EN_LA_BASE_DE_DATOS = "La tarifa del doctor no se encuentra en la base de datos";
    private static final String LA_TARIFA_DE_DIAS_NO_HABILES_O_HABILES_NO_SE_ENCUENTRA_EN_LA_BASE_DE_DATOS = "La tarifa de dias no habiles o habiles no se encuentra en la base de datos";
    private static final String LA_TARIFA_DEL_HORARIO_NO_SE_ENCUENTRA_EN_LA_BASE_DE_DATOS = "La tarifa del horario no se encuentra en la base de datos";
    private static final double DENOMINADOR = 100D;

    // Se inyecta los objetos Dao para consultar la base de datos
    private DaoDoctor daoDoctor;
    private DaoTarifa daoTarifa;

    List<DtoDoctor> dtoDoctores;

    public ValorCitaUSD(DaoDoctor daoDoctor, DaoTarifa daoTarifa) {
        this.daoDoctor = daoDoctor;
        this.daoTarifa = daoTarifa;
    }

    public Double obtenerValorCita(Cita cita) {

        TarifaDiaSemana tarifaDiaSemana = new TarifaDiaSemana();
        TarifaHorarioDoctor tarifaHorarioDoctor = new TarifaHorarioDoctor();

        Long idTarifaDoctor = obtenerIdTarifaDoctor(cita);
        Long valorTarifaDoctor = obtenerValorTarifaDoctor(idTarifaDoctor);

        Long idTarifaDiaSemana = tarifaDiaSemana.obtenerTarifaDiaSemana(cita);
        Long porcentajeTarifaDiaHabil = obtenerPorcentajeTarifaDiaHabil(idTarifaDiaSemana);

        Long idTarifaHorario = tarifaHorarioDoctor.obtenerTarifaHorarioDoctor(dtoDoctores.get(0).getIdHorario());
        Long porcentajeTarifaHora = obtenerporcentajeTarifaHora(idTarifaHorario);

        long porcentajeTotalAdicional = porcentajeTarifaHora + porcentajeTarifaDiaHabil;
        double valorHorarioAdicional = (valorTarifaDoctor * (porcentajeTotalAdicional / DENOMINADOR));

        return valorTarifaDoctor + valorHorarioAdicional;
    }

    // Metodos para extraccion de datos desde la base de datos
    protected Long obtenerIdTarifaDoctor(Cita cita) {
        this.dtoDoctores = this.daoDoctor.listarDoctorPorId(cita.getIdDoctor());
        if (dtoDoctores == null) {
            throw new ExcepcionSinDatos(EL_DOCTOR_NO_SE_ENCUENTRA_EN_LA_BASE_DE_DATOS);
        }
        return dtoDoctores.get(0).getIdTarifa();
    }

    protected Long obtenerValorTarifaDoctor(Long idTarifaDoctor){
        List<DtoTarifa> dtoTarifaDoctores;
        dtoTarifaDoctores = this.daoTarifa.listarTarifaPorId(idTarifaDoctor);
        if (dtoTarifaDoctores == null) {
            throw new ExcepcionSinDatos(LA_TARIFA_DEL_DOCTOR_NO_SE_ENCUENTRA_EN_LA_BASE_DE_DATOS);
        }
        return dtoTarifaDoctores.get(0).getValorTarifa();
    }

    protected Long obtenerPorcentajeTarifaDiaHabil(Long idTarifaDiaSemana) {
        List<DtoTarifa> dtoTarifasDiasHabiles;
        dtoTarifasDiasHabiles = this.daoTarifa.listarTarifaPorId(idTarifaDiaSemana);
        if (dtoTarifasDiasHabiles == null) {
            throw new ExcepcionSinDatos(LA_TARIFA_DE_DIAS_NO_HABILES_O_HABILES_NO_SE_ENCUENTRA_EN_LA_BASE_DE_DATOS);
        }
        return dtoTarifasDiasHabiles.get(0).getValorTarifa();
    }

    protected Long obtenerporcentajeTarifaHora(Long idTarifaHorario) {
        List<DtoTarifa> dtoTarifasHorario;
        dtoTarifasHorario = this.daoTarifa.listarTarifaPorId(idTarifaHorario);
        if (dtoTarifasHorario == null) {
            throw new ExcepcionSinDatos(LA_TARIFA_DEL_HORARIO_NO_SE_ENCUENTRA_EN_LA_BASE_DE_DATOS);
        }
        return dtoTarifasHorario.get(0).getValorTarifa();
    }
}