package com.Perfulandia.ApiUsuarios.config;

import org.springframework.stereotype.Component;
import com.Perfulandia.ApiUsuarios.dto.UsuarioDTO;
import com.Perfulandia.ApiUsuarios.models.Usuario;

@Component
public class UsuarioMapper {
    
    public UsuarioDTO usuarioToDto(Usuario usuario) {
        return new UsuarioDTO(
            usuario.getIdUsuario(),
            usuario.getNombreUsuario(),
            usuario.getEmail(),
            usuario.getActivo(),
            usuario.getIdRol(),
            usuario.getIdComuna()
        );
    }
}