package teste.model;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import teste.dao.AlunoDAO;
import teste.dao.CursoDAO;

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
	
	public String mostrarLista() {
		return "listaraluno";
	}
	
	public List<AlunoBean> listar() {
		AlunoDAO dao = new AlunoDAO();
		return dao.retrieveAll(AlunoBean.class);
	}
	
	public String salvar() {
		AlunoDAO dao = new AlunoDAO();
		dao.create(this);
		
		
		return "mostraraluno";
	}
	
	public String mostrarEdicao(Integer id) {
		AlunoDAO dao = new AlunoDAO();
		AlunoBean aluno = dao.retrieve(AlunoBean.class, id);
		System.out.println(aluno);
		
		Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("editAluno", aluno);		
		
		return "editaraluno";
	}
	
	public String editar(AlunoBean aluno) {
		AlunoDAO dao = new AlunoDAO();
		dao.update(aluno);
		
		return mostrarLista();
	}
	
	public String excluir(Integer id) {
		AlunoDAO dao = new AlunoDAO();
		AlunoBean curso = dao.retrieve(AlunoBean.class, id);
		dao.delete(curso);
		
		return mostrarLista();
	}

}
