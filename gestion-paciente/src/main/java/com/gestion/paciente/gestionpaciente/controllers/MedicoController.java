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
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        
        Medicos medico = null;
        Map<String, Object> response = new HashMap<>();
        try{
            medico = servicioMedico.findById(id);  
        } catch(DataAccessException e){
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("mensaje", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (medico == null) {
           response.put("mensaje", "El Medico ID".concat(id.toString().concat("No existe en la DB")));
           return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Medicos>(medico, HttpStatus.OK ); 
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
