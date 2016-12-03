package br.com.ucb.talp.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import br.com.ucb.talp.dao.DAO;
import br.com.ucb.talp.modelo.Aluno;
import br.com.ucb.talp.modelo.Disciplina;
import br.com.ucb.talp.modelo.GestaoNota;
import br.com.ucb.talp.modelo.Nota;

@ManagedBean
public class NotaBean {
	
	private Nota nota = new Nota();
	private Map<Integer, Aluno> mapaAlunos = new HashMap<Integer, Aluno>(); 
	private Map<Integer, Disciplina> mapaDisciplinas = new HashMap<Integer, Disciplina>();
			
	
	public Nota getNota() {
		return nota;
	}
	
	/**
	 * Método que retorna a listagem de alunos
	 * @return alunos List<String> 
	 */
	public List<SelectItem> getAlunos() {
		List<SelectItem> itens = new ArrayList<SelectItem>();
		List<Aluno> lst = new DAO<Aluno>(Aluno.class).listaTodos();
		mapaAlunos.clear();
		
		for (Aluno aluno : lst) {
			itens.add(new SelectItem(aluno.getId(), aluno.getNome()));
			mapaAlunos.put(aluno.getId(), aluno);
		}
		
		return itens; 
	}
	
	/**
	 * Método que retorna a listagem das disciplinas
	 * @return alunos List<String> 
	 */
	public List<SelectItem> getDisciplinas() {
		
		List<SelectItem> itens = new ArrayList<SelectItem>();
		List<Disciplina> lst = new DAO<Disciplina>(Disciplina.class).listaTodos();
		mapaDisciplinas.clear();
		
		for (Disciplina disciplina : lst) {
			itens.add(new SelectItem(disciplina.getId(), disciplina.getNome()));
			mapaDisciplinas.put(disciplina.getId(), disciplina);
		}
		
		return itens;
	}
	
	/**
	 * Método que retorna a listagem das notas dos alunos
	 * @return alunos List<String> 
	 */
	public List<GestaoNota> getNotas() {
		
		List<GestaoNota> lstGestaoNota = new ArrayList<GestaoNota>();
		List<Nota> lst = new DAO<Nota>(Nota.class).listaTodos();
				
		for (Nota nota : lst) {
			GestaoNota gestao = new GestaoNota();
			gestao.setAluno(mapaAlunos.get(nota.getId_aluno()));
			gestao.setDisciplina(mapaDisciplinas.get(nota.getId_disciplina()));
			gestao.setNota(nota);
			lstGestaoNota.add(gestao);
		}
		
		return lstGestaoNota;
	}
	
	
			
	public String gravarNota() {
		System.out.println("Gravando Nota aluno(a): " + this.nota.getId_aluno() + " - "+ this.nota.getId_disciplina() + " - " + this.nota.getNota_aluno());
		
		if (this.nota.getId() == null) {
			new DAO<Nota>(Nota.class).adiciona(this.nota);
		} else {
			new DAO<Nota>(Nota.class).atualiza(this.nota);
		}

		this.nota = new Nota();

		return "nota?faces-redirect=true";
	}
	
	public void carregar(GestaoNota gestaonota) {
		System.out.println("Carregando nota");
		this.nota = gestaonota.getNota();
	}
	
	public void remover(GestaoNota gestaonota) {
		System.out.println("Removendo nota");
		new DAO<Nota>(Nota.class).remove(gestaonota.getNota());
	}
	
	
}
