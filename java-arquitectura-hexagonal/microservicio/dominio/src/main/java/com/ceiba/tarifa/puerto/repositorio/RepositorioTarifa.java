package com.ceiba.tarifa.puerto.repositorio;

public interface RepositorioTarifa {

    /**
     *Permite consultar las tarifas
     * @param idTarifa
     * @return Si existen tarifas
     */

    boolean existeTarifaPorId(Long idTarifa);
}
