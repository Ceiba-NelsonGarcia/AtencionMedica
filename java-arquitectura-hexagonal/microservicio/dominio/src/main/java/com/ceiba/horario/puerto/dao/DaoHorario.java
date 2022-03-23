package com.ceiba.horario.puerto.dao;

import com.ceiba.horario.modelo.dto.DtoHorario;

import java.util.List;

public interface DaoHorario {
    /**
     * Permite listar horarios
     * @return Los horarios
     * */

    List<DtoHorario> listarHorario();
}
