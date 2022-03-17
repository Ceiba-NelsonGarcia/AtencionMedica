package com.ceiba.doctor.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoDoctor {

    private Long idDoctor;
    private String nombreDoctor;
    private Long idTarifa;
    private Long idHorario;
}
