package com.ceiba.doctor.comando.manejador;

import com.ceiba.doctor.comando.ComandoDoctor;
import com.ceiba.doctor.comando.fabrica.FabricaDoctor;
import com.ceiba.doctor.modelo.entidad.Doctor;
import com.ceiba.doctor.servicio.ServicioActualizarDoctor;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarDoctor implements ManejadorComando<ComandoDoctor> {

    private final FabricaDoctor fabricaDoctor;
    private final ServicioActualizarDoctor servicioActualizarDoctor;

    public ManejadorActualizarDoctor(FabricaDoctor fabricaDoctor, ServicioActualizarDoctor servicioActualizarDoctor) {
        this.fabricaDoctor = fabricaDoctor;
        this.servicioActualizarDoctor = servicioActualizarDoctor;
    }

    public void ejecutar(ComandoDoctor comandoDoctor) {
        Doctor doctor = this.fabricaDoctor.crear(comandoDoctor);
        this.servicioActualizarDoctor.ejecutar(doctor);
    }
}
