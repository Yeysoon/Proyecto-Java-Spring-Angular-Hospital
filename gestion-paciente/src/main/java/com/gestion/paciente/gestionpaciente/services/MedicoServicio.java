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

    public List<Medicos> consultarMedico(){
        return (List<Medicos>) medicoRepositorio.findAll();
    }

    @SuppressWarnings("null")
    public Medicos registrarMedico(Medicos medicos){
        return medicoRepositorio.save(medicos);
    }

    

}
