package com.ceiba.doctor.servicio.testbuilder;

import com.ceiba.doctor.comando.ComandoDoctor;

public class ComandoDoctorTestDataBuilder {

    private Long idDoctor;
    private String nombreDoctor;
    private Long idTarifa;
    private Long idHorario;

    public ComandoDoctorTestDataBuilder(){
        idDoctor = 2L;
        nombreDoctor = "Diego Ariza";
        idTarifa = 1L;
        idHorario = 1L;
    }

    public ComandoDoctorTestDataBuilder conIdDoctor(Long idDoctor, String nombreDoctor, Long idTarifa, Long idHorario) {
        this.idDoctor = idDoctor;
        this.nombreDoctor = nombreDoctor;
        this.idTarifa = idTarifa;
        this.idHorario = idHorario;
        return this;
    }

    public ComandoDoctor build(){
        return new ComandoDoctor(idDoctor, nombreDoctor, idTarifa, idHorario);
    }
}
