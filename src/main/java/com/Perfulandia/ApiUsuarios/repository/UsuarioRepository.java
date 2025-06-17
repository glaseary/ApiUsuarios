package com.Perfulandia.ApiUsuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Perfulandia.ApiUsuarios.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    // Buscar usuario por email (útil para autenticación)
    Usuario findByEmail(String email);
}