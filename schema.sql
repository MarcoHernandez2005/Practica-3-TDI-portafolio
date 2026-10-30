CREATE DATABASE IF NOT EXISTS portafolio_db;
USE portafolio_db;

CREATE TABLE IF NOT EXISTS proyecto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descripcion TEXT NOT NULL,
    tecnologias VARCHAR(200) NOT NULL,
    enlace_github VARCHAR(255)
);

INSERT INTO proyecto (titulo, descripcion, tecnologias, enlace_github) 
VALUES 
('Proyecto Visualización', 'Proyecto enfocado en el desarrollo de visualización.', 'C++', 'https://github.com/MarcoHernandez2005/Proyecto-Visualizacion'),
('Práctica 2: Librería', 'Desarrollo de la práctica de librería para la materia TDI.', 'Java', 'https://github.com/MarcoHernandez2005/Practica2_Libreria'),
('Algoritmo de búsqueda DFS', 'Código del algoritmo de búsqueda DFS solicitado para la materia de Inteligencia Artificial.', 'Python', 'https://github.com/MarcoHernandez2005/P2-Inteligencia_Artificial-DFS');