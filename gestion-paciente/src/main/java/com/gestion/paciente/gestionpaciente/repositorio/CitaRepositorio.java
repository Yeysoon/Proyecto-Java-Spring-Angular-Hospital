package com.gestion.paciente.gestionpaciente.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.gestion.paciente.gestionpaciente.entidades.Citas;

public interface CitaRepositorio extends CrudRepository <Citas, Long> {

}