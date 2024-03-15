package com.gestion.paciente.gestionpaciente.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.gestion.paciente.gestionpaciente.entidades.Pacientes;

public interface PacienteRepositorio extends CrudRepository <Pacientes, Long> {

}
