package com.gestion.paciente.gestionpaciente.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspecialidadDto {

    private Long idEspecialidad;
    private String nombreEspecialidad;
    private String descripcionEspecialidad;

}
