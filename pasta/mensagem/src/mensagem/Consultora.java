package mensagem;

public class Consultora {

	private int id;
	private String nome;
	private double nivel;
	private FilaString tarefas;

	public Consultora(int id, String nome, double nivel) {
		this.id = id;
		this.nome = nome;
		this.nivel = nivel;
		tarefas = new FilaString();
	}

	public FilaString getTarefas() {
		return tarefas;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public double getNivel() {
		return nivel;
	}
}
