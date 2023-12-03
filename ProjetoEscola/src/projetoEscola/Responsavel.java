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
		this.acoesUsuario();
	}

	// Lista alunos do usuário
	private void listarAlunos() {
		Integer i = 1;
		for (Aluno aluno: this.alunos) {
			System.out.println(i + " - " + aluno.getNome());
			i = i + 1;
		}
		this.acoesUsuario();
	}
	
	@Override
	public String getTipoUsuario() {
		return "Responsável";
	}

	// Sobrescreve a função acoesUsuario() dando funcionalidade ao Responsável
	@Override
	public void acoesUsuario() {
		System.out.println(
			"Dentre as opções abaixo escolha qual ação deseja realizar: \n" + 
			"[1] MATRICULAR ALUNO\n" + 
			"[2] LISTAR ALUNOS"
		);
		String acao = scanner.nextLine();
		
		switch (acao) {
			case "1":
				this.matricularAluno();
			break;

			case "2":
				this.listarAlunos();
			break;
			
			default:
				System.out.println("OPÇÃO INVÁLIDA");	
		}
	}
	
}