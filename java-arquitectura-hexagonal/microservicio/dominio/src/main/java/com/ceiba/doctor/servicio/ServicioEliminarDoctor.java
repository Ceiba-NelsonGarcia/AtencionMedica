package com.ceiba.doctor.servicio;

import com.ceiba.doctor.puerto.repositorio.RepositorioDoctor;

public class ServicioEliminarDoctor {

    private final RepositorioDoctor repositorioDoctor;

    public ServicioEliminarDoctor(RepositorioDoctor repositorioDoctor) {
        this.repositorioDoctor = repositorioDoctor;
    }

    public void ejecutar(Long idDoctor) {
        this.repositorioDoctor.eliminarDoctor(idDoctor);
    }
}
