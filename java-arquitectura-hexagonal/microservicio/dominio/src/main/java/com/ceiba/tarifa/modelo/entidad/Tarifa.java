package com.ceiba.tarifa.modelo.entidad;

import lombok.Getter;

@Getter
public class Tarifa {
    private Long idTarifa;
    private String nombreTarifa;
    private Long valorTarifa;

    public Tarifa(Long idTarifa, String nombreTarifa, Long valorTarifa) {
        this.idTarifa = idTarifa;
        this.nombreTarifa = nombreTarifa;
        this.valorTarifa = valorTarifa;
    }
}
