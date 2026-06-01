package com.udea.proyectofinal.controller;


import com.udea.proyectofinal.model.Cliente;
import com.udea.proyectofinal.model.Producto;
import com.udea.proyectofinal.service.ClienteService;
import com.udea.proyectofinal.service.ProductoService;
import com.udea.proyectofinal.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    //ruta para ver todos los clientes
    @GetMapping("/producto")
    public String producto(Model model) {
        model.addAttribute("clientes", productoService.getAllProducto());
        return "producto";
    }
    // miestra en la ruta "agregar"
    @GetMapping("/producto/agregar")
    public String mostrarFormularioAgregar(Model model) {
        model.addAttribute("categorias", categoriaService.getAllCategorias());
        return "agregarProducto";
    }

    // lelva la informacion (los atributos deben llamarse igual que los del objeto pa evitar problemas)
    @PostMapping("/producto/agregar")
    public String agregarProducto(@RequestParam String referencia, @RequestParam Long categoria, @RequestParam int precio, @RequestParam int stock) {
        Producto producto = new Producto();
        producto.setReferencia(referencia);
        producto.setCategoria(categoriaService.getCategoriaById(categoria));
        producto.setPrecio(precio);
        producto.setStock(stock);
        productoService.saveProducto(producto);
        return "redirect:/producto";
    }

    @GetMapping("/producto/delete/{id}")
    public String deleteCliente(@PathVariable Long id) {
        productoService.deleteProducto(id);
        return "redirect:/producto";
    }
}
