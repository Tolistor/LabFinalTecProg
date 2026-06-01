package com.udea.proyectofinal.service;

import com.udea.proyectofinal.model.Categoria;
import com.udea.proyectofinal.repository.CategoriaRepository;
import com.udea.proyectofinal.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria saveCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria getCategoriaById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public void deleteCategoria(Long id) {
        // Verificar si hay productos asociados a la categoría
        long productosCount = productoRepository.countByCategoriaId(id);
        if (productosCount > 0) {
            throw new RuntimeException("No se puede eliminar la categoría porque tiene " + productosCount + " producto(s) asociado(s)");
        }
        categoriaRepository.deleteById(id);
    }
}
