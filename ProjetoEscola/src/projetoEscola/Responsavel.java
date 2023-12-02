package projetoEscola;

import java.util.List;
import java.util.ArrayList;

public class Responsavel extends Usuario {

	public List<Aluno> alunos;
	protected static List<Responsavel> responsaveis = new ArrayList<>();
	
	public Responsavel(String login, String senha, String nome, Integer idade, List<Aluno> alunos) {
		   // Chama o construtor da superclasse Cliente para inicializar atributos herdados
		    super(login, senha, nome, idade);
		    this.alunos = alunos;
			Responsavel.responsaveis.add(this);
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