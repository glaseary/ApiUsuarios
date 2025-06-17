package com.Perfulandia.ApiUsuarios.dto;

import lombok.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SoporteDTO {
    private Integer idTicket;
    private String asunto;
    private String descripcion;
    private String estado;
    private Date fechaCreacion;
    private Date fechaCierre;
    private Integer idUsuario;
}