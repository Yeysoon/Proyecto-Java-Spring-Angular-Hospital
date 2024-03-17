package com.gestion.paciente.gestionpaciente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.paciente.gestionpaciente.dto.HistorialDto;
import com.gestion.paciente.gestionpaciente.entidades.HistorialMedico;
import com.gestion.paciente.gestionpaciente.services.HistorialMedicoServicio;

@RestController
@RequestMapping("/api")
public class HistorialMedicoControler {

     @Autowired
    private HistorialMedicoServicio serviciohistorial;

    @GetMapping ("/listarHistorial")
    public List<HistorialMedico> consultarPaciente(){
        return serviciohistorial.consultarHistorialMedico();
    }

    @PostMapping("/registroHistorial")
    public HistorialMedico registrarHistorialMedico(@RequestBody HistorialDto historialJson){

        HistorialMedico historialmedico = new HistorialMedico();

        historialmedico.setPeso(historialJson.getPeso());
        historialmedico.setEstatura(historialJson.getEstatura());
        historialmedico.setMedicamento(historialJson.getMedicamento());
        historialmedico.setAlergias(historialJson.getAlergias());
        historialmedico.setConsumo(historialJson.getConsumo());
        historialmedico.setDadodealta(historialJson.getDadodealta());
        historialmedico.setRazon(historialJson.getRazon());


        System.out.println("Valor a persistir"+historialmedico.toString());
        return serviciohistorial.registrarHistorialMedico(historialmedico);
    }
}
