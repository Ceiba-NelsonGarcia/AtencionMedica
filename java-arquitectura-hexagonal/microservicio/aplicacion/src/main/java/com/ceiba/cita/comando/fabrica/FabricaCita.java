package com.ceiba.cita.comando.fabrica;

import com.ceiba.cita.comando.ComandoCita;
import com.ceiba.cita.modelo.entidad.Cita;
import org.springframework.stereotype.Component;

@Component
public class FabricaCita {

    public Cita crear(ComandoCita comandoCita) {
        return new Cita(
                comandoCita.getIdCita(),
                comandoCita.getIdUsuario(),
                comandoCita.getIdDoctor(),
                comandoCita.getFechaCita(),
                comandoCita.getHoraInicial(),
                comandoCita.getHoraFinal(),
                comandoCita.getValorUsd(),
                comandoCita.getValorCop()
        );
    }
}
