package com.gestion.paciente.gestionpaciente.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.gestion.paciente.gestionpaciente.entidades.Doctores;

public interface DoctoresRepositorio extends JpaRepository<Doctores, Long> {

    List<Doctores> findByNombreMedico(String nombreMedico);
}