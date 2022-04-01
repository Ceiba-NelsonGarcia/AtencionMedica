package com.ceiba.cita.puerto.repositorio;

import com.ceiba.cita.modelo.entidad.Cita;

public interface RepositorioCita {

    /**
     * Permite crear un cita
     * @param cita
     * @return el id generado
     */
    Long crearCita(Cita cita);

    /**
     * Permite actualizar un cita
     * @param cita
     */
    void actualizarCita(Cita cita);

    /**
     * Permite eliminar un cita
     * @param idCita
     */
    void eliminarCita(Long idCita);

    /**
     * Permite validar si existe un cita con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existeCitaPorId(Long idCita);
}
