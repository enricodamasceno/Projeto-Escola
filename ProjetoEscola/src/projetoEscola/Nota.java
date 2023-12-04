package projetoEscola;

public class Nota {
	private String dataCorrecao;
	private float pontos;
	
	public Nota(String dataCorrecao, float pontos) {
		this.dataCorrecao = dataCorrecao;
		this.pontos = pontos;
	}

	public float getPontos() {
		return pontos;
	}

	public String getData() {
		return dataCorrecao;
	}
}
