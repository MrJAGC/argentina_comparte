package com.usta.argentina_comparte.models.services;

import com.usta.argentina_comparte.entities.UsuarioEntity;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<UsuarioEntity> listarUsuarios();
    UsuarioEntity buscarPorId(String id);
    Optional<UsuarioEntity> buscarPorEmail(String email);
    void guardar(UsuarioEntity usuario);
    void eliminar(String id);
    boolean existePorEmail(String email);
}
