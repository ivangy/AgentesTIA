package Principal;

import java.util.Scanner;

import AgentesTIA.Agente007;
import AgentesTIA.AgenteJefazo;
import AgentesTIA.Agentes;
import IODatos.IODatos;

/**
 * 
 * @author Ivan Sanchez
 * @author Gil Pablo Blanco
 *
 */
public class Principal {

	public static int PintaMenu() {

		int opc;

		Scanner leer = new Scanner(System.in);

		do {

			System.out.println("------------------------------------------------------");
			System.out.println("Menú AgentesTIA");
			System.out.println("------------------------------------------------------");
			System.out.println("1 - Ver todos los agentes con su información"); //acabado
			System.out.println("2 - Ver los agentes que ganen más de una cantidad X"); //acabado
			System.out.println("3 - Dar de alta un nuevo piso");        //acabado
			System.out.println("4 - Dar de alta una nueva arma");       //acabado
			System.out.println("5 - Dar de alta un nuevo agente");		//acabado
			System.out.println("6 - Encriptar toda la información");    //acabado
			System.out.println("7 - Desencriptar toda la información"); //acabado
			System.out.println("8 - Salir");
			System.out.println("");

			System.out.println("Dime una opción:");

			opc = leer.nextInt();

			if ((opc < 1) || (opc > 8)) {
				System.out.println("Esta opcion es invalida, vuelve a intertarlo");
			}
		} while ((opc < 1) || (opc > 8));

		return opc;

	}
	
	private static String winlin() {
		Scanner l = new Scanner(System.in);
		int num=0;
		String dir="";
		do {
		System.out.println("Estas en Windows(1) o Linux(2)");
		num=l.nextInt();
		if(num==1||num==2){
		switch (num) {
		case 1:
			dir="src\\recursos\\";
			break;
			
		case 2:
			dir="src/recursos/";
			break;
		}
		}else System.out.println("ERROR");
		} while (num!=1);
		
		return dir;
	}

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		String dir=winlin();
		
		//Agentes vAgentes[] = new Agentes[10];
		//vAgentes[0] = new AgenteJefazo("Juan", 10, "Alcaniz", 100, 10);
		//vAgentes[1] = new Agente007("Juan", 10, "Alcaniz", 100, 10);
		
		Agentes[] vAgentes = IODatos.cargarAgentes(dir);
		
		int opcion = 0;
		do {

		while (opcion != 8) {
			opcion = PintaMenu();
			switch (opcion) {
			case 1:
				IODatos.mosAgentes(vAgentes);
				break;
			case 2:
				IODatos.ordenarXdinero(vAgentes);
				break;
			case 3:
				IODatos.darAlta("Pisos", IODatos.pisos(), dir);
				break;
			case 4:
				Scanner a = new Scanner(System.in);
				System.out.println("Dime el nuevo arma:");
				String nuArma = a.nextLine();
				IODatos.darAlta("Armas", nuArma, dir);
				break;
			case 5:
				IODatos.altaAgentes(vAgentes,dir);
				break;
			case 6:

				IODatos.encriptarInformacion(dir);
				break;
			case 7:
				
				IODatos.desencriptarInformacion(dir);
				break;
			case 8:
				System.out.println("Gracias por su atención, ¡Adiós!");
				IODatos.guardarAgentes(vAgentes, dir);
			}

		}
		} while (opcion!=8);

	}



}
