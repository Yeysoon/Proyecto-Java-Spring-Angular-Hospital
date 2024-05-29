package com.gestion.paciente.gestionpaciente.repositorio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion.paciente.gestionpaciente.entidades.Citas;


public interface CitasRepositorio extends JpaRepository<Citas, Long>{

    List<Citas> findByCitas(Long idCita);
}
