package projetoEscola;

import java.util.ArrayList;
import java.util.List;

public class Turma {

    // public List<Aluno> aluno;
    // public List<Professor> professor;
    // public List<Atividade> atividade;

	private String nome;
	private List<Aluno> alunos;
	public static List<Turma> turmas; // Atributo estático da lista de turmas.
 	
	public Turma(String nome) {
		this.nome = nome;
		this.alunos = new ArrayList<>();
	}
	
	// Getter para o nome das turmas:
	public String getNome() {
		return nome;
	}
	
	// Exibe informações das turmas:
	public static void exibirInformacoes() {
		System.out.println("Informações das turmas: ");
		
		for (Turma turma : turmas) {
			System.out.println("Nome da turma: " + turma.getNome());
			System.out.println("Alunos matriculados: " + turma.alunos.size());
			System.out.println(); // Linha em branco
		}
	}
}