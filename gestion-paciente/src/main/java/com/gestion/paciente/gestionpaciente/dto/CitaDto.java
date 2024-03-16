package com.gestion.paciente.gestionpaciente.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CitaDto {

    private LocalDate fechaCita;
    private LocalTime horaCita;
    private String motivoCita;
    
}
