package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductoRequestDTO;
import com.example.demo.dto.ProductoResponseDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.ProductoMapper;
import com.example.demo.model.Categoria;
import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;

@Service // Indica que esta clase es un servicio.
public class ProductoService {

    @Autowired // Inyecta el repositorio de Producto.
    private ProductoRepository productoRepo; // Permite interactuar con la tabla 'productos'.

    @Autowired // Inyecta el servicio de Categoria.
    private CategoriaService categoriaService; // Permite usar la lógica de negocio de categorías (Buscar).

    @Autowired
    private ProductoMapper productoMapper;

    // Método para crear un producto.
    public ProductoResponseDTO crear(ProductoRequestDTO dto) {

        Categoria categoria = categoriaService.buscarPorId(dto.getCategoriaId()); // Busca la categoría por su ID.

        Producto producto = productoMapper.toEntity(dto, categoria); // Convierte el ProductoRequestDTO a un Producto.

        Producto productoGuardado = productoRepo.save(producto); // Guarda el Producto en la base de datos.

        return productoMapper.toResponseDTO(productoGuardado); // Convierte el Producto a un ProductoResponseDTO.
    }

    // Método para listar todos los productos.
    public List<ProductoResponseDTO> listar() {
        return productoRepo.findAll() // Busca todos los productos.
                .stream() // Convierte la lista de productos en un Stream.
                .map(productoMapper::toResponseDTO) // Convierte cada Producto a ProductoResponseDTO.
                .toList(); // Convierte el Stream en una lista.
    }

    // Método para buscar un producto por su ID.
    public ProductoResponseDTO buscarPorId(Long id) {
        Producto producto = productoRepo.findById(id) // Busca el producto por su ID.
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado")); // Lanza una excepción si
                                                                                             // el producto no se
                                                                                             // encuentra.

        return productoMapper.toResponseDTO(producto); // Convierte el Producto a un ProductoResponseDTO.
    }

    // Método para eliminar un producto por su ID.
    public void eliminar(Long id) {
        productoRepo.deleteById(id); // Borra el registro de la BD.
    }
}
