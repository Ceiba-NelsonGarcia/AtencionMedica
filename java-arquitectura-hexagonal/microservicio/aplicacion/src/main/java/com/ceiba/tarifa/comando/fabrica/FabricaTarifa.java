package com.ceiba.tarifa.comando.fabrica;

import com.ceiba.tarifa.comando.ComandoTarifa;
import com.ceiba.tarifa.modelo.entidad.Tarifa;
import org.springframework.stereotype.Component;

@Component
public class FabricaTarifa {
    public Tarifa crearTarifa(ComandoTarifa comandoTarifa){
        return new Tarifa(
                comandoTarifa.getIdTarifa(),
                comandoTarifa.getTarifa(),
                comandoTarifa.getValorTarifa()
        );
    }
}
