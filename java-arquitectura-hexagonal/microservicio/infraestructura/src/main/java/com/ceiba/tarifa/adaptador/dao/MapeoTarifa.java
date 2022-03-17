package com.ceiba.tarifa.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.tarifa.modelo.dto.DtoTarifa;
import org.springframework.jdbc.core.RowMapper;

public class MapeoTarifa implements RowMapper<DtoTarifa>, MapperResult {

    @Override
    public DtoTarifa mapRow(ResultSet resultSet, int rowNum) throws SQLException{

        Long idTarifa = resultSet.getLong("id_tarifa");
        String tarifa = resultSet.getString("tarifa");
        Long valorTarifa = resultSet.getLong("valor_tarifa");

        return new DtoTarifa(idTarifa,tarifa,valorTarifa);
    }
}
