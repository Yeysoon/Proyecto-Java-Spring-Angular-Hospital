package com.gestion.paciente.gestionpaciente.services;

import java.util.List;

import com.gestion.paciente.gestionpaciente.entidades.Doctores;
import com.gestion.paciente.gestionpaciente.excepcion.DoctorNotFoundException;

public interface DoctoresServicio {

    Doctores save(Doctores doctores);
	
	List<Doctores> findAll();
	Doctores findById(Long idDoctores) throws DoctorNotFoundException;
	void deleteById(Long idDoctores);
	Doctores update(Doctores doctores);

}
