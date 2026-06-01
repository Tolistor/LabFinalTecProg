package com.udea.proyectofinal.service;

import com.udea.proyectofinal.model.Cliente;
import com.udea.proyectofinal.model.Producto;
import com.udea.proyectofinal.repository.ClienteRepository;
import com.udea.proyectofinal.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    //Todos los productos
    public List<Producto> getAllProducto() {
        return productoRepository.findAll();
    }

    //guardar un producto
    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    //producto por ID
    public Producto getProductoById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    // borrar producto
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }

}
