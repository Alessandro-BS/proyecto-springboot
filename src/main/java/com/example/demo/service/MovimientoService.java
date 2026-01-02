package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Movimiento;
import com.example.demo.model.Producto;
import com.example.demo.model.TipoMovimiento;
import com.example.demo.repository.MovimientoRepository;
import com.example.demo.repository.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepo;

    @Autowired
    private ProductoRepository productoRepo;

    @Transactional
    public Movimiento registrarMovimiento(
            Long productoId,
            TipoMovimiento tipo,
            Integer cantidad) {

        Producto producto = productoRepo.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no existente"));

        if (cantidad <= 0) {
            throw new RuntimeException("Cantidad invalida");
        }

        if (tipo == TipoMovimiento.SALIDA && producto.getStock() < cantidad) {
            throw new RuntimeException("Stock insuficiente");
        }

        // Actualizar stock
        if (tipo == TipoMovimiento.ENTRADA) {
            producto.setStock(producto.getStock() + cantidad);
        } else {
            producto.setStock(producto.getStock() - cantidad);
        }
        productoRepo.save(producto);

        Movimiento mov = new Movimiento();
        mov.setTipo(tipo);
        mov.setCantidad(cantidad);
        mov.setFecha(LocalDateTime.now());
        mov.setProducto(producto);

        return movimientoRepo.save(mov);

    }
}
