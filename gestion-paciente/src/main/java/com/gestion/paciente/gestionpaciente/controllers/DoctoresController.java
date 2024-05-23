package com.gestion.paciente.gestionpaciente.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.paciente.gestionpaciente.dto.DoctoresDto;
import com.gestion.paciente.gestionpaciente.services.DoctoresServicio;

@RestController
@RequestMapping("/api/doctores")
public class DoctoresController {

    @Autowired
    private DoctoresServicio doctoresServicio;

    @GetMapping("/doctores/{idMedicos}")
    public List<DoctoresDto> consultarDoctores(@PathVariable Long idMedicos){
        return doctoresServicio.consultarDoctores(idMedicos);
    }
}
