package br.com.ucb.talp.dao;

import javax.persistence.EntityManager;

import br.com.ucb.talp.modelo.Aluno;
import br.com.ucb.talp.modelo.Disciplina;
import br.com.ucb.talp.modelo.Nota;

public class PopulaBanco {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		
		//+-----------------
		//|Carga para a entidade Aluno
		//+-----------------
		Aluno victor = gerarAluno("Victor Luccas", "MAT1234");
		em.persist(victor);
		
		Aluno alexandre = gerarAluno("Alexandre Santos", "MAT4321");
		em.persist(alexandre);
		
		Aluno joel = gerarAluno("Joel Houston" ,  "MAT1267");
		em.persist(joel);
		
		Aluno matt = gerarAluno("Matt Crocker", "MAT0987");
		em.persist(matt);
		
		//+-----------------
		//|Carga para a entidade Disciplina
		//+-----------------
		Disciplina talp = gerarDisciplina("TALP", "GN00735");
		em.persist(talp);
		
		Disciplina lab3 = gerarDisciplina("LAB3", "GN99025");
		em.persist(lab3);
		
		Disciplina lab2 = gerarDisciplina("LAB2", "GN88734");
		em.persist(lab2);
		
		Disciplina bancodados = gerarDisciplina("Banco de Dados", "GN35799");
		em.persist(bancodados);
		
		//+-----------------
		//|Carga para a entidade Notas
		//+-----------------
		Nota nota1 = gerarNota(victor,talp, 9.9);
		em.persist(nota1);

		Nota nota2 = gerarNota(alexandre,lab2, 10.0);
		em.persist(nota2);
		
		Nota nota3 = gerarNota(joel,lab3, 8.9);
		em.persist(nota3);
		
		Nota nota4 = gerarNota(matt,bancodados, 9.0);
		em.persist(nota4);
				
		// commita a transacao
		em.getTransaction().commit();

		// fecha a entity manager
		em.close();
	}	
	
	/*
	 * M�todo de carga para a entidade aluno
	 */
	private static Aluno gerarAluno(String nome, String matricula) {
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setMatricula(matricula);
		return aluno;
	}
	
	/*
	 * M�todo de carga para a entidade Disciplina
	 */
	private static Disciplina gerarDisciplina(String nome, String cod_disciplina) {
		Disciplina disciplina = new Disciplina();
		disciplina.setNome(nome);
		disciplina.setCod_disciplina(cod_disciplina);
		return disciplina; 
	}
	
	/*
	 * Método de carga para a entidade Disciplina
	 */
	private static Nota gerarNota(Aluno aluno, Disciplina disciplina, Double nota_aluno) {
		Nota n = new Nota();
		n.setId_aluno(aluno.getId());
		n.setId_disciplina(disciplina.getId());
		n.setNota_aluno(nota_aluno);
		return n; 
	}
}
