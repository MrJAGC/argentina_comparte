package com.usta.argentina_comparte.models.services;

import com.usta.argentina_comparte.entities.NoticiaEntity;
import com.usta.argentina_comparte.models.daos.NoticiaDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticiaServiceImpl implements NoticiaService{

    private final NoticiaDAO noticiaDAO;

    public NoticiaServiceImpl(NoticiaDAO noticiaDAO) {
        this.noticiaDAO = noticiaDAO;
    }

    @Override
    public List<NoticiaEntity> listarNoticias() {
        return noticiaDAO.findAll();
    }

    @Override
    public List<NoticiaEntity> listarNoticiasActivas() {
        return noticiaDAO.findByEstadoNoticiaTrue();
    }

    @Override
    public NoticiaEntity buscarPorId(Long id) {
        return noticiaDAO.findById(id).orElseThrow(() -> new RuntimeException("Noticia no encontrada"));
    }

    @Override
    public void guardar(NoticiaEntity noticia) {
        noticiaDAO.save(noticia);
    }

    @Override
    public void eliminar(Long id) {
        noticiaDAO.deleteById(id);
    }

    @Override
    public List<NoticiaEntity> filtar(String titulo, Boolean estado) {
        return noticiaDAO.findByNoticias(titulo, estado);
    }
}
