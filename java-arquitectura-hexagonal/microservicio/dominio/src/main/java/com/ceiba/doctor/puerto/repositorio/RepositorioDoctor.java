package com.ceiba.doctor.puerto.repositorio;

import com.ceiba.doctor.modelo.entidad.Doctor;

public interface RepositorioDoctor {

    /**
     * Permite crear un Doctor
     * @param Doctor
     * @return el id generado
     */
    Long crearDoctor(Doctor Doctor);

    /**
     * Permite actualizar un Doctor
     * @param Doctor
     */
    void actualizarDoctor(Doctor Doctor);

    /**
     * Permite eliminar un Doctor
     * @param idDoctor
     */
    void eliminarDoctor(Long idDoctor);

    /**
     * Permite validar si existe un Doctor con un nombre
     * @param nombreDoctor
     * @return si existe o no
     */
    boolean existeDoctor(String nombreDoctor);

    /**
     * Permite validar si existe un Doctor con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existeDoctorPorId(Long idDoctor);
}
