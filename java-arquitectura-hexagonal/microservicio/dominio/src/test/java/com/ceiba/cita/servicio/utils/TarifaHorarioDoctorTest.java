package com.ceiba.cita.servicio.utils;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TarifaHorarioDoctorTest {

    @Test
    @DisplayName("Deberia devolver la tarifa del horario doctor si es Regular 0 Extra")
    void deberiaDevolverLaTarifaHorarioDelDoctorRegularExtra() {
        //arrange
        TarifaHorarioDoctor tarifaHorarioDoctor = new TarifaHorarioDoctor();
        //act - assert
        assertEquals(6L, tarifaHorarioDoctor.obtenerTarifaHorarioDoctor(0L));
        assertEquals(5L, tarifaHorarioDoctor.obtenerTarifaHorarioDoctor(1L));
        assertEquals(6L, tarifaHorarioDoctor.obtenerTarifaHorarioDoctor(3L));
    }

    @Test
    @DisplayName("Deberia devolver la tarifa del horario doctor si es Regular 0 Extra")
    void deberiaValidarLaTarifaDelDoctorDependiendoSiEsRegular() {
        //arrange
        TarifaHorarioDoctor tarifaHorarioDoctor = new TarifaHorarioDoctor();
        //act - assert
        assertEquals(5L, tarifaHorarioDoctor.validarHorarioRegular(1L,5L));
    }
}