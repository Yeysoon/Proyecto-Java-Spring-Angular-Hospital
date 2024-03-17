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

public class TipoPacientes {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_paciente")
    private Long idPacientes;

    @Column (name = "paciente_nuevo")
    private String pacientenuevo;

    @Column (name = "paciente_existente")
    private String pacineteexistente;

    @Column (name = "numero_identificacion")
    private Integer identificacion;
    

    @Column (name = "nombre_paciente")
    private String nombrepaciente;

    
    
    
}
