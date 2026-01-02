package com.example.demo.exception;

// Clase que hereda de RuntimeException
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) { // Constructor que recibe un mensaje
        super(message); // Llama al constructor de la clase padre
    }
}
