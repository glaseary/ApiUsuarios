package com.Perfulandia.ApiUsuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Perfulandia.ApiUsuarios.models.Pedido;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    
    // Obtener pedidos de un usuario específico
    List<Pedido> findByIdUsuario(Integer idUsuario);
}