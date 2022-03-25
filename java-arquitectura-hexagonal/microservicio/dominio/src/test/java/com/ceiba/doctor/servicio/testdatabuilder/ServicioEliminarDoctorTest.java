package com.ceiba.doctor.servicio.testdatabuilder;

import com.ceiba.doctor.puerto.repositorio.RepositorioDoctor;
import com.ceiba.doctor.servicio.ServicioEliminarDoctor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarDoctorTest {

    @Test
    @DisplayName("Deberia eliminar el doctor llamando al repositorio")
    void deberiaEliminarElDoctorLlamandoAlRepositorio() {
        RepositorioDoctor repositorioDoctor = Mockito.mock(RepositorioDoctor.class);
        ServicioEliminarDoctor servicioEliminarDoctor = new ServicioEliminarDoctor(repositorioDoctor);

        servicioEliminarDoctor.ejecutar(1L);

        Mockito.verify(repositorioDoctor, Mockito.times(1)).eliminarDoctor(1L);

    }
}
