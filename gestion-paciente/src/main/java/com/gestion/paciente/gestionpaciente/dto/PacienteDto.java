package com.gestion.paciente.gestionpaciente.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PacienteDto {

    private Long idPacientes;
    private String nombrePaciente;
    private Integer edad;
    private LocalDate fecha;
    private String genero;
    private String direccion;
    private Integer telefono;
    private Boolean seguro;
    private Integer numeroIdentificacion;
}
