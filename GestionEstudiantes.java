import java.util.ArrayList;
import java.util.Scanner;

/**
 * Sistema de Gestión de Estudiantes Universitarios en consola.
 * Implementa operaciones CRUD básicas utilizando Programación Orientada a Objetos 
 * y colecciones dinámicas (ArrayList).
 * 
 * @author Ricardo Martínez (Rickcm22)
 */
public class GestionEstudiantes {

    /**
     * Clase interna que representa la entidad Estudiante.
     */
    static class Estudiante {
        private final int id;
        private final String nombre;
        private final String carrera;

        public Estudiante(int id, String nombre, String carrera) {
            this.id = id;
            this.nombre = nombre;
            this.carrera = carrera;
        }

        public int getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public String getCarrera() {
            return carrera;
        }

        @Override
        public String toString() {
            return "[ID: " + id + "] | Nombre: " + nombre + " | Carrera: " + carrera;
        }
    }

    // Colección y contador de registros
    private static final ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private static int contadorId = 1;

    /**
     * Método principal que ejecuta el menú interactivo del sistema por consola.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n==================================================");
            System.out.println("   SISTEMA DE GESTION DE ESTUDIANTES UNIVERSITARIOS ");
            System.out.println("==================================================");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Listar estudiantes");
            System.out.println("3. Buscar estudiante por ID");
            System.out.println("4. Eliminar estudiante por ID");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            // Validación segura de entrada numérica
            while (!sc.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, ingrese un número del 1 al 5.");
                sc.next();
                System.out.print("Seleccione una opción: ");
            }
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1 -> agregarEstudiante(sc);
                case 2 -> listarEstudiantes();
                case 3 -> buscarEstudiante(sc);
                case 4 -> eliminarEstudiante(sc);
                case 5 -> System.out.println("\n[!] Saliendo del sistema. ¡Hasta luego!");
                default -> System.out.println("\n[X] Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 5);

        sc.close();
    }

    /**
     * Agrega un nuevo estudiante a la colección dinámica.
     */
    private static void agregarEstudiante(Scanner sc) {
        System.out.print("\nIngrese el nombre del estudiante: ");
        String nombre = sc.nextLine().trim();
        
        System.out.print("Ingrese la carrera del estudiante: ");
        String carrera = sc.nextLine().trim();

        if (nombre.isEmpty() || carrera.isEmpty()) {
            System.out.println("[X] Error: Los campos no pueden estar vacíos.");
            return;
        }

        Estudiante estudiante = new Estudiante(contadorId++, nombre, carrera);
        estudiantes.add(estudiante);
        System.out.println("[✔] Estudiante agregado exitosamente con ID: " + (contadorId - 1));
    }

    /**
     * Muestra el listado completo de estudiantes registrados en el sistema.
     */
    private static void listarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("\n[!] No hay estudiantes registrados actualmente.");
        } else {
            System.out.println("\n--- LISTA DE ESTUDIANTES REGISTRADOS ---");
            for (Estudiante estudiante : estudiantes) {
                System.out.println(estudiante);
            }
        }
    }

    /**
     * Busca y muestra los detalles de un estudiante a partir de su ID único.
     */
    private static void buscarEstudiante(Scanner sc) {
        System.out.print("\nIngrese el ID del estudiante a buscar: ");
        int id = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId() == id) {
                System.out.println("\n[✔] Estudiante encontrado:\n" + estudiante);
                return;
            }
        }
        System.out.println("\n[X] No se encontró un estudiante con el ID proporcionado.");
    }

    /**
     * Elimina un registro de estudiante utilizando su ID único.
     */
    private static void eliminarEstudiante(Scanner sc) {
        System.out.print("\nIngrese el ID del estudiante a eliminar: ");
        int id = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getId() == id) {
                estudiantes.remove(i);
                System.out.println("\n[✔] Estudiante eliminado exitosamente.");
                return;
            }
        }
        System.out.println("\n[X] No se encontró un estudiante con el ID proporcionado.");
    }
}