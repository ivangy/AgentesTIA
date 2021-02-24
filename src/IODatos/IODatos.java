package IODatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class IODatos {

	public static String[] leerDatos(String ruta){
		String nombreFichero = "/home/dawb/Escritorio/AgentesTIA/src/recursos/" + ruta +".txt";
		String piso;
		String ler = "";
		String vPisos[]= new String[10];
		int i = 0;
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
			
				vPisos[i]= ler;
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return vPisos;
	}

	public static void borrarInformacion() {
		String nombreFichero = "/home/dawb/Escritorio/AgentesTIA/src/recursos/prueba.txt";
		File f = new File(nombreFichero);
	
		if(f.exists()) {
			f.delete();	
		}
	}
	
	public static void encriptarInformacion() {
		
	}
	public static void main(String[] args) {
		//leerArmas();
		leerDatos("Pisos");
		//borrarInformacion();
	}
}
