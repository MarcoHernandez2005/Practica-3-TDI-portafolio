package com.ejemplo.portafolio.service;

import com.ejemplo.portafolio.model.Proyecto;
import java.util.List;

public interface ProyectoService {
    List<Proyecto> listarTodos();
    Proyecto buscarPorId(Integer id);
    void guardar(Proyecto proyecto);
    void actualizar(Proyecto proyecto);
    void eliminar(Integer id);
}