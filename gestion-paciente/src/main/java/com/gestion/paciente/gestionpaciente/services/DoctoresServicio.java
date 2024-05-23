package com.gestion.paciente.gestionpaciente.services;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.paciente.gestionpaciente.dto.DoctoresDto;
import com.gestion.paciente.gestionpaciente.repositorio.DoctoresRepositorio;

@Service
public class DoctoresServicio {
    @Autowired 
    private DoctoresRepositorio doctoresRepositorio;

    public List<DoctoresDto> consultarDoctores(Long idMedicos){
        List<Object[]> results = doctoresRepositorio.getDoctores(idMedicos);
        List<DoctoresDto> doctores = new ArrayList<>();

        for (Object[] row : results) {
            DoctoresDto doctoresDto = new DoctoresDto(idMedicos, null, null, null, null, null);
            doctoresDto.setIdMedicos((Long) row[0]);
            doctoresDto.setNombreMedico((String) row[1]);
            doctoresDto.setId_especialidad((Integer) row[2]);
            doctoresDto.setCargo((String) row[3]);
            doctoresDto.setTurno((String) row[4]);

            doctores.add(doctoresDto);
        }
        return doctores;
    }


}
