package com.usta.argentina_comparte.models.daos;

import com.usta.argentina_comparte.entities.SoliContactoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SoliContactoDAO extends JpaRepository<SoliContactoEntity, Long> {

    List<SoliContactoEntity> findByEmail(String email);

    @Query("""
        SELECT s FROM SoliContactoEntity s
        WHERE (:nombre IS NULL OR :nombre = '' OR
            LOWER(s.nombre) LIKE LOWER(CONCAT('%', :nombre, '%') ) )
            AND (:email IS NULL OR :email = '' OR 
            LOWER(s.email) LIKE LOWER(CONCAT('%', :email, '%') ) )
            AND (:desde IS NULL OR s.fechaSolicitud >= :desde)
            AND (:hasta IS NULL OR s.fechaSolicitud <= :hasta)
""")

    List<SoliContactoEntity> filtrarSolicitudes(
            @Param("nombre") String nombre,
            @Param("email") String email,
            @Param("desde") LocalDate desde,
            @Param("hasta") LocalDate hasta
    );
}
