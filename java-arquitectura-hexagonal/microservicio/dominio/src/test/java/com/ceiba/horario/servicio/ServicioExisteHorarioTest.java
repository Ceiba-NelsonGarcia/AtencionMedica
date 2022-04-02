package com.ceiba.horario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.horario.servicio.testdatabuilder.HorarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ServicioExisteHorarioTest {

    @Test
    @DisplayName("Deberia true, cuando se valide la no existencia del Horario")
    void deberiaDevolverTrueCuandoSeValideLaExistenciaDelHorario() {
        // arrange
        Horario horario = new HorarioTestDataBuilder()
                .conIdHorario(1L).conNombreHorario("Regular").conHoraInicial(8).conHoraFinal(9).buildHorario();
        RepositorioHorario repositorioHorario = Mockito.mock(RepositorioHorario.class);
        Mockito.when(repositorioHorario.existeHorarioPorId(Mockito.any())).thenReturn(true);
        ServicioExisteHorario servicioExisteHorario = new ServicioExisteHorario(repositorioHorario);
        // act - assert
        assertTrue(servicioExisteHorario.entregarHorario(horario));
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la no existencia del Horario")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelHorario() {
        // arrange
        Horario horario = new HorarioTestDataBuilder()
                .conIdHorario(1L).conNombreHorario("Regular").conHoraInicial(8).conHoraFinal(9).buildHorario();
        RepositorioHorario repositorioHorario = Mockito.mock(RepositorioHorario.class);
        Mockito.when(repositorioHorario.existeHorarioPorId(Mockito.any())).thenReturn(false);
        ServicioExisteHorario servicioExisteHorario = new ServicioExisteHorario(repositorioHorario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioExisteHorario.entregarHorario(horario),
                ExcepcionDuplicidad.class,"El Horario no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia devolver true, cuando se valide la no existencia del Horario")
    void deberiaDevolverTrueCuandoSeEjecutaValidarExistenciaPreviaHorario() {
        // arrange
        Horario horario = new HorarioTestDataBuilder()
                .conIdHorario(1L).conNombreHorario("Regular").conHoraInicial(8).conHoraFinal(9).buildHorario();
        RepositorioHorario repositorioHorario = Mockito.mock(RepositorioHorario.class);
        Mockito.when(repositorioHorario.existeHorarioPorId(Mockito.any())).thenReturn(true);
        ServicioExisteHorario servicioExisteHorario = new ServicioExisteHorario(repositorioHorario);
        // act - assert
        assertTrue(servicioExisteHorario.validarExistenciaPreviaHorario(horario));
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la no existencia del Horario")
    void deberiaLanzarUnaExcepcionCuandoSeEjecutaValidarExistenciaPreviaHorario() {
        // arrange
        Horario horario = new HorarioTestDataBuilder()
                .conIdHorario(1L).conNombreHorario("Regular").conHoraInicial(8).conHoraFinal(9).buildHorario();
        RepositorioHorario repositorioHorario = Mockito.mock(RepositorioHorario.class);
        Mockito.when(repositorioHorario.existeHorarioPorId(Mockito.any())).thenReturn(false);
        ServicioExisteHorario servicioExisteHorario = new ServicioExisteHorario(repositorioHorario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioExisteHorario.validarExistenciaPreviaHorario(horario),
                ExcepcionDuplicidad.class,"El Horario no existe en el sistema");
    }
}
