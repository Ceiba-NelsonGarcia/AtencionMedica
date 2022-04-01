package com.ceiba.cita.servicio.utils;

import com.ceiba.cita.modelo.entidad.Cita;

public class TarifaDiaSemana {

    private static final int SABADO = 5;
    private static final int DOMINGO = 6;
    private static final long TARIFA_DIA_NO_HABIL = 4;
    private static final long TARIFA_DIA_HABIL = 3;

    public Long obtenerTarifaDiaSemana(Cita cita){

        int numeroDia;
        long idTarifa = TARIFA_DIA_HABIL;

        numeroDia = DiaSemana.obtenerNumeroDiaSemana(cita.getFechaCita());

        // Si el día es 5 Sabado o 6 Domingo el porcentaje de la tarifa es No habil
        if (numeroDia == SABADO || numeroDia == DOMINGO) {
            idTarifa = TARIFA_DIA_NO_HABIL;
        }

        return idTarifa;
    }
}
