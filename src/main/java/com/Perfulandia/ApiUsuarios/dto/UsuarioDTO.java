package com.Perfulandia.ApiUsuarios.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Integer idUsuario;
    private String nombreUsuario;
    private String email;
    private Boolean activo;
    private Integer idRol;   // Referencia a Rol
    private Integer idComuna; // Referencia a Comuna
}