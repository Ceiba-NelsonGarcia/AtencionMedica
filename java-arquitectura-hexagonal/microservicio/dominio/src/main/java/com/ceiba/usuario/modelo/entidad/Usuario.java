package com.ceiba.usuario.modelo.entidad;

import lombok.Getter;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Usuario {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";

    private Long idUsuario;
    private String nombreUsuario;

    public Usuario(Long idUsuario,String nombreUsuario) {
        validarObligatorio(nombreUsuario, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
    }
}
