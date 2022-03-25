package com.ceiba.horario.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.servicio.testdatabuilder.HorarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HorarioTest {

    @Test
    @DisplayName("Deberia crear correctamente la horario")
    void deberiaCrearCorrectamenteLaHorario() {
        // arrange
        //act
        Horario horario = new HorarioTestDataBuilder().conIdHorario(1L).conNombreHorario("Regular").conHoraInicial(8).conHoraFinal(9).buildHorario();
        //assert
        assertEquals(1L, horario.getIdHorario());
        assertEquals("Regular", horario.getNombreHorario());
        assertEquals(8, horario.getHoraInicial());
        assertEquals(9, horario.getHoraFinal());
    }

    @Test
    void deberiaFallarSinNombreDeHorario() {

        //Arrange
        HorarioTestDataBuilder horarioTestDataBuilder = new HorarioTestDataBuilder().conNombreHorario(null).conIdHorario(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    horarioTestDataBuilder.buildHorario();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre del horario");
    }

    @Test
    void deberiaFallarSinHoraInicialDeHorario() {

        //Arrange
        HorarioTestDataBuilder horarioTestDataBuilder = new HorarioTestDataBuilder().conHoraInicial(null).conIdHorario(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    horarioTestDataBuilder.buildHorario();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la hora inicial del horario");
    }

    @Test
    void deberiaFallarSinHoraFinalDeHorario() {

        //Arrange
        HorarioTestDataBuilder horarioTestDataBuilder = new HorarioTestDataBuilder().conHoraFinal(null).conIdHorario(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    horarioTestDataBuilder.buildHorario();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la hora final del horario");
    }
}
