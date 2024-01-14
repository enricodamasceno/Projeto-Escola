package projetoEscola;

import java.util.Scanner;
import java.util.ArrayList;

public class Escola_2 {

	public static Integer rodando = 1;
	public static Integer rodando_usuario;

	public static void main(String[] args) {

		Escola_2.cadastroForcado();

		Scanner scanner = new Scanner(System.in);
		while (rodando == 1) {
			Usuario usuarioAutenticado = null;

			// INTRODUÇÃO AO SISTEMA
			System.out.println("Bem-vindo ao Sistema da Escola!");

			System.out.println("Digite o login do usuário: ");
			String login = scanner.nextLine();

			System.out.print("Digite a senha do usuário: ");
			String senha = scanner.nextLine();

			// VERIFICAÇÃO DO USUÁRIO
			for (Usuario usuario: Usuario.usuarios) {

				if (usuario.verificarUsuario(login, senha)) {
					usuarioAutenticado = usuario;
				}
			}

			// DIVISÃO DAS LÓGICAS DE ACORDO COM A SUBCLASSE - pode ser isolado em um método, futuramente
			if (usuarioAutenticado != null) {
				rodando_usuario = 1;
				System.out.println("Bem vindo, " + usuarioAutenticado.getNome() + "!");
				usuarioAutenticado.acoesUsuario();
			} else {
				System.out.println("Usuário não encontrado.");
			}
		}
		scanner.close();
	}

	// Por opção da equipe não utilizaremos banco de dados, então esse método instancia alguns usuários para primeiro
	// uso no código. No produto final entregue ao cliente, esse método não existiria.
	public static void cadastroForcado() {

		// Criando o responsável Adriano
		new Responsavel("Adriano", "adriano000", "Adriano Bezerra", 45, new ArrayList<>());

		// Criando alunos, cujo responsável é Jeferson
		new Aluno("roberto", "roberto123", "Roberto Arley", 15, Responsavel.responsaveis.get(0));
		new Aluno("citohebe", "cito123", "Hebe Citó", 61, Responsavel.responsaveis.get(0));
		new Aluno("citocaio", "cito123", "Caio Citó", 26, Responsavel.responsaveis.get(0));

		// Colocando os alunos dentro da lista de alunos do responsável Jeferson:
		Responsavel.responsaveis.get(0).alunos.add(Aluno.alunos.get(0));
		Responsavel.responsaveis.get(0).alunos.add(Aluno.alunos.get(1));
		Responsavel.responsaveis.get(0).alunos.add(Aluno.alunos.get(2));

		// Criando o coordenador 
		new Coordenador("gilvan", "josegilvan", "José Gilvan", 43);

		// Criando o professor
		new Professor("citovictor", "cito@2002", "Víctor Citó", 22);

		// Criando a turma
		new Turma("EBSM2101");
	}

}