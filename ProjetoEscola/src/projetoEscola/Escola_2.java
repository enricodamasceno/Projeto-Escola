package projetoEscola;

import java.util.Scanner;
import java.util.List;
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
			if (usuarioAutenticado.getTipoUsuario() == "Aluno") {
				System.out.println("Bem vindo, Aluno(a) " + usuarioAutenticado.getNome());
				// Implementação da lógica do aluno.
			}
			
			if (usuarioAutenticado.getTipoUsuario() == "Responsável") {
				System.out.println("Bem vindo, Responsável " + usuarioAutenticado.getNome());
				rodando_usuario = 1;
				usuarioAutenticado.acoesUsuario();
			}
			
			if (usuarioAutenticado.getTipoUsuario() == "Professor") {
				System.out.println("Bem vindo, Professor(a) " + usuarioAutenticado.getNome());
				// Implementação da lógica do professor.
			}
			
			if (usuarioAutenticado.getTipoUsuario() == "Coordenador") {
				System.out.println("Bem vindo, Coordenador(a) " + usuarioAutenticado.getNome());
				rodando_usuario = 1;
				usuarioAutenticado.acoesUsuario();
			}
			
		} else {
			System.out.println("Usuário não encontrado.");
		}
		}
		scanner.close();
	}

	// Por opção da equipe não utilizaremos banco de dados, então esse método instancia alguns usuários para primeiro
	// uso no código, no produto final entregue ao cliente que contrata a plataforma esse método não existiria.
	public static void cadastroForcado() {

		// Criando o responsável Jeferson
		new Responsavel("jeferson", "jefão123", "Jeferson Arley", 45, new ArrayList<>());

		// Criando o aluno Roberto, cujo responsável é Jeferson
		new Aluno("betohot", "amoeba123", "Roberto Arley", 15, Responsavel.responsaveis.get(0));

		// Colocando o aluno Roberto dentro da lista de alunos do responsável Jeferson:
		Responsavel.responsaveis.get(0).alunos.add(Aluno.alunos.get(0));

		// Criando o coordenador 
		new Coordenador("ZeGil", "JG123", "José Gilvan", 43);
	}

}

