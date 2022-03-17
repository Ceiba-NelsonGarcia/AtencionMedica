package com.ceiba.doctor.adaptador.dao;

import com.ceiba.doctor.modelo.dto.DtoDoctor;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoDoctor implements RowMapper<DtoDoctor>, MapperResult {

    @Override
    public DtoDoctor mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long idDoctor = resultSet.getLong("id_doctor");
        String nombreDoctor = resultSet.getString("nombre_doctor");
        Long idTarifa = resultSet.getLong("id_tarifa");
        Long idHorario = resultSet.getLong("id_horario");

        return new DtoDoctor(idDoctor,nombreDoctor,idTarifa,idHorario);
    }
}
