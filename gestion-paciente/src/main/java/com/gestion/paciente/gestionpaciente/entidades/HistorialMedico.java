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
@Table(name="historial_medico")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistorialMedico {


    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_historial")
    private Long idHistorial;

    private String peso;
    private String estatura;
    private String medicamento;
    private String alergias;
    private String consumo;

    @Column (name = "dado_alta")
    private LocalDate dadodealta;

    private String razon;
   
}
