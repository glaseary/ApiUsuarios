package com.Perfulandia.ApiUsuarios.dto;

import org.springframework.hateoas.RepresentationModel;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO extends RepresentationModel <UsuarioDTO> {
    private Integer idUsuario;
    private String nombreUsuario;
    private String email;
    private Boolean activo;
    private Integer idRol;   // Referencia a Rol
    private Integer idComuna; // Referencia a Comuna
}