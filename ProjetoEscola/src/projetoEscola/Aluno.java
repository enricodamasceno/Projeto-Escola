package projetoEscola;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Aluno extends Usuario {

	public Responsavel responsavel;
	protected static List<Aluno> alunos = new ArrayList<>();
	private List<Atividade> atividade_por_fazer;
	public Map<Atividade, String> atividades_realizadas;
	public Map<Atividade, Nota> atividades_corrigidas = new HashMap<Atividade, Nota>();;

	public Aluno(String login, String senha, String nome, Integer idade, Responsavel responsavel) {

		// Chama o construtor da superclasse Cliente para inicializar atributos herdados
		super(login, senha, nome, idade);
		this.responsavel = responsavel;
		this.atividade_por_fazer = new ArrayList<>();
		this.atividades_realizadas = new HashMap<Atividade, String>();
		Aluno.alunos.add(this);
	}

	public void recebeAtividade(Atividade atividade) {
		this.atividade_por_fazer.add(atividade);
	}

	private void enviarAtividade() {
		// Verifica se há atividades cadastradas
		if (this.atividade_por_fazer.isEmpty()) {
			System.out.println(
				"Não há atividades por fazer. \n" + 
				"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
			);
			return;
		}

		System.out.println("Informe a atividade que você deseja realizar:");
		this.exibirAtividadesPorFazer();
		System.out.println("Escolha a atividade que deseja realizar: ");
		int numeroAtividade = Integer.parseInt(scanner.nextLine());
		// Verifica se a atividade escolhida é válida
		if (numeroAtividade > Atividade.atividades.size()) {
			System.out.println(
				"Número de atividade inválido.\n" +
				"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
			);
			return;
		}
		Atividade atividadeEscolhida = this.atividade_por_fazer.get(numeroAtividade - 1);
		System.out.println(atividadeEscolhida.descricao);
		String resposta = scanner.nextLine();

		this.atividades_realizadas.put(atividadeEscolhida, resposta);
		atividade_por_fazer.remove(atividadeEscolhida);

		atividadeEscolhida.turma.recebeResposta(this, atividadeEscolhida);

		System.out.println("Atividade enviada com sucesso");

	}

	private void exibirAtividadesPorFazer() {
		Integer i = 1;
		for (Atividade atividade : this.atividade_por_fazer) {
			System.out.println(
				"Atividade: " + i + "\n" +
				"Data de entrega: " + atividade.dataEntrega + "\n" + 
				"Descrição: " + atividade.descricao + "\n" +
				"----------------------"
			);
			i = i + 1;
		}
	}

	public Responsavel getResponsavel(){
		return this.responsavel;
	}
	
	@Override
	public String getTipoUsuario() {
		return "Aluno";
	}

	@Override
	public void relatorio() {

	}

	@Override
	public void acoesUsuario() {
		while (Escola_2.rodando_usuario == 1) {
			System.out.println(
				"Dentre as opções abaixo escolha qual ação deseja realizar: \n" + 
				"[1] REALIZAR ATIVIDADE\n" + 
				"[2] GERAR RELATÓRIO\n" +
				"[3] ALTERAR SENHA\n" +
				"[4] LOGOUT\n"
			);
			String acao = scanner.nextLine();

			switch (acao) {
			case "1":
				this.enviarAtividade();
			break;

			case "2":
				this.relatorio();
			break;

			case "3":
				this.alterarSenha();
			break;

			case "4":
				System.out.println("VOCÊ ESTÁ SAINDO DO AMBIENTE");
				Escola_2.rodando_usuario = 0;
			break;

			default:
				System.out.println("OPÇÃO INVÁLIDA");	
			}
		}
	}
}