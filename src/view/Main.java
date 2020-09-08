package view;

import java.util.Scanner;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		
		RedesController redcontroller = new RedesController();
		
		// Pega a primeira letra do SO (se L ent�o linux, se W ent�o windows)
		char os = redcontroller.char_os();
		
	    // Para receber as entradas
		Scanner scan = new Scanner(System.in);
		
		int option = 0;
		
		// Come�a o la�o com as op��es para o usu�rio
		while (option != 99) {
			
			System.out.println(
					"Escolha abaixo a op��o desejada: \n"
					+ "1 - Ver qual � seu sistema operacional.\n"
					+ "2 - Mostra os adaptadores que contenham IPV4. \n"
					+ "3 - Mostra o tempo m�dio do ping com 10 itera��es. \n"
					+ "99 - Finaliza programa");
			
			option = scan.nextInt();
			
			switch (option) {
			
			case 1:
				System.out.println("Seu sistema operacional �: " + redcontroller.full_os());
				break;
			
			case 2:
				System.out.println("Fazendo...");
				break;
			
			case 3:
				System.out.println("Por favor, aguarde alguns segundos");
				redcontroller.ping_medio(os);
				break;
			
			case 99:
				System.out.println("Finalizando o programa...");
				break;
				
			default:
				System.out.println("Op��o Inv�lida");
				break;
			}
		}
		
		scan.close();

	}

}
