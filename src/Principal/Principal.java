package Principal;

import java.util.Scanner;

import AgentesTIA.Agente007;
import AgentesTIA.Agentes;
import IODatos.IODatos;

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

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		

		int opcion = 0;
		do {

		while (opcion != 8) {
			opcion = PintaMenu();
			switch (opcion) {
			case 1:
				IODatos.mosAgentes();
				break;
			case 2:
				IODatos.ordenarXdinero();
				break;
			case 3:

				IODatos.darAlta("Pisos", IODatos.pisos());
				break;
			case 4:
				Scanner a = new Scanner(System.in);
				System.out.println("Dime el nuevo arma:");
				String nuArma = a.nextLine();
				IODatos.darAlta("Armas", nuArma);
				break;
			case 5:
				IODatos.altaAgentes();
				break;
			case 6:

				IODatos.encriptarInformacion();
				break;
			case 7:
				
				IODatos.desencriptarInformacion();
				break;
			case 8:
				System.out.println("Gracias por su atención, ¡Adiós!");

			}

		}
		} while (opcion!=8);

	}

}
