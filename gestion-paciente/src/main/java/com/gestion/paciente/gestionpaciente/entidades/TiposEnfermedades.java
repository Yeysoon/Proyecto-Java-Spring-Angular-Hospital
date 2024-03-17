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
@Table(name="tipo_paciente")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TiposEnfermedades {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_enfermedad")
    private Long idTipoenfermedades;

    @Column (name = "paciente_nuevo")
    private String nombreenfermedad;

    @Column (name = "tipo_enfermedad")
    private String tipoenfermedad;

    private String factor;
    
    private String sintomas;

    private String estado;

    private String tratamiento;

    /*idTipoenfermedades;
    private String nombreenfermedad;
    private String tipoenfermedad;
    private String factor;
    private String sintomas;
    private String estado;
    private String tratamiento; */
}
