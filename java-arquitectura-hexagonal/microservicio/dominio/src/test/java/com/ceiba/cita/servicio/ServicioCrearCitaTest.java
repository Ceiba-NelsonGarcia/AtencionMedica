package com.ceiba.cita.servicio;

import com.ceiba.cita.servicio.utils.DiaSemana;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearCitaTest {
    @Test
    @DisplayName("Deberia devolver el numero de dia de la semana correcto, dada una fecha")
    void deberiaDevolveElNumeroDeDíaDeLaSemanaCorrectoDadaUnaFecha() {
        //arrange
        LocalDate fechaCita = LocalDate.parse("2022-03-24");
        //act - assert
        assertEquals(5, DiaSemana.obtenerNumeroDiaSemana(fechaCita));

    }
}
