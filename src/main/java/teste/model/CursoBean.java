package teste.model;


import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.annotations.GenericGenerator;

import teste.config.HibernateUtil;
import teste.dao.CursoDAO;


@Entity(name = "Curso")
@Table(name = "curso")
public class CursoBean {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Integer id;
	
	@Column
	private String nome;
	
	@OneToMany(mappedBy = "curso", targetEntity = AlunoBean.class, fetch = FetchType.EAGER)
	private List<AlunoBean> alunos;
				
	public CursoBean() {
		super();		
	}
	
	public CursoBean(String nome) {
		super();
	}
	
	public CursoBean(Integer id, String nome) {
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

	public List<AlunoBean> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<AlunoBean> alunos) {
		this.alunos = alunos;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + "]";
	}
	
	public String novo() {
		return "curso";
	}
	
	public String mostrarLista() {
		return "listarcurso";
	}
	
	public List<CursoBean> listar() {
		CursoDAO dao = new CursoDAO();
		return dao.retrieveAll(CursoBean.class);
	}
	
	public String salvar() {
		CursoDAO dao = new CursoDAO();
		dao.create(this);
		
		
		return "mostrarcurso";
	}
	
	public String mostrarEdicao(Integer id) {
		CursoDAO dao = new CursoDAO();
		CursoBean curso = dao.retrieve(CursoBean.class, id);
		
		Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("editCurso", curso);
		
		return "editarcurso";
	}
	
	public String editar(CursoBean curso) {
		CursoDAO dao = new CursoDAO();
		dao.update(curso);
		
		return mostrarLista();
	}
	
	public String excluir(Integer id) {
		CursoDAO dao = new CursoDAO();
		CursoBean curso = dao.retrieve(CursoBean.class, id);
		dao.delete(curso);
		
		return mostrarLista();
	}
	
}
