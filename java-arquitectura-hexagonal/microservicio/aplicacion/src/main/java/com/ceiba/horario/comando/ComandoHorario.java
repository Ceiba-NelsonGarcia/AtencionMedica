package com.ceiba.horario.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoHorario {

    private Long idHorario;
    private String horario;
    private int horaInicial;
    private int horaFinal;

}
