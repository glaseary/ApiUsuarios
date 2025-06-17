package com.Perfulandia.ApiUsuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Perfulandia.ApiUsuarios.models.Comentario;
import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
    
    // Obtener comentarios asociados a un pedido
    List<Comentario> findByIdPedido(Integer idPedido);
}