package com.ceiba.cita.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;
import com.ceiba.cita.servicio.utils.ValorCitaUSD;
import com.ceiba.doctor.modelo.dto.DtoDoctor;
import com.ceiba.doctor.puerto.dao.DaoDoctor;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tarifa.modelo.dto.DtoTarifa;
import com.ceiba.tarifa.puerto.dao.DaoTarifa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ServicioCrearCitaTest {

    Cita cita = new CitaTestDataBuilder().buildCita();
    ValorCitaUSD valorCitaUSD;
    DtoDoctor dtoDoctor = new DtoDoctor(3L, "Alisson Vargas", 1L, 3L);
    DtoTarifa dtoTarifaDoctor = new DtoTarifa(1L,"General", 50L);
    DtoTarifa dtoTarifaDiaHabil = new DtoTarifa(3L,"Dias Habiles", 0L);
    DtoTarifa dtoTarifaHorario = new DtoTarifa(6L,"Horario Extra", 2L);

    @Mock
    private DaoDoctor daoDoctor;

    @Mock
    private DaoTarifa daoTarifa;

    @BeforeEach
    public void setup() {
        valorCitaUSD = new ValorCitaUSD(daoDoctor, daoTarifa);
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del Cita")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelCita() {
        // arrange
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        DaoDoctor daoDoctor = Mockito.mock(DaoDoctor.class);
        DaoTarifa daoTarifa = Mockito.mock(DaoTarifa.class);
        Mockito.when(repositorioCita.existeCitaPorId(Mockito.anyLong())).thenReturn(true);
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita, daoDoctor, daoTarifa);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCita.ejecutar(cita), ExcepcionDuplicidad.class,"La cita ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia velorver false cuando se ejecute validar existencia previa")
    void deberiaDevolverTrueCuandoSeValideLaExistenciaPrevia() {
        // arrange
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        DaoDoctor daoDoctor = Mockito.mock(DaoDoctor.class);
        DaoTarifa daoTarifa = Mockito.mock(DaoTarifa.class);
        Mockito.when(repositorioCita.existeCitaPorId(Mockito.anyLong())).thenReturn(false);
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita, daoDoctor, daoTarifa);
        // act - assert
        assertFalse(servicioCrearCita.validarExistenciaPrevia(cita));
    }

    @Test
    @DisplayName("Deberia delorver valor de la cita en USD cuando se ejecute obtener valor cita usd")
    void deberiaDevolverValorCuandoSeEjecutaObtenerValorCitaUSD() {
        // arrange
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        DaoDoctor daoDoctor = Mockito.mock(DaoDoctor.class);
        DaoTarifa daoTarifa = Mockito.mock(DaoTarifa.class);
        Mockito.when(repositorioCita.existeCitaPorId(Mockito.anyLong())).thenReturn(false);
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita, daoDoctor, daoTarifa);
        // act
        List<DtoDoctor> dtoDoctorList = new ArrayList<>(List.of(dtoDoctor));
        Mockito.when(daoDoctor.listarDoctorPorId(cita.getIdDoctor())).thenReturn(dtoDoctorList);

        List<DtoTarifa> dtoTarifaList = new ArrayList<>(List.of(dtoTarifaDoctor));
        Mockito.when(daoTarifa.listarTarifaPorId(1L)).thenReturn(dtoTarifaList);

        List<DtoTarifa> dtoTarifaListDiaHabil = new ArrayList<>(List.of(dtoTarifaDiaHabil));
        Mockito.when(daoTarifa.listarTarifaPorId(3L)).thenReturn(dtoTarifaListDiaHabil);

        List<DtoTarifa> dtoTarifaListHora = new ArrayList<>(List.of(dtoTarifaHorario));
        Mockito.when(daoTarifa.listarTarifaPorId(6L)).thenReturn(dtoTarifaListHora);
        // assert
        assertEquals(51D, servicioCrearCita.obtenerValorCitaUSD(cita));
    }

    @Test
    @DisplayName("Deberia delorver valor de la cita en COP cuando se ejecute obtener valor cita cop")
    void deberiaDevolverValorCuandoSeEjecutaObtenerValorCitaCOP() {
        // arrange
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        DaoDoctor daoDoctor = Mockito.mock(DaoDoctor.class);
        DaoTarifa daoTarifa = Mockito.mock(DaoTarifa.class);
        Mockito.when(repositorioCita.existeCitaPorId(Mockito.anyLong())).thenReturn(false);
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita, daoDoctor, daoTarifa);
        Double valorCita = 50D;
        // act - assert
        assertEquals(189250D, servicioCrearCita.obtenerValorCitaCOP(valorCita));
    }

    @Test
    @DisplayName("Deberia Crear la cita de manera correcta")
    void deberiaCrearElCitaDeManeraCorrecta() {
        // arrange
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        DaoDoctor daoDoctor = Mockito.mock(DaoDoctor.class);
        DaoTarifa daoTarifa = Mockito.mock(DaoTarifa.class);
        ValorCitaUSD valorCitaUSD = Mockito.mock(ValorCitaUSD.class);
        Mockito.when(repositorioCita.existeCitaPorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioCita.crearCita(cita)).thenReturn(10L);
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita, daoDoctor, daoTarifa);
        // act
        List<DtoDoctor> dtoDoctorList = new ArrayList<>(List.of(dtoDoctor));
        Mockito.when(daoDoctor.listarDoctorPorId(cita.getIdDoctor())).thenReturn(dtoDoctorList);

        List<DtoTarifa> dtoTarifaList = new ArrayList<>(List.of(dtoTarifaDoctor));
        Mockito.when(daoTarifa.listarTarifaPorId(1L)).thenReturn(dtoTarifaList);

        List<DtoTarifa> dtoTarifaListDiaHabil = new ArrayList<>(List.of(dtoTarifaDiaHabil));
        Mockito.when(daoTarifa.listarTarifaPorId(3L)).thenReturn(dtoTarifaListDiaHabil);

        List<DtoTarifa> dtoTarifaListHora = new ArrayList<>(List.of(dtoTarifaHorario));
        Mockito.when(daoTarifa.listarTarifaPorId(6L)).thenReturn(dtoTarifaListHora);
        //cita.setValorCop(valorCitaUSD.obtenerValorCita(cita));
        Long idCita = servicioCrearCita.ejecutar(cita);
        //- assert
        assertEquals(10L,idCita);
        Mockito.verify(repositorioCita, Mockito.times(1)).crearCita(cita);
    }
}
