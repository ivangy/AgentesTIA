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
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import AgentesTIA.Agente007;
import AgentesTIA.AgenteEspia;
import AgentesTIA.AgenteJefazo;
import AgentesTIA.Agentes;

public class IODatos {

	public static String[] leerDatos(String ruta) {
		String nombreFichero = "/home/dawb/Escritorio/AgentesTIA/src/recursos/" + ruta;
	
		String ler = "";
		String vDato[] = new String[10];
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

				vDato[i] = ler;
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return vDato;
	}
	
	public static void mosAgentes() {
		String nombreFichero = "/home/dawb/Escritorio/AgentesTIA/src/recursos/Agentes.txt";
		String ler = "";
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
				System.out.println(ler);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Scanner t = new Scanner(System.in);
		System.out.println("Pulsa cualquier tecla para salir");
		String tecla=t.nextLine();
	}

	public static void borrarInformacion(String ruta) {
		String nombreFichero = "/home/dawb/Escritorio/AgentesTIA/src/recursos/" + ruta;
		File f = new File(nombreFichero);

		if (f.exists()) {
			f.delete();
		}
	}

	public static void encriptarInformacion() {
		String rut="/home/dawb/Escritorio/AgentesTIA/src/recursos/";
		String armas = rut+ "Armas.txt";
		String armasEn = rut+ "Armas.dat";
		String pisos = rut+ "Pisos.txt";
		String pisosEn = rut+ "Pisos.dat";
		String agentes = rut+ "Agentes.txt";
		String agentesEn = rut+ "Agentes.dat";
		String agente007 = rut+ "agentes/Agente007.txt";
		String agente007En = rut+ "agentes/Agente007.dat";
		String agenteEspia = rut+ "agentes/AgenteEspia.txt";
		String agenteEspiaEn = rut+ "agentes/AgenteEspia.dat";
		String agenteJefazo = rut+ "agentes/AgenteJefazo.txt";
		String agenteJefazoEn = rut+ "agentes/AgenteJefazo.dat";

		
		File armasOrigin = new File(armas);
		File armasDestination = new File(armasEn);
		File pisosOrigin = new File(pisos);
		File pisosDestination = new File(pisosEn);
		File agentesOrigin = new File(agentes);
		File agentesDestination = new File(agentesEn);
		File agente007Origin = new File(agente007);
		File agente007Destination = new File(agente007En);
		File agenteEspiaOrigin = new File(agenteEspia);
		File agenteEspiaDestination = new File(agenteEspiaEn);
		File agenteJefazoOrigin = new File(agenteJefazo);
		File agenteJefazoDestination = new File(agenteJefazoEn);

		//Encriptar armas.txt
		if (armasOrigin.exists()) {
			String[] v1 = leerDatos("Armas.txt");
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

		
		//Encriptar pisos.txt
		if (pisosOrigin.exists()) {
			String[] v1 = leerDatos("Pisos.txt");
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
		
		
		
		//Encriptar agentes.txt
		if (agentesOrigin.exists()) {
			String[] v1 = leerDatos("Agentes.txt");
			if (agentesDestination.exists()) {
				agentesDestination.delete();
			}
			try (FileOutputStream fo = new FileOutputStream(agentesDestination);
					DataOutputStream escribir = new DataOutputStream(fo)) {

				for (String s : v1) {
					if (s != null) {
						escribir.writeUTF(s);
					}

				}
				borrarInformacion("Agentes.txt");

			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		} else
			System.out.println("Ya está encriptado el archivo Agentes");
		
		
		// Encriptar agente007.txt
		if (agente007Origin.exists()) {
			String[] v1 = leerDatos("agentes/Agente007.txt");
			if (agente007Destination.exists()) {
				agente007Destination.delete();
			}
			try (FileOutputStream fo = new FileOutputStream(agente007Destination);
					DataOutputStream escribir = new DataOutputStream(fo)) {

				for (String s : v1) {
					if (s != null) {
						escribir.writeUTF(s);
					}

				}
				borrarInformacion("agentes/Agente007.txt");

			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		} else
			System.out.println("Ya está encriptado el archivo Agente007");
				
		
		
		
			// Encriptar agenteEspia.txt
			if (agenteEspiaOrigin.exists()) {
				String[] v1 = leerDatos("agentes/AgenteEspia.txt");
				if (agenteEspiaDestination.exists()) {
					agenteEspiaDestination.delete();
				}
				try (FileOutputStream fo = new FileOutputStream(agenteEspiaDestination);
						DataOutputStream escribir = new DataOutputStream(fo)) {

					for (String s : v1) {
						if (s != null) {
							escribir.writeUTF(s);
						}

					}
					borrarInformacion("agentes/AgenteEspia.txt");

				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			} else
				System.out.println("Ya está encriptado el archivo AgenteEspia");

			
			// Encriptar agenteJefazo.txt
			if (agenteJefazoOrigin.exists()) {
				String[] v1 = leerDatos("agentes/AgenteJefazo.txt");
				if (agenteJefazoDestination.exists()) {
					agenteJefazoDestination.delete();
				}
				try (FileOutputStream fo = new FileOutputStream(agenteJefazoDestination);
						DataOutputStream escribir = new DataOutputStream(fo)) {

					for (String s : v1) {
						if (s != null) {
							escribir.writeUTF(s);
						}

					}
					borrarInformacion("agentes/AgenteJefazo.txt");

				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			} else
				System.out.println("Ya está encriptado el archivo AgenteJefazo");
		
		
		
		
		
		
	}
	
	public static void desencriptarInformacion() {
		String rut="/home/dawb/Escritorio/AgentesTIA/src/recursos/";
		
		String armas = rut+ "Armas.txt";
		String pisos = rut+ "Pisos.txt";
		String armasEn =  rut+ "Armas.dat";
		String pisosEn =  rut+ "Pisos.dat";
		String agentes = rut+ "Agentes.txt";
		String agentesEn = rut+ "Agentes.dat";
		String agente007 = rut+ "agentes/Agente007.txt";
		String agente007En = rut+ "agentes/Agente007.dat";
		String agenteEspia = rut+ "agentes/AgenteEspia.txt";
		String agenteEspiaEn = rut+ "agentes/AgenteEspia.dat";
		String agenteJefazo = rut+ "agentes/AgenteJefazo.txt";
		String agenteJefazoEn = rut+ "agentes/AgenteJefazo.dat";

		File fArmas = new File(armas);
		File fArmasEn = new File(armasEn);
		File fPisos = new File(pisos);
		File fPisosEn = new File(pisosEn);
		File fAgentes = new File(agentes);
		File fAgentesEn = new File(agentesEn);
		File fAgente007 = new File(agente007);
		File fAgente007En = new File(agente007En);
		File fAgenteEspia = new File(agenteEspia);
		File fAgenteEspiaEn = new File(agenteEspiaEn);
		File fAgenteJefazo = new File(agenteJefazo);
		File fAgenteJefazoEn = new File(agenteJefazoEn);
		
		
		
		
		String usu = "", pass = "", fin = "";
		Scanner ler = new Scanner(System.in);

		do {
			System.out.println("Dime el usuario");
			usu = ler.nextLine();
			if (usu.equals("admin")) {
				System.out.println("Dime la contraseña");
				pass = ler.nextLine();
				if (pass.equals("admin")) {

					
					//desencripta Armas.dat
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

					
					//desencripta pisos.dat
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
					
					
					
					//desencripta Agentes.dat
					if (fAgentesEn.exists()) {
						try (FileInputStream fi = new FileInputStream(fAgentesEn);
								DataInputStream leer = new DataInputStream(fi);
								FileWriter fw = new FileWriter(fAgentes);
								PrintWriter writer = new PrintWriter(fw);) {

							fAgentes.createNewFile();

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
						borrarInformacion("Agentes.dat");
					} else
						System.out.println("Ya está desencriptado el archivo Agentes");
					
					
					
					//desencripta agente007.dat
					if (fAgente007En.exists()) {
						try (FileInputStream fi = new FileInputStream(fAgente007En);
								DataInputStream leer = new DataInputStream(fi);
								FileWriter fw = new FileWriter(fAgente007);
								PrintWriter writer = new PrintWriter(fw);) {

							fAgente007.createNewFile();

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
						borrarInformacion("agentes/Agente007.dat");
					} else
						System.out.println("Ya está desencriptado el archivo Agente007");
					
					
					
					//desencripta AgenteEspia.dat
					if (fAgenteEspiaEn.exists()) {
						try (FileInputStream fi = new FileInputStream(fAgenteEspiaEn);
								DataInputStream leer = new DataInputStream(fi);
								FileWriter fw = new FileWriter(fAgenteEspia);
								PrintWriter writer = new PrintWriter(fw);) {

							fAgenteEspia.createNewFile();

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
						borrarInformacion("agentes/AgenteEspia.dat");
					} else
						System.out.println("Ya está desencriptado el archivo AgenteEspia");
					
					
					
					//desencripta AgenteJefazo.dat
					if (fAgenteJefazoEn.exists()) {
						try (FileInputStream fi = new FileInputStream(fAgenteJefazoEn);
								DataInputStream leer = new DataInputStream(fi);
								FileWriter fw = new FileWriter(fAgenteJefazo);
								PrintWriter writer = new PrintWriter(fw);) {

							fAgenteJefazo.createNewFile();

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
						borrarInformacion("agentes/AgenteJefazo.dat");
					} else
						System.out.println("Ya está desencriptado el archivo AgenteJefazo");
					
					
					
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
	
	public static void altaAgentes() {
		
			switch (pintaMenuAgen()) {
			case 1:
				meterAgente007();
				break;
			case 2:
				meterAgenteEspia();		
				break;
			case 3:
				meterAgenteJefazo();
				break;
			}
	}
	
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
	
	public static void ordenarXdinero() {
		String nombreFichero="/home/dawb/Escritorio/AgentesTIA/src/recursos/Agentes.txt";
		Scanner lCant = new Scanner(System.in);
		System.out.println("¿A partir de que cantidad quieres ver?");
		float cantidad=lCant.nextFloat();
		
		String ler="", salario;
		File f = new File(nombreFichero);
			try (FileReader fr = new FileReader(f); Scanner leer = new Scanner(fr)) {

				while (leer.hasNext()) {
					ler = leer.nextLine().trim();
					int sal = ler.indexOf("salario=");
					int coma = ler.indexOf("€");
					salario = ler.substring(sal+9, coma);
					if(salario!=null) {
						if(Float.parseFloat(salario)>cantidad) {
						System.out.println(ler);
						}
					}
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			Scanner t = new Scanner(System.in);
			System.out.println("Pulsa cualquier tecla para salir");
			String tecla=t.nextLine();
	}
	
	public static void meterAgente007() {
		Scanner l = new Scanner(System.in);
		Scanner ln = new Scanner(System.in);
		String nombre,direccion,armas;
		int edad,muertes;
		float salario;
		
				System.out.println("Dime su nombre");
				nombre=l.nextLine();
				System.out.println("Dime su edad");
				edad=ln.nextInt();
				System.out.println("Dime su direccion");
				direccion=l.nextLine();
				System.out.println("Dime su salario");
				salario=ln.nextFloat();
				System.out.println("Dime su muertes");
				muertes=ln.nextInt();
				System.out.println("Dime su arma (Debe poner una de las armas mostradas abajo)");
				String [] vArmas= leerDatos("Armas");
				for (String vA : vArmas) {
					if(vA!=null)System.out.println(vA);
				}
				armas=l.nextLine();
				Agente007 a007 = new Agente007(nombre, edad, direccion, salario, muertes, armas);
				System.out.println("");
				
				String nombreFichero = "/home/dawb/Escritorio/AgentesTIA/src/recursos/agentes/Agente007.txt";
				String nombreFichero2 = "/home/dawb/Escritorio/AgentesTIA/src/recursos/Agentes.txt";
				File f = new File(nombreFichero);
				File f2 = new File(nombreFichero2);
				if (f.exists()) {
					try (FileWriter fw = new FileWriter(f, true); PrintWriter writer = new PrintWriter(fw);
							FileWriter fw2 = new FileWriter(f2, true); PrintWriter writer2 = new PrintWriter(fw2);) {

						writer.println(a007);
						writer2.println(a007);

					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
					}

				} else
					System.out.println("desencripta la informacion antes de meter un nuevo " + "Agente007");
		}

	public static void meterAgenteEspia() {
		Scanner a = new Scanner(System.in);
		Scanner an = new Scanner(System.in);
		String nombre,direccion,pisos;
		int edad;
		float salario;

				System.out.println("Dime su nombre");
				nombre=a.nextLine();
				System.out.println("Dime su edad");
				edad=an.nextInt();
				System.out.println("Dime su direccion");
				direccion=a.nextLine();
				System.out.println("Dime su salario");
				salario=an.nextFloat();
				System.out.println("Dime su piso (Debe poner uno de los pisos mostrados abajo)");
				String [] vPisos= leerDatos("Pisos");
				for (String vP : vPisos) {
					if(vP!=null)System.out.println(vP);
				}
				pisos=a.nextLine();
				
				AgenteEspia aEspia = new AgenteEspia(nombre, edad, direccion, salario, pisos);
				System.out.println("");
				
				String nombreFichero = "/home/dawb/Escritorio/AgentesTIA/src/recursos/agentes/AgenteEspia.txt";
				String nombreFichero2 = "/home/dawb/Escritorio/AgentesTIA/src/recursos/Agentes.txt";
				File f = new File(nombreFichero);
				File f2 = new File(nombreFichero2);
				if (f.exists()) {
					try (FileWriter fw = new FileWriter(f, true); PrintWriter writer = new PrintWriter(fw);
							FileWriter fw2 = new FileWriter(f2, true); PrintWriter writer2 = new PrintWriter(fw2);) {

						writer.println(aEspia);
						writer2.println(aEspia);

					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
					}

				} else
					System.out.println("desencripta la informacion antes de meter un nuevo " + "AgenteEspia");
		}
	
	public static void meterAgenteJefazo() {
		Scanner l = new Scanner(System.in);
		Scanner ln = new Scanner(System.in);
		String nombre,direccion;
		int edad,anos_mandato;
		float salario;

				System.out.println("Dime su nombre");
				nombre=l.nextLine();
				System.out.println("Dime su edad");
				edad=ln.nextInt();
				System.out.println("Dime su direccion");
				direccion=l.nextLine();
				System.out.println("Dime su salario");
				salario=ln.nextFloat();
				System.out.println("Dime sus años de mandato");
				anos_mandato=ln.nextInt();
				AgenteJefazo aJefazo = new AgenteJefazo(nombre, edad, direccion, salario, anos_mandato);
				System.out.println("");
				
				String nombreFichero = "/home/dawb/Escritorio/AgentesTIA/src/recursos/agentes/AgenteJefazo.txt";
				String nombreFichero2 = "/home/dawb/Escritorio/AgentesTIA/src/recursos/Agentes.txt";
				File f = new File(nombreFichero);
				File f2 = new File(nombreFichero2);
				if (f.exists()) {
					try (FileWriter fw = new FileWriter(f, true); PrintWriter writer = new PrintWriter(fw);
							FileWriter fw2 = new FileWriter(f2, true); PrintWriter writer2 = new PrintWriter(fw2);) {

						writer.println(aJefazo);
						writer2.println(aJefazo);

					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
					}

				} else
					System.out.println("desencripta la informacion antes de meter un nuevo " + "AgenteJefazo");
		}

}