package com.Perfulandia.ApiUsuarios.dto;

import lombok.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
    private Integer idPedido;
    private Date fechaPedido;
    private String estado;
    private Integer totalNeto;
    private Integer idUsuario; 
    private Integer idProducto; 
    private Integer idCupon; 
}