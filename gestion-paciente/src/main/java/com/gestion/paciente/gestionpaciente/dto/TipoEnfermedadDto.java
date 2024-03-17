package com.gestion.paciente.gestionpaciente.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TipoEnfermedadDto {

    private Long idTipoenfermedades;
    private String nombreenfermedad;
    private String tipoenfermedad;
    private String factor;
    private String sintomas;
    private String estado;
    private String tratamiento;

}
