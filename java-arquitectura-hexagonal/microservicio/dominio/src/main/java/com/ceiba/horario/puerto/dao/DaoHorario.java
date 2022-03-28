package com.ceiba.horario.puerto.dao;

import com.ceiba.horario.modelo.dto.DtoHorario;

import java.util.List;

public interface DaoHorario {
    /**
     * Permite listar horarios
     * @return Los horarios
     * */

    List<DtoHorario> listarHorario();

    /**
     * Permite listar un solo horario por idHorario
     * @return El horario especifico del Doctor 1 Regular o el resto Hextra
     * */

    List<DtoHorario> listarHorarioPorId(Long idHorario);
}
