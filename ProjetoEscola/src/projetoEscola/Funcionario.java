package projetoEscola;

public abstract class Funcionario {

	  private String login;

	  private String nome;

	  private String senha;

	  public Funcionario(String login, String nome, String senha) {
		  this.login = login;
		  this.nome = nome;
		  this.senha = senha;
	  }
	  
	  public String getLogin() {
	        return login;
	    }

	   public String getNome() {
	       return nome;
	    }


	    public String getSenha() {
	        return senha;
	    }
	    
	  private void entrar() {
	  }

	  public String alterarSenha() {
	  return null;
	  }

	  public String gerarRelatorio() {
	  return null;
	  }

	}