package com.ceiba.doctor.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.doctor.comando.ComandoDoctor;
import com.ceiba.doctor.comando.manejador.ManejadorActualizarDoctor;
import com.ceiba.doctor.comando.manejador.ManejadorCrearDoctor;
import com.ceiba.doctor.comando.manejador.ManejadorEliminarDoctor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctores")
@Api(tags = { "Controlador comando doctor"})
public class ComandoControladorDoctor {

    private final ManejadorCrearDoctor manejadorCrearDoctor;
    private final ManejadorEliminarDoctor manejadorEliminarDoctor;
    private final ManejadorActualizarDoctor manejadorActualizarDoctor;

    @Autowired
    public ComandoControladorDoctor(ManejadorCrearDoctor manejadorCrearDoctor,
                                    ManejadorEliminarDoctor manejadorEliminarDoctor,
                                    ManejadorActualizarDoctor manejadorActualizarDoctor) {
        this.manejadorCrearDoctor = manejadorCrearDoctor;
        this.manejadorEliminarDoctor = manejadorEliminarDoctor;
        this.manejadorActualizarDoctor = manejadorActualizarDoctor;
    }

    @PostMapping(value="crear")
    @ApiOperation("Crear Doctor")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoDoctor comandoDoctor) {
        return manejadorCrearDoctor.ejecutar(comandoDoctor);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar Doctor")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarDoctor.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar Doctor")
    public void actualizar(@RequestBody ComandoDoctor comandoDoctor,@PathVariable Long id) {
        comandoDoctor.setIdDoctor(id);
        manejadorActualizarDoctor.ejecutar(comandoDoctor);
    }
}
