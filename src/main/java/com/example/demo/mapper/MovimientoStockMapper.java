package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.MovimientoStockResponseDTO;
import com.example.demo.model.MovimientoStock;

@Component
public class MovimientoStockMapper {

    public MovimientoStockResponseDTO toDto(MovimientoStock movimiento) {
        MovimientoStockResponseDTO dto = new MovimientoStockResponseDTO(); // Crear nuevo dto

        dto.setId(movimiento.getId()); // Asignar id
        dto.setProducto(movimiento.getProducto().getNombre()); // Asignar nombre del producto
        dto.setTipo(movimiento.getTipo()); // Asignar tipo de movimiento
        dto.setCantidad(movimiento.getCantidad()); // Asignar cantidad
        dto.setFecha(movimiento.getFecha()); // Asignar fecha
        dto.setDescripcion(movimiento.getDescripcion()); // Asignar descripcion

        return dto;
    }
}
