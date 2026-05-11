package com.usta.argentina_comparte.models.daos;

import com.usta.argentina_comparte.entities.NoticiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoticiaDAO extends JpaRepository<NoticiaEntity, Long> {

    List<NoticiaEntity> findByEstadoNoticiaTrue();

    @Query("""
        SELECT n FROM NoticiaEntity n
        WHERE (:titulo IS NULL OR :titulo = '' OR
            LOWER(n.tituloNoticia) LIKE LOWER(CONCAT('%', :tituloNoticia, '%') ) )
        AND (:estado_ntc IS NULL OR n.estadoNoticia = :estadoNoticia)
    """)

    List<NoticiaEntity> findByNoticias(
            @Param("titulo") String tituloNotica,
            @Param("estado_ntc") Boolean estadoNoticia
    );
}
