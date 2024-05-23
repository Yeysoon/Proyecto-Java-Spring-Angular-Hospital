package com.gestion.paciente.gestionpaciente.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestion.paciente.gestionpaciente.entidades.Doctores;

public interface DoctoresRepositorio extends JpaRepository<Doctores, Long>{
        
    @Query("SELECT f.facturaId, f.fechaFactura, c.nombre AS nombreCliente, f.total, df.cantidad AS cantidadProducto, df.precioUnitario"
        +
        "FROM Factura f, DetalleFactura df, Cliente c"+
        "WHERE f.facturaId = df.factura.facturaId AND f.cliente.clienteId = c.clienteId AND f.cliente.clienteId = :clienteId")
    List<Object[]> getDoctores(@Param("clienteId")Long clienteId);
}