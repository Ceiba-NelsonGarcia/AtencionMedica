package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Usuario;

public class UsuarioTestDataBuilder {

    private Long idUsuario;
    private String nombreUsuario;
    //private String clave;
    //private LocalDateTime fecha;

    public UsuarioTestDataBuilder() {
        nombreUsuario = "1234";
        //clave = "1234";
        //fecha = LocalDateTime.now();
    }

  /*  public UsuarioTestDataBuilder conClave(String clave) {
        this.clave = clave;
        return this;
    }
*/
    public UsuarioTestDataBuilder conIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

   /* public UsuarioTestDataBuilder conFechaCreacion(LocalDateTime fechaCreacion) {
        this.fecha = fechaCreacion;
        return this;
    }*/

    public UsuarioTestDataBuilder conNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        return this;
    }

    /*public Usuario build() {
        return new Usuario(id,nombreUsuario, clave,fecha);
    }*/
    public Usuario buildUsuario() {
        return new Usuario(idUsuario,nombreUsuario);
    }
}
