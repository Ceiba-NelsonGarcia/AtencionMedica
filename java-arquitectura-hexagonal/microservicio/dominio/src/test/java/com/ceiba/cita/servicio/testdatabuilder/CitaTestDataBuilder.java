package com.ceiba.cita.servicio.testdatabuilder;

import com.ceiba.cita.modelo.entidad.Cita;

import java.time.LocalDate;

public class CitaTestDataBuilder {

    private Long idCita;
    private Long idUsuario;
    private Long idDoctor;
    private LocalDate fechaCita;
    private Integer horaInicial;
    private Integer horaFinal;
    private Double valorUsd;
    private Double valorCop;

    public CitaTestDataBuilder() {

        idCita = 1L;
        idUsuario = 2L;
        idDoctor = 3L;
        fechaCita = LocalDate.parse("2202-03-24");
        horaInicial = 8;
        horaFinal = 9;
        valorUsd = 10D;
        valorCop = 40000D;
    }

    public CitaTestDataBuilder conIdCita(Long idCita) {
        this.idCita = idCita;
        return this;
    }

    public CitaTestDataBuilder conIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public CitaTestDataBuilder conIdDoctor(Long idDoctor) {
        this.idDoctor = idDoctor;
        return this;
    }

    public CitaTestDataBuilder conFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
        return this;
    }

    public CitaTestDataBuilder conHoraInicial(Integer horaInicial) {
        this.horaInicial = horaInicial;
        return this;
    }

    public CitaTestDataBuilder conHoraFinal(Integer horaFinal) {
        this.horaFinal = horaFinal;
        return this;
    }

    public CitaTestDataBuilder conValorUsd(Double valorUsd) {
        this.valorUsd = valorUsd;
        return this;
    }

    public CitaTestDataBuilder conValorCop(Double valorCop) {
        this.valorCop = valorCop;
        return this;
    }

    public Cita buildCita() {
        return new Cita(idCita,idUsuario, idDoctor,  fechaCita, horaInicial, horaFinal, valorUsd,  valorCop);
    }
}
