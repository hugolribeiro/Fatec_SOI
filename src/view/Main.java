package view;

import java.util.Scanner;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		
		RedesController redcontroller = new RedesController();
		
		// Pega a primeira letra do SO (se L então linux, se W então windows)
		char os = redcontroller.char_os();
		
	    // Para receber as entradas
		Scanner scan = new Scanner(System.in);
		
		int option = 0;
		
		// Começa o laço com as opções para o usuário
		while (option != 99) {
			
			System.out.println(
					"Escolha abaixo a opção desejada: \n"
					+ "1 - Ver qual é seu sistema operacional.\n"
					+ "2 - Mostra os adaptadores que contenham IPV4. \n"
					+ "3 - Mostra o tempo médio do ping com 10 iterações. \n"
					+ "99 - Finaliza programa");
			
			option = scan.nextInt();
			
			switch (option) {
			
			case 1:
				System.out.println("Seu sistema operacional é: " + redcontroller.full_os());
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
				System.out.println("Opção Inválida");
				break;
			}
		}
		
		scan.close();

	}

}
