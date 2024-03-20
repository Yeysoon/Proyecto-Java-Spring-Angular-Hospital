package com.gestion.paciente.gestionpaciente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.paciente.gestionpaciente.dto.MedicoDto;

import com.gestion.paciente.gestionpaciente.entidades.Medicos;
import com.gestion.paciente.gestionpaciente.services.MedicoServicio;

@RestController
@RequestMapping("/api")

public class MedicoController {

    @Autowired
    private MedicoServicio servicioMedico;
    

     @GetMapping ("/listarMedicos")
    public List<Medicos> consultarMedico(){
        return servicioMedico.consultarMedico();
    }


    @PostMapping ("/registroMedico")
    public Medicos registrarMedico(@RequestBody MedicoDto medicoJson){
        Medicos medicos = new Medicos();

        medicos.setEspecialidad(medicoJson.getEspecialidad());
        medicos.setLicenciaMedica(medicoJson.getLicenciaMedica());
        medicos.setCargo(medicoJson.getCargo());
        medicos.setTurno(medicoJson.getTurno());

        System.out.println("Valor a persistir"+ medicos.toString());
        return servicioMedico.registrarMedico(medicos);

    }

}
