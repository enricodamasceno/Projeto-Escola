package projetoEscola;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Escola {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		// INSTANCIANDO COORDENADORES
		List<Funcionario> coordenadores = new ArrayList<>();
		coordenadores.add(new Coordenador("cito123", "Vitor Citó", "cito321"));
		coordenadores.add(new Coordenador("henrique", "Pedro Henrique", "FernandaDevolveMeuFilho"));

		// INSTANCIANDO PROFESSORES DEFAULT
		List<Funcionario> professores = new ArrayList<>();
		professores.add(new Professor("gilvan123", "Gilvan", "senha123"));
		professores.add(new Professor("fidovento", "Windson", "senha123"));

		// INSTANCIANDO RESPONSÁVEIS
		List<Responsavel> responsaveis = new ArrayList<>();

		List<Aluno> alunosJeferson = new ArrayList<>();
		
		responsaveis.add(new Responsavel("jeferson", "Jeferson", 40, "jeferson123", alunosJeferson));

		List<Aluno> alunosMarcos = new ArrayList<>();
		
		responsaveis.add(new Responsavel("marcos", "Marcos", 45, "Marcos123", alunosMarcos));
		
		// INSTANCIANDO ALUNOS DEFAULT
			List<Aluno> alunos = new ArrayList<>();
			alunos.add(new Aluno("betohot", "Beto", 14, "amoela", responsaveis.get(0)));
			
			alunos.add(new Aluno("adriano12", "Adriano", 15, "amoela2", responsaveis.get(1)));
			
			
		/*INCLUINDO OS ALUNOS DENTRO DA LISTA DOS RESPONSÁVEIS ( ESTA ASSOCIAÇÃO DEVE SER FEITA APÓS A INSTANCIAÇÃO DE ALUNOS,
		  PARA QUE NÃO OCORRAM ERROS.  */
			alunosJeferson.add(alunos.get(0));
			alunosMarcos.add(alunos.get(1));
		

		// INTRODUÇÃO AO SISTEMA
		System.out.println("Bem-vindo ao Sistema da Escola!");
		System.out.println("Escolha o seu tipo de usuário:");
		System.out.println("1. Aluno");
		System.out.println("2. Responsável");
		System.out.println("3. Professor");
		System.out.println("4. Coordenador");

		int escolha = scanner.nextInt();
		scanner.nextLine(); // Consumir a quebra de linha

		switch (escolha) {

///////////////////////////////////////////// LÓGICA PARA ALUNOS ////////////////////////////////////////////////
		case 1:
			System.out.println("Você selecionou Aluno.");

			// Pergunta e obtém o login do aluno
			System.out.print("Digite o login do aluno: ");
			String loginAluno = scanner.nextLine();

			// Pergunta e obtém a senha do aluno
			System.out.print("Digite a senha do aluno: ");
			String senhaAluno = scanner.nextLine();

			// Verifique se o login e senha correspondem a algum objeto Aluno
			boolean autenticado = false;
			for (Aluno aluno : alunos) {
				if (aluno.getLogin().equals(loginAluno) && aluno.getSenha().equals(senhaAluno)) {
					autenticado = true;
					// RECUPERANDO O RESPONSÁVEL DESTE ALUNO
					Responsavel responsavel = aluno.getResponsavel();
					System.out.println("Login e senha corretos. Bem-vindo, " + aluno.getNome() + "!");
					System.out.println("O Responsável associado a este aluno é: " + responsavel.getNome());
					
				}
			}

			if (!autenticado) {
				System.out.println("Login ou senha incorretos. Encerrando o programa.");
			}

			break;

//////////////////////////////////////// LÓGICA PARA RESPONSÁVEIS ////////////////////////////////////////////////
		case 2:
			System.out.println("Você selecionou Responsável.");

			System.out.print("Digite seu login: ");
			String loginResponsavel = scanner.nextLine();

			System.out.print("Digite sua senha: ");
			String senhaResponsavel = scanner.nextLine();

			boolean autenticadoResponsavel = false;
			for (Responsavel responsavel : responsaveis) {
				if (responsavel.getLogin().equals(loginResponsavel)
						&& responsavel.getSenha().equals(senhaResponsavel)) {
					autenticadoResponsavel = true;
					System.out.println("Login e senha corretos. Bem-vindo, " + responsavel.getNome() + "!");

					// LISTA PARA RECUPERAR OS ALUNOS ASSOCIADOS A ESSE RESPONSÁVEL USANDO O MÉTODO
					// GETALUNOS()
					List<Aluno> alunosAssociados = responsavel.getAlunos();

					////////// LÓGICA PARA PERCORRER A LISTA DE ALUNOS ASSOCIADAS A ESSE RESPONSÁVEL
					if (alunosAssociados.isEmpty()) {
						System.out.println("Não há alunos associados a este responsável.");
					} else {
						System.out.println("Alunos associados a " + responsavel.getNome() + ":");
						for (Aluno aluno : alunosAssociados) {
							System.out.println("Nome do(s) aluno(s): " + aluno.getNome());
						}
					}

				}
			}

			if (!autenticadoResponsavel) {
				System.out.println("Login ou senha incorretos para o responsavel. Encerrando o programa.");
			}

			break;
///////////////////////////////////////// LÓGICA PARA PROFESSORES //////////////////////////////////////////////////////////
		case 3:
			System.out.println("Você selecionou Professor.");

			System.out.print("Digite seu login: ");
			String loginProfessor = scanner.nextLine();

			System.out.print("Digite sua senha:");
			String senhaProfessor = scanner.nextLine();

			boolean autenticadoProfessor = false;
			for (Funcionario professor : professores) {
				if (professor.getLogin().equals(loginProfessor) && professor.getSenha().equals(senhaProfessor)) {
					autenticadoProfessor = true;
					System.out.println("Login e senha corretos. Bem-vindo, " + professor.getNome() + "!");
					// Implemente a lógica adicional para o coordenador aqui
				}
			}

			if (!autenticadoProfessor) {
				System.out.println("Login ou senha incorretos para o professor. Encerrando o programa.");
			}
			break;

//////////////////////// LÓGICA PARA COORDENADORESS VULGO MANDA EM TUDO ////////////////////////////////////////////////
		case 4:

			System.out.println("Você selecionou Coordenador.");

			System.out.print("Digite seu login: ");
			String loginCoordenador = scanner.nextLine();

			System.out.print("Digite sua senha: ");
			String senhaCoordenador = scanner.nextLine();

			boolean autenticadoCoordenador = false;
			for (Funcionario coordenador : coordenadores) {
				if (coordenador.getLogin().equals(loginCoordenador)
						&& coordenador.getSenha().equals(senhaCoordenador)) {
					autenticadoCoordenador = true;
					System.out.println("Login e senha corretos. Bem-vindo, " + coordenador.getNome() + "!");
					// Implementar a lógica adicional para o coordenador aqui
				}
			}

			if (!autenticadoCoordenador) {
				System.out.println("Login ou senha incorretos para o coordenador. Encerrando o programa.");
			}

			break;
		default:
			System.out.println("Opção inválida. Encerrando o programa.");
			break;
		}

		scanner.close();
	}

}
