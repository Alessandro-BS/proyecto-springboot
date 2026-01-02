package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.MovimientoStock;
import com.example.demo.model.Producto;

import java.util.List;

public interface MovimientoStockRepository extends JpaRepository<MovimientoStock, Long> {
    // Obtener todos los movimientos de un producto
    List<MovimientoStock> findByProducto(Producto producto);
}
