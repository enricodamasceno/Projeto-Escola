package projetoEscola;

import java.util.List;


public class Aluno extends Usuario {

	public Responsavel responsavel;
	//public List<Turma> turma;
	//public List<Nota> nota;
	// public List<Atividade> atividade;

	public Aluno(String login, String senha, String nome, Integer idade, Responsavel responsavel) {

		// Chama o construtor da superclasse Cliente para inicializar atributos herdados
		super(login, senha, nome, idade);
		this.responsavel = responsavel;
	}

	private void enviarAtividade() {
	}

	public Responsavel getResponsavel(){
		return this.responsavel;
	}
	
	@Override
	public String getTipoUsuario() {
		return "Aluno";
	}
}