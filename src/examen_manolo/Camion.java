package examen_manolo;

public class Camion extends Vehiculos {
	    private double capacidadToneladas;

	    public Camion(String matricula, String marca, String modelo, double precioPorDia, double capacidadToneladas) {
	        super(matricula, marca, modelo, precioPorDia);
	        this.capacidadToneladas = capacidadToneladas;
	    }

	    @Override
	    public double calcularPrecio(int dias) {
	        double extra = 1 + (capacidadToneladas * 0.05); // Aumenta 5% por tonelada
	        return super.calcularPrecio(dias) * extra;
	    }
	}

