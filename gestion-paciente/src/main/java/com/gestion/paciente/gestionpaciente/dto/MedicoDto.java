package com.gestion.paciente.gestionpaciente.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class MedicoDto {

    private Long idMedicos;
    private String especialidad;
    private String licenciaMedica;
    private String cargo;
    private String turno;

}
