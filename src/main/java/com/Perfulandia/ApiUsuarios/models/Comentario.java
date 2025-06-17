package com.Perfulandia.ApiUsuarios.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "COMENTARIO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private Integer idComentario;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "PEDIDO_id_pedido")
    private Integer idPedido; // Relación con Pedido
}