package com.ceiba.cita.modelo.entidad;

import lombok.Getter;
import java.time.LocalDate;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Cita {

    private static final String SE_DEBE_INGRESAR_EL_IDUSUARIO_DE_USUARIO = "Se debe ingresar el idUsuario de usuario";
    private static final String SE_DEBE_INGRESAR_EL_IDDOCTOR_DE_DOCTOR = "Se debe ingresar el idDoctor de doctor";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_LA_CITA = "Se debe ingresar la Fecha de la Cita";
    private static final String SE_DEBE_INGRESAR_LA_HORAINICIAL_DE_LA_CITA = "Se debe ingresar la HoraInicial de la Cita";
    private static final String SE_DEBE_INGRESAR_LA_HORAFINAL_DE_LA_CITA = "Se debe ingresar la HoraFinal de la Cita";

    private Long idCita;
    private Long idUsuario;
    private Long idDoctor;
    private LocalDate fechaCita;
    private Integer horaInicial;
    private Integer horaFinal;
    private Double valorUsd;
    private Double valorCop;

    public Cita(Long idCita, Long idUsuario, Long idDoctor, LocalDate fechaCita, Integer horaInicial, Integer horaFinal,
                Double valorUsd, Double valorCop) {

        validarObligatorio(idUsuario, SE_DEBE_INGRESAR_EL_IDUSUARIO_DE_USUARIO);
        validarObligatorio(idDoctor, SE_DEBE_INGRESAR_EL_IDDOCTOR_DE_DOCTOR);
        validarObligatorio(fechaCita, SE_DEBE_INGRESAR_LA_FECHA_DE_LA_CITA);
        validarObligatorio(horaInicial, SE_DEBE_INGRESAR_LA_HORAINICIAL_DE_LA_CITA);
        validarObligatorio(horaFinal, SE_DEBE_INGRESAR_LA_HORAFINAL_DE_LA_CITA);

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
