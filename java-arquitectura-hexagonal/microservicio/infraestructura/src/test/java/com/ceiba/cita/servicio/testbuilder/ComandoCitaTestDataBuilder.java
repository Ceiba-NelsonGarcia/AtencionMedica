package com.ceiba.cita.servicio.testbuilder;

import com.ceiba.cita.comando.ComandoCita;
import java.time.LocalDate;

public class ComandoCitaTestDataBuilder {

    private Long idCita;
    private Long idUsuario;
    private Long idDoctor;
    private LocalDate fechaCita;
    private Integer horaInicial;
    private Integer horaFinal;
    private Double valorUsd;
    private Double valorCop;

    public ComandoCitaTestDataBuilder() {
        idUsuario = 1L;
        idDoctor = 1L;
        fechaCita = LocalDate.parse("2022-04-05");
        horaInicial = 8;
        horaFinal = 9;
        valorUsd = 51D;
        valorCop = 185000D;
    }

    public ComandoCitaTestDataBuilder conIdCita(Long idUsuario, Long idDoctor, LocalDate fechaCita, Integer horaInicial, Integer horaFinal, Double valorUsd, Double valorCop) {
        this.idUsuario = idUsuario;
        this.idDoctor = idDoctor;
        this.fechaCita = fechaCita;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.valorUsd = valorUsd;
        this.valorCop = valorCop;
        return this;
    }

    public ComandoCita build(){
        return  new ComandoCita(idCita, idUsuario, idDoctor, fechaCita, horaInicial, horaFinal, valorUsd, valorCop);
    }
}
