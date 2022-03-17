package com.ceiba.horario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;

public class ServicioExisteHorario {

    private static final String El_HORARIO_NO_EXISTE_EN_EL_SISTEMA = "La_Horario_no_existe_en_el_sistema";

    private RepositorioHorario repositorioHorario;

    public ServicioExisteHorario(RepositorioHorario repositorioHorario) {
        this.repositorioHorario = repositorioHorario;
    }

    //Metodo para entregar el Horario que se va a signar al Doctor
    public void entregarHorario(Horario Horario){
        validarExistenciaPreviaHorario(Horario);
        this.repositorioHorario.existeHorarioPorId(Horario.getIdHorario());
    }

    public void validarExistenciaPreviaHorario(Horario Horario) {
        boolean existe = this.repositorioHorario.existeHorarioPorId(Horario.getIdHorario());
        if (!existe ) {
            throw new ExcepcionDuplicidad(El_HORARIO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
