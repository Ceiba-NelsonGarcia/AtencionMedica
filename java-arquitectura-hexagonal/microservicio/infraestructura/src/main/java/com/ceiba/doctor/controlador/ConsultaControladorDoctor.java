package com.ceiba.doctor.controlador;

import com.ceiba.doctor.consulta.ManejadorListarDoctor;
import com.ceiba.doctor.modelo.dto.DtoDoctor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctores")
@Api(tags={"Controlador consulta doctores"})
public class ConsultaControladorDoctor  {

    private final ManejadorListarDoctor manejadorListarDoctor;

    public ConsultaControladorDoctor(ManejadorListarDoctor manejadorListarDoctor) {
        this.manejadorListarDoctor = manejadorListarDoctor;
    }

    @GetMapping
    @ApiOperation("Listar Doctores")
    public List<DtoDoctor> listar() {
        return this.manejadorListarDoctor.ejecutar();
    }
}
