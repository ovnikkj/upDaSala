package filas;

public class FilaString {

	private int N = 1;
	private String dados[] = new String[N];
	private int ini, fim, cont;

	public void init() {
		ini = fim = cont = 0;
	}

	public boolean isEmpty() {
		return (cont == 0);
	}

	public boolean isFull() {
		return (cont == N);
	}

	public void enqueue(String elem) {
		if (isFull()) {
			System.out.println("Aumentando o tamanho da fila de " + N + " para " + (N + 1));
			ajustarTamanho();
		}
		dados[fim] = elem;
		fim = (fim + 1) % N;
		cont++;
	}

	public String dequeue() {
		if (isEmpty()) {
			System.out.println("Fila vazia!");
			return null;
		}
		String elem = dados[ini];
		ini = (ini + 1) % N;
		cont--;
		return elem;
	}

	public String first() {
		if (isEmpty()) {
			System.out.println("Fila vazia!");
			return null;
		}
		return dados[ini];
	}

	public void showFirst() {
		System.out.println(first());
	}

	public int size() {
		return cont;
	}

	private void ajustarTamanho() {
		int novoTamanho = N + 1;
		String[] novoDados = new String[novoTamanho];

		for (int i = 0; i < cont; i++) {
			novoDados[i] = dados[(ini + i) % N];
		}

		dados = novoDados;
		ini = 0;
		fim = cont;
		N = novoTamanho;
	}
}