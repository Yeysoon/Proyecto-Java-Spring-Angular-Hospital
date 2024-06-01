package com.gestion.paciente.gestionpaciente.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gestion.paciente.gestionpaciente.repositorio.DoctoresRepositorio;
import com.gestion.paciente.gestionpaciente.entidades.Doctores;
import com.gestion.paciente.gestionpaciente.excepcion.DoctorNotFoundException;

@Service
public class DoctoresServicioImpl implements DoctoresServicio {

    public final DoctoresRepositorio doctoresRepositorio;

    public DoctoresServicioImpl(DoctoresRepositorio doctoresRepositorio) {
        this.doctoresRepositorio = doctoresRepositorio;
    }

    @Override
    public Doctores save(Doctores doctores){
        return doctoresRepositorio.save(doctores);
    }

    @Override
    public List<Doctores> findAll() {
        return doctoresRepositorio.findAll();
    }

    @Override
    public Doctores findById(Long idDoctores) throws DoctorNotFoundException {
        return doctoresRepositorio.findById(idDoctores).orElseThrow(
            () -> new DoctorNotFoundException("Doctor con id " + idDoctores + " No se encuentra")
        );
    }

    @Override
    public void deleteById(Long idDoctores) {
        doctoresRepositorio.deleteById(idDoctores);
    }

    @Override
    public Doctores update(Doctores doctores) {
        return doctoresRepositorio.save(doctores);
    }
}
