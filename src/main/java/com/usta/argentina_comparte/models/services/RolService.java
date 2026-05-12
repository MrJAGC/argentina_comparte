package com.usta.argentina_comparte.models.services;

import com.usta.argentina_comparte.entities.RolEntity;

import java.util.List;

public interface RolService {
    List<RolEntity> listarRoles();
    RolEntity buscarPorId(Long id);
    void guardar(RolEntity rol);
    void eleminar(Long id);
}
