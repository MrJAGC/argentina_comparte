package com.usta.argentina_comparte.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "testimonios")
public class TestimonioEntity  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_testimonio")
    private Long idTestimonio;

    @NotBlank
    @Size(max = 50)
    @Column(name = "nombre_testimonio", length = 50, nullable = false)
    private String testimonio;

    @Size(max = 200)
    @Column(name = "foto_url")
    private String fotoUrl;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_testimonio", nullable = false)
    private LocalDate fechaTestimonio;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity usuario;

    public TestimonioEntity() {
    }

}
