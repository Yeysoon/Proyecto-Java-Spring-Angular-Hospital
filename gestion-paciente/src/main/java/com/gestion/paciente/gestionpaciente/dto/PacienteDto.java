package com.gestion.paciente.gestionpaciente.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PacienteDto {

    private Long idPacientes;
    private Long numeroIdentificacion;
    private String nombrePaciente;
    private Integer edad;
    private String direccion;
    private Integer telefono;
    private String correoElectronico;
    private char sexo;
    private String contactoEmergencia;
    private Integer telefonoEmergencia;
    
}
