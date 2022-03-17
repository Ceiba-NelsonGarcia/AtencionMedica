package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoUsuario;

import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoUsuarioTestDataBuilder {

    private Long idUsuario;
    private String nombreUsuario;
    //private String clave;
    //private LocalDateTime fecha;

    public ComandoUsuarioTestDataBuilder() {
        nombreUsuario = UUID.randomUUID().toString();
        //clave = "1234";
        //fecha = LocalDateTime.now();
    }

    public ComandoUsuarioTestDataBuilder conNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        return this;
    }

    public ComandoUsuario build() {
        return new ComandoUsuario(idUsuario,nombreUsuario);
    }

   /* public ComandoUsuario build() {
        return new ComandoUsuario(id,nombre, clave,fecha);
    }*/
}
