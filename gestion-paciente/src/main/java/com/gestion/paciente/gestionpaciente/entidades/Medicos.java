package com.gestion.paciente.gestionpaciente.entidades;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="medico")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private Long idMedicos;

    @Column(name = "nombre_medico")
    private String nombreMedico;
    private String especialidad;

    @Column (name = "licencia_medica")
    private String licenciaMedica;
    private String cargo;
    private String turno;
}
