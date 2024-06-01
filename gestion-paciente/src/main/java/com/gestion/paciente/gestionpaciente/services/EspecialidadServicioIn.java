package com.gestion.paciente.gestionpaciente.services;

import java.util.List;
import com.gestion.paciente.gestionpaciente.entidades.Especialidades;

public interface EspecialidadServicioIn {
    List<Especialidades> findAll();
    Especialidades findById(Long idEspecialidad);
}
