package com.ejemplo.portafolio.controller;

import com.ejemplo.portafolio.model.Proyecto;
import com.ejemplo.portafolio.service.ProyectoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @GetMapping("/")
    public String inicio() {
        return "redirect:/proyectos";
    }

    @GetMapping
    public String listarProyectos(Model model) {
        model.addAttribute("proyectos", proyectoService.listarTodos());
        model.addAttribute("proyecto", new Proyecto());
        return "portafolio";
    }

    @PostMapping
    public String guardarProyecto(@Valid @ModelAttribute("proyecto") Proyecto proyecto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("proyectos", proyectoService.listarTodos());
            return "portafolio";
        }
        proyectoService.guardar(proyecto);
        return "redirect:/proyectos";
    }

    @PutMapping("/editar/{id}")
    public String actualizarProyecto(@PathVariable Integer id, @Valid @ModelAttribute("proyecto") Proyecto proyecto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("proyectos", proyectoService.listarTodos());
            return "portafolio";
        }
        proyecto.setId(id);
        proyectoService.actualizar(proyecto);
        return "redirect:/proyectos";
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarProyecto(@PathVariable Integer id) {
        proyectoService.eliminar(id);
        return "redirect:/proyectos";
    }
}