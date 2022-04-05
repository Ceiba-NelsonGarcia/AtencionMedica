package com.ceiba.doctor.adaptador.repositorio;

import com.ceiba.doctor.modelo.entidad.Doctor;
import com.ceiba.doctor.puerto.repositorio.RepositorioDoctor;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioDoctorMysql implements RepositorioDoctor {

    private static final String ID_DOCTOR = "idDoctor";
    private static final String DOCTOR = "doctor";
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace=DOCTOR, value="crear")
    private String sqlCrear;

    @SqlStatement(namespace=DOCTOR, value="actualizar")
    private String sqlActualizar;

    @SqlStatement(namespace=DOCTOR, value="eliminar")
    private String sqlEliminar;

    @SqlStatement(namespace=DOCTOR, value="existe")
    private String sqlExiste;

    @SqlStatement(namespace=DOCTOR, value="existePorId")
    private String sqlExistePorId;

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
        paramSource.addValue(ID_DOCTOR, idDoctor);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public void actualizarDoctor(Doctor doctor) {
        this.customNamedParameterJdbcTemplate.actualizar(doctor, sqlActualizar);
    }

    @Override
    public boolean existeDoctorPorId(Long idDoctor) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(ID_DOCTOR, idDoctor);

        return Boolean.TRUE.equals(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId, paramSource, Boolean.class));
    }
}
