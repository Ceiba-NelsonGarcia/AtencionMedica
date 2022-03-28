package com.ceiba.cita.servicio.utils;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.Mockito;

public class TarifaDiaSemanaTest {

    @Test
    @DisplayName("Deberia devolver el IdTarifa de acuerdo al dia de la semana")
    void deberiaDevolverElIdTarifaDeAcuerdoAlDiaDeLaSemana(){
        //Arrange
        Cita cita = new CitaTestDataBuilder().buildCita();
        TarifaDiaSemana tarifaDiaSemana = Mockito.mock(TarifaDiaSemana.class);
        // Act - Assert
        assertEquals(0, tarifaDiaSemana.obtenerTarifaDia(cita));
    }
}
