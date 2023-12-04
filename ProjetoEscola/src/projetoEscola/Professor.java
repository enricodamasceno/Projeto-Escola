package projetoEscola;

import java.util.List;
import java.util.ArrayList;

public class Professor extends Usuario {

	private static List<Professor> professores = new ArrayList<>();

	public Professor(String login, String senha, String nome, Integer idade) {
		// Chama o construtor da superclasse Usuário para inicializar atributos herdados
		super(login, senha, nome, idade);
		Professor.professores.add(this);
	}

	private Atividade cadastrarAtividade() {
		System.out.println("OPÇÃO ESCOLHIDA: CADASTRAR ATIVIDADE");
		System.out.println("Informe a data de entrega da atividade: ");
		String data = scanner.nextLine();
		System.out.println("Informe a descrição da atividade: ");
		String descricao = scanner.nextLine();

		Atividade.atividades.add(new Atividade(data, descricao));
		System.out.println(
				"Atividade cadastrada com sucesso.\n" +
						"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				);
		return null;
	}

	private void alterarAtividade() {
		System.out.println("OPÇÃO ESCOLHIDA: ALTERAR ATIVIDADE");

		// Verifica se há atividades cadastradas
		if (Atividade.atividades.isEmpty()) {
			System.out.println("Não há atividades cadastradas. \n"
					+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			return;
		}

		System.out.println("Informe a atividade que você deseja alterar:");
		Atividade.exibirAtividades();
		System.out.println("Escolha a atividade que deseja alterar: ");
		int numeroAtividade = Integer.parseInt(scanner.nextLine());
		// Verifica se a atividade escolhida é válida
		if (numeroAtividade > Atividade.atividades.size()) {
			System.out.println(
					"Número de atividade inválido.\n" +
							"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
					);
			return;
		}
		Atividade atividadeEscolhida = Atividade.atividades.get(numeroAtividade - 1);
		System.out.println("Atividade: " + atividadeEscolhida.descricao + "\n");

		// Recebe os novos parâmetros da atividade
		System.out.println("Informe a nova data de entrega da atividade: ");
		String novaData = scanner.nextLine();
		System.out.println("Informe a nova descrição da atividade: ");
		String novaDescricao = scanner.nextLine();
		atividadeEscolhida.dataEntrega = novaData;
		atividadeEscolhida.descricao = novaDescricao;
		System.out.println("Atividade modificada com sucesso");
	}

	public void excluirAtividade() {
		System.out.println("OPÇÃO ESCOLHIDA: EXCLUIR ATIVIDADE");

		// Verifica se há atividades cadastradas
		if (Atividade.atividades.isEmpty()) {
			System.out.println("Não há atividades cadastradas. \n"
					+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			return;
		}

		System.out.println("Informe a atividade que você deseja excluir:");
		Atividade.exibirAtividades();
		System.out.println("Escolha a atividade que deseja excluir: ");
		int numeroAtividade = Integer.parseInt(scanner.nextLine());
		// Verifica se a atividade escolhida é válida
		if (numeroAtividade > Atividade.atividades.size()) {
			System.out.println(
					"Número de atividade inválido.\n" +
							"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
					);
			return;
		}
		// Confere a atividade para o usuário
		Atividade atividadeEscolhida = Atividade.atividades.get(numeroAtividade - 1);
		System.out.println("Atividade: " + atividadeEscolhida.descricao);
		System.out.println("Data de entrega: " + atividadeEscolhida.dataEntrega + "\n");

		// Confirma a exclusão
		System.out.println("DESEJA EXCLUIR A ATIVIDADE? \n"
				+ "[1] Sim. \n"
				+ "[2] Não. \n"
				);
		String acao = scanner.nextLine();
		switch(acao) {
		case "1":
			Atividade.atividades.remove(atividadeEscolhida);
			System.out.println("ATIVIDADE EXCLUÍDA.");
			break;
		case "2":
			System.out.println("ATIVIDADE NÃO EXCLUÍDA.");
			break;
		}
	}

	private Nota lancarNota() {
		return null;
	}

	public Nota alterarNota() {
		return null;
	}

	@Override
	public String getTipoUsuario() {
		return "Professor";
	}

	// Sobrescreve a função acoesUsuario() dando funcionalidade ao Professor
	@Override
	public void acoesUsuario() {
		while (Escola_2.rodando_usuario == 1) {
			System.out.println(
					"Dentre as opções abaixo escolha qual ação deseja realizar: \n" + 
							"[1] CADASTRAR ATIVIDADE\n" + 
							"[2] ALTERAR ATIVIDADE\n" +
							"[3] EXCLUIR ATIVIDADE\n" +
							"[4] LANÇAR NOTA\n" +
							"[5] ALTERAR NOTA\n" +
							"[6] LOGOUT\n"
					);
			String acao = scanner.nextLine();

			switch (acao) {
			case "1":
				this.cadastrarAtividade();
				break;

			case "2":
				this.alterarAtividade();
				break;

			case "3":
				this.excluirAtividade();
				break;

			case "4":
				this.lancarNota();
				break;

			case "5":
				this.alterarNota();
				break;

			case "6":
				System.out.println("VOCÊ ESTÁ SAINDO DO AMBIENTE");
				Escola_2.rodando_usuario = 0;
				break;

			default:
				System.out.println("OPÇÃO INVÁLIDA");	
			}
		}
	}
}