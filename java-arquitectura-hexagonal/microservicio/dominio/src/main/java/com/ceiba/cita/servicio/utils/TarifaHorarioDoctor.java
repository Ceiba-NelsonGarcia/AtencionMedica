package com.ceiba.cita.servicio.utils;

public class TarifaHorarioDoctor {

    public Long obtenerTarifaHorarioDoctor(Long idHorario){

        // Horario regular
        long idTarifaDoctor = 5L;

        if (idHorario != 1L) {
            //Horatio Extra
            idTarifaDoctor = 6L;
        }

        return idTarifaDoctor;
    }
}
