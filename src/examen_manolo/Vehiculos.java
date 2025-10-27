package examen_manolo;

public class Vehiculos {
	    protected String matricula;
	    protected String marca;
	    protected String modelo;
	    protected double precioPorDia;
	    protected boolean disponible;

	    public Vehiculos(String matricula, String marca, String modelo, double precioPorDia) {
	        this.matricula = matricula;
	        this.marca = marca;
	        this.modelo = modelo;
	        this.precioPorDia = precioPorDia;
	        this.disponible = true;
	    }

	    public double calcularPrecio(int dias) {
	        return precioPorDia * dias;
	    }

	    public boolean isDisponible() {
	        return disponible;
	    }

	    public void setDisponible(boolean disponible) {
	        this.disponible = disponible;
	    }

	    @Override
	    public String toString() {
	        return marca + " " + modelo + " (" + matricula + ")";
	    }
	}
	

