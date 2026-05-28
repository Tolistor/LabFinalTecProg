package com.udea.proyectofinal.repository;

import com.udea.proyectofinal.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// nos da todos lo metodos CRUD (Create, Read, Update, Delete) de la base de datos
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
