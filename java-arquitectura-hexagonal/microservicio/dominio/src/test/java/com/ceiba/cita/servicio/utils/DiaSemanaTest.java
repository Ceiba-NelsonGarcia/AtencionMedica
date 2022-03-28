package com.ceiba.cita.servicio.utils;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

class DiaSemanaTest {

    @Test
    @DisplayName("Deberia devolver el numero de dia de la semana correcto, dada una fecha")
    void deberiaDevolverElNumeroDeDíaDeLaSemanaCorrectoDadaUnaFecha() {
        //arrange
        Cita cita = new CitaTestDataBuilder().buildCita();
        DiaSemana diaSemana = Mockito.mock(DiaSemana.class);
        LocalDate fechaCita1 = LocalDate.parse("2022-03-28");
        LocalDate fechaCita2 = LocalDate.parse("2022-03-29");
        //act - assert
        assertEquals(4, DiaSemana.obtenerNumeroDiaSemana(cita.getFechaCita()));
        assertEquals(1, DiaSemana.obtenerNumeroDiaSemana(fechaCita1));
        assertEquals(2, DiaSemana.obtenerNumeroDiaSemana(fechaCita2));
    }
}
