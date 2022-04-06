package com.ceiba.doctor.controlador;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.ceiba.ApplicationMock;
import com.ceiba.doctor.comando.ComandoDoctor;
import com.ceiba.doctor.servicio.testbuilder.ComandoDoctorTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorDoctor.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorDoctorTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

/*    @Test
    @DisplayName("Deberia crear un doctor")
    void deberiaCrearUnDoctor() throws Exception{
        // arrange
        ComandoDoctor doctor = new ComandoDoctorTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/doctores/crear")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(doctor)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }*/

/*    @Test
    @DisplayName("Deberia actualizar un doctor")
    void deberiaActualizarUnDoctor() throws Exception{
        // arrange
        Long id = 1L;
        ComandoDoctor doctor = new ComandoDoctorTestDataBuilder().build();
        // act - assert
        mocMvc.perform(put("/doctores/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(doctor)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deberia eliminar un doctor")
    void deberiaEliminarUnDoctor() throws Exception {
        // arrange
        Long id = 1L;
        // act - assert
        mocMvc.perform(delete("/doctores/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mocMvc.perform(get("/doctores")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }*/
}
