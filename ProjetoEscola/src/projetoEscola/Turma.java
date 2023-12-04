package projetoEscola;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Turma {
	
	Scanner scanner = new Scanner(System.in);
	private String nome;
	private List<Aluno> alunos;
	public static List<Turma> turmas = new ArrayList<>(); // Atributo estático da lista de turmas.
	private List<Atividade> atividades_listadas;
	public Map<Aluno, Map> dicionario_aluno_atividade;
 	
	public Turma(String nome) {
		this.nome = nome;
		// Verifica se o nome escolhido já está em uso
		for (Turma turma: Turma.turmas) {
			if (nome.equals(turma.getNome())) {
				this.nome = this.validaNomeTurma();
			}
		}

		this.alunos = new ArrayList<>();
		this.dicionario_aluno_atividade = new HashMap<Aluno, Map>();
		this.atividades_listadas = new ArrayList<>();
		Turma.turmas.add(this);
	}

	public void recebeResposta(Aluno aluno, Atividade atividade) {
		if (this.dicionario_aluno_atividade.containsKey(aluno)) {
			this.dicionario_aluno_atividade.get(aluno).put(atividade, aluno.atividades_realizadas.get(atividade));
			return;
		}
		
		Map<Atividade, String> dicionario_aluno = new HashMap<Atividade, String>();
		dicionario_aluno.put(atividade, aluno.atividades_realizadas.get(atividade));
		this.dicionario_aluno_atividade.put(aluno, dicionario_aluno);
	}

	public void distribuiAtividade(Atividade atividade) {
		this.atividades_listadas.add(atividade);
		for (Aluno aluno: Aluno.alunos) {
			aluno.recebeAtividade(atividade);
		}
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
	public static void exibirTurmas() {
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