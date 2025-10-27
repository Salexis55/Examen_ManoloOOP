/**
 * 
 */
package examen_manolo;

/**
 * @author marcos 27 oct 2025
 */
public class Alquiler {
    private Cliente cliente;
    private Vehiculos vehiculo;
    private int dias;
    private Pago pago;
    private Empleado empleado;

    public Alquiler(Cliente cliente, Vehiculos vehiculo, int dias, Empleado empleado) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.dias = dias;
        this.empleado = empleado;

        double total = vehiculo.calcularPrecio(dias);
        this.pago = new Pago(total, "Tarjeta de crédito");

        vehiculo.setDisponible(false);
    }

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
