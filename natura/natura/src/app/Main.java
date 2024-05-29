package app;

import java.util.Random;
import java.util.Scanner;

import classes.Consultora;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner entrada = new Scanner(System.in);
		Consultora c1 = new Consultora("Andressa");

		boolean executar = true;

		do {

			System.out.println("Voce deseja executar uma nova tarefa?");
			System.out.println("[1]sim");
			System.out.println("[2]nao");

			int escolha = entrada.nextInt();
			switch (escolha) {
			case 1: {

				if (c1.getNivel() >= 3 && c1.getNivel() < 7) {
					c1.getNotificações().enqueue("Em que ano a natura foi fundada?");
					int resposta;
					do {
						c1.getNotificações().showFirst();
						System.out.println("[1]1867");
						System.out.println("[2]1975");
						System.out.println("[3]1969");

						System.out.println("Escreva sua resposta: ");
						resposta = entrada.nextInt();
						if (resposta == 3) {
							System.out.println("Correta ");
							c1.executarTarefa();

						} else {
							System.out.println("Incorreta");
						}
					} while (resposta != 3);

				}else

				if (c1.getNivel() < 3) {
					int num1 = rand.nextInt(5) + 1, num2 = rand.nextInt(5) + 1, resultado = num1 + num2, resposta;
					c1.getNotificações()
							.enqueue("nos ajude a contar o estoque!: " + num1 + " perfumes + " + num2 + " perfumes");
					do {

						c1.getNotificações().showFirst();
						System.out.println("Alternativas: [1] [2] [3] [4] [5] [6] [7] [8] [9] [10] ");

						resposta = entrada.nextInt();
						if (resposta != resultado) {
							System.out.println("Resposta errada");
						} else {
							System.out.println("Resposta correta!");
							c1.executarTarefa();
						}
					} while (resposta != resultado);

				} else
					System.out.println("Voce chegou ao nivel V.I.P, sem tarefas por enquanto");
				

			}
				break;

			case 2: {
				executar = false;
			}
				break;
			default:
				System.out.println("entrada invalida");
			}

		} while (executar);

	}// final main code
}// func
