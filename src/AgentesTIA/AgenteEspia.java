package AgentesTIA;

import java.util.ArrayList;

import IODatos.IODatos;

/**
 * 
 * @author Ivan Sanchez
 * @author Gil Pablo Blanco
 *
 */
public final class AgenteEspia extends Agentes {

	private ArrayList<String> pisos;

	public AgenteEspia(String nombre, int edad, String direccion, float salario) {
		super(nombre, edad, direccion, salario);
		this.pisos = IODatos.leerDatos("Pisos.txt", IODatos.so());
	}

	public ArrayList<String> getPisos() {
		return pisos;
	}

	public void setPisos(ArrayList<String> pisos) {
		this.pisos = pisos;
	}

	@Override
	public String toString() {
		return super.toString() + ", piso= " + pisos;
	}

}
