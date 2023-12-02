package projetoEscola;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Escola_2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Usuario usuarioAutenticado = null;

		//////////////// INSTANCIAMENTO DE USUÁRIOS ///////////////
		
		// Criando o responsável Jeferson
		List<Aluno> alunosJeferson = new ArrayList<>();
		new Responsavel("jeferson", "jefão123", "Jeferson Arley", 45, alunosJeferson);

		// Criando o aluno Roberto, cujo responsável é Jeferson
		new Aluno("betohot", "amoeba123", "Roberto Arley", 15, Responsavel.responsaveis.get(0));

		// Colocando o aluno Roberto dentro da lista de alunos do responsável Jeferson:
		alunosJeferson.add(Aluno.alunos.get(0));

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
				usuarioAutenticado.acoesUsuario();
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
		scanner.close();
	}

}

