package AgentesTIA;

public final class Agente007 extends Agentes{
	

	private int muertes;
	private String armas;
	
	public Agente007(String nombre, int edad, String direccion, float salario, int muertes, String armas) {
		super(nombre, edad, direccion, salario);
		this.muertes = muertes;
		this.armas = armas;
	}

	public int getMuertes() {
		return muertes;
	}

	public void setMuertes(int muertes) {
		this.muertes = muertes;
	}

	public String getArmas() {
		return armas;
	}

	public void setArmas(String armas) {
		this.armas = armas;
	}

	@Override
	public String toString() {
		return "nombre= " + super.nombre + ", edad= " + super.edad + 
				", dirección= " + super.direccion + ", salario= " +super.salario  
				+ "€ , muertes=" + muertes + ", arma=" + armas;
	}

	
	
	

}
