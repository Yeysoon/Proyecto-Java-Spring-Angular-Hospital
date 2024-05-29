package com.gestion.paciente.gestionpaciente.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.paciente.gestionpaciente.dto.CitasDto;
import com.gestion.paciente.gestionpaciente.entidades.Citas;
import com.gestion.paciente.gestionpaciente.entidades.Doctores;
import com.gestion.paciente.gestionpaciente.entidades.Pacientes;
import com.gestion.paciente.gestionpaciente.repositorio.CitasRepositorio;
import com.gestion.paciente.gestionpaciente.repositorio.DoctoresRepositorio;
import com.gestion.paciente.gestionpaciente.repositorio.PacienteRepositorio;

@Service
public class CitasServicio {

    @Autowired

    private final CitasRepositorio citasRepositorio;
    private final DoctoresRepositorio doctoresRepositorio;
    private final PacienteRepositorio pacienteRepositorio;

    public CitasServicio(CitasRepositorio citasRepositorio, DoctoresRepositorio doctoresRepositorio, PacienteRepositorio pacienteRepositorio){


        this.citasRepositorio = citasRepositorio;
        this.doctoresRepositorio = doctoresRepositorio;
        this.pacienteRepositorio = pacienteRepositorio;

    }

    public List<Citas> getAll(){
        return citasRepositorio.findAll();
    }

    public Optional<Citas> getCitasById(Long idCitas){

        return citasRepositorio.findById(idCitas);
    }

    public Citas saveCitas(Citas citas){

        return citasRepositorio.save(citas);
    }

    public Citas saveCita(CitasDto citasDto){

        Doctores doctores = doctoresRepositorio.getById(CitasDto.idDoctores())
        .orElseThrow(() -> new IllegalArgumentException("Especiality not found"));

        Pacientes pacientes = pacienteRepositorio.getById(CitasDto.idPacientes())
        .orElseThrow(() -> new IllegalArgumentException("Especiality not found"));
        
        Citas citas = new Citas();
         citas.setFechaCita(citasDto.getFechaCita());
         citas.setHoraCita(citasDto.getHoraCita());
         citas.setMotivoCita(citas.getMotivoCita());
         citas.setIdDoctores(doctores);
         citas.setIdPacientes(pacientes);

         return citasRepositorio.save(citas);
    }

}
