package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Usuario;

public class UsuarioTestDataBuilder {

    private Long idUsuario;
    private String nombreUsuario;

    public UsuarioTestDataBuilder() {
        nombreUsuario = "1234";
    }

    public UsuarioTestDataBuilder conIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public UsuarioTestDataBuilder conNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        return this;
    }

    public Usuario buildUsuario() {
        return new Usuario(idUsuario,nombreUsuario);
    }
}
