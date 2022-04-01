package com.ceiba.cita.servicio.utils;

public class TarifaHorarioDoctor {

    private static final long HORARIO_REGULAR = 5L;
    private static final long HORARIO_EXTRA = 6L;

    public Long obtenerTarifaHorarioDoctor(Long idHorario){

        // Horario regular
        long idTarifaDoctor = HORARIO_REGULAR;

        if (idHorario != 1L) {
            //Horatio Extra
            idTarifaDoctor = HORARIO_EXTRA;
        }

        return idTarifaDoctor;
    }
}
