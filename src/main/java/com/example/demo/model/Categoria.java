package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Le dice a Spring/JPA que esta clase representa una tabla en la base de datos.
@Table(name = "categorias") // Define el nombre de la tabla en MySQL.
@Data // Genera automáticamente los getters, setters, toString, equals y hashCode.
@NoArgsConstructor // Genera un constructor vacío.
@AllArgsConstructor // Genera un constructor con todos los atributos.

public class Categoria {
    @Id // Indica que el atributo id es la clave primaria de la tabla.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera valores autoincrementales para el id.
    private Long id;

    @Column(nullable = false, unique = true) // Indica que el atributo nombre no puede ser nulo y debe ser único.
    private String nombre;

}
