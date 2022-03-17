package com.ceiba.tarifa.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoTarifa {
    private Long idTarifa;
    private String tarifa;
    private Long valorTarifa;
}
