package com.gestion.paciente.gestionpaciente.excepcion;

public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException(String message) {
        super(message);
    }
}
