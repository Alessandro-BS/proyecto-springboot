# Sistema de Gestión de Inventario (Proyecto Personal)

Este es un proyecto backend realizado con **Spring Boot** para la gestión de inventario básica.

## 📋 Funcionalidades Principales

El sistema permite gestionar:

- **Categorías**: Clasificación de productos.
- **Productos**: Mantenimiento de información de productos asociados a categorías.
- **Movimientos**: Registro de flujo de stock.
  - **ENTRADA**: Ingreso de mercancía.
  - **SALIDA**: Retiro de mercancía.

## 🛠️ Tecnologías Utilizadas

- **Java 21**
- **Spring Boot** (Web, Data JPA)
- **MySQL** (Base de datos)
- **Lombok** (Reducción de código boilerplate)
- **Maven** (Gestor de dependencias)

## 🚀 Cómo ejecutar

1.  Clonar el repositorio.
2.  Configurar la base de datos en `application.properties`.
3.  Ejecutar con:
    ```bash
    ./mvnw spring-boot:run
    ```
