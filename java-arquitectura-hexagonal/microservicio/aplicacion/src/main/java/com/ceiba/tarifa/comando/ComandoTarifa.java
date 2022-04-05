package com.ceiba.tarifa.comando;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoTarifa {

    private Long idTarifa;
    private String nombreTarifa;
    private Long valorTarifa;
}
