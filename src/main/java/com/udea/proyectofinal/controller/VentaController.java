package com.udea.proyectofinal.controller;

import com.udea.proyectofinal.model.Cliente;
import com.udea.proyectofinal.model.Producto;
import com.udea.proyectofinal.model.Venta;
import com.udea.proyectofinal.service.ClienteService;
import com.udea.proyectofinal.service.ProductoService;
import com.udea.proyectofinal.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/venta")
    public String venta(Model model) {
        model.addAttribute("ventas", ventaService.getAllVentas());
        return "venta";
    }

    @GetMapping("/venta/agregar")
    public String mostrarFormularioAgregar(Model model) {
        model.addAttribute("productos", productoService.getAllProducto());
        model.addAttribute("clientes", clienteService.getAllClientes());
        return "agregarVenta";
    }

    // RequestParam = lo uso para atrapar lo que le ingresamos en los campos y mandarlo en el objeto
    @PostMapping("/venta/agregar")
    public String agregarVenta(@RequestParam Long producto, @RequestParam Long cliente, @RequestParam int cantidad, @RequestParam String estado, RedirectAttributes redirectAttributes) {
        try {
            Producto productoObj = productoService.getProductoById(producto);
            Venta venta = new Venta();
            venta.setProducto(productoObj);
            venta.setCliente(clienteService.getClienteById(cliente));
            venta.setCantidad(cantidad);
            venta.setEstado(estado);
            venta.setPrecioUnitario(productoObj.getPrecio());
            venta.setTotal(productoObj.getPrecio() * cantidad);
            ventaService.saveVenta(venta);
            redirectAttributes.addFlashAttribute("mensaje", "Venta realizada exitosamente");
            return "redirect:/venta";
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/venta/agregar";
        }
    }

    @GetMapping("/venta/delete/{id}")
    public String deleteVenta(@PathVariable Long id) {
        ventaService.deleteVenta(id);
        return "redirect:/venta";
    }

    // ruta para editar estado de venta (pagado despachado pendiente)
    @PostMapping("/venta/update-estado/{id}")
    public String updateEstado(@PathVariable Long id, @RequestParam String estado) {
        ventaService.updateEstado(id, estado);
        return "redirect:/venta";
    }
}
