package com.ceiba.cita.modelo.entidad;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Cita {

    private Long idCita;
    private Long idUsuario;
    private Long idDoctor;
    private LocalDate fechaCita;
    private int horaInicial;
    private int horaFinal;
    private Double valorUsd;
    private Double valorCop;

    public Cita(Long idCita, Long idUsuario, Long idDoctor, LocalDate fechaCita, int horaInicial, int horaFinal, Double valorUsd, Double valorCop) {
        this.idCita = idCita;
        this.idUsuario = idUsuario;
        this.idDoctor = idDoctor;
        this.fechaCita = fechaCita;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.valorUsd = valorUsd;
        this.valorCop = valorCop;
    }
}
