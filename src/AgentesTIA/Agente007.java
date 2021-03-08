package AgentesTIA;

import java.security.Principal;
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
	private ArrayList<String>armas;

	/**
	 * 
	 * @param nombre
	 * @param edad
	 * @param direccion
	 * @param salario
	 * @param muertes
	 */
	public Agente007(String nombre, int edad, String direccion, float salario, int muertes) {
		super(nombre, edad, direccion, salario);
		this.muertes = muertes;
		this.armas = IODatos.leerDatos("Armas.txt", IODatos.so());
	}



/**
 * 
 * @return Numero de muertoes como numero int
 */
	public int getMuertes() {
		return muertes;
	}



/**
 * 
 * @param muertes
 */
	public void setMuertes(int muertes) {
		this.muertes = muertes;
	}




	public ArrayList<String> getArmas() {
		return armas;
	}




	public void setArmas(ArrayList<String> armas) {
		this.armas = armas;
	}




	@Override
	public String toString() {
		return super.toString() + ", muertes=" + muertes + ", armas= " + this.armas;
	}

	
	
	

}
