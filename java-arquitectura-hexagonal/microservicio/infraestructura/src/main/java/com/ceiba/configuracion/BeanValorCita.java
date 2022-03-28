package com.ceiba.configuracion;

import com.ceiba.cita.servicio.utils.ValorCitaUSD;
import com.ceiba.doctor.puerto.dao.DaoDoctor;
import com.ceiba.tarifa.puerto.dao.DaoTarifa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanValorCita {

    @Bean
    public ValorCitaUSD valorCitaUSD(DaoDoctor daoDoctor, DaoTarifa daoTarifa){
        return new ValorCitaUSD(daoDoctor, daoTarifa);
    }
}
