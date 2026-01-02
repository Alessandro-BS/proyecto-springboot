package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Categoria;
import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;

@Service // Indica que esta clase es un servicio.
public class ProductoService {

    @Autowired // Inyecta el repositorio de Producto.
    private ProductoRepository productoRepo; // Permite interactuar con la tabla 'productos'.

    @Autowired // Inyecta el servicio de Categoria.
    private CategoriaService categoriaService; // Permite usar la lógica de negocio de categorías (Buscar).

    // Método para crear un producto.
    public Producto crear(Producto producto) {
        // Obtenemos el ID de la categoría que viene en el JSON de la petición.
        Long categoriaId = producto.getCategoria().getId();

        // Buscamos la categoría completa en la BD usando el servicio de categorías.
        // Si no existe, el servicio lanzará una excepción y se detendrá el proceso
        // aquí.
        Categoria categoria = categoriaService.buscarPorId(categoriaId);

        // Asignamos la categoría encontrada al producto para asegurar que sea válida.
        producto.setCategoria(categoria);
        return productoRepo.save(producto);
    }

    // Método para listar todos los productos.
    public List<Producto> listar() {
        return productoRepo.findAll(); // Devuelve la lista completa de productos.
    }

    // Método para buscar un producto por su ID.
    public Producto buscarPorId(Long id) {
        return productoRepo.findById(id) // Busca por Clave Primaria.
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado")); // Lanza error si no
                                                                                             // existe.
    }

    // Método para eliminar un producto por su ID.
    public void eliminar(Long id) {
        productoRepo.deleteById(id); // Borra el registro de la BD.
    }
}
