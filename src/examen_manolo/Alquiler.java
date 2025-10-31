/**
 * Clase que representa un alquiler de vehículo.
 */
package examen_manolo;
/**
* Prueba
*/

/**
 * @author marcos 27 oct 2025
 */
public class Alquiler {
    // Atributos principales del alquiler
    private Cliente cliente;     // Cliente que realiza el alquiler
    private Vehiculos vehiculo;  // Vehículo alquilado
    private int dias;            // Número de días de alquiler
    private Pago pago;           // Información del pago
    private Empleado empleado;   // Empleado que gestiona el alquiler

    // Constructor: crea un nuevo alquiler
    public Alquiler(Cliente cliente, Vehiculos vehiculo, int dias, Empleado empleado) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.dias = dias;
        this.empleado = empleado;

        // Calcula el precio total usando el método del vehículo
        double total = vehiculo.calcularPrecio(dias);

        // Crea el pago con el total y un método de pago fijo
        this.pago = new Pago(total, "Tarjeta de crédito");

        // Marca el vehículo como no disponible (ya está alquilado)
        vehiculo.setDisponible(false);
    }

    // Método toString: muestra toda la información del alquiler en textos
    @Override
    public String toString() {
        return "Alquiler:\n" +
                "Cliente: " + cliente + "\n" +
                "Vehículo: " + vehiculo + "\n" +
                "Empleado: " + empleado + "\n" +
                "Días: " + dias + "\n" +
                pago + "\n";
    }
}
