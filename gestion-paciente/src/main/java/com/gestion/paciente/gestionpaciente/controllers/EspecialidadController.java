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

import com.gestion.paciente.gestionpaciente.dto.EspecialidadDto;
import com.gestion.paciente.gestionpaciente.entidades.Especialidades;
import com.gestion.paciente.gestionpaciente.services.EspecialidadServicio;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class EspecialidadController {

    @Autowired
    private EspecialidadServicio servicioEspecialidad;


    @GetMapping("/listarEspecialidades")
    public List<Especialidades> consultarEspecialidad(){
        return servicioEspecialidad.consultarEspecialidad();
    }


    @PostMapping("/registroEspecialidades")
    public Especialidades registrarEspecialidad(@RequestBody EspecialidadDto especialidadJson){
        Especialidades especialidades = new Especialidades();

        especialidades.setNombreEspecialidad(especialidadJson.getNombreEspecialidad());
        especialidades.setDescripcionEspecialidad(especialidadJson.getDescripcionEspecialidad());

        System.out.println("Valor a persistir"+ especialidades.toString());
        return servicioEspecialidad.registrarEspecialidad(especialidades);
    }


    @GetMapping ("/especialidades/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){

        Especialidades especialidad = null;
        Map<String, Object> response = new HashMap<>();

        try {
            especialidad = servicioEspecialidad.findById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("mensaje", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (especialidad == null) {
            response.put("mensaje", "La especialidad ID".concat(id.toString().concat("No existe en la DB")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Especialidades>(especialidad, HttpStatus.OK);
    }


    @PostMapping ("/guardarEspecialidades")
    @ResponseStatus (HttpStatus.CREATED)
    public Especialidades guardarEspecialidades(@RequestBody Especialidades especialidades){
        return servicioEspecialidad.save(especialidades);
    }


    @PutMapping("/especialidades/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Especialidades actualizarEspecialidades(@RequestBody Especialidades especialidades, @PathVariable Long id){
        Especialidades especialidadActual = servicioEspecialidad.findById(id);

        especialidadActual.setNombreEspecialidad(especialidades.getNombreEspecialidad());
        especialidadActual.setDescripcionEspecialidad(especialidades.getDescripcionEspecialidad());

        return servicioEspecialidad.save(especialidadActual);
    }

    @DeleteMapping("/especialidades/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarEspecialidades(@PathVariable Long id){
        servicioEspecialidad.delete(id);
    }
}
