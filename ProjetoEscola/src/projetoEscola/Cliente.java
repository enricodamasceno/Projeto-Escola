package projetoEscola;

public abstract class Cliente {

	  private String login;

	  private String nome;

	  private Integer idade;

	  private String senha;

	 public Cliente(String login, String nome, Integer idade, String senha) {
	  	this.login = login;
	  	this.nome = nome;
	  	this.idade = idade;
	  	this.senha = senha;
	  		
	  	}
	 
	 public String getLogin() {
	        return login;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public Integer getIdade() {
	        return idade;
	    }

	    public String getSenha() {
	        return senha;
	    }
	    
	  private void entrar() {
	  }

	  private String alterarSenha() {
	  return null;
	  }

	  private String gerarRelatorio() {
	  return null;
	  }

	}