package com.ceiba.cita.servicio.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;
import com.ceiba.doctor.modelo.dto.DtoDoctor;
import com.ceiba.doctor.puerto.dao.DaoDoctor;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.tarifa.modelo.dto.DtoTarifa;
import com.ceiba.tarifa.puerto.dao.DaoTarifa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ValorCitaUSDTest {

    Cita cita;
    ValorCitaUSD valorCitaUSD;
    TarifaDiaSemana tarifaDiaSemana;
    TarifaHorarioDoctor tarifaHorarioDoctor;
    DtoDoctor dtoDoctor = new DtoDoctor(3L, "Alisson Vargas", 1L, 3L);
    DtoTarifa dtoTarifaDoctor = new DtoTarifa(1L,"General", 50L);
    DtoTarifa dtoTarifaDiaHabil = new DtoTarifa(3L,"Dias Habiles", 0L);
    DtoTarifa dtoTarifaHorario = new DtoTarifa(6L,"Horario Extra", 2L);

    @Mock private DaoDoctor daoDoctor;
    @Mock private DaoTarifa daoTarifa;

    @BeforeEach
    public void setup() {
        valorCitaUSD = new ValorCitaUSD(daoDoctor, daoTarifa);
        cita = new CitaTestDataBuilder().buildCita();
    }

    @Test
    @DisplayName("Deberia obtener idTarifa doctor")
    void deberiaObtenerIdTarifaDoctor(){
        //arrange
        List<DtoDoctor> dtoDoctorList = new ArrayList<>(List.of(dtoDoctor));
        //act
        Mockito.when(daoDoctor.listarDoctorPorId(cita.getIdDoctor())).thenReturn(dtoDoctorList);
        // assert
        assertEquals(1L, valorCitaUSD.obtenerIdTarifaDoctor(cita));
    }

    @Test
    @DisplayName("Obtener idTaria, deberria lanzar excepcion cuando dtoDoctor sea null")
    void obtenerIdTarifaDeberiaLanzarExcepcionCuandoDtoDoctorSeaNull(){
        //arrange - act
        Mockito.when(daoDoctor.listarDoctorPorId(cita.getIdDoctor())).thenReturn(null);
        // assert
        assertThrows(ExcepcionSinDatos.class,()-> valorCitaUSD.obtenerIdTarifaDoctor(cita));
    }

    @Test
    @DisplayName("Deberia Obtener el valor de la tarifa doctor")
    void deberiaObtenerElValorTarifaDoctor(){
        //arrange
        List<DtoTarifa> dtoTarifaList = new ArrayList<>(List.of(dtoTarifaDoctor));
        //act
        Mockito.when(daoTarifa.listarTarifaPorId(1L)).thenReturn(dtoTarifaList);
        // assert
        assertEquals(50L, valorCitaUSD.obtenerValorTarifaDoctor(1L));
    }

    @Test
    @DisplayName("Obtener valor tarifa doctor deberria lanzar excepcion cuando dtoTarifaDoctor sea null")
    void obtenerValorTarifaDoctorDeberiaLanzarExcepcionCuandoDtoTarifaDoctorSeaNull(){
        //arrange - act
        Mockito.when(daoTarifa.listarTarifaPorId(20L)).thenReturn(null);
        // assert
        assertThrows(ExcepcionSinDatos.class,()-> valorCitaUSD.obtenerValorTarifaDoctor(20L));
    }

    @Test
    @DisplayName("Deberia obtener el porcentaje del dia habil o no")
    void deberiaObtenerPorcentajeTarifaDiaHabil(){
        //arrange
        List<DtoTarifa> dtoTarifaList = new ArrayList<>(List.of(dtoTarifaDiaHabil));
        //act
        Mockito.when(daoTarifa.listarTarifaPorId(3L)).thenReturn(dtoTarifaList);
        // assert
        assertEquals(0L, valorCitaUSD.obtenerPorcentajeTarifaDiaHabil(3L));
    }

    @Test
    @DisplayName("Obtener porcentaje tarifa dia habil, deberria lanzar excepcion cuando dtoTarifaDiaHabil sea null")
    void ObtenerPorcentajeTarifaDiaHabilDeberiaLanzarExcepcionCuandoDtoTarifaDiaHabilSeaNull(){
        //arrange - act
        Mockito.when(daoTarifa.listarTarifaPorId(20L)).thenReturn(null);
        // assert
        assertThrows(ExcepcionSinDatos.class,()-> valorCitaUSD.obtenerPorcentajeTarifaDiaHabil(20L));
    }

    @Test
    @DisplayName("Deberia obtener el porcentaje del dia hora")
    void deberiaObtenerPorcentajeTarifaDiaHora(){
        //arrange
        List<DtoTarifa> dtoTarifaList = new ArrayList<>(List.of(dtoTarifaHorario));
        //act
        Mockito.when(daoTarifa.listarTarifaPorId(6L)).thenReturn(dtoTarifaList);
        // assert
        assertEquals(2L, valorCitaUSD.obtenerporcentajeTarifaHora(6L));
    }

    @Test
    @DisplayName("Obtener porcentaje tarifa hora, deberria lanzar excepcion cuando dtoTarifaDiaHabil sea null")
    void ObtenerPorcentajeTarifaHoraDeberiaLanzarExcepcionCuandoDtoTarifaHorarioSeaNull(){
        //arrange - act
        Mockito.when(daoTarifa.listarTarifaPorId(20L)).thenReturn(null);
        // assert
        assertThrows(ExcepcionSinDatos.class,()-> valorCitaUSD.obtenerporcentajeTarifaHora(20L));
    }

    //Principal
    @Test
    @DisplayName("Deberia devolver el valor de la cita en usd")
    void deberiaDevolverElcalculoValorCitaEnUsd() {
        //arrange
        List<DtoDoctor> dtoDoctorList = new ArrayList<>(List.of(dtoDoctor));
        Mockito.when(daoDoctor.listarDoctorPorId(cita.getIdDoctor())).thenReturn(dtoDoctorList);

        List<DtoTarifa> dtoTarifaList = new ArrayList<>(List.of(dtoTarifaDoctor));
        Mockito.when(daoTarifa.listarTarifaPorId(1L)).thenReturn(dtoTarifaList);

        List<DtoTarifa> dtoTarifaListDiaHabil = new ArrayList<>(List.of(dtoTarifaDiaHabil));
        Mockito.when(daoTarifa.listarTarifaPorId(3L)).thenReturn(dtoTarifaListDiaHabil);

        List<DtoTarifa> dtoTarifaListHora = new ArrayList<>(List.of(dtoTarifaHorario));
        Mockito.when(daoTarifa.listarTarifaPorId(6L)).thenReturn(dtoTarifaListHora);
        // assert
        assertEquals(51D,valorCitaUSD.obtenerValorCita(cita));
    }
}
