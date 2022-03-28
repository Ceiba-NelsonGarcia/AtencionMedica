package com.ceiba.cita.servicio.utils;

public class ConvertirUSDaCOP {

    private static final Double TRM = 3785D;

    public Double obtenerValorCOP(Double valorCitaUSD) {

        return TRM * valorCitaUSD;
    }

}
