package com.ceiba.horario.modelo.entidad;

import lombok.Getter;

@Getter
public class Horario {

    private Long idHorario;
    private String nombreHorario;
    private Integer horaInicial;
    private Integer horaFinal;

    public Horario(Long idHorario, String horario, Integer horaInicial, Integer horaFinal) {
        this.idHorario = idHorario;
        this.nombreHorario = horario;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
    }
}

