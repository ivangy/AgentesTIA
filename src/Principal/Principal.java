package Principal;

import java.util.Scanner;

public class Principal {

	public static int PintaMenu() {
		
		int opc;
		
		Scanner leer = new Scanner (System.in);
		
		
		do {
		
			System.out.println("------------------------------------------------------");
			System.out.println("Menú AgentesTIA");
			System.out.println("------------------------------------------------------");
			System.out.println("1 - Ver todos los agentes con su información");
			System.out.println("2 - Ver los agentes que ganen más de una cantidad X");
			System.out.println("3 - Dar de alta un nuevo piso");
			System.out.println("4 - Dar de alta una nueva arma");
			System.out.println("5 - Dar de alta un nuevo agente");
			System.out.println("6 - Encriptar toda la información");
			System.out.println("7 - Desencriptar toda la información");
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
		
		
	}
	
}

