package app;

import classes.Baralho;

public class Main {

	public static void main(String[] args) {
		Baralho b1 = new Baralho();
		for (int i = 0; i < 52; i++) {
			System.out.println(b1.getMonte()[i].getValor() + " de " + b1.getMonte()[i].getNaipe());

		}
	}

}
