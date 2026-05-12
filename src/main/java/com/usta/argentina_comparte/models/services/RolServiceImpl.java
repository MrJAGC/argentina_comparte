package com.usta.argentina_comparte.models.services;

import com.usta.argentina_comparte.entities.RolEntity;
import com.usta.argentina_comparte.models.daos.RolDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService{

    private final RolDAO rolDAO;

    public RolServiceImpl(RolDAO rolDAO) {
        this.rolDAO = rolDAO;
    }


    @Override
    public List<RolEntity> listarRoles() {
        return rolDAO.findAll();
    }

    @Override
    public RolEntity buscarPorId(Long id) {
        return rolDAO.findById(id).orElseThrow(() -> new RuntimeException("Este rol no existe"));
    }

    @Override
    public void guardar(RolEntity rol) {
        rolDAO.save(rol);
    }

    @Override
    public void eleminar(Long id) {
        rolDAO.deleteById(id);
    }
}
