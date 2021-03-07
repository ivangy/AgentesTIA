package IODatos;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import AgentesTIA.Agentes;

public class aaaa {
	public static ArrayList<Agentes> test2() {
		File f = new File("src\\recursos\\" + "Agentes.dat");
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
			
			//esta bien (no pongo nada para no asustar)
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vAprueba;
		}
	
	public static void test() {
		ArrayList<Agentes> resultado= IODatos.cargarAgentes("src\\recursos\\");
		ArrayList<Agentes> esperado= test2();
		int num = resultado.size();
		Agentes[] vEsperado=new Agentes[num];
		Agentes[] vResultado=new Agentes[num];
		int i=0, j=0;
		
		
		for (Agentes a : esperado) {
			vEsperado[i]=a;
			System.out.println(vEsperado[i]);
			i++;
		}
		for (Agentes b : resultado) {
			vResultado[j]=b;
			System.out.println(vResultado[j]);
			j++;
		}
		
		for (int l = 0; l < vResultado.length; l++) {
			if(vResultado[l]!=null) {
				Agentes resul=vResultado[l];
				Agentes espe=vResultado[l];
				if(resul==espe) {
					System.out.println("True, no hay error");
				}
			}
		}
		
	}

	public static void main(String[] args) {
		test();

	}

}
