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
@Table(name="paciente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pacientes {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long idPacientes;

    @Column (name = "numero_identificacion")
    private Long numeroIdentificacion;

    @Column (name = "nombre_paciente")
    private String nombrePaciente;

    private Integer edad;
    private String direccion;
    private Integer telefono;
    
    @Column (name = "correo_electronico")
    private String correoElectronico;

    private char sexo;

    @Column (name = "contacto_emergencia")
    private String contactoEmergencia;

    @Column (name = "telefono_emergencia")
    private String telefonoEmergencia;
}
