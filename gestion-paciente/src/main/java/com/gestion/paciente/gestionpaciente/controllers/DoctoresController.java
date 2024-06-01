package com.gestion.paciente.gestionpaciente.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.paciente.gestionpaciente.entidades.Doctores;
import com.gestion.paciente.gestionpaciente.entidades.Especialidades;
import com.gestion.paciente.gestionpaciente.services.DoctoresServicio;
import com.gestion.paciente.gestionpaciente.services.EspecialidadServicioIn;


@RequestMapping("/doctores")
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class DoctoresController {

    private final DoctoresServicio doctoresServicio;
    private final EspecialidadServicioIn especialidadServicioIn;

    public DoctoresController(DoctoresServicio doctoresServicio, EspecialidadServicioIn especialidadServicioIn) {
        this.doctoresServicio = doctoresServicio;
        this.especialidadServicioIn = especialidadServicioIn;
    }
    
    @PostMapping("/create")
    public Doctores save(@RequestBody Doctores doctores) {
        return doctoresServicio.save(doctores);
    }
    
    @GetMapping("")
    public List<Doctores> findAll(){
        return doctoresServicio.findAll();
    }
    
    @GetMapping("/{idDoctor}")
    public Doctores findById(@PathVariable("idDoctor") Long idDoctor) {
        return doctoresServicio.findById(idDoctor);
    }
    
    @DeleteMapping("/{idDoctor}")
    public void deleteById(@PathVariable("idDoctor") Long idDoctor) {
        doctoresServicio.deleteById(idDoctor);
    }
    
    @PutMapping
    public Doctores update(@RequestBody Doctores doctores) {
        Doctores doctorDB = doctoresServicio.findById(doctores.getIdDoctores());
        doctorDB.setNombreMedico(doctores.getNombreMedico());
        
        if (doctores.getIdEspecialidades() != null) {
            Especialidades especialidades = especialidadServicioIn.findById(doctores.getIdEspecialidades().getIdEspecialidad());
            doctorDB.setIdEspecialidades(especialidades);
        }
        doctorDB.setLicenciaMedica(doctores.getLicenciaMedica());
        doctorDB.setCargo(doctores.getCargo());
        doctorDB.setTurno(doctores.getTurno());

        
        
        return doctoresServicio.update(doctorDB);
    }
}
