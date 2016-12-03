package br.com.ucb.talp.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.ucb.talp.dao.DAO;
import br.com.ucb.talp.modelo.Disciplina;

@ManagedBean
public class DisciplinaBean {

	private Disciplina disciplina = new Disciplina();
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	
	/**
	 * Método que retorna a listagem de alunos
	 * @return alunos List<Aluno> 
	 */
	public List<Disciplina> getDisciplinas() {
		return new DAO<Disciplina>(Disciplina.class).listaTodos();
	}
		
	public String gravarDisciplina() {
		System.out.println("Gravando disciplina " + this.disciplina.getNome()  + " - "+ this.disciplina.getCod_disciplina());

		if (this.disciplina.getId() == null) {
			new DAO<Disciplina>(Disciplina.class).adiciona(this.disciplina);
		} else {
			new DAO<Disciplina>(Disciplina.class).atualiza(this.disciplina);
		}

		this.disciplina = new Disciplina();

		return "disciplina?faces-redirect=true";
	}
	
	public void carregar(Disciplina disciplina) {
		System.out.println("Carregando displina");
		this.disciplina = disciplina;
	}

	public void remover(Disciplina disciplina) {
		System.out.println("Removendo disciplina");
		new DAO<Disciplina>(Disciplina.class).remove(disciplina);
	}
	
}
