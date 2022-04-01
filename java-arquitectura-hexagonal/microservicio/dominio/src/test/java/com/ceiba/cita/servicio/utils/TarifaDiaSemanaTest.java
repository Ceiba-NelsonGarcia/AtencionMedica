package com.ceiba.cita.servicio.utils;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class TarifaDiaSemanaTest {

    @Test
    @DisplayName("Deberia devolver el IdTarifa de acuerdo al dia de la semana")
    void deberiaDevolverElIdTarifaDeAcuerdoAlDiaDeLaSemana(){
        //Arrange
        Cita cita = new CitaTestDataBuilder().buildCita();
        TarifaDiaSemana tarifaDiaSemana = new TarifaDiaSemana();
        // Act - Assert
        assertEquals(3, tarifaDiaSemana.obtenerTarifaDiaSemana(cita));
    }

    @Test
    @DisplayName("Deberia devolver un valor idTarifa valido")
    void deberiaDevolverUnValosValidoIdTarifaValido(){
        // arrange
        Cita cita = new CitaTestDataBuilder().buildCita();
        TarifaDiaSemana tarifaDiaSemana = new TarifaDiaSemana();
        // Act - Assert
        assertEquals(3L, tarifaDiaSemana.validarDiasNoHabiles(7,3L));
    }

    @Test
    @DisplayName("Deberia devolver un valor idTarifa valido")
    void deberiaDevolverUnValorValidoIdTarifaCuandoSeEjecutaLaCondicion(){
        // arrange
        Cita cita = new CitaTestDataBuilder().buildCita();
        TarifaDiaSemana tarifaDiaSemana = new TarifaDiaSemana();
        // Act - Assert
        assertEquals(4L, tarifaDiaSemana.validarDiasNoHabiles(5,3L));
    }

    @Test
    @DisplayName("Deberia devolver un valor idTarifa valido")
    void deberiaDevolverUnValorValidoIdTarifaNoHabilCuandoSeEjecutaLaCondicion(){
        // arrange
        Cita cita = new CitaTestDataBuilder().buildCita();
        TarifaDiaSemana tarifaDiaSemana = new TarifaDiaSemana();
        // Act - Assert
        assertEquals(4L, tarifaDiaSemana.validarDiasNoHabiles(6,3L));
    }
}
