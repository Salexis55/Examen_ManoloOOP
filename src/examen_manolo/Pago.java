
package examen_manolo;

/**
 * @author marcos 27 oct 2025
 */
public class Pago {
    private double monto;
    private String metodo;

    public Pago(double monto, String metodo) {
        this.monto = monto;
        this.metodo = metodo;
    }

    @Override
    public String toString() {
        return "Pago de $" + monto + " con método: " + metodo;
    }
}



