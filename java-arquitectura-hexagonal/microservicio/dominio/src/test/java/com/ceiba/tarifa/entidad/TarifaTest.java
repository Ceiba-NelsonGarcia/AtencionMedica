package com.ceiba.tarifa.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.tarifa.modelo.entidad.Tarifa;
import com.ceiba.tarifa.servicio.testdatabuilder.TarifaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TarifaTest {

    @Test
    @DisplayName("Deberia crear correctamente la tarifa")
    void deberiaCrearCorrectamenteLaTarifa() {
        // arrange
        //act
        Tarifa tarifa = new TarifaTestDataBuilder().conIdTarifa(1L).conNombreTarifa("Regular").conValorTarifa(50L).buildTarifa();
        //assert
        assertEquals(1L, tarifa.getIdTarifa());
        assertEquals("Regular", tarifa.getNombreTarifa());
        assertEquals(50L, tarifa.getValorTarifa());
    }

    @Test
    void deberiaFallarSinNombreDeTarifa() {

        //Arrange
        TarifaTestDataBuilder tarifaTestDataBuilder = new TarifaTestDataBuilder().conNombreTarifa(null).conIdTarifa(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    tarifaTestDataBuilder.buildTarifa();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre de la tarifa");
    }

    @Test
    void deberiaFallarSinValorDeTarifa() {

        //Arrange
        TarifaTestDataBuilder tarifaTestDataBuilder = new TarifaTestDataBuilder().conValorTarifa(null).conIdTarifa(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    tarifaTestDataBuilder.buildTarifa();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el valor de la tarifa");
    }
}
