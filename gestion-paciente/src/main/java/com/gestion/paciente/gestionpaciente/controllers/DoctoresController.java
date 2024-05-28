package com.gestion.paciente.gestionpaciente.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.paciente.gestionpaciente.dto.DoctoresDto;
import com.gestion.paciente.gestionpaciente.entidades.Doctores;
import com.gestion.paciente.gestionpaciente.services.DoctoresServicio;

@RestController
@RequestMapping("/Doctores")
public class DoctoresController {

     @Autowired
     private final DoctoresServicio doctoresServicio;

     public DoctoresController(DoctoresServicio doctoresServicio){
        this.doctoresServicio = doctoresServicio;
     }


     @GetMapping
     public ResponseEntity<List<Doctores>> getList(){
        return ResponseEntity.ok(doctoresServicio.getAll());
     }



     @GetMapping("/{id}")
     public ResponseEntity<Doctores> getDoctoresById(@PathVariable Long idDoctores){
        Optional<Doctores> docto = doctoresServicio.getDoctoresById(idDoctores);
        return docto.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
     }


     @PostMapping("/add")
    public ResponseEntity<Doctores> createDoctores(@RequestBody DoctoresDto doctoresDto) {
        Doctores doctores = doctoresServicio.saveDoctor(doctoresDto);
        return ResponseEntity.ok(doctores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctores> updateDoctores(@PathVariable Long idDoctores, @RequestBody DoctoresDto doctoresDto) {
        Doctores updatedDoctores = doctoresServicio.updateDoctores(idDoctores, doctoresDto);
        return ResponseEntity.ok(updatedDoctores);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctores(@PathVariable Long idDoctores) {
        doctoresServicio.deleteDoctores(idDoctores);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Doctores>> findDoctoresByName(@RequestParam String nombreMedico) {
        List<Doctores> doctores = doctoresServicio.findDoctoresByName(nombreMedico);
        return ResponseEntity.ok(doctores);
    }


}
