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

    //se inyectan los objetos Dto al consultar la Base de datos
    private final DaoDoctor daoDoctor;
    private final DaoTarifa daoTarifa;

    public ValorCitaUSD(DaoDoctor daoDoctor, DaoTarifa daoTarifa) {
        this.daoDoctor = daoDoctor;
        this.daoTarifa = daoTarifa;
    }

    public Double obtenerValorCita(Cita cita) {

        Long valorDoctor;
        Long idTarifaDia;
        Long idTarifaHorario;
        Long porcentajeTarifaDia;
        Long porcentajeTarifaHora;
        long porcentajeTotalAdicional;
        double valorHorarioAdicional;
        double denominador = 100D;

        TarifaDiaSemana tarifaDiaSemana = new TarifaDiaSemana();
        TarifaHorarioDoctor tarifaHorarioDoctor = new TarifaHorarioDoctor();

        /**
         * Se extrae los datos del doctor con el cual se esta creando la cita
         * @param cita.getIdDoctor
         */
        List<DtoDoctor> dtoDoctor = this.daoDoctor.listarDoctorPorId(cita.getIdDoctor());
        if (dtoDoctor == null) {
            throw new ExcepcionSinDatos(EL_DOCTOR_NO_SE_ENCUENTRA_EN_LA_BASE_DE_DATOS);
        }

        /**
         * Se extrae los datos de la tarifa del doctor 1 General o 2 Especialista
         * @param dtoDoctor.get(0).getIdTarifa()
         */
        List<DtoTarifa> dtoTarifa = this.daoTarifa.listarTarifaPorId(dtoDoctor.get(0).getIdTarifa());
        if (dtoTarifa == null) {
            throw new ExcepcionSinDatos(LA_TARIFA_DEL_DOCTOR_NO_SE_ENCUENTRA_EN_LA_BASE_DE_DATOS);
        }
        valorDoctor = dtoTarifa.get(0).getValorTarifa();
        //Valida el porcentaje dependiedo si la cita se programada en dias habiles o no.
        idTarifaDia = tarifaDiaSemana.obtenerTarifaDia(cita);

        /**
         * Se extrae los datos de la tarifa si la cita es en un dia habil o no.
         * @param idTarifaDia
         */
        List<DtoTarifa> dtoTarifaDia = this.daoTarifa.listarTarifaPorId(idTarifaDia);
        if (dtoTarifaDia == null) {
            throw new ExcepcionSinDatos(LA_TARIFA_DE_DIAS_NO_HABILES_O_HABILES_NO_SE_ENCUENTRA_EN_LA_BASE_DE_DATOS);
        }
        porcentajeTarifaDia = dtoTarifaDia.get(0).getValorTarifa();
        //Se determina si el horario es extra o no
        idTarifaHorario = tarifaHorarioDoctor.obtenerTarifaHorarioDoctor(dtoDoctor.get(0).getIdHorario());

        /**
         * Se extrae los datos de la tarifa si la cita es en un dia habil o no.
         * @param idTarifaHorario
         */
        List<DtoTarifa> dtoTarifaHorario = this.daoTarifa.listarTarifaPorId(idTarifaHorario);
        if (dtoTarifaHorario == null) {
            throw new ExcepcionSinDatos(LA_TARIFA_DEL_HORARIO_NO_SE_ENCUENTRA_EN_LA_BASE_DE_DATOS);
        }

        porcentajeTarifaHora = dtoTarifaHorario.get(0).getValorTarifa();
        porcentajeTotalAdicional = porcentajeTarifaHora + porcentajeTarifaDia;
        valorHorarioAdicional = (valorDoctor * (porcentajeTotalAdicional / denominador));

        return valorDoctor + valorHorarioAdicional;
    }
}