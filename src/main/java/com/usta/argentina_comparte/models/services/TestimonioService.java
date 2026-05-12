package com.usta.argentina_comparte.models.services;

import com.usta.argentina_comparte.entities.TestimonioEntity;

import java.util.List;

public interface TestimonioService {

    List<TestimonioEntity> listarTestimonios();
    TestimonioEntity buscarPorId(Long id);
    List<TestimonioEntity> buscarPorUsuario(String idUsuario);
    void guardar(TestimonioEntity testimonio);
    void eliminar(Long id);
    List<TestimonioEntity> filtrar(String nombre);
}
