package com.udea.proyectofinal.repository;

import com.udea.proyectofinal.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
    
    @Query("SELECT COUNT(v) FROM Venta v WHERE v.producto.id = :productoId")
    long countByProductoId(@Param("productoId") Long productoId);
}
