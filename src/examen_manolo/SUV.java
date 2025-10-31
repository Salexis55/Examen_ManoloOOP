package examen_manolo;

// La clase SUV hereda de Vehiculos
public class SUV extends Vehiculos {

    // Indica si el SUV tiene tracción 4x4
    private boolean traccion4x4;

    // Constructor: inicializa los datos del SUV
    public SUV(String matricula, String marca, String modelo, double precioPorDia, boolean traccion4x4) {
        // Llama al constructor de la clase padre (Vehiculos)
        super(matricula, marca, modelo, precioPorDia);
        this.traccion4x4 = traccion4x4;
    }

    // Sobrescribe el método calcularPrecio de la clase padre
    @Override
    public double calcularPrecio(int dias) {
        // Si tiene tracción 4x4, el precio aumenta un 15%
        double extra = traccion4x4 ? 1.15 : 1.0;
        // Devuelve el precio base multiplicado por el incremento
        return super.calcularPrecio(dias) * extra;
    }
}
