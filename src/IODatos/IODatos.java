package IODatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class IODatos {
	public static void leerArmas(){
		String nombreFichero = "/home/dawb/Escritorio/AgentesTIA/src/recursos/Armas.txt";
		String arma;
		String ler = "";
		File f = new File(nombreFichero);
		
		if(!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		
		try (FileReader fr = new FileReader(f); Scanner leer = new Scanner(fr)) {

			while (leer.hasNext()) {
				ler = leer.nextLine().trim();
				arma = ler.substring(0);
				System.out.println(arma);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void leerPisos(){
		String nombreFichero = "recursos/Pisos.txt";
		String nombre, direccion, numero;
		File f = new File(nombreFichero);
	}
	public static void main(String[] args) {
		leerArmas();
	}
}
