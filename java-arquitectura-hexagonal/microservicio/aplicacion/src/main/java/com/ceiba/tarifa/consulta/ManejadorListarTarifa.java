package com.ceiba.tarifa.consulta;

import java.util.List;

import com.ceiba.tarifa.modelo.dto.DtoTarifa;
import com.ceiba.tarifa.puerto.dao.DaoTarifa;
import org.springframework.stereotype.Component;

@Component
public class ManejadorListarTarifa {

    private final DaoTarifa daoTarifa;

    public ManejadorListarTarifa(DaoTarifa daoTarifa) {
        this.daoTarifa = daoTarifa;
    }

    public List<DtoTarifa> ejecutarTarifa(){
        return this.daoTarifa.listarTarifa();
    }
}
