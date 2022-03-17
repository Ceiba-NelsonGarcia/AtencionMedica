package com.ceiba.doctor.modelo.entidad;

import lombok.Getter;

@Getter
public class Doctor {

    private Long idDoctor;
    private String nombreDoctor;
    private Long idTarifa;
    private Long idHorario;

    public Doctor(Long idDoctor, String nombreDoctor, Long idTarifa, Long idHorario) {
        this.idDoctor = idDoctor;
        this.nombreDoctor = nombreDoctor;
        this.idTarifa = idTarifa;
        this.idHorario = idHorario;
    }
}
