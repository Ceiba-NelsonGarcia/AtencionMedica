package com.ceiba.horario.adaptador.dao;

import com.ceiba.horario.modelo.dto.DtoHorario;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoHorario implements RowMapper<DtoHorario>, MapperResult {

    @Override
    public DtoHorario mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long idHorario = resultSet.getLong("id_Horario");
        String nombreHorario = resultSet.getString("nombre_horario");
        int horarInicial = resultSet.getInt("hora_inicial");
        int horarFinal = resultSet.getInt("hora_final");

        return new DtoHorario(idHorario,nombreHorario,horarInicial,horarFinal);
    }

}
