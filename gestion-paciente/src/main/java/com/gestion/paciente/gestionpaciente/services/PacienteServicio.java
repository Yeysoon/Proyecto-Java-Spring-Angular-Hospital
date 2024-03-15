package com.gestion.paciente.gestionpaciente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.paciente.gestionpaciente.entidades.Pacientes;
import com.gestion.paciente.gestionpaciente.repositorio.PacienteRepositorio;

@Service
public class PacienteServicio {

    @Autowired
    private PacienteRepositorio pacienteRepositorio;


    /** Consultar Paciente
     * @return
     */
    public List<Pacientes> consultarPaciente(){
        return (List<Pacientes>)pacienteRepositorio.findAll();
    }


    /** Registrar Paciente
     * @param paciente
     * @return
     */
    @SuppressWarnings("null")
    public Pacientes registrarPaciente(Pacientes paciente){
        return pacienteRepositorio.save(paciente);
    }

}
