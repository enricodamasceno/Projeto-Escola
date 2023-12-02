package projetoEscola;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Escola_2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Usuario usuarioAutenticado = null;

		//////////////// INSTANCIAMENTO DE USUÁRIOS ///////////////
		
		// CRIANDO LISTA DE USUARIOS
		List<Usuario> usuarios = new ArrayList<>();

		// INSTANCIANDO COORDENADORES
		List<Coordenador> coordenadores = new ArrayList<>();

		// INSTANCIANDO PROFESSORES 
		List<Professor> professores = new ArrayList<>();

		// INSTANCIANDO RESPONSÁVEIS
		List<Responsavel> responsaveis = new ArrayList<>();

		// Criando o responsável Jeferson
		List<Aluno> alunosJeferson = new ArrayList<>();
		responsaveis.add(new Responsavel("jeferson", "jefão123", "Jeferson Arley", 45, alunosJeferson));

		// INSTANCIANDO ALUNOS 
		List<Aluno> alunos = new ArrayList<>();

		// Criando o aluno Roberto, cujo responsável é Jeferson
		alunos.add(new Aluno("betohot", "amoeba123", "Roberto Arley", 15, responsaveis.get(0)));

		// Colocando o aluno Roberto dentro da lista de alunos do responsável Jeferson:
		alunosJeferson.add(alunos.get(0));

		// Colocando Jeferson e Roberto na lista de usuários:
		usuarios.add(alunos.get(0));
		usuarios.add(responsaveis.get(0));

		// INTRODUÇÃO AO SISTEMA
		System.out.println("Bem-vindo ao Sistema da Escola!");

		System.out.println("Digite o login do usuário: ");
		String login = scanner.nextLine();

		System.out.print("Digite a senha do usuário: ");
		String senha = scanner.nextLine();

		// VERIFICAÇÃO DO USUÁRIO
		for (Usuario usuario: usuarios) {

			if (usuario.verificarUsuario(login, senha)) {
				usuarioAutenticado = usuario;
			}
		}

		// DIVISÃO DAS LÓGICAS DE ACORDO COM A SUBCLASSE - pode ser isolado em um método, futuramente
		if (usuarioAutenticado != null) {
			if (usuarioAutenticado.getTipoUsuario() == "Aluno") {
				System.out.println("Bem vindo, Aluno(a) " + usuarioAutenticado.getNome());
				// Implementação da lógica do aluno.
			}
			
			if (usuarioAutenticado.getTipoUsuario() == "Responsável") {
				System.out.println("Bem vindo, Responsável " + usuarioAutenticado.getNome());
				// Implementação da lógica do responsável.
			}
			
			if (usuarioAutenticado.getTipoUsuario() == "Professor") {
				System.out.println("Bem vindo, Professor(a) " + usuarioAutenticado.getNome());
				// Implementação da lógica do professor.
			}
			
			if (usuarioAutenticado.getTipoUsuario() == "Coordenador") {
				System.out.println("Bem vindo, Coordenador(a) " + usuarioAutenticado.getNome());
				// Implementação da lógica do coordenador.
			}
			
		} else {
			System.out.println("Usuário não encontrado.");
		}









		//////////////////////////////////////// LÓGICA PARA RESPONSÁVEIS ////////////////////////////////////////////////
		/* case 2:
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
		 */
		scanner.close();
	}

}

