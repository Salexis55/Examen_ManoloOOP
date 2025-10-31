package examen_manolo;

// La clase Camion hereda de Vehiculos
public class Camion extends Vehiculos {
    
    // Capacidad del camión en toneladas
    private double capacidadToneladas;

    // Constructor que inicializa los datos del camión
    public Camion(String matricula, String marca, String modelo, double precioPorDia, double capacidadToneladas) {
        // Llama al constructor de la clase padre (Vehiculos)
        super(matricula, marca, modelo, precioPorDia);
        this.capacidadToneladas = capacidadToneladas;
    }

    // Sobrescribe el método calcularPrecio de la clase padre
    @Override
    public double calcularPrecio(int dias) {
        // Aumenta el precio total un 5% por cada tonelada de capacidad
        double extra = 1 + (capacidadToneladas * 0.05);
        // Devuelve el precio base (de la clase padre) multiplicado por el extra
        return super.calcularPrecio(dias) * extra;
    }
}