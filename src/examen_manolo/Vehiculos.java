package examen_manolo;

// Clase base (padre) para todos los tipos de vehículos: SUV, Camion, SEDAN, etc.
public class Vehiculos {

    // Atributos comunes a todos los vehículos
    protected String matricula;      // Matrícula del vehículo
    protected String marca;          // Marca del vehículo
    protected String modelo;         // Modelo del vehículo
    protected double precioPorDia;   // Precio de alquiler por día
    protected boolean disponible;    // Indica si el vehículo está disponible

    // Constructor: inicializa los datos del vehículo
    public Vehiculos(String matricula, String marca, String modelo, double precioPorDia) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.precioPorDia = precioPorDia;
        this.disponible = true; // Por defecto, el vehículo está disponible
    }

    // Calcula el precio total según los días de alquiler
    public double calcularPrecio(int dias) {
        return precioPorDia * dias;
    }

    // Devuelve si el vehículo está disponible
    public boolean isDisponible() {
        return disponible;
    }

    // Permite cambiar el estado de disponibilidad
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // Devuelve una representación en texto del vehículo
    @Override
    public String toString() {
        return marca + " " + modelo + " (" + matricula + ")";
    }
}