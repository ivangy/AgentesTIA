package AgentesTIA;

public class Agente007 extends Agentes{
	

	private int muertes;
	
	private int armas;
	
	public Agente007(String nombre, int edad, String direccion, int salario, int muertes, int armas) {
		
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

	public int getArmas() {
		return armas;
	}

	public void setArmas(int armas) {
		this.armas = armas;
	}

	@Override
	public String toString() {
		return super.toString() + "Agente007 [muertes=" + muertes + ", armas=" + armas + "]";
	}

	

}
