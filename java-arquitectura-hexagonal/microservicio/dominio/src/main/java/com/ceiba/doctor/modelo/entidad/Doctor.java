package com.ceiba.doctor.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Doctor {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_DOCTOR = "Se debe ingresar el nombre de doctor";
    private static final String SE_DEBE_INGRESAR_EL_IDTARIFA_DE_DOCTOR = "Se debe ingresar la tarifa de doctor";
    private static final String SE_DEBE_INGRESAR_EL_HORARIO_DE_DOCTOR = "Se debe ingresar el horario de doctor";

    private Long idDoctor;
    private String nombreDoctor;
    private Long idTarifa;
    private Long idHorario;

    public Doctor(Long idDoctor, String nombreDoctor, Long idTarifa, Long idHorario) {

        validarObligatorio(nombreDoctor, SE_DEBE_INGRESAR_EL_NOMBRE_DE_DOCTOR);
        validarObligatorio(idTarifa, SE_DEBE_INGRESAR_EL_IDTARIFA_DE_DOCTOR);
        validarObligatorio(idHorario, SE_DEBE_INGRESAR_EL_HORARIO_DE_DOCTOR);

        this.idDoctor = idDoctor;
        this.nombreDoctor = nombreDoctor;
        this.idTarifa = idTarifa;
        this.idHorario = idHorario;
    }
}
