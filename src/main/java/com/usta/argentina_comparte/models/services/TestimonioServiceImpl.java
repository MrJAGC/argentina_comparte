package com.usta.argentina_comparte.models.services;

import com.usta.argentina_comparte.entities.TestimonioEntity;
import com.usta.argentina_comparte.models.daos.TestimonioDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestimonioServiceImpl implements TestimonioService{

    private final TestimonioDAO testimonioDAO;

    public TestimonioServiceImpl(TestimonioDAO testimonioDAO) {
        this.testimonioDAO = testimonioDAO;
    }

    @Override
    public List<TestimonioEntity> listarTestimonios() {
        return testimonioDAO.findAll();
    }

    @Override
    public TestimonioEntity buscarPorId(Long id) {
        return testimonioDAO.findById(id).orElseThrow(() -> new RuntimeException("Testimonio no encontrado"));
    }

    @Override
    public List<TestimonioEntity> buscarPorUsuario(String idUsuario) {
        return testimonioDAO.findByUsuario_IdUsuario(idUsuario);
    }

    @Override
    public void guardar(TestimonioEntity testimonio) {
        testimonioDAO.save(testimonio);
    }

    @Override
    public void eliminar(Long id) {
        testimonioDAO.deleteById(id);
    }

    @Override
    public List<TestimonioEntity> filtrar(String nombre) {
        return testimonioDAO.filtrarTestimonios(nombre);
    }
}