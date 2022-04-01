package com.ceiba.doctor.adaptador.repositorio;

import com.ceiba.doctor.modelo.entidad.Doctor;
import com.ceiba.doctor.puerto.repositorio.RepositorioDoctor;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioDoctorMysql implements RepositorioDoctor {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="doctor", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="doctor", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="doctor", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="doctor", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="doctor", value="existePorId")
    private static String sqlExistePorId;

    public RepositorioDoctorMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crearDoctor(Doctor doctor) {
        return this.customNamedParameterJdbcTemplate.crear(doctor, sqlCrear);
    }

    @Override
    public void eliminarDoctor(Long idDoctor) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idDoctor", idDoctor);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public void actualizarDoctor(Doctor doctor) {
        this.customNamedParameterJdbcTemplate.actualizar(doctor, sqlActualizar);
    }

    @Override
    public boolean existeDoctorPorId(Long idDoctor) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idDoctor", idDoctor);

        return Boolean.TRUE.equals(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId, paramSource, Boolean.class));
    }
}
