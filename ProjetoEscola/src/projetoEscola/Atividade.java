package projetoEscola;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;;

public class Atividade {
	public String dataEntrega;
	public String descricao;

	Scanner scanner = new Scanner(System.in);

	public static List<Atividade> atividades = new ArrayList<>();

	public Atividade(String dataEntrega, String descricao) {
		this.dataEntrega = dataEntrega;
		this.descricao = descricao;
		for (Atividade atividade : atividades) {
			if (descricao.equals(atividade.descricao)) {
				this.descricao = this.validaDescricao();
			}
		}
	}

	// Função utilizada para a verificação da descrição
	private String validaDescricao() {
		System.out.println("Descrição já utilizada por outra atividade, escreva outra descrição: ");
		String nova_descricao = scanner.nextLine();
		for (Atividade atividade: atividades) {
			if (nova_descricao.equals(atividade.descricao)) {
				return this.validaDescricao();
			}
		}
		return nova_descricao;
	}

	// Exibe informações das atividades:
	public static void exibirAtividades() {
		
		Integer i = 1;
		for (Atividade atividade : atividades) {
			System.out.println(
					"Atividade: " + i + "\n" +
					"Data de entrega: " + atividade.dataEntrega + "\n" + 
					"Descrição: " + atividade.descricao + "\n" +
					"----------------------"
					);
			i = i + 1;
		}
	}
}
