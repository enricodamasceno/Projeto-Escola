package projetoEscola;

import java.util.List;
import java.util.ArrayList;

public class Professor extends Usuario {

  protected static List<Professr> professres = new ArrayList<>();
  //public List<Atividade> atividade;
  //public List<Turma> turma;
  
  public Professor(String login, String senha, String nome, Integer idade) {
  	   // Chama o construtor da superclasse Usuário para inicializar atributos herdados
  	    super(login, senha, nome, idade);
        Professor.professores.add(this);
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

  @Override
	public void acoesUsuario() {
		
	}

}