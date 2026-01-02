package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.ProductoRequestDTO;
import com.example.demo.dto.ProductoResponseDTO;
import com.example.demo.model.Categoria;
import com.example.demo.model.Producto;

@Component
public class ProductoMapper {

    public Producto toEntity(ProductoRequestDTO dto, Categoria categoria) { // Convertir un ProductoRequestDTO a un
                                                                            // Producto
        Producto producto = new Producto(); // Crear un nuevo Producto
        producto.setNombre(dto.getNombre()); // Asignar el nombre del Producto
        producto.setDescripcion(dto.getDescripcion()); // Asignar la descripción del Producto
        producto.setPrecio(dto.getPrecio()); // Asignar el precio del Producto
        producto.setCategoria(categoria); // Asignar la categoría del Producto
        producto.setStock(0); // Asignar el stock del Producto
        return producto; // Devolver el Producto creado
    }

    public ProductoResponseDTO toResponseDTO(Producto producto) { // Convertir un Producto a un ProductoResponseDTO
        return new ProductoResponseDTO(
                producto.getId(), // Asignar el id del Producto
                producto.getNombre(), // Asignar el nombre del Producto
                producto.getDescripcion(), // Asignar la descripción del Producto
                producto.getPrecio(), // Asignar el precio del Producto
                producto.getCategoria().getNombre(), // Asignar la categoría del Producto
                producto.getStock()); // Asignar el stock del Producto
    }
}
