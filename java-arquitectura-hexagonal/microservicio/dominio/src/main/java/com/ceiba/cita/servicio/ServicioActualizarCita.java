package com.ceiba.cita.servicio;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarCita {

    private static final String EL_CITA_NO_EXISTE_EN_EL_SISTEMA = "El no cita existe en el sistema";

    private final RepositorioCita repositorioCita;

    public ServicioActualizarCita(RepositorioCita repositorioCita) {
        this.repositorioCita = repositorioCita;
    }

    public void ejecutar(Cita cita) {
        validarExistenciaPrevia(cita);
        this.repositorioCita.actualizarCita(cita);
    }

    private void validarExistenciaPrevia(Cita cita) {
        boolean existe = this.repositorioCita.existeCitaPorId(cita.getIdCita());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_CITA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
