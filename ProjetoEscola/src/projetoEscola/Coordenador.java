package projetoEscola;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Coordenador extends Usuario {

	Scanner scanner = new Scanner(System.in);
	protected static List<Coordenador> coordenadores = new ArrayList<>();

	public Coordenador(String login, String senha, String nome, Integer idade) {
		super(login, senha, nome, idade);
		Coordenador.coordenadores.add(this);
	}

	// Método utilizado para cadastrar novos responsáveis
	private void cadastrarResponsavel() {
		System.out.println("OPÇÃO ESCOLHIDA: CADASTRAR RESPONSÁVEL");
		System.out.println("Digite o nome do responsável: ");
		String nome_responsavel = scanner.nextLine();
		System.out.println("Digite a idade do responsável: ");
		String idade_responsavel_string = scanner.nextLine();
		int idade_responsavel = Integer.parseInt(idade_responsavel_string);
		System.out.println("Digite um login para o responsável: ");
		String login_responsavel = scanner.nextLine();
		System.out.println("Digite a senha do responsável: ");
		String senha_responsavel = scanner.nextLine();

		new Responsavel(login_responsavel, senha_responsavel, nome_responsavel, idade_responsavel, new ArrayList<Aluno>());

		System.out.println(
				"Responsável cadastrado com sucesso.\n" +
						"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				);
	}

	// Método utilizado para cadastrar novos professores
	private void cadastrarProfessor() {
		System.out.println("OPÇÃO ESCOLHIDA: CADASTRAR PROFESSOR");
		System.out.println("Digite o nome do professor: ");
		String nome_professor = scanner.nextLine();
		System.out.println("Digite a idade do professor: ");
		String idade_professor_string = scanner.nextLine();
		int idade_professor = Integer.parseInt(idade_professor_string);
		System.out.println("Digite um login para o professor: ");
		String login_professor = scanner.nextLine();
		System.out.println("Digite a senha do professor: ");
		String senha_professor = scanner.nextLine();

		new Professor(login_professor, senha_professor, nome_professor, idade_professor);

		System.out.println(
				"Professor cadastrado com sucesso.\n" +
						"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				);
	}

	// Método 
	private void cadastrarTurma() {
		System.out.println("Informe o nome da nova turma: ");
		String nomeTurma = scanner.nextLine();

		Turma turma_criada = new Turma(nomeTurma);

		System.out.println(
				"Você criou a turma: " + turma_criada.getNome() + ". Se quiser adicionar alunos, utilize a função Alterar Turma." + "\n"+
						"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				);
	}

	// Método utilizado para alterar a turma
	public void alterarTurma() {

		// Verifica se há turmas cadastradas
		if (Turma.turmas.isEmpty()) {
			System.out.println("Não há turmas cadastradas. \n"
					+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			return;
		}

		System.out.println("Escolha a turma que deseja alterar: ");

		Turma.exibirTurmas();
		int numeroTurma = Integer.parseInt(scanner.nextLine());
		// Verifica se a turma escolhida é válida
		if (numeroTurma > Turma.turmas.size()) {
			System.out.println(
					"Número de turma inválido.\n" +
							"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
					);
			return;
		}

		Turma turmaEscolhida = Turma.turmas.get(numeroTurma - 1);
		System.out.println(
				"Turma " + turmaEscolhida.getNome() + " escolhida.\n" + 
						"Dentre os alunos abaixo selecione aqueles que deseja enturmar\n" +
						"para tal utilize o índice dos alunos separados por vírgula segundo\n" +
						"o molde: \"3, 4, 5, 8, 10, 14\" [sem aspas]"
				);

		// expõe os alunos disponíveis para enturmar
		Integer i = 1;
		for(Aluno aluno: Aluno.alunos) {
			System.out.println("[" + i + "] " + aluno.getNome());
			i = i + 1;
		}

		// enturma os alunos
		String alunos_selecionados = scanner.nextLine();
		String[] codigo_alunos = alunos_selecionados.replaceAll("\\s+", "").split(",");
		Integer alunos_enturmados = 0;
		for (String codigo: codigo_alunos) {
			Integer codigo_int = Integer.parseInt(codigo);
			turmaEscolhida.getAlunos().add(Aluno.alunos.get(codigo_int - 1));
			alunos_enturmados = alunos_enturmados + 1;
		}

		System.out.println(
				"Turma " + turmaEscolhida.getNome() + " modificada com sucesso.\n" + 
						alunos_enturmados + " alunos enturmados.\n" +
						"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				);
	}

	@Override
	public String getTipoUsuario() {
		return "Coordenador";
	}

	@Override
	public void relatorio() {
		
	}

	@Override
	public void acoesUsuario() {
		while (Escola_2.rodando_usuario == 1) {
			System.out.println(
					"Dentre as opções abaixo escolha qual ação deseja realizar: \n" + 
							"[1] CADASTRAR PROFESSOR\n" + 
							"[2] CADASTRAR TURMA\n" +
							"[3] CADASTRAR RESPONSÁVEL\n" +
							"[4] ALTERAR TURMA\n" +
							"[5] LOGOUT"
					);
			String acao = scanner.nextLine();

			switch (acao) {
			case "1":
				this.cadastrarProfessor();
				break;

			case "2":
				this.cadastrarTurma();
				break;

			case "3":
				this.cadastrarResponsavel();
				break;

			case "4":
				this.alterarTurma();
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