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
    private LocalDate fechaNacimiento;
    private String genero;
    private String direccion;
    private Integer telefono;
    private Boolean seguro;
    private Integer numeroIdentificacion;
    private float peso;
    private float estatura;
    private String medicamento;
    private String alergias;
    private LocalDate fechaAlta;
    private String razon;
    
}
