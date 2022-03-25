package com.ceiba.doctor.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.doctor.modelo.entidad.Doctor;
import com.ceiba.doctor.servicio.testdatabuilder.DoctorTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DoctorTest {

    @Test
    @DisplayName("Deberia crear correctamente el doctor")
    void deberiaCrearCorrectamenteElDoctor() {
        // arrange
        //act
        Doctor doctor = new DoctorTestDataBuilder().conIdDoctor(1L).conNombreDoctor("Pedro").conIdTarifa(1L).conIdHorario(2L).builDoctor();
        //assert
        assertEquals(1L, doctor.getIdDoctor());
        assertEquals("Pedro", doctor.getNombreDoctor());
        assertEquals(1L, doctor.getIdTarifa());
        assertEquals(2L, doctor.getIdHorario());
    }
    // Validación de Campos nulos
    @Test
    void deberiaFallarSinNombreDeDoctor() {

        //Arrange
        DoctorTestDataBuilder doctorTestDataBuilder = new DoctorTestDataBuilder().conNombreDoctor(null).conIdDoctor(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    doctorTestDataBuilder.builDoctor();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre de doctor");
    }
    @Test
    void deberiaFallarSinTarifaDeDoctor() {

        //Arrange
        DoctorTestDataBuilder doctorTestDataBuilder = new DoctorTestDataBuilder().conIdTarifa(null).conIdDoctor(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    doctorTestDataBuilder.builDoctor();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la tarifa de doctor");
    }

    @Test
    void deberiaFallarSinHorarioDeDoctor() {

        //Arrange
        DoctorTestDataBuilder doctorTestDataBuilder = new DoctorTestDataBuilder().conIdHorario(null).conIdDoctor(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    doctorTestDataBuilder.builDoctor();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el horario de doctor");
    }
}
