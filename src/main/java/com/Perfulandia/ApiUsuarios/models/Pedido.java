package com.Perfulandia.ApiUsuarios.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "PEDIDO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer idPedido;

    @Column(name = "fecha_pedido", nullable = false)
    private Date fechaPedido;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "total_neto", nullable = false)
    private Integer totalNeto;

    @Column(name = "USUARIO_id_usuario")
    private Integer idUsuario; // Relación con Usuario

    @Column(name = "PRODUCTO_id_producto")
    private Integer idProducto; // Referencia a Producto (gestión externa)

    @Column(name = "CUPON_id_cupon")
    private Integer idCupon; // Referencia a Cupón (gestión externa)
}