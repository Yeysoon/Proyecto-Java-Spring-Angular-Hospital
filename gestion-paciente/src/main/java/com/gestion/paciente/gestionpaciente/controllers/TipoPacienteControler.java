package com.gestion.paciente.gestionpaciente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.paciente.gestionpaciente.dto.TipoPDto;
import com.gestion.paciente.gestionpaciente.entidades.TipoPacientes;
import com.gestion.paciente.gestionpaciente.services.TiposPServicio;


@RestController
@RequestMapping("/api")
public class TipoPacienteControler {

    @Autowired
    private TiposPServicio serviciotiposp;

    @GetMapping ("/listartipodepacientes")
    public List<TipoPacientes> consultarTipoPaciente(){
        return serviciotiposp.consultarTipoPaciente();
    }

    @PostMapping("/registrotipoPacientes")
    public TipoPacientes registrarTipoPaciente(@RequestBody TipoPDto tipopJson){

        TipoPacientes tipoPacientes = new TipoPacientes();


        tipoPacientes.setPacientenuevo(tipopJson.getPacientenuevo());
        tipoPacientes.setIdentificacion(tipopJson.getIdentificacion());
        tipoPacientes.setNombrepaciente(tipopJson.getNombrepaciente());

        System.out.println("Valor a persistir claro"+tipoPacientes.toString());
        return serviciotiposp.registrarTipoPacientes(tipoPacientes);

         
    }
       
}

