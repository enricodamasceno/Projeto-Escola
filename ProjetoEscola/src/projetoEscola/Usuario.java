package projetoEscola;

public abstract class Usuario {

	  private String login;
	  private String senha;
	  private String nome;
	  private Integer idade;

	  public Usuario(String login, String senha, String nome, Integer idade) {
		  this.login = login;
		  this.senha = senha;
		  this.nome = nome;
		  this.idade = idade;
	  }
	  
	  // Método para verificar a senha.
	  public boolean verificarUsuario(String loginDigitado, String senhaDigitada) {
		  return this.senha.equals(senhaDigitada);
	  }
	  
	  // Método para alterar a senha.
	  protected void alterarSenha(String novaSenha) {
		  this.senha = novaSenha;
	  }
	  
	  // Método abstrato para retornar o tipo do usuário no login.
	  public abstract String getTipoUsuario();
	  
	  public String getLogin() {
		  return login;
	  }
	  
	  public String getNome() {
		  return nome;
	  }
	}