package com.usta.argentina_comparte.models.services;

import com.usta.argentina_comparte.entities.SoliContactoEntity;

import java.time.LocalDate;
import java.util.List;

public interface SoliContactoService {
    List<SoliContactoEntity> listarSolicitudes();
    SoliContactoEntity buiscarPorId(Long id);
    List<SoliContactoEntity> buscarPorEmail(String email);
    void guardar(SoliContactoEntity solicitud);
    void eliminar(Long id);
    List<SoliContactoEntity> filtrar(String nombre, String email, LocalDate desde, LocalDate hasta);
}
