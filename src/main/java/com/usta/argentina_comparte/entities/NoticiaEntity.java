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
@Table(name = "noticias")
public class NoticiaEntity implements Serializable {

    private static final long sertialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long codigoNoticia;

    @NotBlank
    @Size(max = 50)
    @Column(name = "titulo", length = 50, nullable = false)
    private String tituloNoticia;

    @NotBlank
    @Size(max = 150)
    @Column(name = "resumen", length = 150, nullable = false)
    private String resumen;

    @NotBlank
    @Size(max = 400)
    @Column(name = "contenido", length = 400, nullable = false)
    private String contenido;

    @Size(max = 200)
    @Column(name = "foto_url", length = 200, nullable = false)
    private String fotoUrl;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_publicacion", nullable = false)
    private LocalDate fechaPublicacion;

    @Column(name = "estado_ntc", nullable = false)
    private boolean estadoNoticia;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity usuario;

    public NoticiaEntity() {
    }

}
