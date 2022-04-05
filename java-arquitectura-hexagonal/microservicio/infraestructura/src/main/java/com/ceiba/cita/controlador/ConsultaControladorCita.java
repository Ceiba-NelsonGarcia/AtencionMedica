package com.ceiba.cita.controlador;

import com.ceiba.cita.consulta.ManejadorListarCita;
import com.ceiba.cita.modelo.dto.DtoCita;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/citas")
@Api(tags={"Controlador consulta citas"})
public class ConsultaControladorCita {

    private final ManejadorListarCita manejadorListarCita;

    public ConsultaControladorCita(ManejadorListarCita manejadorListarCita) {
        this.manejadorListarCita = manejadorListarCita;
    }

    @GetMapping
    @ApiOperation("Listar Cita")
    public List<DtoCita> listarCitas() {
        return this.manejadorListarCita.ejecutar();
    }
}
