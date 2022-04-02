package com.ceiba.doctor.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.doctor.modelo.entidad.Doctor;
import com.ceiba.doctor.puerto.repositorio.RepositorioDoctor;
import com.ceiba.doctor.servicio.testdatabuilder.DoctorTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioCrearDoctorTest {

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del Doctor")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelDoctor() {
        // arrange
        Doctor doctor = new DoctorTestDataBuilder().builDoctor();
        RepositorioDoctor repositorioDoctor = Mockito.mock(RepositorioDoctor.class);
        Mockito.when(repositorioDoctor.existeDoctorPorId(Mockito.anyLong())).thenReturn(true);
        ServicioCrearDoctor servicioCrearDoctor = new ServicioCrearDoctor(repositorioDoctor);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearDoctor.ejecutar(doctor), ExcepcionDuplicidad.class,"El doctor ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia Crear el doctor de manera correcta")
    void deberiaCrearElDoctorDeManeraCorrecta() {
        // arrange
        Doctor doctor = new DoctorTestDataBuilder().builDoctor();
        RepositorioDoctor repositorioDoctor = Mockito.mock(RepositorioDoctor.class);
        Mockito.when(repositorioDoctor.existeDoctorPorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioDoctor.crearDoctor(doctor)).thenReturn(10L);
        ServicioCrearDoctor servicioCrearDoctor = new ServicioCrearDoctor(repositorioDoctor);
        // act
        Long idDoctor = servicioCrearDoctor.ejecutar(doctor);
        //- assert
        assertEquals(10L,idDoctor);
        Mockito.verify(repositorioDoctor, Mockito.times(1)).crearDoctor(doctor);
    }
}
