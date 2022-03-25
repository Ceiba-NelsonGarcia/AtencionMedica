package com.ceiba.tarifa.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tarifa.puerto.repositorio.RepositorioTarifa;
import com.ceiba.tarifa.modelo.entidad.Tarifa;

public class ServicioExisteTarifa {

    private static final String LA_TARIFA_NO_EXISTE_EN_EL_SISTEMA = "La tarifa no existe en el sistema";

    private RepositorioTarifa repositorioTarifa;

    public ServicioExisteTarifa(RepositorioTarifa repositorioTarifa) {
        this.repositorioTarifa = repositorioTarifa;
    }

    //Metodo para entregar la tarifa que se va a signar al Doctor
    public void entregarTarifa(Tarifa tarifa){
        validarExistenciaPreviaTarifa(tarifa);
        this.repositorioTarifa.existeTarifaPorId(tarifa.getIdTarifa());
    }

    public void validarExistenciaPreviaTarifa(Tarifa tarifa) {
        boolean existe = this.repositorioTarifa.existeTarifaPorId(tarifa.getIdTarifa());
        if (!existe ) {
            throw new ExcepcionDuplicidad(LA_TARIFA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
