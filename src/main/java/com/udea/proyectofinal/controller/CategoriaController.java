package com.udea.proyectofinal.controller;

import com.udea.proyectofinal.model.Categoria;
import com.udea.proyectofinal.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categoria")
    public String categoria(Model model) {
        model.addAttribute("categorias", categoriaService.getAllCategorias());
        return "categoria";
    }

    @GetMapping("/categoria/agregar")
    public String mostrarFormularioAgregar() {
        return "agregarCategoria";
    }

    @PostMapping("/categoria/agregar")
    public String agregarCategoria(Categoria categoria) {
        categoriaService.saveCategoria(categoria);
        return "redirect:/categoria";
    }

    @GetMapping("/categoria/delete/{id}")
    public String deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
        return "redirect:/categoria";
    }
}
