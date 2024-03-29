package com.ceiba.configuracion;

import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.ServicioActualizarCita;
import com.ceiba.cita.servicio.ServicioCrearCita;
import com.ceiba.cita.servicio.ServicioEliminarCita;
import com.ceiba.cita.servicio.utils.ValorCitaUSD;
import com.ceiba.doctor.puerto.dao.DaoDoctor;
import com.ceiba.doctor.puerto.repositorio.RepositorioDoctor;
import com.ceiba.doctor.servicio.ServicioActualizarDoctor;
import com.ceiba.doctor.servicio.ServicioCrearDoctor;
import com.ceiba.doctor.servicio.ServicioEliminarDoctor;
import com.ceiba.tarifa.puerto.dao.DaoTarifa;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearCita servicioCrearCita(RepositorioCita repositorioCita, DaoDoctor daoDoctor, DaoTarifa daoTarifa) {
        return new ServicioCrearCita(repositorioCita, daoDoctor, daoTarifa);
    }

    @Bean
    public ServicioEliminarCita servicioEliminarCita(RepositorioCita repositorioCita) {
        return new ServicioEliminarCita(repositorioCita);
    }

    @Bean
    public ServicioActualizarCita servicioActualizarCita(RepositorioCita repositorioCita) {
        return new ServicioActualizarCita(repositorioCita);
    }

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

    @Bean
    public ValorCitaUSD valorCitaUSD(DaoDoctor daoDoctor, DaoTarifa daoTarifa){
        return new ValorCitaUSD(daoDoctor, daoTarifa);
    }
}
