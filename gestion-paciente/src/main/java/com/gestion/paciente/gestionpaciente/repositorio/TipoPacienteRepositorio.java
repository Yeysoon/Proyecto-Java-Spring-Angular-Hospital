package com.gestion.paciente.gestionpaciente.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.gestion.paciente.gestionpaciente.entidades.TipoPacientes;

public interface TipoPacienteRepositorio extends CrudRepository <TipoPacientes, Long> {

}
