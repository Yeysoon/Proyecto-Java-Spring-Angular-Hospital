package com.gestion.paciente.gestionpaciente.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.paciente.gestionpaciente.dto.CitasDto;
import com.gestion.paciente.gestionpaciente.entidades.Citas;
import com.gestion.paciente.gestionpaciente.services.CitasServicio;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/Citas")
public class CitasController {

    @Autowired
     private final CitasServicio citasServicio;

     public CitasController(CitasServicio citasServicio){
        this.citasServicio = citasServicio;
     }


     @GetMapping("/citas")
     public List<Citas> getList(){
        return citasServicio.getAll();
     }



     @GetMapping("/{id}")
     public ResponseEntity<Citas> getCitasById(@PathVariable Long idCita){
        Optional<Citas> cita = citasServicio.getCitasById(idCita);
        return cita.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
     }


     @PostMapping("/add")
    public ResponseEntity<Citas> createCitas(@RequestBody CitasDto citasDto) {
        Citas citas = citasServicio.saveCita(citasDto);
        return ResponseEntity.ok(citas);
    }

    @PutMapping("/citas/{idCita}")
    public ResponseEntity<Citas> updateCitas(@PathVariable Long idCita, @RequestBody CitasDto citasDto) {
        Citas updatedCitas = citasServicio.updateCitas(idCita, citasDto);
        return ResponseEntity.ok(updatedCitas);
    }

    @DeleteMapping("/citas/{idCita}")
    public ResponseEntity<Void> deleteCitas(@PathVariable Long idCita) {
        citasServicio.deleteCitas(idCita);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Citas>> findCitasByMotivo(@RequestParam String motivoCita) {
        List<Citas> citas = citasServicio.findCitasByMotivo(motivoCita);
        return ResponseEntity.ok(citas);
    }

}
