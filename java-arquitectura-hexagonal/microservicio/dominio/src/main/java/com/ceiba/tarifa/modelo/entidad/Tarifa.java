package com.ceiba.tarifa.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Tarifa {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_TARIFA = "Se debe ingresar el nombre de la tarifa";
    private static final String SE_DEBE_INGRESAR_EL_VALOR_DE_LA_TARIFA = "Se debe ingresar el valor de la tarifa";

    private Long idTarifa;
    private String nombreTarifa;
    private Long valorTarifa;

    public Tarifa(Long idTarifa, String nombreTarifa, Long valorTarifa) {

        validarObligatorio(nombreTarifa, SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_TARIFA);
        validarObligatorio(valorTarifa, SE_DEBE_INGRESAR_EL_VALOR_DE_LA_TARIFA);

        this.idTarifa = idTarifa;
        this.nombreTarifa = nombreTarifa;
        this.valorTarifa = valorTarifa;
    }
}
