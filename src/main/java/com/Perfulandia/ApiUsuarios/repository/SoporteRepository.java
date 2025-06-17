package com.Perfulandia.ApiUsuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Perfulandia.ApiUsuarios.models.Soporte;
import java.util.List;

public interface SoporteRepository extends JpaRepository<Soporte, Integer> {
    
    // Buscar tickets de soporte por usuario
    List<Soporte> findByIdUsuario(Integer idUsuario);
}