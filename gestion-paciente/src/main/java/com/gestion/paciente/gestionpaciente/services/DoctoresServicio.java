package com.gestion.paciente.gestionpaciente.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.paciente.gestionpaciente.repositorio.DoctoresRepositorio;
import com.gestion.paciente.gestionpaciente.repositorio.EspecialidadRespositorio;
import com.gestion.paciente.gestionpaciente.dto.DoctoresDto;
import com.gestion.paciente.gestionpaciente.dto.MedicoDto;
import com.gestion.paciente.gestionpaciente.entidades.Doctores;
import com.gestion.paciente.gestionpaciente.entidades.Especialidades;

@Service
public class DoctoresServicio {

    @Autowired
    private final DoctoresRepositorio doctoresRepositorio;
    private final EspecialidadRespositorio especialidadRespositorio;

    public DoctoresServicio(DoctoresRepositorio doctoresRepositorio, EspecialidadRespositorio especialidadRespositorio){

        this.doctoresRepositorio = doctoresRepositorio;
        this.especialidadRespositorio = especialidadRespositorio;
    }



    //Listar todos los doctores
    public List<Doctores> getAll(){
        return doctoresRepositorio.findAll();
    }

    

    //Buscar por Id en Doctores
    public Optional<Doctores> getDoctoresById(Long idDoctores){
        return doctoresRepositorio.findById(idDoctores);
    }


    //Guardado general doctores
    public Doctores saveDoctores(Doctores doctores){
        return doctoresRepositorio.save(doctores);
    }


    //Guardar doctores
    public Doctores saveDoctor(DoctoresDto doctoresDto) {
        Especialidades especialidades = especialidadRespositorio.findById(doctoresDto.getIdEspecialidades())
                .orElseThrow(() -> new IllegalArgumentException("Especiality not found"));

        Doctores doctores = new Doctores();
        doctores.setNombreMedico(doctoresDto.getNombreMedico());
        doctores.setIdEspecialidades(especialidades);
        doctores.setLicenciaMedica(doctoresDto.getLicenciaMedica());
        doctores.setCargo(doctoresDto.getCargo());
        doctores.setTurno(doctoresDto.getTurno());

        return doctoresRepositorio.save(doctores);
    }

    //Actualizar doctores
    public Doctores updateDoctores(Long idDoctores, DoctoresDto doctoresDto) {
        Doctores existingDoctores = doctoresRepositorio.findById(idDoctores)
                .orElseThrow(() -> new IllegalArgumentException("Medico not found"));

        Especialidades especialidades = especialidadRespositorio.findById(doctoresDto.getIdEspecialidades())
                .orElseThrow(() -> new IllegalArgumentException("Especiality not found"));

        existingDoctores.setNombreMedico(doctoresDto.getNombreMedico());
        existingDoctores.setIdEspecialidades(especialidades);
        existingDoctores.setLicenciaMedica(doctoresDto.getLicenciaMedica());
        existingDoctores.setCargo(doctoresDto.getCargo());
        existingDoctores.setTurno(doctoresDto.getTurno());

        return doctoresRepositorio.save(existingDoctores);
    }


    //Eliminar doctores
    public void deleteDoctores(Long idDoctores) {
        Doctores existingDoctores = doctoresRepositorio.findById(idDoctores)
                .orElseThrow(() -> new IllegalArgumentException("Medico not found"));
        doctoresRepositorio.delete(existingDoctores);
    }


    //Listar por nombre de medios
    public List<Doctores> findDoctoresByName(String nombreMedico) {
        return doctoresRepositorio.findByName(nombreMedico);
    }

}
