package com.gestion.paciente.gestionpaciente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gestion.paciente.gestionpaciente.dto.CitaDto;
import com.gestion.paciente.gestionpaciente.entidades.Citas;
import com.gestion.paciente.gestionpaciente.services.CitaServicio;

@RestController
@RequestMapping("/api")
public class CitasMedicasController {

    @Autowired
    private CitaServicio servicioCita;

    @GetMapping ("/listarCitas")
    public List<Citas> consultarPaciente(){
        return servicioCita.consultarCita();
    }

    @PostMapping("/registroCitas")
    public Citas registrarCitas(@RequestBody CitaDto citaJson){

        Citas cita = new Citas();

        cita.setFechaCita(citaJson.getFechaCita());
        cita.setHoraCita(citaJson.getHoraCita());
        cita.setMotivoCita(citaJson.getMotivoCita());

        System.out.println("Valor a persistir"+cita.toString());
        return servicioCita.registrarPaciente(cita);
    }

}
