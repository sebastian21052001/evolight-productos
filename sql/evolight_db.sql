-- Base de datos del módulo Productos - EVOLIGHT
CREATE DATABASE IF NOT EXISTS evolight_db CHARACTER SET utf8mb4;
USE evolight_db;

CREATE TABLE IF NOT EXISTS productos (
    id        INT AUTO_INCREMENT PRIMARY KEY,
    nombre    VARCHAR(100)  NOT NULL,
    categoria VARCHAR(50)   NOT NULL,
    precio    DECIMAL(10,2) NOT NULL,
    stock     INT           NOT NULL DEFAULT 0
);

INSERT INTO productos (nombre, categoria, precio, stock) VALUES
('Panel LED 18W', 'Iluminación Interior', 25000, 40),
('Reflector LED 50W', 'Iluminación Exterior', 68000, 15);
