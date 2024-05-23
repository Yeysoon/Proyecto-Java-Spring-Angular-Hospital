package com.gestion.paciente.gestionpaciente.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DoctoresDto {
        
    private Long idMedicos;   
    private String nombreMedico;
    private Integer id_especialidad;    
    private String licenciaMedica;
    private String cargo;
    private String turno;
}
