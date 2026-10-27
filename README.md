# EVOLIGHT - Módulo Productos (GA7-220501096-AA2-EV01)

Módulo de productos en Java con conexión a MySQL por JDBC y operaciones de
inserción, consulta, actualización y eliminación (CRUD).

Autor: Sebastián Muñoz Erazo

## Requisitos
- JDK 17 o superior
- MySQL (o XAMPP)
- Maven (incluido en NetBeans)

## Ejecución
1. Ejecutar `sql/evolight_db.sql` en MySQL (phpMyAdmin o Workbench).
2. En `Conexion.java` ajustar `USUARIO` y `CLAVE` si es necesario.
3. Ejecutar la clase `com.evolight.app.Main`.

## Estructura
- `com.evolight.modelo`: clase `Producto`.
- `com.evolight.conexion`: clase `Conexion` (JDBC).
- `com.evolight.dao`: clase `ProductoDAO` (CRUD).
- `com.evolight.app`: clase `Main` (menú de consola).

## Estándares de codificación
- Clases en PascalCase, métodos y variables en camelCase, paquetes en minúscula.
- Comentarios en clases y métodos.
