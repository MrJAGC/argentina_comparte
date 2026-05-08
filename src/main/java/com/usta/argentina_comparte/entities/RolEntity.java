package com.usta.argentina_comparte.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "roles")
public class RolEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long idRol;

    @NotBlank
    @Size(max = 20)
    @Column(name= "nombre_rol",length = 20, nullable = false)
    private String rol;

    public RolEntity() {
    }

    public RolEntity(String rol) {
        this.rol = rol;
    }
}
