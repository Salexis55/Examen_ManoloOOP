/**
 * 
 */
package examen_manolo;

/**
 * @author marcos 27 oct 2025
 */
public class main {
    public static void main(String[] args) {
        // Crear algunos vehículos
        SUV suv = new SUV("ABC123", "Toyota", "RAV4", 80.0, true);
        Vehiculos sedan = new SEDAN("XYZ456", "Honda", "Civic", 60.0, false);
        Camion camion = new Camion("LMN789", "Volvo", "FH", 120.0, 5.0);

        // Crear cliente y empleado
        Cliente cliente = new Cliente("Juan Pérez", "12345678");
        Empleado empleado = new Empleado("María López", "E001");

        // Realizar alquileres
        Alquiler alquiler1 = new Alquiler(cliente, suv, 3, empleado);
        Alquiler alquiler2 = new Alquiler(cliente, camion, 2, empleado);

        // Mostrar información
        System.out.println(alquiler1);
        System.out.println(alquiler2);
    }
}
