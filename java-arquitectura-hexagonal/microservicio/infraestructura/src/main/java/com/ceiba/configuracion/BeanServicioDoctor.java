package com.ceiba.configuracion;

import com.ceiba.doctor.puerto.repositorio.RepositorioDoctor;
import com.ceiba.doctor.servicio.ServicioActualizarDoctor;
import com.ceiba.doctor.servicio.ServicioCrearDoctor;
import com.ceiba.doctor.servicio.ServicioEliminarDoctor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioDoctor {

    @Bean
    public ServicioCrearDoctor servicioCrearDoctor(RepositorioDoctor repositorioDoctor) {
        return new ServicioCrearDoctor(repositorioDoctor);
    }

    @Bean
    public ServicioEliminarDoctor servicioEliminarDoctor(RepositorioDoctor repositorioDoctor) {
        return new ServicioEliminarDoctor(repositorioDoctor);
    }

    @Bean
    public ServicioActualizarDoctor servicioActualizarDoctor(RepositorioDoctor repositorioDoctor) {
        return new ServicioActualizarDoctor(repositorioDoctor);
    }
}
