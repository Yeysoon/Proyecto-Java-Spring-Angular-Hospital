package com.gestion.paciente.gestionpaciente.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CitaDto {

    private LocalDate fechaCita;
    private int horaCita;
    private String motivoCita;

}
