package classes;

import java.security.DrbgParameters.NextBytes;
import java.util.Random;

public class Baralho {
	private Carta[] monte = new Carta[52];
	int j = 0;

	public Baralho() {
		for (int i = 0; i < 13; i++) {
			monte[j++] = new Carta(i + 1, Naipe.COPAS);
			monte[j++] = new Carta(i + 1, Naipe.ESPADAS);
			monte[j++] = new Carta(i + 1, Naipe.OUROS);
			monte[j++] = new Carta(i + 1, Naipe.PAUS);
		}
	}

	public Carta[] getMonte() {
		return monte;
	}

	Random rand = new Random();

	int[] arraySorteado = new int[52];

	private void embaralhar() {

		for (int i = 0; i < 52; i++) {

		}

	}
public void sortear() {
	
	//preciso fazer um sorteio de 52 numeros
		
	}

}
	

