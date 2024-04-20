package com.gestion.paciente.gestionpaciente.entidades;

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
@Table(name="especialidades")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Especialidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_especialidad")
    private Long idEspecialidad;

    @Column(name = "nombre_especialidad")
    private String nombreEspecialidad;
    
    @Column(name = "descripcion_especialidad")
    private String descripcionEspecialidad;

}
