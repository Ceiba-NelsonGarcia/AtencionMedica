package com.ceiba.tarifa.modelo.entidad;

import lombok.Getter;

@Getter
public class Tarifa {
    private Long idTarifa;
    private String tarifa;
    private Long valorTarifa;

    public Tarifa(Long idTarifa, String tarifa, Long valorTarifa) {
        this.idTarifa = idTarifa;
        this.tarifa = tarifa;
        this.valorTarifa = valorTarifa;
    }
}
