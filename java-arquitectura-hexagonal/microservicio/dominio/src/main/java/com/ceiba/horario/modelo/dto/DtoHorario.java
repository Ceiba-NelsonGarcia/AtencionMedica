package com.ceiba.horario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoHorario {
    private Long idHorario;
    private String horario;
    private int horaInicial;
    private int horaFinal;
}
