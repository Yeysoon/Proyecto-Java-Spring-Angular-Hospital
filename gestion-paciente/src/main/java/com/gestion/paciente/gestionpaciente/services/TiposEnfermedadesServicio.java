package com.gestion.paciente.gestionpaciente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gestion.paciente.gestionpaciente.entidades.TiposEnfermedades;
import com.gestion.paciente.gestionpaciente.repositorio.TipoEnfermedadesRepositorio;



public class TiposEnfermedadesServicio {

    @Autowired
    private TipoEnfermedadesRepositorio tipoenfermedadesrepositorio;


    /** Consultar Paciente
     * @return
     */
    public List<TiposEnfermedades> consultarTipoEnfermedades(){
        return (List<TiposEnfermedades>)tipoenfermedadesrepositorio.findAll();
    }


    /** Registrar Paciente
     * @param tipoe
     * @return
     */
    @SuppressWarnings("null")
    public TiposEnfermedades registrarTipoEnfermedades(TiposEnfermedades tipoe){
        return tipoenfermedadesrepositorio.save(tipoe);
    }

}
