package projetoEscola;

import java.util.List;


public class Aluno extends Cliente {

    //public List<Turma> turma;
    public Responsavel responsavel;
    //public List<Nota> nota;
   // public List<Atividade> atividade;
    
    public Aluno(String login, String nome, Integer idade, String senha, Responsavel responsavel) {
   // Chama o construtor da superclasse Cliente para inicializar atributos herdados
    super(login, nome, idade, senha);
    this.responsavel = responsavel;
}
    
   public Responsavel getResponsavel(){
	   return this.responsavel;
   }


  private void enviarAtividade() {
  }

}