package com.usta.argentina_comparte.models.services;

import com.usta.argentina_comparte.entities.SoliContactoEntity;
import com.usta.argentina_comparte.models.daos.SoliContactoDAO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SoliContactoServiceImpl implements SoliContactoService {

    private final SoliContactoDAO soliContactoDAO;

    public SoliContactoServiceImpl(SoliContactoDAO soliContactoDAO) {
        this.soliContactoDAO = soliContactoDAO;
    }

    @Override
    public List<SoliContactoEntity> listarSolicitudes() {
        return soliContactoDAO.findAll();
    }

    @Override
    public SoliContactoEntity buiscarPorId(Long id) {
        return soliContactoDAO.findById(id).orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
    }

    @Override
    public List<SoliContactoEntity> buscarPorEmail(String email) {
        return soliContactoDAO.findByEmail(email);
    }

    @Override
    public void guardar(SoliContactoEntity solicitud) {
        soliContactoDAO.save(solicitud);
    }

    @Override
    public void eliminar(Long id) {
        soliContactoDAO.deleteById(id);
    }

    @Override
    public List<SoliContactoEntity> filtrar(String nombre, String email, LocalDate desde, LocalDate hasta) {
        return soliContactoDAO.filtrarSolicitudes(nombre, email, desde, hasta);
    }
}
