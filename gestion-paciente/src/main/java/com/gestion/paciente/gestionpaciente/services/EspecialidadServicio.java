package com.gestion.paciente.gestionpaciente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.paciente.gestionpaciente.entidades.Especialidades;
import com.gestion.paciente.gestionpaciente.repositorio.EspecialidadRespositorio;

import jakarta.transaction.Transactional;

@Service
public class EspecialidadServicio {

    @Autowired
    private EspecialidadRespositorio especialidadRespositorio;

    /**
     * Consultar totas las Especialidad
     * @param id
     */
    public List<Especialidades> consultarEspecialidad(){
        return (List<Especialidades>) especialidadRespositorio.findAll();
    }

    /**
     * Registrar Especialidad
     * @param id
     */
    public Especialidades registrarEspecialidad(Especialidades especialidades){
        return especialidadRespositorio.save(especialidades);
    }

    /**
     * Buscar por ID
     * @param id
     */
    @Transactional
    public Especialidades findById(Long id){
        return especialidadRespositorio.findById(id).orElse(null);
    };


    /**
     * Guardar Especialidad
     * @param id
     */
    @Transactional
    public Especialidades save(Especialidades especialidades){
        return especialidadRespositorio.save(especialidades);
    }

    /**
     * Eliminar Especialidad
     * @param id
     */
    public void delete(Long id){
        especialidadRespositorio.deleteById(id);
    }

}
