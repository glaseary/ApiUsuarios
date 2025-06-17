package com.Perfulandia.ApiUsuarios.services;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Perfulandia.ApiUsuarios.config.UsuarioMapper;
import com.Perfulandia.ApiUsuarios.dto.CrearUsuarioRequest;
import com.Perfulandia.ApiUsuarios.dto.UsuarioDTO;
import com.Perfulandia.ApiUsuarios.models.Usuario;
import com.Perfulandia.ApiUsuarios.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepo;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioMapper mapper;

    // Listar todos los usuarios
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepo.findAll().stream()
            .map(mapper::usuarioToDto)
            .toList();
    }

    // Crear un nuevo usuario
    public Usuario crearUsuario(CrearUsuarioRequest req) {
        try {
            Usuario usuario = new Usuario();
            usuario.setNombreUsuario(req.getNombreUsuario());
            usuario.setEmail(req.getEmail());

            String rawPassword = req.getPassword();
            if (rawPassword == null || rawPassword.isBlank()) {
                throw new IllegalArgumentException("La contraseña es requerida");
            }
            usuario.setPassword(passwordEncoder.encode(rawPassword));

            usuario.setActivo(true);
            usuario.setIdRol(req.getIdRol());
            usuario.setIdComuna(req.getIdComuna());

            System.out.println("DEBUG >> Usuario a guardar: " + usuario);

            return usuarioRepo.save(usuario);

        } catch (Exception e) {
            System.out.println("❌ ERROR al crear usuario:");
            e.printStackTrace(); // Esto te muestra la traza completa en consola
            throw e; // re-lanza la excepción para que el controlador lo capture
        }
    }

    // Buscar usuario por ID
    public UsuarioDTO buscarUsuarioPorId(Integer id) {
        Usuario usuario = usuarioRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
        return mapper.usuarioToDto(usuario);
    }

    // Actualizar usuario
    public UsuarioDTO actualizarUsuario(Integer id, UsuarioDTO dto) {
        Usuario usuario = usuarioRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));

        usuario.setNombreUsuario(dto.getNombreUsuario());
        usuario.setEmail(dto.getEmail());
        usuario.setActivo(dto.getActivo());
        usuario.setIdRol(dto.getIdRol());
        usuario.setIdComuna(dto.getIdComuna());

        return mapper.usuarioToDto(usuarioRepo.save(usuario));
    }

    // Eliminar usuario
    public void eliminarUsuario(Integer id) {
        usuarioRepo.deleteById(id);
    }
}