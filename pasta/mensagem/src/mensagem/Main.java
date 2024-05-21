package mensagem;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Consultora c1 = new Consultora(1, "Marcia", 0);
		c1.getTarefas().enqueue("Boas vindas, este é nosso sitema, assista nosso pequeno tutorial para iniciar");
		
		System.out.println("Ola "+c1.getNome()+"");
		System.out.println("[1]ver tarefas [2]fechar programa");
		int opcao;
		opcao = Scanner entrada.next
		while(opcao = 1) {
			System.out.println(c1.getTarefas());
		}

	}

	public boolean tutorial() {
		boolean tutorial = true;
		return tutorial;
	}
}
