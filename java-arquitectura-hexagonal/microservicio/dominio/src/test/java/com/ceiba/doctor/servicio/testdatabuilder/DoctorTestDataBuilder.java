package com.ceiba.doctor.servicio.testdatabuilder;

public class DoctorTestDataBuilder {

    private Long idDoctor;
    private String nombreDoctor;
    private Long idTarifa;
    private Long idHorario;

    public DoctorTestDataBuilder() {
        this.idDoctor = 1L;
        this.nombreDoctor = "Pedro";
        this.idTarifa = 1L;
        this.idHorario = 2L;
    }
    
    public DoctorTestDataBuilder conIdDoctor(Long idDoctor) {
        this.idDoctor = idDoctor;
        return this;
    }

    public DoctorTestDataBuilder conNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
        return this;
    }

    public DoctorTestDataBuilder conIdTarifa(Long idTarifa) {
        this.idTarifa = idTarifa;
        return this;
    }

    public DoctorTestDataBuilder conIdHorario(Long idHorario) {
        this.idHorario = idHorario;
        return this;
    }
}
