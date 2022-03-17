package com.ceiba.doctor.comando.fabrica;

import com.ceiba.doctor.comando.ComandoDoctor;
import com.ceiba.doctor.modelo.entidad.Doctor;
import org.springframework.stereotype.Component;

@Component
public class FabricaDoctor {

    public Doctor crear(ComandoDoctor comandoDoctor) {
        return new Doctor(
                comandoDoctor.getIdDoctor(),
                comandoDoctor.getNombreDoctor(),
                comandoDoctor.getIdTarifa(),
                comandoDoctor.getIdHorario()
        );
    }
}
