package com.ceiba.doctor.adaptador.dao;

import java.util.List;

import com.ceiba.doctor.modelo.dto.DtoDoctor;
import com.ceiba.doctor.puerto.dao.DaoDoctor;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoDoctorMysql implements DaoDoctor {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace= "doctor", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace= "doctor", value="sqlListarId")
    private static String sqlListarId;

    public DaoDoctorMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoDoctor> listarDoctor() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoDoctor());
    }

    @Override
    public List<DtoDoctor> listarDoctorPorId(Long idDoctor) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idDoctor", idDoctor);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarId, paramSource, new MapeoDoctor());
    }
}
