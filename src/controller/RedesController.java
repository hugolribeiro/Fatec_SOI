package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public RedesController() {
		super();
	}
	
	// Retorna apenas o primeiro char do OS
	public char char_os() {
		String os = System.getProperty("os.name");
		return (os.charAt(0));
	}
	
	// Retorna o sistema Operacional completo
	public String full_os() {
		return System.getProperty("os.name");
	}
	
	// Método para trabalhar com o ping
	public void ping_medio(char letra_os) {
		
		// Determinar as variáveis
		double media = 0;
		double soma = 0;
		String comando = "";
		int count = 0;
		
		
		if (letra_os == 'W') {
			comando = "PING -n 10 www.google.com.br"; 
		}
		// Se for linux
		else {
			comando = "PING -c 10 www.google.com.br";
		}
		
		try {
			Process p = Runtime.getRuntime().exec(comando);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				if (linha.contains("time=")) {
					// Pegando o primeiro dígito (após o = ). O "+ 5" é para iniciar no número
					int first_digit = (linha.indexOf("time=") + 5);
					int last_digit = linha.lastIndexOf("ms");
					int latency_number = Integer.parseInt(linha.substring(first_digit, last_digit));  
					soma += latency_number;
					count += 1;
				}
				linha = buffer.readLine();
			}
			media = soma / count;
			System.out.println("O tempo médio de PING é: " + media + "ms");
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
