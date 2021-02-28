package AgentesTIA;

public final class AgenteEspia extends Agentes{
	
	private String pisos;

	public AgenteEspia(String nombre, int edad, String direccion, float salario, String pisos) {
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
		return "nombre= " + super.nombre + ", edad= " + super.edad + 
		", dirección= " + super.direccion + ", salario= " +super.salario  
		+ "€ , piso= " + pisos;
	}
	
	
	
	

}
