package examen_manolo;


public class Cliente {
	    private String nombre;
	    private String documento;

	    public Cliente(String nombre, String documento) {
	        this.nombre = nombre;
	        this.documento = documento;
	    }

	    @Override
	    public String toString() {
	        return nombre + " (DNI: " + documento + ")";
	    }
	}

