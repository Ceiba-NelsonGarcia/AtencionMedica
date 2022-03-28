package com.ceiba.tarifa.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.tarifa.modelo.dto.DtoTarifa;
import com.ceiba.tarifa.puerto.dao.DaoTarifa;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoTarifaMysql implements DaoTarifa {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "tarifa", value = "Listar")
    private static String sqlListar;

    @SqlStatement(namespace = "tarifa", value = "sqlListarId")
    private static String sqlListarId;

    public DaoTarifaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoTarifa> listarTarifa(){
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoTarifa());
    }

    @Override
    public List<DtoTarifa> listarTarifaPorId(Long idTarifa){
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idTarifa", idTarifa);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarId, paramSource, new MapeoTarifa());
    }
}
