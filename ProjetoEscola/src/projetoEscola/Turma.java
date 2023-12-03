package projetoEscola;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Turma {
	
	Scanner scanner = new Scanner(System.in);
	private String nome;
	private List<Aluno> alunos;
	public static List<Turma> turmas = new ArrayList<>(); // Atributo estático da lista de turmas.
 	
	public Turma(String nome) {
		this.nome = nome;
		// Verifica se o nome escolhido já está em uso
		for (Turma turma: Turma.turmas) {
			if (nome.equals(turma.getNome())) {
				this.nome = this.validaNomeTurma();
			}
		}

		this.alunos = new ArrayList<>();
		Turma.turmas.add(this);
	}

	// Função utilizada para a verificação do nome da turma
	private String validaNomeTurma() {
		System.out.println("Nome de turma já utilizado por outra turma, escreva outro nome: ");
		String novo_nome = scanner.nextLine();
		for (Turma turma: Turma.turmas) {
			if (novo_nome.equals(turma.getNome())) {
				return this.validaNomeTurma();
			}
		}
		return novo_nome;
	}
	
	// Getter para o nome das turmas:
	public String getNome() {
		return nome;
	}

	public List<Aluno> getAlunos(){
		return alunos;
	}
	
	// Exibe informações das turmas:
	public static void exibirInformacoes() {
		System.out.println("Informações das turmas: ");
		
		Integer i = 1;
		for (Turma turma : turmas) {
			System.out.println(
				"Turma: " + i + "\n" +
				"Nome da turma: " + turma.getNome() + "\n" + 
				"Alunos matriculados: " + turma.alunos.size() + "\n" +
				"----------------------"
			);
			i = i + 1;
		}
	}
}