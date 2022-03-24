package com.ceiba.cita.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CitaTest {

    @Test
    @DisplayName("Deberia crear correctamente la Cita")
    void deberiaCrearCorrectamenteLaCita(){

        // arrange
        LocalDate fechaCita = LocalDate.parse("2202-03-24");
        // act
        Cita cita = new CitaTestDataBuilder()
                        .conIdCita(1L).conIdUsuario(2L).conIdDoctor(3L).conFechaCita(fechaCita)
                        .conHoraInicial(8).conHoraFinal(9).conValorUsd(10D).conValorCop(40000D)
                        .buildCita();
        // assert
        assertEquals(1L,cita.getIdCita());
        assertEquals(2L,cita.getIdUsuario());
        assertEquals(3L,cita.getIdDoctor());
        assertEquals(fechaCita,cita.getFechaCita());
        assertEquals(8,cita.getHoraInicial());
        assertEquals(9,cita.getHoraFinal());
        assertEquals(10,cita.getValorUsd());
        assertEquals(40000,cita.getValorCop());
    }

    @Test
    void deberiaFallarSinIdUsuario(){

        // arrange
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().conIdUsuario(null).conIdCita(1L);
        // act - assert
        BasePrueba.assertThrows(()->{
            citaTestDataBuilder.buildCita();
        },
                ExcepcionValorObligatorio.class, "Se debe ingresar el idUsuario de usuario");
    }

    @Test
    void deberiaFallarSinIdDoctor(){

        // arrange
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().conIdDoctor(null).conIdCita(1L);
        // act - assert
        BasePrueba.assertThrows(()->{
                    citaTestDataBuilder.buildCita();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el idDoctor de doctor");
    }

    @Test
    void deberiaFallarSinFechaCita(){

        // arrange
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().conFechaCita(null).conIdCita(1L);
        // act - assert
        BasePrueba.assertThrows(()->{
                    citaTestDataBuilder.buildCita();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la FechaCita de la Cita");
    }

    @Test
    void deberiaFallarSinHoraInicial(){

        // arrange
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().conHoraInicial(0).conIdCita(1L);
        // act - assert
        BasePrueba.assertThrows(()->{
                    citaTestDataBuilder.buildCita();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la HoraInicial de la Cita");
    }

    @Test
    void deberiaFallarSinHoraFinal(){

        // arrange
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().conHoraFinal(0).conIdCita(1L);
        // act - assert
        BasePrueba.assertThrows(()->{
                    citaTestDataBuilder.buildCita();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la HoraFinal de la Cita");
    }

}
