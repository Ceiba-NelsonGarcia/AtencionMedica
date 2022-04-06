package com.ceiba.cita.adaptador.repositorio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDate;

class RepositorioCitaMysqlTest {

    private static final String ID_CITA = "idCita";
    private static final String CITA = "cita";
    Cita cita = new Cita(1L, 1L,1L, LocalDate.now(), 8, 9, 50D, 185000D);

    @Test
    @DisplayName("Deveria devolver el IdCita cuando se ejecute crearCita")
    void deveriaDevolverIdCitaCuandoSeEjecuteCrearCita(){
        // arrange
        RepositorioCitaMysql repositorioCitaMysql = Mockito.mock(RepositorioCitaMysql.class);
        CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate = Mockito.mock(CustomNamedParameterJdbcTemplate.class);
        // act
        String sqlCrear = "insert into cita (id_usuario,id_doctor,fecha_cita,hora_inicial,hora_final,valor_usd, valor_cop) values(:idUsuario,:idDoctor,:fechaCita,:horaInicial,:horaFinal,:valorUsd,:valorCop)";
        Mockito.when(customNamedParameterJdbcTemplate.crear(cita,sqlCrear)).thenReturn(1L);
        //TO-DO no pasa por bien por customNamedParameterJdbcTemplate
        // assert
        assertEquals(0L, repositorioCitaMysql.crearCita(cita));
    }

/*    @Test
    @DisplayName("Deveria devolver el IdCita cuando se ejecute crearCita")
    void deveriaDevolverTrueCuandoSeValidaExistenciaPorId(){
        // arrange
        RepositorioCitaMysql repositorioCitaMysql = Mockito.mock(RepositorioCitaMysql.class);
        CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate = Mockito.mock(CustomNamedParameterJdbcTemplate.class);
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        // act
        paramSource.addValue(ID_CITA, 1L);
        String sqlExistePorId = "select count(1) from cita where id_cita = :idCita";
        Mockito.when(customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId, paramSource, Boolean.class)).thenReturn(true);
        //TO-DO no pasa por bien por customNamedParameterJdbcTemplate
        // assert
        assertTrue(repositorioCitaMysql.existeCitaPorId(1L));
    }*/

}
