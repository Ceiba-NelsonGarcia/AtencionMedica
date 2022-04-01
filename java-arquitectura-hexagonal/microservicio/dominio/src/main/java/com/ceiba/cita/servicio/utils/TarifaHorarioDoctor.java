package com.ceiba.cita.servicio.utils;

public class TarifaHorarioDoctor {

    private static final long HORARIO_REGULAR = 5L;
    private static final long HORARIO_EXTRA = 6L;
    private static final long VALIDAR_HORARIO_REGULAR = 1L;

    public Long obtenerTarifaHorarioDoctor(Long idHorario){

        // Horario regular
        return validarHorarioRegular(idHorario, HORARIO_REGULAR);
    }

    Long validarHorarioRegular(Long idHorario, Long idTarifaDoctor){

        if (idHorario != VALIDAR_HORARIO_REGULAR) {
            //Horatio Extra
            idTarifaDoctor = HORARIO_EXTRA;
        }
        return idTarifaDoctor;
    }
}
