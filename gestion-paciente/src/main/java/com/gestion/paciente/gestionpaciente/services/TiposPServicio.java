package com.gestion.paciente.gestionpaciente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.paciente.gestionpaciente.entidades.TipoPacientes;
import com.gestion.paciente.gestionpaciente.repositorio.TipoPacienteRepositorio;

@Service
public class TiposPServicio {

    @Autowired
    private TipoPacienteRepositorio tipopacienterepositorio;


    /** Consultar Paciente
     * @return
     */
    public List<TipoPacientes> consultarTipoPaciente(){
        return (List<TipoPacientes>)tipopacienterepositorio.findAll();
    }


    /** Registrar Paciente
     * @param tipop
     * @return
     */
    @SuppressWarnings("null")
    public TipoPacientes registrarTipoPacientes(TipoPacientes tipop){
        return tipopacienterepositorio.save(tipop);
    }
    
//hola

}
