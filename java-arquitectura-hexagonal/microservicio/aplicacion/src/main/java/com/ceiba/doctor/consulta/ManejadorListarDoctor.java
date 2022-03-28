package com.ceiba.doctor.consulta;

import com.ceiba.doctor.modelo.dto.DtoDoctor;
import com.ceiba.doctor.puerto.dao.DaoDoctor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarDoctor {

    private final DaoDoctor daoDoctor;

    public ManejadorListarDoctor(DaoDoctor daoDoctor){
        this.daoDoctor = daoDoctor;
    }

    public List<DtoDoctor> ejecutar(){
        return this.daoDoctor.listarDoctor();
    }

    public List<DtoDoctor> ejecutarPorId(Long IdDoctor){
        return this.daoDoctor.listarDoctorPorId(IdDoctor);
    }
}
