package com.ceiba.horario.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Horario {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_HORARIO = "Se debe ingresar el nombre del horario";
    private static final String SE_DEBE_INGRESAR_LA_HORA_INICIAL_DEL_HORARIO = "Se debe ingresar la hora inicial del horario";
    private static final String SE_DEBE_INGRESAR_LA_HORA_FINAL_DEL_HORARIO = "Se debe ingresar la hora final del horario";

    private Long idHorario;
    private String nombreHorario;
    private Integer horaInicial;
    private Integer horaFinal;

    public Horario(Long idHorario, String nombreHorario, Integer horaInicial, Integer horaFinal) {

        validarObligatorio(nombreHorario, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_HORARIO);
        validarObligatorio(horaInicial, SE_DEBE_INGRESAR_LA_HORA_INICIAL_DEL_HORARIO);
        validarObligatorio(horaFinal, SE_DEBE_INGRESAR_LA_HORA_FINAL_DEL_HORARIO);

        this.idHorario = idHorario;
        this.nombreHorario = nombreHorario;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
    }
}

