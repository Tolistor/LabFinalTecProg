package com.udea.proyectofinal.repository;

import com.udea.proyectofinal.model.Producto;
import com.udea.proyectofinal.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository  extends JpaRepository<Producto, Long>{

}
