package IODatos;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import AgentesTIA.Agente007;
import AgentesTIA.AgenteEspia;
import AgentesTIA.AgenteJefazo;
import AgentesTIA.Agentes;

/**
 * 
 * @author Ivan Sanchez
 * @author Gil Pablo Blanco
 *
 */
public class IODatos {
	/**
	 * Antes de mirar el codigo ten en cuenta esta variable y este vector: dir: es
	 * una direccion que depende de el sistema operativo vAgentes: dinamico con la
	 * informacion de los agentes
	 */

	/**
	 * Lee los archivos txt
	 * 
	 * @param ruta es el nombre del archivo que quieres leer
	 * @return te devuelve cada line de dentro del archivo en forma de vector
	 */
	public static ArrayList<String> leerDatos(String ruta, String dir) {

		String nombreFichero = dir + ruta;

		String ler = "";
		ArrayList<String> vDato = new ArrayList<>();
		// String vDato[] = new String[10];
		int i = 0;
		File f = new File(nombreFichero);
		if (!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		try (FileReader fr = new FileReader(f); Scanner leer = new Scanner(fr)) {

			while (leer.hasNext()) {
				ler = leer.nextLine().trim();

				vDato.add(ler);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return vDato;
	}

	/**
	 * lee el vector dinamicos vAgentes y lo muestra por pantalla
	 */
	public static void mosAgentes(ArrayList<Agentes> vAgentes) {
		for (Agentes a : vAgentes)
			System.out.println(a);

		Scanner t = new Scanner(System.in);
		System.out.println("Pulsa cualquier tecla para salir");
		String tecla = t.nextLine();
	}

	/**
	 * Borra los archivos que le mandes la ruta
	 * 
	 * @param ruta es el nombre del archivo
	 */
	public static void borrarInformacion(String ruta, String dir) {
		String nombreFichero = dir + ruta;
		File f = new File(nombreFichero);
		File direct = new File(ruta);
		
	
		
		if (f.exists()) {
			f.delete();
		}
	}

	/**
	 * Convierte un archivo de .dat a .txt y llama a borrarInformacion para que
	 * borre los archivos .dat
	 */
	public static void encriptarInformacion(String dir) {
		String rut = dir;
		String armas = rut + "Armas.txt";
		String armasEn = rut + "Armas.dat";
		String pisos = rut + "Pisos.txt";
		String pisosEn = rut + "Pisos.dat";

		File armasOrigin = new File(armas);
		File armasDestination = new File(armasEn);
		File pisosOrigin = new File(pisos);
		File pisosDestination = new File(pisosEn);

		// Encriptar armas.txt
		if (armasOrigin.exists()) {
			ArrayList<String> v1 = leerDatos("Armas.txt", dir);
			if (armasDestination.exists()) {
				armasDestination.delete();
			}
			try (FileOutputStream fo = new FileOutputStream(armasDestination);
					DataOutputStream escribir = new DataOutputStream(fo)) {

				for (String s : v1) {
					if (s != null) {
						escribir.writeUTF(s);
					}

				}

				borrarInformacion("Armas.txt", dir);

			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		} else
			System.out.println("Ya está encriptado el archivo Armas");

		// Encriptar pisos.txt
		if (pisosOrigin.exists()) {
			ArrayList<String> v1 = leerDatos("Pisos.txt", dir);
			if (pisosDestination.exists()) {
				pisosDestination.delete();
			}
			try (FileOutputStream fo = new FileOutputStream(pisosDestination);
					DataOutputStream escribir = new DataOutputStream(fo)) {

				for (String s : v1) {
					if (s != null) {
						escribir.writeUTF(s);
					}

				}
				borrarInformacion("Pisos.txt", dir);

			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		} else
			System.out.println("Ya está encriptado el archivo Pisos");

	}

	/**
	 * Convierte un archivo de .txt a .dat y llama a borrarInformacion para que
	 * borre los archivos .txt
	 */
	public static void desencriptarInformacion(String dir) {
		String rut = dir;

		String armas = rut + "Armas.txt";
		String pisos = rut + "Pisos.txt";
		String armasEn = rut + "Armas.dat";
		String pisosEn = rut + "Pisos.dat";

		File fArmas = new File(armas);
		File fArmasEn = new File(armasEn);
		File fPisos = new File(pisos);
		File fPisosEn = new File(pisosEn);

		String usu = "", pass = "", fin = "";
		Scanner ler = new Scanner(System.in);

		do {
			System.out.println("Dime el usuario");
			usu = ler.nextLine();
			if (usu.equals("admin")) {
				System.out.println("Dime la contraseña");
				pass = ler.nextLine();
				if (pass.equals("admin")) {

					// desencripta Armas.dat
					if (fArmasEn.exists()) {
						try (FileInputStream fi = new FileInputStream(fArmasEn);
								DataInputStream leer = new DataInputStream(fi);
								FileWriter fw = new FileWriter(fArmas);
								PrintWriter writer = new PrintWriter(fw);) {

							fArmas.createNewFile();

							while (true) {
								writer.println(leer.readUTF());
							}

						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							// e.printStackTrace();
						}
						borrarInformacion("Armas.dat", dir);
					} else
						System.out.println("Ya está desencriptado el archivo Armas");

					// desencripta pisos.dat
					if (fPisosEn.exists()) {
						try (FileInputStream fi = new FileInputStream(fPisosEn);
								DataInputStream leer = new DataInputStream(fi);
								FileWriter fw = new FileWriter(fPisos);
								PrintWriter writer = new PrintWriter(fw);) {

							fPisos.createNewFile();

							while (true) {
								writer.println(leer.readUTF());
							}

						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							// e.printStackTrace();
						}
						borrarInformacion("Pisos.dat", dir);
					} else
						System.out.println("Ya está desencriptado el archivo Pisos");

					fin = "fin";
				} else
					System.out.println("ERROR");
			} else
				System.out.println("ERROR");

		} while (fin != "fin");

	}

	/**
	 * Mete informacion dada como parametro al archivo .txt dado por parametro
	 * 
	 * @param ruta es el nombre del archivo
	 * @param dato es lo que te pasan para meter dentro del archivo
	 */
	public static void darAlta(String ruta, String dato, String dir) {
		String nombreFichero = dir + ruta + ".txt";
		File f = new File(nombreFichero);

		if (f.exists()) {
			try (FileWriter fw = new FileWriter(f, true); PrintWriter writer = new PrintWriter(fw);) {

				writer.println(dato);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}

		} else
			System.out.println("desencripta la informacion antes de meter un nuevo " + ruta);
	}

	/**
	 * Switch que llama primero a Pintamenu y luego con la opcion que te da
	 * pintamenu llama a otro metodo el cual mete informacion a un archivo
	 */
	public static void altaAgentes(ArrayList<Agentes> vAgentes, String dir) {

		switch (pintaMenuAgen()) {
		case 1:
			meterAgente007(vAgentes, dir);
			break;
		case 2:
			meterAgenteEspia(vAgentes, dir);
			break;
		case 3:
			meterAgenteJefazo(vAgentes);
			break;
		}
	}

	/**
	 * pinta un menu por pantalla
	 * 
	 * @return devuelve una opcion
	 */
	public static int pintaMenuAgen() {
		Scanner lr = new Scanner(System.in);
		int opc;
		do {
			System.out.println("1 - Añadir Agente007");
			System.out.println("2 - Añadir Agente Espia");
			System.out.println("3 - Añadir Agente Jefazo");
			System.out.println("");

			System.out.println("Dime una opción:");

			opc = lr.nextInt();

			if ((opc < 1) || (opc > 3)) {
				System.out.println("Esta opcion es invalida, vuelve a intertarlo");
			}
		} while ((opc < 1) || (opc > 3));
		return opc;
	}

	/**
	 * Te pide por pantalla datos del piso y los junta en una variable
	 * 
	 * @return devuelve la informacion del piso que nos han dado en una variable
	 */
	public static String pisos() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Ciudad:");
		String ciudad = leer.nextLine();
		System.out.println("Calle:");
		String calle = leer.nextLine();
		System.out.println("Numero:");
		String numero = leer.nextLine();

		String piso = (ciudad + ", " + calle + " número " + numero);
		return piso;
	}

	/**
	 * muestra por pantalla segun el dinero que nos introduzcan por pantalla
	 */
	public static void ordenarXdinero(ArrayList<Agentes> vAgentes) {
		Scanner leer = new Scanner(System.in);
		int num = 0;
		System.out.println("Dime a partir de que cantidad te muestro los agentes");
		try {
			num = leer.nextInt();
		} catch (Exception e) {
			System.out.println("ERROR NO ES UN NUMERO VALIDO");
		}
		for (Agentes a : vAgentes) {
			if (a.getSalario() >= num) {
				System.out.println(a);
			}
		}
		Scanner t = new Scanner(System.in);
		System.out.println("Pulsa cualquier tecla para salir");
		String tecla = t.nextLine();
	}

	/**
	 * Añade un nuevo agente007
	 */
	public static void meterAgente007(ArrayList<Agentes> vAgentes, String dir) {
		Scanner l = new Scanner(System.in);
		Scanner ln = new Scanner(System.in);
		String nombre, direccion, armas;
		int edad, muertes;
		float salario;

		System.out.println("Dime su nombre");
		nombre = l.nextLine();
		System.out.println("Dime su edad");
		edad = ln.nextInt();
		System.out.println("Dime su direccion");
		direccion = l.nextLine();
		System.out.println("Dime su salario");
		salario = ln.nextFloat();
		System.out.println("Dime ha cuantos a  matado");
		muertes = ln.nextInt();

		/*
		 * ArrayList<String> vArmas= leerDatos("Armas.txt", dir); for (String vA :
		 * vArmas) { if(vA!=null)System.out.println(vA); } System.out.
		 * println("Dime su arma (Debe poner una o mas de las armas mostradas arriba)");
		 * armas=l.nextLine();
		 */

		vAgentes.add(new Agente007(nombre, edad, direccion, salario, muertes));

	}

	/**
	 * Añade un nuevo agenteEspia
	 */
	public static void meterAgenteEspia(ArrayList<Agentes> vAgentes, String dir) {
		Scanner a = new Scanner(System.in);
		Scanner an = new Scanner(System.in);
		String nombre, direccion, pisos;
		int edad;
		float salario;

		System.out.println("Dime su nombre");
		nombre = a.nextLine();
		System.out.println("Dime su edad");
		edad = an.nextInt();
		System.out.println("Dime su direccion");
		direccion = a.nextLine();
		System.out.println("Dime su salario");
		salario = an.nextFloat();

		/*
		 * ArrayList<String> vPisos= leerDatos("Pisos.txt",dir); for (String vP :
		 * vPisos) { if(vP!=null)System.out.println(vP); } System.out.
		 * println("Dime su piso (Debe poner uno de los pisos mostrados arriba)");
		 * pisos=a.nextLine();
		 */

		vAgentes.add(new AgenteEspia(nombre, edad, direccion, salario));

	}

	/**
	 * Añade un nuevo agenteJefazo
	 */
	public static void meterAgenteJefazo(ArrayList<Agentes> vAgentes) {
		Scanner l = new Scanner(System.in);
		Scanner ln = new Scanner(System.in);
		String nombre, direccion;
		int edad, anos_mandato;
		float salario;

		System.out.println("Dime su nombre");
		nombre = l.nextLine();
		System.out.println("Dime su edad");
		edad = ln.nextInt();
		System.out.println("Dime su direccion");
		direccion = l.nextLine();
		System.out.println("Dime su salario");
		salario = ln.nextFloat();
		System.out.println("Dime sus años de mandato");
		anos_mandato = ln.nextInt();

		vAgentes.add(new AgenteJefazo(nombre, edad, direccion, salario, anos_mandato));
	}

	/**
	 * Guarda en un archivo .dat el vector dinamico dado por parametro
	 * 
	 * @param vAgentes vector dinamico con la informacion de los agentes
	 */
	public static void guardarAgentes(ArrayList<Agentes> vAgentes, String dir) {

		File f = new File(dir + "Agentes.dat");
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try (FileOutputStream fo = new FileOutputStream(f); ObjectOutputStream escribir = new ObjectOutputStream(fo)) {
			for (Agentes a : vAgentes) {
				escribir.writeObject(a);
			}

			/*
			 * for (Agentes agentes : vAgentes) { if (agentes != null)
			 * escribir.writeObject(agentes); }
			 */

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	// hacer pruebas
	/**
	 * lee el archivo .dat de agentes y lo convierte en un vector dinamico
	 * 
	 * @return vAgentes contiene los agentes leidos del archivo .dat
	 */
	public static ArrayList<Agentes> cargarAgentes(String dir) {
		File f = new File(dir + "Agentes.dat");
		ArrayList<Agentes> vAgentes = new ArrayList<>();

		if (!f.exists()) {
			try {
				f.createNewFile();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
		}

		try (FileInputStream fo = new FileInputStream(f); ObjectInputStream leer = new ObjectInputStream(fo)) {

			while (true) {
				vAgentes.add((Agentes) leer.readObject());
			}

			// vAgentes = (Agentes[]) leer.readObject();
			/*
			 * while (true) { vAgentes[cont] = (Agentes) leer.readObject(); cont++; }
			 */

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("Carga de datos completada");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vAgentes;
	}

	/**
	 * Asigna la direccion de todos los archivos que se van a usar en el programa
	 * 
	 * @return dir es una direccion que depende de el sistema operativo
	 */
	public static String so() {
		Scanner l = new Scanner(System.in);
		int num = 0;
		String dir = "";
		do {
			System.out.println("Estas en Windows(1) o Linux(2)");
			num = l.nextInt();
			if (num == 1 || num == 2) {
				switch (num) {
				case 1:
					dir = "recursos\\";
					break;

				case 2:
					dir = "recursos/";
					break;
				}
			} else
				System.out.println("ERROR");
		} while (num < 1 || num > 2);

		return dir;
	}
}