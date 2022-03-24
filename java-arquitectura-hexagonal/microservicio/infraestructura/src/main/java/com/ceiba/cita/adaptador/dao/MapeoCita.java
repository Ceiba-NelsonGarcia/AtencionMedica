package com.ceiba.cita.adaptador.dao;

import com.ceiba.cita.modelo.dto.DtoCita;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;

public class MapeoCita implements RowMapper<DtoCita>, MapperResult {

    @Override
    public DtoCita mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long idCita = resultSet.getLong("id_cita");
        Long idUsuario = resultSet.getLong("id_usuario");
        Long idDoctor = resultSet.getLong("id_doctor");
        LocalDate fechaCita = extraerLocalDate(resultSet, "fecha_cita");
        Integer horaInicial = resultSet.getInt("hora_inicial");
        Integer horaFinal = resultSet.getInt("hora_final");
        Double valorUsd = resultSet.getDouble("valor_usd");
        Double valorCop = resultSet.getDouble("valor_cop");

        return new DtoCita(idCita, idUsuario, idDoctor, fechaCita, horaInicial, horaFinal, valorUsd, valorCop);
    }
}
