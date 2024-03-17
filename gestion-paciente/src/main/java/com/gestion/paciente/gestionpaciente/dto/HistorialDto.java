package com.gestion.paciente.gestionpaciente.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HistorialDto {


    private String peso;
    private String estatura;
    private String medicamento;
    private String alergias;
    private String consumo;
    private LocalDate dadodealta;
    private String razon;
    
}
