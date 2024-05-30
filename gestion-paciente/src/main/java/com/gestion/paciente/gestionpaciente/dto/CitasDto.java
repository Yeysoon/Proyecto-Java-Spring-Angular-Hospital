package com.gestion.paciente.gestionpaciente.dto;


import java.sql.Date;
import java.sql.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CitasDto {

private Long idCita;
private Date fechaCita;
private Time horaCita;
private String motivoCita;
private Long idPacientes;
private Long idDoctores;

}
