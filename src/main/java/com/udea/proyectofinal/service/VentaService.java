package com.udea.proyectofinal.service;

import com.udea.proyectofinal.model.Producto;
import com.udea.proyectofinal.model.Venta;
import com.udea.proyectofinal.repository.VentaRepository;
import com.udea.proyectofinal.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    public Venta saveVenta(Venta venta) {
        Producto producto = venta.getProducto();
        
        if (producto.getStock() < venta.getCantidad()) {
            throw new RuntimeException("Stock insuficiente. Stock disponible: " + producto.getStock());
        }
        
        producto.setStock(producto.getStock() - venta.getCantidad());
        productoRepository.save(producto);
        
        return ventaRepository.save(venta);
    }

    public Venta getVentaById(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    public void deleteVenta(Long id) {
        Venta venta = getVentaById(id);
        if (venta != null) {
            Producto producto = venta.getProducto();
            producto.setStock(producto.getStock() + venta.getCantidad());
            productoRepository.save(producto);
        }
        ventaRepository.deleteById(id);
    }
}
