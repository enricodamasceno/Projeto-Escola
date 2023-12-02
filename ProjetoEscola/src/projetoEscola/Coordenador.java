package projetoEscola;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Coordenador extends Usuario {
	
	Scanner scanner = new Scanner(System.in);
	protected static List<Coordenador> coordenadores = new ArrayList<>();
	
	public Coordenador(String login, String senha, String nome, Integer idade) {
		super(login, senha, nome, idade);
		Coordenador.coordenadores.add(this);
	}

	private Responsavel cadastrarResponsavel() {
		return null;
		}

	private Professor cadastrarProfessor() {
		return null;
		}

	private Turma cadastrarTurma() {
		System.out.println("Informe o nome da nova turma: ");
		String nomeTurma = scanner.nextLine();
		
		Turma novaTurma = new Turma(nomeTurma);
		Turma.turmas.add(novaTurma); // Adiciona a nova turma à lista de turmas
		
		System.out.println("Você criou a turma: " + nomeTurma + ". Se quiser adicionar alunos, utilize a função Alterar Turma.");
		return novaTurma;
		}
	  
	public Turma alterarTurma(List<Turma> turmas) {
		System.out.println("Qual turma você deseja modificar?");
		Turma.exibirInformacoes();
		
		int numeroTurma = scanner.nextInt();
		// Confere se o número fornecido está de acordo.
		if (numeroTurma >= 1 && numeroTurma <= turmas.size()) {
			Turma turmaEscolhida = turmas.get(numeroTurma - 1);
			
			// Lógica para modificar a turma.
			
			System.out.println("Turma " + turmaEscolhida.getNome() + " modificada com sucesso.");
			return turmaEscolhida;
		} else {
			System.out.println("Número de turma inválido.");
			return null;
		}
	
	}
	
	@Override
	public String getTipoUsuario() {
		return "Coordenador";
	}
	
}