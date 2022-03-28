package com.ceiba.cita.servicio.utils;

import org.jetbrains.annotations.NotNull;
import java.time.LocalDate;

/**
 * Devuelve el número de día de la semana para determinar si es no habil 6 Sabado o 7 Domingo
 * */

public final class DiaSemana {

    private DiaSemana(){}

    public static int obtenerNumeroDiaSemana(@NotNull LocalDate fechaCita){

        return fechaCita.getDayOfWeek ().getValue ();
    }
}
