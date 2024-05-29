package classes;

import java.util.Scanner;

import filas.FilaString;

public class Consultora {
	Scanner entrada = new Scanner(System.in);
	private String nome;
	private double nivel = 0.00;
	private int nivelIntAnterior;
	private FilaString notificações;

	public Consultora(String nome) {
		super();
		this.nome = nome;
		nivelIntAnterior = (int) nivel;
		notificações = new FilaString();
	}

	public String getNome() {
		return nome;
	}

	public double getNivel() {
		return nivel;
	}

	public FilaString getNotificações() {
		return notificações;
	}

	public void executarTarefa() {

		if (!notificações.isEmpty()) {
			System.out.println(nome + " executou a tarefa");

			notificações.dequeue();
			nivel = nivel + 0.75;
			if ((int) nivel > nivelIntAnterior) {
				nivelIntAnterior = (int) nivel;
				System.out
						.println("============= parabens você subiu de nivel: " + nivelIntAnterior + " =============");
			}

		} else {
			System.out.println("!! voce nao tem nenhuma tarefa para ser realizada agora :( !!");
		}
	}

}
