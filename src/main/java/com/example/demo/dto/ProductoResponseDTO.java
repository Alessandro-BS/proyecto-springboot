package com.example.demo.dto;

public class ProductoResponseDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String categoriaNombre;
    private Integer stock;

    public ProductoResponseDTO(
            Long id,
            String nombre,
            String descripcion,
            Double precio,
            String categoriaNombre,
            Integer stock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoriaNombre = categoriaNombre;
        this.stock = stock;
    }

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public Integer getStock() {
        return stock;
    }
}
