package com.usta.argentina_comparte.models.services;

import com.usta.argentina_comparte.entities.NoticiaEntity;

import java.util.List;

public interface NoticiaService {
    List<NoticiaEntity> listarNoticias();
    List<NoticiaEntity> listarNoticiasActivas();
    NoticiaEntity buscarPorId(Long id);
    void guardar(NoticiaEntity noticia);
    void eliminar(Long id);
    List<NoticiaEntity> filtar(String titulo, Boolean estado);
}
