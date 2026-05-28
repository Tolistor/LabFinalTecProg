package com.udea.proyectofinal.controller;

import com.udea.proyectofinal.model.Cliente;
import com.udea.proyectofinal.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    //ruta para ver todos los clientes
    @GetMapping("/cliente")
    public String cliente(Model model) {
        model.addAttribute("clientes", clienteService.getAllClientes());
        return "cliente";
    }
    // miestra en la ruta "agregar"
    @GetMapping("/cliente/agregar")
    public String mostrarFormularioAgregar() {
        return "agregar";
    }

    // lelva la informacion (los atributos deben llamarse igual que los del objeto pa evitar problemas)
    @PostMapping("/cliente/agregar")
    public String agregarCliente(Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "redirect:/cliente";
    }
//    // vista para agregar cliente
//    @GetMapping("/cliente/agregar")
//    public String mostrarFormularioAgregar() {
//        return "agregar";
//    }
//
//    // para agregar cliente la ruta es /cliente/agregar
//    @PostMapping("/cliente/agregar")
//    public String agregarCliente(@RequestParam String documento, @RequestParam String nombre, @RequestParam String direccion, @RequestParam String correo) {
//        Cliente cliente = new Cliente();
//        cliente.setDocumento(documento);
//        cliente.setNombre(nombre);
//        cliente.setDireccion(direccion);
//        cliente.setCorreo(correo);
//        clienteService.saveCliente(cliente);
//        return "redirect:/cliente";
//    }

    // para borrar cliente
    @GetMapping("/cliente/delete/{id}")
    public String deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return "redirect:/cliente";
    }
}
