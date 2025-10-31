package examen_manolo;

// La clase SEDAN hereda de Vehiculos
public class SEDAN extends Vehiculos {

    // Indica si el sedán es de lujo o no
    private boolean lujo;

    // Constructor: inicializa los datos del sedán
    public SEDAN(String matricula, String marca, String modelo, double precioPorDia, boolean lujo) {
        // Llama al constructor de la clase padre (Vehiculos)
        super(matricula, marca, modelo, precioPorDia);
        this.lujo = lujo;
    }

    // Sobrescribe el método calcularPrecio de la clase padre
    @Override
    public double calcularPrecio(int dias) {
        // Si es de lujo, se aplica un 10% extra al precio total
        double extra = lujo ? 1.10 : 1.0;
        // Devuelve el precio base multiplicado por el factor extra
        return super.calcularPrecio(dias) * extra;
    }
}