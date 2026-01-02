package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MovimientoStockDTO;
import com.example.demo.dto.MovimientoStockResponseDTO;
import com.example.demo.mapper.MovimientoStockMapper;
import com.example.demo.model.MovimientoStock;
import com.example.demo.service.MovimientoStockService;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoStockController {

    @Autowired
    private MovimientoStockService service; // Inyección de dependencias

    @Autowired
    private MovimientoStockMapper mapper; // Inyección de dependencias

    @PostMapping // Mapeo de la ruta
    public MovimientoStockResponseDTO registrar(
            @RequestBody MovimientoStockDTO request) {
        MovimientoStock movimiento = service.registrarMovimiento( // Llama al servicio
                request.getProductoId(), // ID del producto
                request.getTipo(), // Tipo de movimiento
                request.getCantidad(), // Cantidad
                request.getDescripcion()); // Descripción

        return mapper.toDto(movimiento); // Mapea el movimiento a un DTO
    }
}
