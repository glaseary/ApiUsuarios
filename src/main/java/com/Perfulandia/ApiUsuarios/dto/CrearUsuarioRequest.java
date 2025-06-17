package com.Perfulandia.ApiUsuarios.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrearUsuarioRequest {
    private String nombreUsuario;
    private String email;
    
    @JsonProperty("password") 
    private String password;

    private Integer idRol; // Se asigna desde la API externa de roles
    private Integer idComuna; // Se asigna desde la API externa de comunas
}