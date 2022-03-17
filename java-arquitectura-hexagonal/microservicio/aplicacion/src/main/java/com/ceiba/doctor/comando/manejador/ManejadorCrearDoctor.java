package com.ceiba.doctor.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.doctor.comando.ComandoDoctor;
import com.ceiba.doctor.comando.fabrica.FabricaDoctor;
import com.ceiba.doctor.modelo.entidad.Doctor;
import com.ceiba.doctor.servicio.ServicioCrearDoctor;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearDoctor implements ManejadorComandoRespuesta<ComandoDoctor, ComandoRespuesta<Long>> {

    private final FabricaDoctor fabricaDoctor;
    private final ServicioCrearDoctor servicioCrearDoctor;

    public ManejadorCrearDoctor(FabricaDoctor fabricaDoctor, ServicioCrearDoctor servicioCrearDoctor) {
        this.fabricaDoctor = fabricaDoctor;
        this.servicioCrearDoctor = servicioCrearDoctor;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoDoctor comandoDoctor) {
        Doctor doctor = this.fabricaDoctor.crear(comandoDoctor);
        return new ComandoRespuesta<>(this.servicioCrearDoctor.ejecutar(doctor));
    }
}
