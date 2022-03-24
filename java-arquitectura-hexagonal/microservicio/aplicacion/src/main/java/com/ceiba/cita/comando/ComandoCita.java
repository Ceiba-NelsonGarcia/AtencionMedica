package com.ceiba.cita.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCita {

    private Long idCita;
    private Long idUsuario;
    private Long idDoctor;
    private LocalDate fechaCita;
    private Integer horaInicial;
    private Integer horaFinal;
    private Double valorUsd;
    private Double valorCop;
}
