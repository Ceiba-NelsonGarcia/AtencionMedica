package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoUsuario;

import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoUsuarioTestDataBuilder {

    private Long idUsuario;
    private String nombreUsuario;

    public ComandoUsuarioTestDataBuilder() {
        nombreUsuario = UUID.randomUUID().toString();
    }

    public ComandoUsuarioTestDataBuilder conNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        return this;
    }

    public ComandoUsuario build() {
        return new ComandoUsuario(idUsuario,nombreUsuario);
    }

}
