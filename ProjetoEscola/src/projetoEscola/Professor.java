package projetoEscola;

import java.util.List;

public class Professor extends Usuario {

    //public List<Atividade> atividade;
    //public List<Turma> turma;
    
    public Professor(String login, String senha, String nome, Integer idade) {
    	   // Chama o construtor da superclasse Usuário para inicializar atributos herdados
    	    super(login, senha, nome, idade);
    	}

  private Nota lancarNota() {
  return null;
  }

  public Nota alterarNota(int nota) {
  return null;
  }

  private Atividade cadastrarAtividade() {
  return null;
  }

  private Integer cadastrarFrequencia() {
  return null;
  }

  private Atividade alterarAtividade( ) {
  return null;
  }

  public void excluirAtividade() {
  }
  
  @Override
	public String getTipoUsuario() {
		return "Professor";
	}

}