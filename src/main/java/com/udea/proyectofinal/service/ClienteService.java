package com.udea.proyectofinal.service;

import com.udea.proyectofinal.model.Cliente;
import com.udea.proyectofinal.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    //Todos los clientes
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    //guardar un cliente
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    //cliente por ID
    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    // borrar cliente
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
