package com.ceiba.horario.modelo.entidad;

import lombok.Getter;

@Getter
public class Horario {

    private Long idHorario;
    private String nombreHorario;
    private int horaInicial;
    private int horaFinal;

    public Horario(Long idHorario, String horario, int horaInicial, int horaFinal) {
        this.idHorario = idHorario;
        this.nombreHorario = horario;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
    }
}

