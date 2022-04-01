package com.ceiba.horario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;

public class ServicioExisteHorario {

    private static final String EL_HORARIO_NO_EXISTE_EN_EL_SISTEMA = "El Horario no existe en el sistema";

    private RepositorioHorario repositorioHorario;

    public ServicioExisteHorario(RepositorioHorario repositorioHorario) {
        this.repositorioHorario = repositorioHorario;
    }

    //Metodo para entregar el horario que se va a signar al Doctor
    public boolean entregarHorario(Horario horario){
        validarExistenciaPreviaHorario(horario);
        this.repositorioHorario.existeHorarioPorId(horario.getIdHorario());
        return true;
    }

    public boolean validarExistenciaPreviaHorario(Horario horario) {
        boolean existe = this.repositorioHorario.existeHorarioPorId(horario.getIdHorario());
        if (!existe ) {
            throw new ExcepcionDuplicidad(EL_HORARIO_NO_EXISTE_EN_EL_SISTEMA);
        }
        return true;
    }
}
