package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductoRequestDTO;
import com.example.demo.dto.ProductoResponseDTO;
import com.example.demo.service.ProductoService;

@RestController // Indica que esta clase es un controlador.
@RequestMapping("/api/productos") // Mapea las peticiones a esta URL.
public class ProductoController {

    @Autowired // Inyecta la dependencia de ProductoService.
    private ProductoService service;

    @PostMapping // Mapea la petición POST.
    public ProductoResponseDTO crear(@RequestBody ProductoRequestDTO dto) {
        return service.crear(dto); // Guarda el producto en la base de datos.
    }

    @GetMapping // Mapea la petición GET.
    public List<ProductoResponseDTO> listar() {
        return service.listar(); // Obtiene todos los productos de la base de datos.
    }

    @GetMapping("/{id}") // Mapea la petición GET.
    public ProductoResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id); // Obtiene el producto por su ID.
    }

    @DeleteMapping("/{id}") // Mapea la petición DELETE.
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id); // Elimina el producto por su ID.
    }
}
