package com.gestion.paciente.gestionpaciente.entidades;

import java.time.LocalDate;

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
@Table(name="citas_medicas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Citas {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Long ididCitas;

    private LocalDate fechaCita;

    private int horaCita;

    @Column (name = "motivo_cita")
    private String motivoCita;
 
}
