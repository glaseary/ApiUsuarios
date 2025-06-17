package com.Perfulandia.ApiUsuarios.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "SOPORTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Soporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    private Integer idTicket;

    @Column(name = "asunto", nullable = false)
    private String asunto;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;

    @Column(name = "fecha_cierre")
    private Date fechaCierre;

    @Column(name = "USUARIO_id_usuario")
    private Integer idUsuario; // Relación con Usuario
}