package com.gestion.paciente.gestionpaciente.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.paciente.gestionpaciente.entidades.Doctores;

public interface DoctoresRepositorio extends JpaRepository<Doctores, Long>{
        
}
