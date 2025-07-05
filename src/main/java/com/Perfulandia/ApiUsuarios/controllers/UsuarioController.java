package com.Perfulandia.ApiUsuarios.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.hateoas.Link;
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

    // --- Endpoints CRUD (Sin cambios) ---

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

    // --- Endpoints HATEOAS (Nuevos) ---

    /**
     * Devuelve un solo usuario con links HATEOAS detallados.
     * GET /api/usuarios/{id}/hateoas
     */
    @GetMapping("/hateoas/{id}")
    public ResponseEntity<?> getUsuarioHATEOAS(@PathVariable Integer id) {
        try {
            UsuarioDTO usuario = service.buscarUsuarioPorId(id);
            String gatewayUrl = "http://localhost:8888/api/proxy/usuarios";

            // Limpiamos links por si acaso
            usuario.removeLinks();

            // Añadimos los links correspondientes
            usuario.add(Link.of(gatewayUrl + "/hateoas/" + id).withSelfRel());
            usuario.add(Link.of(gatewayUrl + "/hateoas").withRel("todos-los-usuarios"));
            usuario.add(Link.of(gatewayUrl + "/" + id).withRel("actualizar").withType("PUT"));
            usuario.add(Link.of(gatewayUrl + "/" + id).withRel("eliminar").withType("DELETE"));
            
            // Ejemplo de link a un recurso relacionado (si existiera)
            // usuario.add(Link.of(gatewayUrl + "/" + id + "/pedidos").withRel("pedidos-del-usuario"));

            return ResponseEntity.ok(usuario);

        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("mensaje", ex.getMessage()));
        }
    }

    /**
     * Devuelve la lista de usuarios, cada uno con sus links HATEOAS básicos.
     * GET /api/usuarios/hateoas
     */
    @GetMapping("/hateoas")
    public ResponseEntity<List<UsuarioDTO>> listarHATEOAS() {
        List<UsuarioDTO> usuarios = service.listarUsuarios();
        String gatewayUrl = "http://localhost:8888/api/proxy/usuarios";

        for (UsuarioDTO dto : usuarios) {
            // Limpiamos links por si acaso
            dto.removeLinks();

            // Link a sí mismo (self)
            dto.add(Link.of(gatewayUrl + "/hateoas/" + dto.getIdUsuario()).withSelfRel());
            
            // Link para crear un nuevo usuario
            dto.add(Link.of(gatewayUrl).withRel("crear-usuario").withType("POST"));
        }
        return ResponseEntity.ok(usuarios);
    }
}