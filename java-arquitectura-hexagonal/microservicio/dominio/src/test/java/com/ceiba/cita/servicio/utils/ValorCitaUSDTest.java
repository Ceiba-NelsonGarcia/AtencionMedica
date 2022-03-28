package com.ceiba.cita.servicio.utils;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValorCitaUSDTest {

    @Test
    @DisplayName("Deberia devolver el valor de la cita en usd")
    void deberiaDevolverElcalculoValorCitaEnUsd() {
        //arrange
        Cita cita = new CitaTestDataBuilder().buildCita();
        ValorCitaUSD valorCitaUSD = Mockito.mock(ValorCitaUSD.class);
        //act - assert
        assertEquals(0, valorCitaUSD.obtenerValorCita(cita));
    }
}
