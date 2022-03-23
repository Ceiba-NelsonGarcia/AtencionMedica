package com.ceiba.doctor.servicio;

import com.ceiba.doctor.modelo.entidad.Doctor;
import com.ceiba.doctor.puerto.repositorio.RepositorioDoctor;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarDoctor {

    private static final String EL_DOCTOR_NO_EXISTE_EN_EL_SISTEMA = "El Doctor no existe en el sistema";

    private final RepositorioDoctor repositorioDoctor;

    public ServicioActualizarDoctor(RepositorioDoctor repositorioDoctor) {
        this.repositorioDoctor = repositorioDoctor;
    }

    public void ejecutar(Doctor doctor) {
        validarExistenciaPrevia(doctor);
        this.repositorioDoctor.actualizarDoctor(doctor);
    }

    private void validarExistenciaPrevia(Doctor doctor) {
        boolean existe = this.repositorioDoctor.existeDoctorPorId(doctor.getIdDoctor());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_DOCTOR_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
