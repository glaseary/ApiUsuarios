package com.Perfulandia.ApiUsuarios.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "USUARIO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nombre_usuario", nullable = false)
    private String nombreUsuario;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "activo", nullable = false)
    private Boolean activo;

    @Column(name = "COMUNA_id_comuna")
    private Integer idComuna; // Referencia a Comuna (gestión externa)

    @Column(name = "ROL_id_rol")
    private Integer idRol; // Referencia a Rol (gestión externa)
}
