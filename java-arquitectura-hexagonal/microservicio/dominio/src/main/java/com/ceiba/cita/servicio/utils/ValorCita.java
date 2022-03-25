package com.ceiba.cita.servicio.utils;

import com.ceiba.cita.modelo.entidad.Cita;

public class ValorCita {



    public Double obtenerValorCita(Cita cita){

        Double porcentajeTarifaHora = 0D;
        Double porcentajeTarifaDia  = 0D;
        Double porcentajeTotalAdicional  = 0D;
        Double valorDoctor = 0D;
        Double valorHorarioAdicional = 0D;
        Double valorCitaUSD;



        porcentajeTotalAdicional = porcentajeTarifaHora + porcentajeTarifaDia;

        valorHorarioAdicional = valorDoctor * porcentajeTotalAdicional;

        valorCitaUSD = valorDoctor + valorHorarioAdicional;

        return valorCitaUSD;
    }
}
