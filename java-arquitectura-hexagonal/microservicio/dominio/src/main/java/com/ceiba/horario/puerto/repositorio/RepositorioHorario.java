package com.ceiba.horario.puerto.repositorio;

public interface RepositorioHorario {

    /**
     * Permite validar si existe el horario por idHorario
     * @return Si existe el horario
     */

    Boolean existeHorarioPorId(Long idHorario);
}
