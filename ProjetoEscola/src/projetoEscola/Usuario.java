package projetoEscola;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Usuario {

	Scanner scanner = new Scanner(System.in);
	private String login;
	private String senha;
	private String nome;
	private Integer idade;
	protected static List<Usuario> usuarios = new ArrayList<>();

	public Usuario(String login, String senha, String nome, Integer idade) {
		this.login = login;
		for (Usuario usuario: Usuario.usuarios) {
			if (login.equals(usuario.getLogin())) {
				this.login = this.validaNomeLogin();
			}
		}
		this.senha = senha;
		this.nome = nome;
		this.idade = idade;
		usuarios.add(this);
	}

	protected String validaNomeLogin() {
		System.out.println("Login já utilizado por outro usuário, escreva outro login: ");
		String novo_login = scanner.nextLine();
		for (Usuario usuario: Usuario.usuarios) {
			if (novo_login.equals(usuario.getLogin())) {
				return this.validaNomeLogin();
			}
		}
		return novo_login;
	}

	// Método para verificar a senha.
	public boolean verificarUsuario(String loginDigitado, String senhaDigitada) {
		return this.senha.equals(senhaDigitada) && this.login.equals(loginDigitado);
	}

	// Método para alterar a senha.
	protected void alterarSenha(String novaSenha) {
		this.senha = novaSenha;
	}

	// Método abstrato para retornar o tipo do usuário no login.
	public abstract String getTipoUsuario();

	// Método abstrato para as funcionalidades de cada usuário após o login.
	public abstract void acoesUsuario();

	// Método abstrato para o logout de cada usuário após o login.
	public void logout() {
	}

	public String getLogin() {
		return login;
	}

	public String getNome() {
		return nome;
	}
}