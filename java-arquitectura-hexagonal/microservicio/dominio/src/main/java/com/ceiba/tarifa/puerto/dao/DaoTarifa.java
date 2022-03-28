package com.ceiba.tarifa.puerto.dao;

import com.ceiba.tarifa.modelo.dto.DtoTarifa;
import java.util.List;

public interface DaoTarifa {

    /**
     * Permite listar las tarifas
     * @return Las Tarifas
     * */

    List<DtoTarifa> listarTarifa();

    /**
     * Permite para devolver los datos de un doctor en especifico
     * @return los doctores
     */
    List<DtoTarifa> listarTarifaPorId(Long idTarifa);

}
