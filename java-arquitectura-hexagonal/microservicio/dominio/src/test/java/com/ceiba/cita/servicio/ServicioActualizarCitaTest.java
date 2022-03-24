package com.ceiba.cita.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioActualizarCitaTest {

    @Test
    @DisplayName("Deberia validar la existencia previa de la cita")
    void deberíaValidarLaExistenciaPreviaDeLaCita(){

        // arrange
        Cita cita = new CitaTestDataBuilder().conIdCita(1L).buildCita();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioCita.existeCitaPorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarCita servicioActualizarCita = new ServicioActualizarCita(repositorioCita);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCita.ejecutar(cita), ExcepcionDuplicidad.class, "La cita existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Cita cita = new CitaTestDataBuilder().conIdCita(1L).buildCita();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioCita.existeCitaPorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarCita servicioActualizarCita = new ServicioActualizarCita(repositorioCita);
        // act
        servicioActualizarCita.ejecutar(cita);
        //assert
        Mockito.verify(repositorioCita,Mockito.times(1)).actualizarCita(cita);
    }
}