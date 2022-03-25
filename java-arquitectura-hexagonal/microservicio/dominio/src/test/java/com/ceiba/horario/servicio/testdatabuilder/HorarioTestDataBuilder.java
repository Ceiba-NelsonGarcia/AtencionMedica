package com.ceiba.horario.servicio.testdatabuilder;

import com.ceiba.horario.modelo.entidad.Horario;

public class HorarioTestDataBuilder {

    private Long idHorario;
    private String nombreHorario;
    private Integer horaInicial;
    private Integer horaFinal;

    public HorarioTestDataBuilder() {
        this.idHorario = 1L;
        this.nombreHorario = "Regular";
        this.horaInicial = 8;
        this.horaFinal = 9;
    }

    public HorarioTestDataBuilder conIdHorario(Long idHorario) {
        this.idHorario = idHorario;
        return this;
    }

    public HorarioTestDataBuilder conNombreHorario(String nombreHorario) {
        this.nombreHorario = nombreHorario;
        return this;
    }

    public HorarioTestDataBuilder conHoraInicial(Integer horaInicial) {
        this.horaInicial = horaInicial;
        return this;
    }

    public HorarioTestDataBuilder conHoraFinal(Integer horaFinal) {
        this.horaFinal = horaFinal;
        return this;
    }

    public Horario buildHorario(){
        return new Horario(idHorario, nombreHorario, horaInicial, horaFinal);
    }
}
