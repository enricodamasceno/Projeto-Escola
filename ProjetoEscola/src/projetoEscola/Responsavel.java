package projetoEscola;

import java.util.List;

public class Responsavel extends Usuario {

	public List<Aluno> alunos;
	
	public Responsavel(String login, String senha, String nome, Integer idade, List<Aluno> alunos) {
		   // Chama o construtor da superclasse Cliente para inicializar atributos herdados
		    super(login, senha, nome, idade);
		    this.alunos = alunos;
		    }

	public List<Aluno> getAlunos() {
		return this.alunos;
		}
	 
	private Aluno matricularAluno() {
	  return null;
	  }
	
	@Override
	public String getTipoUsuario() {
		return "Responsável";
	}
	
}