package com.gestion.paciente.gestionpaciente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.paciente.gestionpaciente.dto.MedicoDto;

import com.gestion.paciente.gestionpaciente.entidades.Medicos;
import com.gestion.paciente.gestionpaciente.services.MedicoServicio;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class MedicoController {

    @Autowired
    private MedicoServicio servicioMedico;
    

     @GetMapping ("/listarMedicos")
    public List<Medicos> consultarMedico(){
        return servicioMedico.consultarMedico();
    }

    @PostMapping ("/registroMedicos")
    public Medicos registrarMedico(@RequestBody MedicoDto medicoJson){
        Medicos medicos = new Medicos();

        medicos.setNombreMedico(medicoJson.getNombreMedico());
        medicos.setEspecialidad(medicoJson.getEspecialidad());
        medicos.setLicenciaMedica(medicoJson.getLicenciaMedica());
        medicos.setCargo(medicoJson.getCargo());
        medicos.setTurno(medicoJson.getTurno());

        System.out.println("Valor a persistir"+ medicos.toString());
        return servicioMedico.registrarMedico(medicos);

    }

    @GetMapping ("/medicos/{id}")
    public Medicos buscarPorId(@PathVariable Long id){
        return servicioMedico.findById(id);
    }

    @PostMapping ("/guardarMedicos")
    @ResponseStatus(HttpStatus.CREATED)
    public Medicos guardarMedicos(@RequestBody Medicos medicos){
        return servicioMedico.save(medicos);
    } 

    @PutMapping ("/medicos/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Medicos actualizarMedicos(@RequestBody Medicos medicos, @PathVariable Long id){
        Medicos medicoActual = servicioMedico.findById(id);

        medicoActual.setNombreMedico(medicos.getNombreMedico());
        medicoActual.setEspecialidad(medicos.getEspecialidad());
        medicoActual.setLicenciaMedica(medicos.getLicenciaMedica());
        medicoActual.setCargo(medicos.getCargo());
        medicoActual.setTurno(medicos.getTurno());

        return servicioMedico.save(medicoActual);
    }

    @DeleteMapping ("/medicos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarMedicos(@PathVariable Long id){
        servicioMedico.delete(id);
    }

}
