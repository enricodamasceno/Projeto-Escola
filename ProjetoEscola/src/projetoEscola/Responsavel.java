package projetoEscola;

import java.util.List;

public class Responsavel extends Cliente {

    public List<Aluno> alunos;
	
	 public Responsavel(String login, String nome, Integer idade, String senha, List<Aluno> alunos ) {
		   // Chama o construtor da superclasse Cliente para inicializar atributos herdados
		    super(login, nome, idade, senha);
		    this.alunos = alunos;
		}

	 public List<Aluno> getAlunos() {
		return this.alunos;
	 }
  private Aluno matricularAluno() {
  return null;
  }

}