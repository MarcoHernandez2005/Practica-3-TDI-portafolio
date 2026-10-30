# Portafolio de Desarrollo Profesional - Práctica 3

Aplicación web desarrollada con Spring Boot, Spring MVC y JdbcTemplate para la gestión de un portafolio de proyectos tecnológicos, cumpliendo con la arquitectura MVC.

## Requisitos
* **Versión de Java:** JDK 17
* **Base de datos:** MySQL 8.0+
* **Gestor de dependencias:** Maven

## Configuración de la Base de Datos
Antes de ejecutar el proyecto, es necesario crear la base de datos y la tabla correspondiente.
1. Ejecuta el archivo `schema.sql` adjunto en la raíz del proyecto dentro de tu gestor MySQL.
2. Verifica que las credenciales en `src/main/resources/application.properties` coincidan con tu entorno local:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/portafolio_db?useSSL=false&serverTimezone=UTC
   spring.datasource.username=root
   spring.datasource.password=Tony2005*
   Instrucciones de Ejecución
   
Desde una terminal posicionada en la raíz del proyecto, ejecuta los siguientes comandos de Maven:

Limpiar y compilar el proyecto:

Bash
mvn clean compile
Levantar el servidor de Spring Boot:

Bash
mvn spring-boot:run
Abrir el navegador en la siguiente ruta: http://localhost:8080/proyectos