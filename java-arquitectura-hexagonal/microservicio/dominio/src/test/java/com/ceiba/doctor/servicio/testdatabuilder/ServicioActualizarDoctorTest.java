package com.ceiba.doctor.servicio.testdatabuilder;

import com.ceiba.BasePrueba;
import com.ceiba.doctor.modelo.entidad.Doctor;
import com.ceiba.doctor.puerto.repositorio.RepositorioDoctor;
import com.ceiba.doctor.servicio.ServicioActualizarDoctor;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioActualizarDoctorTest {

    @Test
    @DisplayName("Deberia validar la existencia previa del doctor")
    void deberiaValidarLaExistenciaPreviaDelDoctor() {
        // arrange
        Doctor doctor = new DoctorTestDataBuilder().conIdDoctor(1L).builDoctor();
        RepositorioDoctor repositorioDoctor = Mockito.mock(RepositorioDoctor.class);
        Mockito.when(repositorioDoctor.existeDoctorPorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarDoctor servicioActualizarDoctor = new ServicioActualizarDoctor(repositorioDoctor);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarDoctor.ejecutar(doctor), ExcepcionDuplicidad.class,"El no doctor existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Doctor doctor = new DoctorTestDataBuilder().conIdDoctor(1L).builDoctor();
        RepositorioDoctor repositorioDoctor = Mockito.mock(RepositorioDoctor.class);
        Mockito.when(repositorioDoctor.existeDoctorPorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarDoctor servicioActualizarDoctor = new ServicioActualizarDoctor(repositorioDoctor);
        // act
        servicioActualizarDoctor.ejecutar(doctor);
        //assert
        Mockito.verify(repositorioDoctor,Mockito.times(1)).actualizarDoctor(doctor);
    }
}
