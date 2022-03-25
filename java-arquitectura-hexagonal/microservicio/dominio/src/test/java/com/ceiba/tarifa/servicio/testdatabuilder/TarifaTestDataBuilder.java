package com.ceiba.tarifa.servicio.testdatabuilder;

import com.ceiba.tarifa.modelo.entidad.Tarifa;

public class TarifaTestDataBuilder {

    private Long idTarifa;
    private String nombreTarifa;
    private Long valorTarifa;

    public TarifaTestDataBuilder() {
        this.idTarifa = 1L;
        this.nombreTarifa = "Regular";
        this.valorTarifa = 50L;
    }

    public TarifaTestDataBuilder conIdTarifa(Long idTarifa) {
        this.idTarifa = idTarifa;
        return this;
    }

    public TarifaTestDataBuilder conNombreTarifa(String nombreTarifa) {
        this.nombreTarifa = nombreTarifa;
        return this;
    }

    public TarifaTestDataBuilder conValorTarifa(Long valorTarifa) {
        this.valorTarifa = valorTarifa;
        return this;
    }

    public Tarifa buildTarifa() {
        return new Tarifa(idTarifa,nombreTarifa,valorTarifa);
    }
}
