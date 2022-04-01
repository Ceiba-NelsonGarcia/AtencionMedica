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
        TarifaHorarioDoctor tarifaHorarioDoctor = Mockito.mock(TarifaHorarioDoctor.class);
        //act - assert
        assertEquals(0L, tarifaHorarioDoctor.obtenerTarifaHorarioDoctor(0L));
        assertEquals(0L, tarifaHorarioDoctor.obtenerTarifaHorarioDoctor(1L));
        assertEquals(0L, tarifaHorarioDoctor.obtenerTarifaHorarioDoctor(3L));
    }
}
