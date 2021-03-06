package AgentesTIA;

import java.util.ArrayList;

import IODatos.IODatos;

/**
 * 
 * @author Ivan Sanchez
 * @author Gil Pablo Blanco
 *
 */
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


	@Override
	public String toString() {
		return "nombre= " + super.nombre + ", edad= " + super.edad + 
				", dirección= " + super.direccion + ", salario= " +super.salario  
				+ "€ , muertes=" + muertes + ", armas= " + this.armas;
	}

	
	
	

}
