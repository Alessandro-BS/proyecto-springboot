package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.MovimientoStock;
import com.example.demo.model.Producto;
import com.example.demo.model.TipoMovimiento;
import com.example.demo.repository.MovimientoStockRepository;
import com.example.demo.repository.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class MovimientoStockService {

    @Autowired
    private MovimientoStockRepository movimientoRepo;

    @Autowired
    private ProductoRepository productoRepo;

    @Transactional // Transacción para garantizar la integridad de los datos (si falla: rollback)
    public MovimientoStock registrarMovimiento(
            Long productoId,
            TipoMovimiento tipo,
            Integer cantidad,
            String descripcion) {

        // Buscar producto
        Producto producto = productoRepo.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Validar cantidad
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }

        // Calcular nuevo stock
        int stockActual = producto.getStock();
        int nuevoStock;

        if (tipo == TipoMovimiento.ENTRADA) { // Si es entrada
            nuevoStock = stockActual + cantidad; // Sumar cantidad al stock actual
        } else { // Si es salida
            if (stockActual < cantidad) { // Si el stock actual es menor a la cantidad
                throw new IllegalStateException("Stock insuficiente"); // Lanza excepción
            }
            nuevoStock = stockActual - cantidad; // Restar cantidad al stock actual
        }

        // Actualizar stock del producto
        producto.setStock(nuevoStock); // Cambiar stock del producto
        productoRepo.save(producto); // Guardar cambios en la base de datos

        // Registrar movimientos
        MovimientoStock movimiento = new MovimientoStock();
        movimiento.setProducto(producto); // Producto al que se le realiza el movimiento
        movimiento.setTipo(tipo); // Tipo de movimiento (entrada/salida)
        movimiento.setCantidad(cantidad); // Cantidad de movimiento
        movimiento.setDescripcion(descripcion); // Descripción del movimiento

        return movimientoRepo.save(movimiento); // Guardar movimiento en la base de datos
    }
}
