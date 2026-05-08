package com.usta.argentina_comparte.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "usuarios")

public class UsuarioEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Size(max = 15)
    @Column(name = "id_usuario")
    private String idUsuario;

    @NotBlank
    @Size(max = 50)
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @NotBlank
    @Email
    @Size(max = 100)
    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @NotBlank
    @Size(max = 15)
    @Column(name = "telefono", length = 15, nullable = false)
    private String telefono;

    @NotBlank
    @Size(max = 100)
    @Column(name = "contraseña", length = 100, nullable = false, unique = true)
    private String contraseña;

    @Column(name = "estado_usu", nullable = false)
    private boolean estadoUsu = true;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_rol", nullable = false)
    private RolEntity rol;

    public UsuarioEntity() {
    }
}
