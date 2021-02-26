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
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class IODatos {

	public static String[] leerDatos(String ruta) {
		String nombreFichero = "/home/dawb/Escritorio/AgentesTIA/src/recursos/" + ruta + ".txt";
		String piso;
		String ler = "";
		String vPisos[] = new String[10];
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

				vPisos[i] = ler;
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return vPisos;
	}

	public static void borrarInformacion(String ruta) {
		String nombreFichero = "/home/dawb/Escritorio/AgentesTIA/src/recursos/" + ruta;
		File f = new File(nombreFichero);

		if (f.exists()) {
			f.delete();
		}
	}

	public static void encriptarInformacion() {
		String armas = "/home/dawb/Escritorio/AgentesTIA/src/recursos/Armas.txt";
		String armasEn = "/home/dawb/Escritorio/AgentesTIA/src/recursos/Armas.dat";
		String pisos = "/home/dawb/Escritorio/AgentesTIA/src/recursos/Pisos.txt";
		String pisosEn = "/home/dawb/Escritorio/AgentesTIA/src/recursos/Pisos.dat";

		File armasOrigin = new File(armas);
		File armasDestination = new File(armasEn);
		File pisosOrigin = new File(pisos);
		File pisosDestination = new File(pisosEn);

		if (armasOrigin.exists()) {
			String[] v1 = leerDatos("Armas");
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

				borrarInformacion("Armas.txt");

			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		} else
			System.out.println("Ya está encriptado el archivo Armas");

		if (pisosOrigin.exists()) {
			String[] v1 = leerDatos("Pisos");
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
				borrarInformacion("Pisos.txt");

			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		} else
			System.out.println("Ya está encriptado el archivo Pisos");
	}

	public static void desencriptarInformacion() {
		String armas = "/home/dawb/Escritorio/AgentesTIA/src/recursos/Armas.txt";
		String pisos = "/home/dawb/Escritorio/AgentesTIA/src/recursos/Pisos.txt";
		String armasEn = "/home/dawb/Escritorio/AgentesTIA/src/recursos/Armas.dat";
		String pisosEn = "/home/dawb/Escritorio/AgentesTIA/src/recursos/Pisos.dat";

		File fArmas = new File(armas);
		File fPisos = new File(pisos);
		File fArmasEn = new File(armasEn);
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
						borrarInformacion("Armas.dat");
					} else
						System.out.println("Ya está desencriptado el archivo Armas");

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
						borrarInformacion("Pisos.dat");
					} else
						System.out.println("Ya está desencriptado el archivo Pisos");
					fin = "fin";
				} else
					System.out.println("ERROR");
			} else
				System.out.println("ERROR");

		} while (fin != "fin");

	}

	public static void darAlta(String ruta, String dato) {
		String nombreFichero = "/home/dawb/Escritorio/AgentesTIA/src/recursos/" + ruta + ".txt";
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
}
