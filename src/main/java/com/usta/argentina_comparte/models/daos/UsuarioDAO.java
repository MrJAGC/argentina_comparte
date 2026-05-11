package com.usta.argentina_comparte.models.daos;

import com.usta.argentina_comparte.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioDAO extends JpaRepository<UsuarioEntity, String> {
    
    Optional<UsuarioEntity> findByEmail(String email);

    boolean existsByEmail(String email);
}
