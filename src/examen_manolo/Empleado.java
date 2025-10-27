package examen_manolo;

public class Empleado {
    private String nombre;
    private String idEmpleado;

    public Empleado(String nombre, String idEmpleado) {
        this.nombre = nombre;
        this.idEmpleado = idEmpleado;
    }

    @Override
    public String toString() {
        return nombre + " (ID: " + idEmpleado + ")";
    }
}