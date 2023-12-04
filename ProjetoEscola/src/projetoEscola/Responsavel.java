package projetoEscola;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Responsavel extends Usuario {

	Scanner scanner = new Scanner(System.in);

	public List<Aluno> alunos;
	protected static List<Responsavel> responsaveis = new ArrayList<>();

	public Responsavel(String login, String senha, String nome, Integer idade, List<Aluno> alunos) {
		// Chama o construtor da superclasse Usuário para inicializar atributos herdados
		super(login, senha, nome, idade);
		this.alunos = alunos;
		Responsavel.responsaveis.add(this);
	}

	public List<Aluno> getAlunos() {
		return this.alunos;
	}

	// Pede ao usuário informações necessárias para o instanciamento de um novo aluno dependente do responsável usuário
	private void matricularAluno() {
		System.out.println("OPÇÃO ESCOLHIDA: MATRICULAR ALUNO");
		System.out.println("Digite o nome do aluno: ");
		String nome_aluno = scanner.nextLine();
		System.out.println("Digite a idade do aluno: ");
		String idade_aluno_string = scanner.nextLine();
		int idade_aluno = Integer.parseInt(idade_aluno_string);
		System.out.println("Digite um login para o aluno: ");
		String login_aluno = scanner.nextLine();
		System.out.println("Digite a senha do aluno: ");
		String senha_aluno = scanner.nextLine();

		this.alunos.add( new Aluno(login_aluno, senha_aluno, nome_aluno, idade_aluno, this) );

		System.out.println(
				"Aluno matriculado com sucesso.\n" +
						"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				);
	}

	// Lista alunos do usuário
	private void listarAlunos() {
		Integer i = 1;
		for (Aluno aluno: this.alunos) {
			System.out.println(i + " - " + aluno.getNome());
			i = i + 1;
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	@Override
	public String getTipoUsuario() {
		return "Responsável";
	}

	@Override
	public void relatorio() {
		System.out.println("Escolha o aluno que deseja ver o relatório: ");
		this.listarAlunos();
		Integer numero_aluno = Integer.parseInt(scanner.nextLine());
		if (numero_aluno > this.alunos.size()) {
			System.out.println(
				"Número de aluno inválido.\n" +
				"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
			);
			return;
		}
		Aluno aluno_escolhido = this.alunos.get(numero_aluno - 1);

		aluno_escolhido.relatorio();
	}

	// Sobrescreve a função acoesUsuario() dando funcionalidade ao Responsável
	@Override
	public void acoesUsuario() {
		while (Escola_2.rodando_usuario == 1) {
			System.out.println(
					"Dentre as opções abaixo escolha qual ação deseja realizar: \n" + 
							"[1] MATRICULAR ALUNO\n" + 
							"[2] LISTAR ALUNOS\n" +
							"[3] GERAR RELATÓRIO\n" +
							"[4] ALTERAR SENHA\n" +
							"[5] LOGOUT"
					);
			String acao = scanner.nextLine();

			switch (acao) {
			case "1":
				this.matricularAluno();
				break;

			case "2":
				this.listarAlunos();
				break;

			case "3":
				this.relatorio();
			break;

			case "4":
				this.alterarSenha();
			break;

			case "5":
				System.out.println("VOCÊ ESTÁ SAINDO DO AMBIENTE");
				Escola_2.rodando_usuario = 0;
			break;

			default:
				System.out.println("OPÇÃO INVÁLIDA");	
			}
		}
	}

}