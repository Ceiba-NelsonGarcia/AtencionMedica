package com.ceiba.cita.servicio.utils;

import com.ceiba.cita.modelo.entidad.Cita;

public class TarifaDiaSemana {

    public Long obtenerTarifaDia(Cita cita){

        int numeroDia;
        long idTarifa = 3L;

        numeroDia = DiaSemana.obtenerNumeroDiaSemana(cita.getFechaCita());

        // Si el día es 5 Sabado o 6 Domingo el porcentaje de la tarifa es No habil
        if (numeroDia == 5 || numeroDia == 6) {
            idTarifa = 4L;
        }

        return idTarifa;
    }
}
