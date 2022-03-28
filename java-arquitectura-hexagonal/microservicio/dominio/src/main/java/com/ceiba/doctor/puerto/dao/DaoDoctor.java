package com.ceiba.doctor.puerto.dao;

import com.ceiba.doctor.modelo.dto.DtoDoctor;
import java.util.List;

public interface DaoDoctor {

    /**
     * Permite listar doctores
     * @return los doctores
     */
    List<DtoDoctor> listarDoctor();

    /**
     * Permite para devolver los datos de un doctor en especifico
     * @return los doctores
     */
    List<DtoDoctor> listarDoctorPorId(Long idDoctor);
}
