package com.ceiba.configuracion;

import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.ServicioActualizarCita;
import com.ceiba.cita.servicio.ServicioCrearCita;
import com.ceiba.cita.servicio.ServicioEliminarCita;
import com.ceiba.doctor.puerto.dao.DaoDoctor;
import com.ceiba.tarifa.puerto.dao.DaoTarifa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioCita {

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
}
