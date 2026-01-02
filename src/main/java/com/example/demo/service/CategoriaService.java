package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRepository;

@Service // Indica que esta clase es un servicio.
public class CategoriaService {

    @Autowired // Inyecta la dependencia de CategoriaRepository.
    private CategoriaRepository repo; // Esta variable podrá hablar con la base de datos (CRUD).

    // Método para crear una categoría.
    public Categoria crear(Categoria categoria) {
        return repo.save(categoria); // Guarda la categoría en la base de datos.
    }

    // Método para listar todas las categorías.
    public List<Categoria> listar() {
        return repo.findAll(); // Obtiene todas las categorías de la base de datos.
    }

    // Método para buscar una categoría por su ID.
    public Categoria buscarPorId(Long id) {
        return repo.findById(id) // Busca la categoría por su ID.
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada")); // Lanza una excepción si
                                                                                              // no se
        // encuentra la categoría.
    }

    // Método para eliminar una categoría por su ID.
    public void eliminar(Long id) {
        repo.deleteById(id); // Elimina la categoría por su ID.
    }
}
