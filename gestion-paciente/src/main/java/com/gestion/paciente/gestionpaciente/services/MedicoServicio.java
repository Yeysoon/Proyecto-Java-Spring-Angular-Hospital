package com.gestion.paciente.gestionpaciente.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.gestion.paciente.gestionpaciente.entidades.Medicos;
import com.gestion.paciente.gestionpaciente.repositorio.MedicoRepositorio;


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
    @SuppressWarnings("null")
    public Medicos registrarMedico(Medicos medicos){
        return medicoRepositorio.save(medicos);
    }

    

}
