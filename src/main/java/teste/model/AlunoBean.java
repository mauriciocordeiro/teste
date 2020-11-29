package teste.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "aluno")
public class AlunoBean {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Integer id;

	@Column
	private String nome;
	
	@ManyToOne
	private CursoBean curso;
	
	public AlunoBean() {}
	
	public AlunoBean(String nome) {
		super();
		this.nome = nome;
	}

	public AlunoBean(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public CursoBean getCurso() {
		return curso;
	}

	public void setCurso(CursoBean curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + "]";
	}
	
	public String novo() {
		return "aluno";
	}

}
