package com.ceiba.doctor.servicio;

import com.ceiba.doctor.modelo.entidad.Doctor;
import com.ceiba.doctor.puerto.repositorio.RepositorioDoctor;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearDoctor {

    private static final String EL_DOCTOR_YA_EXISTE_EN_EL_SISTEMA = "El Doctor ya existe en el sistema";

    private final RepositorioDoctor repositorioDoctor;

    public ServicioCrearDoctor(RepositorioDoctor repositorioDoctor) {
        this.repositorioDoctor = repositorioDoctor;
    }

    public Long ejecutar(Doctor doctor) {
        validarExistenciaPrevia(doctor);
        return this.repositorioDoctor.crearDoctor(doctor);
    }

    private void validarExistenciaPrevia(Doctor doctor) {
        boolean existe = this.repositorioDoctor.existeDoctor(doctor.getNombreDoctor());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_DOCTOR_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
