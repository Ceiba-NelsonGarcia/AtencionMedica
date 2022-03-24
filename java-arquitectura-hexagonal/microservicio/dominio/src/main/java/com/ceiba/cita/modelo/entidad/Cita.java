package com.ceiba.cita.modelo.entidad;

import lombok.Getter;
import java.time.LocalDate;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Cita {

    private static final String SE_DEBE_INGRESAR_EL_IDUSUARIO_DE_USUARIO = "Se debe ingresar el idUsuario de usuario";
    private static final String SE_DEBE_INGRESAR_EL_IDDOCTOR_DE_DOCTOR = "Se debe ingresar el idDortor de doctor";

    private Long idCita;
    private Long idUsuario;
    private Long idDoctor;
    private LocalDate fechaCita;
    private int horaInicial;
    private int horaFinal;
    private Double valorUsd;
    private Double valorCop;

    public Cita(Long idCita, Long idUsuario, Long idDoctor, LocalDate fechaCita, int horaInicial, int horaFinal,
                Double valorUsd, Double valorCop) {
        validarObligatorio(idUsuario, SE_DEBE_INGRESAR_EL_IDUSUARIO_DE_USUARIO);
        validarObligatorio(idDoctor, SE_DEBE_INGRESAR_EL_IDDOCTOR_DE_DOCTOR);
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
