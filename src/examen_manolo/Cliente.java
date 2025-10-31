package examen_manolo;

// Clase que representa a un cliente
public class Cliente {

    // Atributos del cliente
    private String nombre;     // Nombre del cliente
    private String documento;  // Documento de identidad (DNI)

    // Constructor: inicializa los datos del cliente
    public Cliente(String nombre, String documento) {
        this.nombre = nombre;
        this.documento = documento;
    }

    // Método toString: devuelve una representación en texto del cliente
    @Override
    public String toString() {
        return nombre + " (DNI: " + documento + ")";
    }
}