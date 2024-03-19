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
@Table(name="formulario_paciente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pacientes {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long idPacientes;

    @Column (name = "nombre_paciente")
    private String nombrePaciente;

    private Integer edad;

    @Column (name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    private String genero;
    private String direccion;
    private Integer telefono;
    private Boolean seguro;

    @Column (name = "numero_identificacion")
    private Integer numeroIdentificacion;

    private float peso;
    private float estatura;
    private String medicamento;
    private String alergias;
    
    @Column (name = "fecha_alta")
    private LocalDate fechaAlta;
    private String Razon;


}
