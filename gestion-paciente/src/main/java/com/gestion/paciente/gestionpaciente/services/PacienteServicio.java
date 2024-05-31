package com.gestion.paciente.gestionpaciente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.paciente.gestionpaciente.entidades.Pacientes;
import com.gestion.paciente.gestionpaciente.repositorio.PacienteRepositorio;

import jakarta.transaction.Transactional;

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
    
    public Pacientes registrarPaciente(Pacientes paciente){
        return pacienteRepositorio.save(paciente);
    }



    /**
     * Buscar por ID
     * @param 
     * @return
     */
    
    @Transactional
    public Pacientes findById(Long id){
        return pacienteRepositorio.findById(id).orElse(null);
    };

    
    /**
     * Guardar Pacientes
     * @param pacientes
     * @return
     */
   
    @Transactional
    public Pacientes save(Pacientes pacientes){
        return pacienteRepositorio.save(pacientes);
    };

    
    /**
     * Eliminar Pacientes
     * @param id
     */
    
    @Transactional
    public void delete(Long id){
        pacienteRepositorio.deleteById(id);
    };


}
