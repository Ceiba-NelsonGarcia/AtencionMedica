package com.ceiba.horario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.horario.servicio.testdatabuilder.HorarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioExisteHorarioTest {

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la no existencia del Horario")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelHorario() {
        // arrange
        Horario horario = new HorarioTestDataBuilder().conIdHorario(1L).conNombreHorario("Regular").conHoraInicial(8).conHoraFinal(9).buildHorario();
        RepositorioHorario repositorioHorario = Mockito.mock(RepositorioHorario.class);
        Mockito.when(repositorioHorario.existeHorarioPorId(Mockito.anyLong())).thenReturn(false);
        ServicioExisteHorario servicioExisteHorario = new ServicioExisteHorario(repositorioHorario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioExisteHorario.entregarHorario(horario), ExcepcionDuplicidad.class,"El Horario no existe en el sistema");
    }
}
