package com.ceiba.doctor.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoDoctor {

    private Long idDoctor;
    private String nombreDoctor;
    private Long idTarifa;
    private Long idHorario;
}
