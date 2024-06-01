package com.gestion.paciente.gestionpaciente.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestion.paciente.gestionpaciente.entidades.Especialidades;
import com.gestion.paciente.gestionpaciente.repositorio.EspecialidadRespositorio;
import jakarta.transaction.Transactional;

@Service
public class EspecialidadServicio implements EspecialidadServicioIn {

    @Autowired
    private EspecialidadRespositorio especialidadRespositorio;

    @Override
    public List<Especialidades> findAll() {
        return (List<Especialidades>) especialidadRespositorio.findAll();
    }

    @Override
    @Transactional
    public Especialidades findById(Long id) {
        return especialidadRespositorio.findById(id).orElse(null);
    }

    public Especialidades registrarEspecialidad(Especialidades especialidades) {
        return especialidadRespositorio.save(especialidades);
    }

    @Transactional
    public Especialidades save(Especialidades especialidades) {
        return especialidadRespositorio.save(especialidades);
    }

    public void delete(Long id) {
        especialidadRespositorio.deleteById(id);
    }

    public List<Especialidades> consultarEspecialidad() {
        return (List<Especialidades>) especialidadRespositorio.findAll();
    }
}
