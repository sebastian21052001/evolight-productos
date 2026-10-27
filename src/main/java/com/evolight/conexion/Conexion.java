package com.evolight.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Administra la conexión a la base de datos MySQL por medio de JDBC.
 */
public class Conexion {

    private static final String URL =
            "jdbc:mysql://localhost:3306/evolight_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USUARIO = "root";
    private static final String CLAVE = ""; // Cambiar por la clave de su MySQL

    private Conexion() {
    }

    /**
     * Abre y retorna una nueva conexión a la base de datos.
     */
    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
}
