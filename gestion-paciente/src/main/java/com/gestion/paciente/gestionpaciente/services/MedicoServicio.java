package com.gestion.paciente.gestionpaciente.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.gestion.paciente.gestionpaciente.entidades.Medicos;
import com.gestion.paciente.gestionpaciente.repositorio.MedicoRepositorio;

import jakarta.transaction.Transactional;


@Service
public class MedicoServicio {
    @Autowired
    private MedicoRepositorio medicoRepositorio;
    
    /**Consultar todos los medicos
     * @return
     */
    public List<Medicos> consultarMedico(){
        return (List<Medicos>) medicoRepositorio.findAll();
    }

    /**RegistrarMedicos
     * @param medicos
     * @return
     */
    
    public Medicos registrarMedico(Medicos medicos){
        return medicoRepositorio.save(medicos);
    }

    
    /**
     * Buscar por ID
     * @param 
     * @return
     */
    
    @Transactional
    public Medicos findById(Long id){
        return medicoRepositorio.findById(id).orElse(null);
    };

    
    /**
     * Guardar Medicos
     * @param medicos
     * @return
     */
   
    @Transactional
    public Medicos save(Medicos medicos){
        return medicoRepositorio.save(medicos);
    };

    
    /**
     * Eliminar Medicos
     * @param id
     */
    
    @Transactional
    public void delete(Long id){
        medicoRepositorio.deleteById(id);
    };

}
