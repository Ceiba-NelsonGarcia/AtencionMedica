package com.ceiba.doctor.comando.manejador;

import com.ceiba.doctor.servicio.ServicioEliminarDoctor;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarDoctor implements ManejadorComando<Long> {

    private final ServicioEliminarDoctor servicioEliminarDoctor;

    public ManejadorEliminarDoctor(ServicioEliminarDoctor servicioEliminarDoctor) {
        this.servicioEliminarDoctor = servicioEliminarDoctor;
    }

    public void ejecutar(Long idDoctor) {
        this.servicioEliminarDoctor.ejecutar(idDoctor);
    }
}
