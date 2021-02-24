package AgentesTIA;

public class AgenteEspia extends Agentes{
	
	private String pisos;
	
	public AgenteEspia (String nombre, int edad, String direccion, int salario, String pisos) {
		
		super(nombre, edad, direccion, salario);
		
		this.pisos = pisos;
	}

	public String getPisos() {
		return pisos;
	}

	public void setPisos(String pisos) {
		this.pisos = pisos;
	}

	@Override
	public String toString() {
		return super.toString() + "AgenteEspia [pisos=" + pisos + "]";
	}
	
	

}
