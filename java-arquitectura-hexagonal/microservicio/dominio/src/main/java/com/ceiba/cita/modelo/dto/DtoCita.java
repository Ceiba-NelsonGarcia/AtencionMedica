package com.ceiba.cita.modelo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoCita {

    private Long idCita;
    private Long idUsuario;
    private Long idDoctor;
    private LocalDate fechaCita;
    private Integer horaInicial;
    private Integer horaFinal;
    private Double valorUsd;
    private Double valorCop;

}
