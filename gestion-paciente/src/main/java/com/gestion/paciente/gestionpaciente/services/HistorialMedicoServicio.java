package com.gestion.paciente.gestionpaciente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gestion.paciente.gestionpaciente.entidades.HistorialMedico;
import com.gestion.paciente.gestionpaciente.repositorio.HistorialMedicoRepositorio;


public class HistorialMedicoServicio {

    @Autowired

    private HistorialMedicoRepositorio historialmedicorepositorio;
    /** 
     * @return
     */
    public List<HistorialMedico> consultarHistorialMedico(){
        return (List<HistorialMedico>) historialmedicorepositorio.findAll();
    }


    /** Registrar Paciente
     * @param historialMedico
     * @return
     */
    @SuppressWarnings("null")
    public HistorialMedico registrarHistorialMedico(HistorialMedico historialMedico){
        return historialmedicorepositorio.save(historialMedico);
}


}
