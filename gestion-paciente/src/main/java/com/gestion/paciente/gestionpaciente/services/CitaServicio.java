package com.gestion.paciente.gestionpaciente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.paciente.gestionpaciente.entidades.Citas;
import com.gestion.paciente.gestionpaciente.repositorio.CitaRepositorio;



@Service
public class CitaServicio {

    @Autowired
    private CitaRepositorio citaRepositorio;


    /** Consultar cita
     * @return
     */
    public List<Citas> consultarCita(){
        return (List<Citas>)citaRepositorio.findAll();
    }


    /** Registrar cita
     * @param cita
     * @return
     */
    
    public Citas registrarPaciente(Citas cita){
        return citaRepositorio.save(cita);
    }

}
