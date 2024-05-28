package com.gestion.paciente.gestionpaciente.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctoresDto {

    private Long idDoctores;
    private String nombreMedico;
    private Long idEspecialidades;
    private String licenciaMedica;
    private String cargo;
    private String turno;
    
}
