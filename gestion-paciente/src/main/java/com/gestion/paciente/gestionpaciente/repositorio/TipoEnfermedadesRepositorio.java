package com.gestion.paciente.gestionpaciente.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.gestion.paciente.gestionpaciente.entidades.TiposEnfermedades;

public interface TipoEnfermedadesRepositorio extends CrudRepository <TiposEnfermedades, Long> {

}
