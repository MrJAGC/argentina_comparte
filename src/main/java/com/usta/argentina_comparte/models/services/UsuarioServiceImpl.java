package com.usta.argentina_comparte.models.services;

import com.usta.argentina_comparte.entities.UsuarioEntity;
import com.usta.argentina_comparte.models.daos.UsuarioDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioDAO usuarioDAO;

    public UsuarioServiceImpl(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    public List<UsuarioEntity> listarUsuarios(){
        return usuarioDAO.findAll();
    }

    @Override
    public UsuarioEntity buscarPorId(String id) {
        return usuarioDAO.findById(id).orElseThrow(()  -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public Optional<UsuarioEntity> buscarPorEmail(String email) {
        return usuarioDAO.findByEmail(email);
    }

    @Override
    public void guardar(UsuarioEntity usuario) {
        usuarioDAO.save(usuario);
    }

    @Override
    public void eliminar(String id) {
        usuarioDAO.deleteById(id);
    }

    @Override
    public boolean existePorEmail(String email) {
        return usuarioDAO.existsByEmail(email);
    }
}
