package com.ceiba.cita.puerto.dao;

import com.ceiba.cita.modelo.dto.DtoCita;

import java.util.List;

public interface DaoCita {

    /**
     * Permite listar Citas
     * @return los citas
     */
    List<DtoCita> listarCitas();
}
