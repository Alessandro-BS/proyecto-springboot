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

import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;

@RestController // Indica que esta clase es un controlador.
@RequestMapping("/api/productos") // Mapea las peticiones a esta URL.
public class ProductoController {

    @Autowired // Inyecta la dependencia de ProductoService.
    private ProductoService service;

    @PostMapping // Mapea la petición POST.
    public Producto crear(@RequestBody Producto producto) {
        return service.crear(producto); // Guarda el producto en la base de datos.
    }

    @GetMapping // Mapea la petición GET.
    public List<Producto> listar() {
        return service.listar(); // Obtiene todos los productos de la base de datos.
    }

    @DeleteMapping("/{id}") // Mapea la petición DELETE.
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id); // Elimina el producto por su ID.
    }
}
