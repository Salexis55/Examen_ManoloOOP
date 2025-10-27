package examen_manolo;

public class SUV extends Vehiculos {
	    private boolean traccion4x4;

	    public SUV(String matricula, String marca, String modelo, double precioPorDia, boolean traccion4x4) {
	        super(matricula, marca, modelo, precioPorDia);
	        this.traccion4x4 = traccion4x4;
	    }

	    @Override
	    public double calcularPrecio(int dias) {
	        double extra = traccion4x4 ? 1.15 : 1.0; // 15% más si tiene tracción 4x4
	        return super.calcularPrecio(dias) * extra;
	    }
	}
	

