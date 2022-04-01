package com.ceiba.tarifa.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tarifa.modelo.entidad.Tarifa;
import com.ceiba.tarifa.puerto.repositorio.RepositorioTarifa;
import com.ceiba.tarifa.servicio.testdatabuilder.TarifaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ServicioExisteTarifaTest {

    @Test
    @DisplayName("Deberia devolver un true, cuando se valide la no existencia del Tarifa")
    void deberiaDevolverUnTrueCuandoSeValideLaExistenciaDelTarifa() {
        // arrange
        Tarifa tarifa = new TarifaTestDataBuilder()
                .conIdTarifa(1L).conNombreTarifa("Regular").conValorTarifa(50L).buildTarifa();
        RepositorioTarifa repositorioTarifa = Mockito.mock(RepositorioTarifa.class);
        Mockito.when(repositorioTarifa.existeTarifaPorId(Mockito.anyLong())).thenReturn(true);
        ServicioExisteTarifa servicioExisteTarifa = new ServicioExisteTarifa(repositorioTarifa);
        // act - assert
        assertTrue(servicioExisteTarifa.entregarTarifa(tarifa));
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la no existencia del Tarifa")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelTarifa() {
        // arrange
        Tarifa tarifa = new TarifaTestDataBuilder()
                .conIdTarifa(1L).conNombreTarifa("Regular").conValorTarifa(50L).buildTarifa();
        RepositorioTarifa repositorioTarifa = Mockito.mock(RepositorioTarifa.class);
        Mockito.when(repositorioTarifa.existeTarifaPorId(Mockito.anyLong())).thenReturn(false);
        ServicioExisteTarifa servicioExisteTarifa = new ServicioExisteTarifa(repositorioTarifa);
        // act - assert
        BasePrueba.assertThrows(() -> servicioExisteTarifa.entregarTarifa(tarifa),
                ExcepcionDuplicidad.class,"La tarifa no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia devolver true, cuando se valide la existencia previa de la Tarifa")
    void deberiaDeberiaDevolverTrueCuandoSeValideLaExistenciaPreviaDeTarifa() {
        // arrange
        Tarifa tarifa = new TarifaTestDataBuilder()
                .conIdTarifa(1L).conNombreTarifa("Regular").conValorTarifa(50L).buildTarifa();
        RepositorioTarifa repositorioTarifa = Mockito.mock(RepositorioTarifa.class);
        Mockito.when(repositorioTarifa.existeTarifaPorId(Mockito.anyLong())).thenReturn(true);
        ServicioExisteTarifa servicioExisteTarifa = new ServicioExisteTarifa(repositorioTarifa);
        // act - assert
        assertTrue(servicioExisteTarifa.validarExistenciaPreviaTarifa(tarifa));
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion, cuando se valide la no existencia previa de la Tarifa")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaPreviaDeTarifa() {
        // arrange
        Tarifa tarifa = new TarifaTestDataBuilder()
                .conIdTarifa(1L).conNombreTarifa("Regular").conValorTarifa(50L).buildTarifa();
        RepositorioTarifa repositorioTarifa = Mockito.mock(RepositorioTarifa.class);
        Mockito.when(repositorioTarifa.existeTarifaPorId(Mockito.anyLong())).thenReturn(false);
        ServicioExisteTarifa servicioExisteTarifa = new ServicioExisteTarifa(repositorioTarifa);
        // act - assert
        BasePrueba.assertThrows(() -> servicioExisteTarifa.entregarTarifa(tarifa),
                ExcepcionDuplicidad.class,"La tarifa no existe en el sistema");
    }
}
