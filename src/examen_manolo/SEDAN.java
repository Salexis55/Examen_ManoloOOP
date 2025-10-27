package examen_manolo;


	public class SEDAN extends Vehiculos {
	    private boolean lujo;

	    public SEDAN(String matricula, String marca, String modelo, double precioPorDia, boolean lujo) {
	        super(matricula, marca, modelo, precioPorDia);
	        this.lujo = lujo;
	    }

	    @Override
	    public double calcularPrecio(int dias) {
	        double extra = lujo ? 1.10 : 1.0; // 10% más si es de lujo
	        return super.calcularPrecio(dias) * extra;
	    }
	}
	

