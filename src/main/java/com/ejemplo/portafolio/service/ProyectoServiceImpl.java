package com.ejemplo.portafolio.service;

import com.ejemplo.portafolio.model.Proyecto;
import com.ejemplo.portafolio.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoServiceImpl implements ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    public List<Proyecto> listarTodos() {
        return proyectoRepository.findAll();
    }

    @Override
    public Proyecto buscarPorId(Integer id) {
        return proyectoRepository.findById(id);
    }

    @Override
    public void guardar(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
    }

    @Override
    public void actualizar(Proyecto proyecto) {
        proyectoRepository.update(proyecto);
    }

    @Override
    public void eliminar(Integer id) {
        proyectoRepository.deleteById(id);
    }
}