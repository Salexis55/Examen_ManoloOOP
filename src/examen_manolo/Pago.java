package examen_manolo;

/**
 * Clase que representa un pago realizado por un alquiler o venta.
 * @author marcos
 * @date 27 oct 2025
 */
public class Pago {

    // Monto total del pago
    private double monto;

    // Método utilizado (por ejemplo: tarjeta, efectivo, etc.)
    private String metodo;

    // Constructor: inicializa los datos del pago
    public Pago(double monto, String metodo) {
        this.monto = monto;
        this.metodo = metodo;
    }

    // Método toString: devuelve una descripción legible del pago
    @Override
    public String toString() {
        return "Pago de $" + monto + " con método: " + metodo;
    }
}