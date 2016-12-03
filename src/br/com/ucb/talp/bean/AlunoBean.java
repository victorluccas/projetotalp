package br.com.ucb.talp.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.ucb.talp.dao.DAO;
import br.com.ucb.talp.modelo.Aluno;

@ManagedBean
public class AlunoBean {
	
	private Aluno aluno = new Aluno();
	
	public Aluno getAluno() {
		return aluno;
	}
	
	/**
	 * Método que retorna a listagem de alunos
	 * @return alunos List<Aluno> 
	 */
	public List<Aluno> getAlunos() {
		return new DAO<Aluno>(Aluno.class).listaTodos();
	}
			
	public String gravarAluno() {
		System.out.println("Gravando Aluno(a): " + this.aluno.getMatricula() + " - "+ this.aluno.getNome());
		
		if (this.aluno.getId() == null) {
			new DAO<Aluno>(Aluno.class).adiciona(this.aluno);
		} else {
			new DAO<Aluno>(Aluno.class).atualiza(this.aluno);
		}

		this.aluno = new Aluno();

		return "aluno?faces-redirect=true";
	}
	
	public void carregar(Aluno aluno) {
		System.out.println("Carregando aluno");
		this.aluno = aluno;
	}

	public void remover(Aluno aluno) {
		System.out.println("Removendo aluno");
		new DAO<Aluno>(Aluno.class).remove(aluno);
	}
	
	
}
