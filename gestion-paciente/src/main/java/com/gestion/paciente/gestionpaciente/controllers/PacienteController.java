package com.gestion.paciente.gestionpaciente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.paciente.gestionpaciente.dto.PacienteDto;
import com.gestion.paciente.gestionpaciente.entidades.Pacientes;
import com.gestion.paciente.gestionpaciente.services.PacienteServicio;

@RestController
@RequestMapping("/api")
public class PacienteController {

    @Autowired
    private PacienteServicio servicioPaciente;

    @GetMapping ("/listarPacientes")
    public List<Pacientes> consultarPaciente(){
        return servicioPaciente.consultarPaciente();
    }

    @PostMapping("/registroPacientes")
    public Pacientes registrarPaciente(@RequestBody PacienteDto pacienteJson){

        Pacientes paciente = new Pacientes();

        paciente.setNombrePaciente(pacienteJson.getNombrePaciente());
        paciente.setEdad(pacienteJson.getEdad());
        paciente.setFechaNacimiento(pacienteJson.getFechaNacimiento());
        paciente.setGenero(pacienteJson.getGenero());
        paciente.setDireccion(pacienteJson.getDireccion());
        paciente.setTelefono(pacienteJson.getTelefono());
        paciente.setSeguro(pacienteJson.getSeguro());
        paciente.setNumeroIdentificacion(pacienteJson.getNumeroIdentificacion());
        paciente.setPeso(pacienteJson.getPeso());
        paciente.setEstatura(pacienteJson.getEstatura());
        paciente.setMedicamento(pacienteJson.getMedicamento());
        paciente.setAlergias(pacienteJson.getAlergias());
        paciente.setFechaAlta(pacienteJson.getFechaAlta());
        paciente.setRazon(pacienteJson.getRazon());
    
        

        System.out.println("Valor a persistir claro"+paciente.toString());
        return servicioPaciente.registrarPaciente(paciente);

    }
}
