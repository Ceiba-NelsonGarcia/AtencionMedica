package com.ceiba.cita.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;
import com.ceiba.cita.servicio.utils.ValorCitaUSD;
import com.ceiba.doctor.puerto.dao.DaoDoctor;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tarifa.puerto.dao.DaoTarifa;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioCrearCitaTest {

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del Cita")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelCita() {
        // arrange
        Cita cita = new CitaTestDataBuilder().buildCita();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        DaoDoctor daoDoctor = Mockito.mock(DaoDoctor.class);
        DaoTarifa daoTarifa = Mockito.mock(DaoTarifa.class);
        Mockito.when(repositorioCita.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita, daoDoctor, daoTarifa);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCita.ejecutar(cita), ExcepcionDuplicidad.class,"La cita ya existe en el sistema");
    }

   /* @Test
    @DisplayName("Deberia Crear la cita de manera correcta")
    void deberiaCrearElCitaDeManeraCorrecta() {
        // arrange
        Cita cita = new CitaTestDataBuilder().buildCita();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        DaoDoctor daoDoctor = Mockito.mock(DaoDoctor.class);
        DaoTarifa daoTarifa = Mockito.mock(DaoTarifa.class);
        ValorCitaUSD valorCitaUSD = Mockito.mock(ValorCitaUSD.class);
        Mockito.when(repositorioCita.existe(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioCita.crearCita(cita)).thenReturn(10L);
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita, daoDoctor, daoTarifa);
        // act
        //cita.setValorCop(valorCitaUSD.obtenerValorCita(cita));
        Long idCita = servicioCrearCita.ejecutar(cita);
        //- assert
        assertEquals(10L,idCita);
        Mockito.verify(repositorioCita, Mockito.times(1)).crearCita(cita);
    }*/
}
