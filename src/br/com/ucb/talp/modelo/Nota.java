package br.com.ucb.talp.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Nota {

	@Id
	@GeneratedValue //(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer id_aluno;
	private Integer id_disciplina;
	private Double nota_aluno;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getNota_aluno() {
		return nota_aluno;
	}
	public void setNota_aluno(Double nota_aluno) {
		this.nota_aluno = nota_aluno;
	}
		
	public Integer getId_aluno() {
		return id_aluno;
	}
	public void setId_aluno(Integer id_aluno) {
		this.id_aluno = id_aluno;
	}
	public Integer getId_disciplina() {
		return id_disciplina;
	}
	public void setId_disciplina(Integer id_disciplina) {
		this.id_disciplina = id_disciplina;
	}
	
}