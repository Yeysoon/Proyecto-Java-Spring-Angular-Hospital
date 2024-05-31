package com.gestion.paciente.gestionpaciente.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.gestion.paciente.gestionpaciente.dto.PacienteDto;
import com.gestion.paciente.gestionpaciente.entidades.Pacientes;
import com.gestion.paciente.gestionpaciente.services.PacienteServicio;


@CrossOrigin(origins = {"http://localhost:4200"})
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

        paciente.setNumeroIdentificacion(pacienteJson.getNumeroIdentificacion());
        paciente.setNombrePaciente(pacienteJson.getNombrePaciente());
        paciente.setEdad(pacienteJson.getEdad());
        paciente.setDireccion(pacienteJson.getDireccion());
        paciente.setTelefono(pacienteJson.getTelefono());
        paciente.setCorreoElectronico(pacienteJson.getCorreoElectronico());
        paciente.setSexo(pacienteJson.getSexo());
        paciente.setContactoEmergencia(pacienteJson.getContactoEmergencia());
        paciente.setTelefonoEmergencia(pacienteJson.getTelefonoEmergencia());

        System.out.println("Valor a persistir claro"+paciente.toString());
        return servicioPaciente.registrarPaciente(paciente);

    }





    @GetMapping ("/pacientes/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        
        Pacientes paciente = null;
        Map<String, Object> response = new HashMap<>();
        try{
            paciente = servicioPaciente.findById(id);  
        } catch(DataAccessException e){
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("mensaje", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (paciente == null) {
           response.put("mensaje", "El Paciente ID".concat(id.toString().concat("No existe en la DB")));
           return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Pacientes>(paciente, HttpStatus.OK ); 
    }

    @PostMapping ("/guardarPacientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Pacientes guardarPacientes(@RequestBody Pacientes pacientes){
        return servicioPaciente.save(pacientes);
    } 

    @PutMapping ("/pacientes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Pacientes actualizarPacientes(@RequestBody Pacientes pacientes, @PathVariable Long id){
        Pacientes pacienteActual = servicioPaciente.findById(id);


        pacienteActual.setNumeroIdentificacion(pacientes.getNumeroIdentificacion());
        pacienteActual.setNombrePaciente(pacientes.getNombrePaciente());
        pacienteActual.setEdad(pacientes.getEdad());
        pacienteActual.setDireccion(pacientes.getDireccion());
        pacienteActual.setTelefono(pacientes.getTelefono());
        pacienteActual.setCorreoElectronico(pacientes.getCorreoElectronico());
        pacienteActual.setSexo(pacientes.getSexo());
        pacienteActual.setContactoEmergencia(pacientes.getContactoEmergencia());
        pacienteActual.setTelefonoEmergencia(pacientes.getTelefonoEmergencia()); 

        return servicioPaciente.save(pacienteActual);
    }

    @DeleteMapping ("/pacientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarPacientes(@PathVariable Long id){
        servicioPaciente.delete(id);
    }


}
