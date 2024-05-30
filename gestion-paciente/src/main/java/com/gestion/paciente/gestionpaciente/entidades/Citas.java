package com.gestion.paciente.gestionpaciente.entidades;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="citas_medicas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Citas {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id_cita" )
private Long idCita;

@Column(name = "fecha_cita")
private Date fechaCita;

@Column(name = "hora_cita")
private Time horaCita;

@Column(name = "motivo_cita")
private String motivoCita;

@OneToOne
@JoinColumn (name = "id_paciente")
private Pacientes idPaciente;

@OneToOne
@JoinColumn (name = "id_medico")
private Doctores idDoctor;









}
