package com.usta.argentina_comparte.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "solicitud_contacto")

public class SoliContactoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_solicitud")
    private Long numeroSolicitud;

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
    @Column(name = "telefono")
    private String telefono;

    @NotBlank
    @Size(max = 250)
    @Column(name = "finalidad", length = 250, nullable = false)
    private String finalidad;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_solicitud", nullable = false)
    private LocalDate fechaSolicitud;

    public SoliContactoEntity() {
    }
}
