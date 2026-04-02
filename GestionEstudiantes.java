import java.util.ArrayList;
import java.util.Scanner;

public class GestionEstudiantes {

    // Clase interna para representar un estudiante
    static class Estudiante {
        private int id;
        private String nombre;
        private String carrera;

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
            return "ID: " + id + ", Nombre: " + nombre + ", Carrera: " + carrera;
        }
    }

    // Lista para almacenar los estudiantes
    private static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private static int contadorId = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Sistema de Gestión de Estudiantes Universitarios ---");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Listar estudiantes");
            System.out.println("3. Buscar estudiante por ID");
            System.out.println("4. Eliminar estudiante por ID");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarEstudiante(sc);
                    break;
                case 2:
                    listarEstudiantes();
                    break;
                case 3:
                    buscarEstudiante(sc);
                    break;
                case 4:
                    eliminarEstudiante(sc);
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 5);

        sc.close();
    }

    // Método para agregar un estudiante
    private static void agregarEstudiante(Scanner sc) {
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese la carrera del estudiante: ");
        String carrera = sc.nextLine();

        Estudiante estudiante = new Estudiante(contadorId++, nombre, carrera);
        estudiantes.add(estudiante);
        System.out.println("Estudiante agregado exitosamente.");
    }

    // Método para listar todos los estudiantes
    private static void listarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            System.out.println("\n--- Lista de Estudiantes ---");
            for (Estudiante estudiante : estudiantes) {
                System.out.println(estudiante);
            }
        }
    }

    // Método para buscar un estudiante por ID
    private static void buscarEstudiante(Scanner sc) {
        System.out.print("Ingrese el ID del estudiante a buscar: ");
        int id = sc.nextInt();

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId() == id) {
                System.out.println("Estudiante encontrado: " + estudiante);
                return;
            }
        }
        System.out.println("No se encontró un estudiante con el ID proporcionado.");
    }

    // Método para eliminar un estudiante por ID
    private static void eliminarEstudiante(Scanner sc) {
        System.out.print("Ingrese el ID del estudiante a eliminar: ");
        int id = sc.nextInt();

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId() == id) {
                estudiantes.remove(estudiante);
                System.out.println("Estudiante eliminado exitosamente.");
                return;
            }
        }
        System.out.println("No se encontró un estudiante con el ID proporcionado.");
    }
}