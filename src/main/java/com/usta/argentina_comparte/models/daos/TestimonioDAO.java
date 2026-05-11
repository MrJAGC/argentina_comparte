package com.usta.argentina_comparte.models.daos;

import com.usta.argentina_comparte.entities.TestimonioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestimonioDAO extends JpaRepository<TestimonioEntity, Long> {

    List<TestimonioEntity> findByUsuario_IdUsuario(String idUsuario);

    @Query("""
        SELECT t FROM TestimonioEntity t
        WHERE (:nombre IS NULL OR :nombre = '' OR 
            LOWER(t.testimonio) LIKE LOWER(CONCAT('%', :nombre, '%') ) )
""")

    List<TestimonioEntity> filtrarTestimonios(
            @Param("nombre") String nombre
    );
}
