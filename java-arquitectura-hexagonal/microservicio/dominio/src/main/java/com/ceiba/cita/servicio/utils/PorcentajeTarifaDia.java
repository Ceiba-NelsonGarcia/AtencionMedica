package com.ceiba.cita.servicio.utils;

import com.ceiba.cita.modelo.entidad.Cita;

public class PorcentajeTarifaDia {

    private Cita cita;

    public Long obtenerPorcentajeTarifaDia(Cita cita){

        int numeroDia;
        Long idTarifaDia;
        Long porcentajeTarifa = 0L;


        numeroDia = DiaSemana.obtenerNumeroDiaSemana(cita.getFechaCita());

        // Si el día es 5 Sabado o 6 Domingo el porcentaje de la tarifa es No habil
        if (numeroDia == 5 || numeroDia == 6) {

            idTarifaDia = 4L;
            //porcentajeTarifa = tarifa.getValorTarifa(idTarifaDia);

        }else{
            porcentajeTarifa = 0L;
        }


        return porcentajeTarifa;
    }
}
