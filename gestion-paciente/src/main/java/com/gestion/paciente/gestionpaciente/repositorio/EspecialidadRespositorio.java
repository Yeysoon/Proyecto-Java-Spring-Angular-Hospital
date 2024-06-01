package com.gestion.paciente.gestionpaciente.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.paciente.gestionpaciente.entidades.Especialidades;

public interface EspecialidadRespositorio extends JpaRepository <Especialidades, Long> {

}
