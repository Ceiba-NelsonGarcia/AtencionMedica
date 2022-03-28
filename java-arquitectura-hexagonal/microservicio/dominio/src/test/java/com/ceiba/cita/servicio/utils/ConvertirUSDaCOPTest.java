package com.ceiba.cita.servicio.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConvertirUSDaCOPTest {

    @Test
    @DisplayName("Deberia devolver el valor de la cita en USD convertido a COP")
    void DeberiaDevolverElValorDeLaCitaEnUsdConvertidoACop(){
        //arrange
        double valorCitaUSD;
        valorCitaUSD = 100D;

        ConvertirUSDaCOP convertirUSDaCOP = new ConvertirUSDaCOP();

        //act - assert
        assertEquals(378500D, convertirUSDaCOP.obtenerValorCOP(valorCitaUSD));
    }

}
