package examen_manolo;

// Clase que representa a un empleado de la empresa
public class Empleado {

    // Atributos del empleado
    private String nombre;      // Nombre del empleado
    private String idEmpleado;  // Identificador único del empleado

    // Constructor: inicializa los datos del empleado
    public Empleado(String nombre, String idEmpleado) {
        this.nombre = nombre;
        this.idEmpleado = idEmpleado;
    }

    // Método toString: devuelve una representación en texto del empleado
    @Override
    public String toString() {
        return nombre + " (ID: " + idEmpleado + ")";
    }
}