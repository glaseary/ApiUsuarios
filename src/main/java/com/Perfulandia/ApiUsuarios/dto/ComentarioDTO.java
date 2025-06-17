package com.Perfulandia.ApiUsuarios.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComentarioDTO {
    private Integer idComentario;
    private String descripcion;
    private Integer idPedido;
}