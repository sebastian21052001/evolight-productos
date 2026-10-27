package com.evolight.app;

import com.evolight.dao.ProductoDAO;
import com.evolight.modelo.Producto;

import java.util.List;
import java.util.Scanner;

/**
 * Menú de consola para probar el módulo Productos de EVOLIGHT.
 */
public class Main {

    private static final Scanner entrada = new Scanner(System.in);
    private static final ProductoDAO dao = new ProductoDAO();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1 -> insertarProducto();
                case 2 -> listarProductos();
                case 3 -> buscarProducto();
                case 4 -> actualizarProducto();
                case 5 -> eliminarProducto();
                case 0 -> System.out.println("Hasta pronto.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n=== EVOLIGHT - Módulo Productos ===");
        System.out.println("1. Insertar producto");
        System.out.println("2. Listar productos");
        System.out.println("3. Buscar producto por id");
        System.out.println("4. Actualizar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("0. Salir");
    }

    private static void insertarProducto() {
        Producto p = pedirDatos();
        System.out.println(dao.insertar(p) ? "Producto insertado." : "No se pudo insertar.");
    }

    private static void listarProductos() {
        List<Producto> lista = dao.listar();
        if (lista.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        lista.forEach(System.out::println);
    }

    private static void buscarProducto() {
        int id = leerEntero("Id del producto: ");
        Producto p = dao.buscarPorId(id);
        System.out.println(p != null ? p : "Producto no encontrado.");
    }

    private static void actualizarProducto() {
        int id = leerEntero("Id del producto a actualizar: ");
        if (dao.buscarPorId(id) == null) {
            System.out.println("Producto no encontrado.");
            return;
        }
        Producto p = pedirDatos();
        p.setId(id);
        System.out.println(dao.actualizar(p) ? "Producto actualizado." : "No se pudo actualizar.");
    }

    private static void eliminarProducto() {
        int id = leerEntero("Id del producto a eliminar: ");
        System.out.println(dao.eliminar(id) ? "Producto eliminado." : "Producto no encontrado.");
    }

    /** Pide los datos del producto aplicando validaciones básicas. */
    private static Producto pedirDatos() {
        String nombre = leerTextoNoVacio("Nombre: ");
        String categoria = leerTextoNoVacio("Categoría: ");
        double precio = leerPrecio("Precio: ");
        int stock = leerEntero("Stock: ");
        while (stock < 0) {
            System.out.println("El stock no puede ser negativo.");
            stock = leerEntero("Stock: ");
        }
        return new Producto(0, nombre, categoria, precio, stock);
    }

    private static String leerTextoNoVacio(String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = entrada.nextLine().trim();
        } while (texto.isEmpty());
        return texto;
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(entrada.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número entero válido.");
            }
        }
    }

    private static double leerPrecio(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                double valor = Double.parseDouble(entrada.nextLine().trim());
                if (valor >= 0) {
                    return valor;
                }
                System.out.println("El precio no puede ser negativo.");
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }
}
