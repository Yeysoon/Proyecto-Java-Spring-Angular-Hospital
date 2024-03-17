package com.gestion.paciente.gestionpaciente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.paciente.gestionpaciente.dto.TipoEnfermedadDto;
import com.gestion.paciente.gestionpaciente.entidades.TiposEnfermedades;
import com.gestion.paciente.gestionpaciente.services.TiposEnfermedadesServicio;

@RestController
@RequestMapping("/api")
public class TipoEnfermedadesControler {


    @Autowired
    private TiposEnfermedadesServicio servicioEnfermedades;

    @GetMapping ("/listarEnfermedades")
    public List<TiposEnfermedades> colsultarTiposEnfermedades(){
        return servicioEnfermedades.consultarTipoEnfermedades();
    }

    @PostMapping("/registroEnfermedades")
    public TiposEnfermedades registrarTiposEnfermedades(@RequestBody TipoEnfermedadDto enfermedadJson){

        TiposEnfermedades enfermedad = new TiposEnfermedades();

        enfermedad.setNombreenfermedad(enfermedadJson.getNombreenfermedad());
        enfermedad.setTipoenfermedad(enfermedadJson.getTipoenfermedad());
        enfermedad.setFactor(enfermedadJson.getFactor());
        enfermedad.setSintomas(enfermedadJson.getSintomas());
        enfermedad.setEstado(enfermedadJson.getEstado());
        enfermedad.setTratamiento(enfermedadJson.getTratamiento());        
        

        System.out.println("Valor a persistir claro"+enfermedad.toString());
        return servicioEnfermedades.registrarTipoEnfermedades(enfermedad);

    }
}
