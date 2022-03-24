package com.ceiba.cita.servicio;

import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarCitaTest {

    @Test
    @DisplayName("Deberia eliminar la cita llamando al repositorio")
    void deberiaEliminarLaCitaLlamandoAlRepositorio(){

        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        ServicioEliminarCita servicioEliminarCita = new ServicioEliminarCita(repositorioCita);

        servicioEliminarCita.ejecutar(1L);

        Mockito.verify(repositorioCita, Mockito.times(1)).eliminarCita(1L);
    }
}
