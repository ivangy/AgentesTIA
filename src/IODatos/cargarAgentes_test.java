package IODatos;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import org.junit.Test;

import AgentesTIA.Agentes;

/**
 * 
 * @author Ivan Sanchez
 * @author Gil Pablo Blanco
 *
 */
public class cargarAgentes_test {

/**
 * Lee lo que hay dentro de Agentes.dat y devuelve vAprueba
 * @return vAprueba es un vector de agentes 
 */
	public ArrayList<Agentes> esperado() {
	File f = new File("recursos/" + "Agentes.dat");
	ArrayList<Agentes> vAprueba = new ArrayList<>();
	try (FileInputStream fo = new FileInputStream(f);
			 ObjectInputStream leer = new ObjectInputStream(fo)){
			
			while (true) {
				vAprueba.add((Agentes) leer.readObject());
			}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return vAprueba;
	}
	
	/**
	 * Es un test que prueba que el metodo IODatos.cargarAgentes no tenga fallos.
	 * Lo que hace el test es comparar el metodo IODatos.cargarAgentes con
	 * el metodo esperado, que es el metodo base de lectura.
	 * El resultado esperado es sin errores. (Saldran lineas rojas en la consola 
	 * pero es normal)
	 */
	@Test
	public void test() {
		ArrayList<Agentes> resultado= IODatos.cargarAgentes("recursos/");
		ArrayList<Agentes> esperado= esperado();
		int num = resultado.size();
		Agentes[] vEsperado=new Agentes[num];
		Agentes[] vResultado=new Agentes[num];
		int i=0, j=0;
		
		
		for (Agentes a : esperado) {
			vEsperado[i]=a;
			i++;
		}
		for (Agentes b : resultado) {
			vResultado[j]=b;
			j++;
		}
		
		for (int l = 0; l < vResultado.length; l++) {
			if(vResultado[l]!=null) {
				Agentes resul=vResultado[l];
				Agentes espe=vResultado[l];
				
				assertEquals(resul, espe);
				
			}
		}
		
	}
	
	

}
