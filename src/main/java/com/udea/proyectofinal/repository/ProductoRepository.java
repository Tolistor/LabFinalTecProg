package com.udea.proyectofinal.repository;

import com.udea.proyectofinal.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
    @Query("SELECT COUNT(p) FROM Producto p WHERE p.categoria.id = :categoriaId")
    long countByCategoriaId(@Param("categoriaId") Long categoriaId);
}
