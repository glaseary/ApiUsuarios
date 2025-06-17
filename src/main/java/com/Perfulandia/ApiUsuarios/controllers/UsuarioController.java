package com.Perfulandia.ApiUsuarios.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Perfulandia.ApiUsuarios.dto.CrearUsuarioRequest;
import com.Perfulandia.ApiUsuarios.dto.UsuarioDTO;
import com.Perfulandia.ApiUsuarios.models.Usuario;
import com.Perfulandia.ApiUsuarios.services.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping
    public List<UsuarioDTO> getAll() {
        return service.listarUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        try {
            UsuarioDTO usuario = service.buscarUsuarioPorId(id);
            return ResponseEntity.ok(usuario);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("mensaje", ex.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<Usuario> crear(@RequestBody CrearUsuarioRequest request) {
        Usuario creado = service.crearUsuario(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> editarUsuario(@PathVariable Integer id, @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO actualizado = service.actualizarUsuario(id, usuarioDTO);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}