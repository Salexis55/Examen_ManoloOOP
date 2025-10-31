package examen_manolo;
import java.time.LocalDate;
import java.util.*;

/**
 * Main.java
 * Sistema simple de Venta de Coches (consola).
 * Archivo autocontenido: contiene todas las clases necesarias para ejecutar una demo.
 *
 * Cómo compilar:
 *   javac Main.java
 * Cómo ejecutar:
 *   java Main
 *
 * Atención: es una demo educativa — el pago está simulado (no conecta con pasarelas).
 */
public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final List<Coche> flota = new ArrayList<>();
    private static final List<Venta> ventas = new ArrayList<>();

    public static void main(String[] args) {
        seedData();
        System.out.println("=== SISTEMA DE VENTA DE COCHES - DEMO ===");
        boolean running = true;
        while (running) {
            printMenu();
            int opcion = readInt("Elige una opción: ");
            switch (opcion) {
                case 1 -> listarCoches();
                case 2 -> verDetalleCoche();
                case 3 -> realizarCompra();
                case 4 -> listarVentas();
                case 5 -> anadirCoche();
                case 0 -> {
                    System.out.println("Saliendo... ¡hasta luego!");
                    running = false;
                }
                default -> System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
        sc.close();
    }

    private static void printMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Listar coches disponibles");
        System.out.println("2. Ver detalle de un coche");
        System.out.println("3. Comprar un coche");
        System.out.println("4. Listar ventas realizadas");
        System.out.println("5. Añadir un coche (solo demo)");
        System.out.println("0. Salir");
    }

    /* ---------- Operaciones del sistema ---------- */

    private static void listarCoches() {
        System.out.println("\nListado de coches (ID - Marca Modelo - Precio - Estado):");
        if (flota.isEmpty()) {
            System.out.println("No hay coches en la flota.");
            return;
        }
        for (Coche c : flota) {
            System.out.printf("%s - %s %s - %.2f€ - %s%n",
                    c.getId(), c.getMarca(), c.getModelo(), c.getPrecio(), c.isDisponible() ? "DISPONIBLE" : "VENDIDO");
        }
    }

    private static void verDetalleCoche() {
        String id = readString("Introduce el ID del coche: ");
        Optional<Coche> opt = findCocheById(id);
        if (opt.isPresent()) {
            System.out.println("Coche no encontrado.");
            return;
        }
        Coche c = opt.get();
        System.out.println("\n--- Detalle del coche ---");
        System.out.println(c);
    }

    private static void realizarCompra() {
        String id = readString("Introduce el ID del coche a comprar: ");
        Optional<Coche> opt = findCocheById(id);
        if (opt.isPresent()) {
            System.out.println("Coche no encontrado.");
            return;
        }
        Coche coche = opt.get();
        if (!coche.isDisponible()) {
            System.out.println("Lo siento, ese coche ya está vendido.");
            return;
        }

        System.out.println("Has seleccionado: " + coche.getMarca() + " " + coche.getModelo() + " - " + coche.getPrecio() + "€");
        System.out.println("Introduce datos del cliente:");
        String nombre = readString("Nombre: ");
        String dni = readString("DNI: ");
        String telefono = readString("Teléfono: ");

        Cliente cliente = new Cliente(UUID.randomUUID().toString(), nombre, dni, telefono);

        System.out.println("Selecciona método de pago:");
        System.out.println("1. Tarjeta");
        System.out.println("2. Efectivo");
        int metodo = readInt("Opción: ");
        Pago pago;
        if (metodo == 1) {
            String numTarjeta = readString("Número de tarjeta (simulado): ");
            pago = new PagoTarjeta(numTarjeta);
        } else {
            pago = new PagoEfectivo();
        }

        double importe = coche.getPrecio();
        System.out.printf("Importe a pagar: %.2f€%n", importe);

        boolean exito = pago.procesarPago(importe);
        if (!exito) {
            System.out.println("Pago rechazado. Compra cancelada.");
            return;
        }

        // Registrar venta
        Venta venta = new Venta(UUID.randomUUID().toString(), coche, cliente, LocalDate.now(), importe, pago);
        ventas.add(venta);
        coche.setDisponible(false);
        System.out.println("Compra completada. Venta registrada con ID: " + venta.getId());
    }

    private static void listarVentas() {
        System.out.println("\nVentas realizadas:");
        if (ventas.isEmpty()) {
            System.out.println("No se ha realizado ninguna venta aún.");
            return;
        }
        for (Venta v : ventas) {
            System.out.printf("%s - %s %s vendido a %s el %s por %.2f€ (Método: %s)%n",
                    v.getId(),
                    v.getCoche().getMarca(),
                    v.getCoche().getModelo(),
                    v.getCliente().getNombre(),
                    v.getFecha().toString(),
                    v.getImporte(),
                    v.getPago().getClass().getSimpleName());
        }
    }

    private static void anadirCoche() {
        System.out.println("\nAñadir coche (demo):");
        String marca = readString("Marca: ");
        String modelo = readString("Modelo: ");
        String matricula = readString("Matrícula: ");
        double precio = readDouble("Precio (€): ");
        Coche c = new Coche(UUID.randomUUID().toString(), marca, modelo, matricula, precio, true);
        flota.add(c);
        System.out.println("Coche añadido con ID: " + c.getId());
    }

    /* ---------- Utilidades ---------- */

    private static Optional<Coche> findCocheById(String id) {
        return flota.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String line = sc.nextLine().trim();
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Introduce un número entero.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String line = sc.nextLine().trim();
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Introduce un número (p. ej. 12000.50).");
            }
        }
    }

    private static String readString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    private static void seedData() {
        flota.add(new Coche("C-001", "Toyota", "Corolla", "1234-ABC", 15000.0, true));
        flota.add(new Coche("C-002", "Seat", "Ibiza", "2345-BCD", 9000.0, true));
        flota.add(new Coche("C-003", "BMW", "Serie 3", "3456-CDE", 28000.0, true));
        flota.add(new Coche("C-004", "Renault", "Clio", "4567-DEF", 8000.0, true));
    }

    /* ---------- Clases del dominio (autocontenido) ---------- */

    static class Coche {
        private final String id;
        private final String marca;
        private final String modelo;
        private final String matricula;
        private final double precio;
        private boolean disponible;

        public Coche(String id, String marca, String modelo, String matricula, double precio, boolean disponible) {
            this.id = id;
            this.marca = marca;
            this.modelo = modelo;
            this.matricula = matricula;
            this.precio = precio;
            this.disponible = disponible;
        }

        public String getId() { return id; }
        public String getMarca() { return marca; }
        public String getModelo() { return modelo; }
        public String getMatricula() { return matricula; }
        public double getPrecio() { return precio; }
        public boolean isDisponible() { return disponible; }
        public void setDisponible(boolean disponible) { this.disponible = disponible; }

        @Override
        public String toString() {
            return "ID: " + id + "\nMarca: " + marca + "\nModelo: " + modelo + "\nMatrícula: " + matricula +
                    "\nPrecio: " + String.format("%.2f", precio) + "€\nEstado: " + (disponible ? "DISPONIBLE" : "VENDIDO");
        }
    }

    static class Cliente {
        private final String id;
        private final String nombre;
        private final String dni;
        private final String telefono;

        public Cliente(String id, String nombre, String dni, String telefono) {
            this.id = id;
            this.nombre = nombre;
            this.dni = dni;
            this.telefono = telefono;
        }

        public String getId() { return id; }
        public String getNombre() { return nombre; }
        public String getDni() { return dni; }
        public String getTelefono() { return telefono; }
    }

    static class Venta {
        private final String id;
        private final Coche coche;
        private final Cliente cliente;
        private final LocalDate fecha;
        private final double importe;
        private final Pago pago;

        public Venta(String id, Coche coche, Cliente cliente, LocalDate fecha, double importe, Pago pago) {
            this.id = id;
            this.coche = coche;
            this.cliente = cliente;
            this.fecha = fecha;
            this.importe = importe;
            this.pago = pago;
        }

        public String getId() { return id; }
        public Coche getCoche() { return coche; }
        public Cliente getCliente() { return cliente; }
        public LocalDate getFecha() { return fecha; }
        public double getImporte() { return importe; }
        public Pago getPago() { return pago; }
    }

    interface Pago {
        boolean procesarPago(double importe);
    }

    static class PagoTarjeta implements Pago {
        private final String numeroTarjeta;

        public PagoTarjeta(String numeroTarjeta) {
            this.numeroTarjeta = numeroTarjeta;
        }

        @Override
        public boolean procesarPago(double importe) {
            if (numeroTarjeta == null || numeroTarjeta.length() < 8) {
                System.out.println("Número de tarjeta inválido.");
                return false;
            }
            System.out.printf("Procesando pago con tarjeta ****%s ... OK%n",
                    numeroTarjeta.substring(Math.max(0, numeroTarjeta.length() - 4)));
            return true;
        }
    }

    static class PagoEfectivo implements Pago {
        @Override
        public boolean procesarPago(double importe) {
            System.out.println("Pago en efectivo confirmado (simulado).");
            return true;
        }
    }
}
