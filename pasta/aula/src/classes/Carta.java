package classes;

public class Carta {
	private int valor;
	private Naipe naipe;

	public Carta(int valor, Naipe naipe) {
		super();
		this.valor = valor;
		this.naipe = naipe;
	}

	public int getValor() {
		return valor;
	}

	public Naipe getNaipe() {
		return naipe;
	}
}
