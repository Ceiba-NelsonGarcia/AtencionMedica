package com.ceiba.cita.adaptador.repositorio;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCitaMysql implements RepositorioCita {

    private static final String ID_CITA = "idCita";
    private static final String CITA = "cita";
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace= CITA, value="crear")
    private String sqlCrear;

    @SqlStatement(namespace= CITA, value="actualizar")
    private String sqlActualizar;

    @SqlStatement(namespace= CITA, value="eliminar")
    private String sqlEliminar;

    @SqlStatement(namespace= CITA, value="existe")
    private String sqlExiste;

    @SqlStatement(namespace= CITA, value="existePorId")
    private String sqlExistePorId;

    public RepositorioCitaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crearCita(Cita cita) {
        return this.customNamedParameterJdbcTemplate.crear(cita, sqlCrear);
    }

    @Override
    public void eliminarCita(Long idCita) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(ID_CITA, idCita);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public void actualizarCita(Cita cita) {
        this.customNamedParameterJdbcTemplate.actualizar(cita, sqlActualizar);
    }

    @Override
    public boolean existeCitaPorId(Long idCita) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(ID_CITA, idCita);

        return Boolean.TRUE.equals(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId, paramSource, Boolean.class));
    }
}
