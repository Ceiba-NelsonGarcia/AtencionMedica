package com.ceiba.cita.servicio.utils;

import java.time.LocalDate;

/**
 * Devuelve el número de día de la semana para determinar si es no habil 6 Sabado o 7 Domingo
 * */

public class DiaSemana {

    public static int obtenerNumeroDiaSemana(LocalDate fechaCita){

        fechaCita = LocalDate.now ();
        fechaCita = fechaCita.plusDays ( 1 );
        return fechaCita.getDayOfWeek ().getValue ();
    }
}
