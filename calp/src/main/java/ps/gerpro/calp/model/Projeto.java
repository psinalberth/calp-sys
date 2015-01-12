package ps.gerpro.calp.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PROJETO", catalog = "labpesquisa")
public class Projeto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private TipoProjeto tipoProjeto;
	private Professor professor;
	private String nome;
	private String resumo;
	private Set<Aluno> alunos = new HashSet<Aluno>(0);

	public Projeto() {
	}

	public Projeto(TipoProjeto tipoProjeto, Professor professor, String nome,
			String resumo) {
		this.tipoProjeto = tipoProjeto;
		this.professor = professor;
		this.nome = nome;
		this.resumo = resumo;
	}

	public Projeto(TipoProjeto tipoProjeto, Professor professor, String nome,
			String resumo, Set<Aluno> alunos) {
		this.tipoProjeto = tipoProjeto;
		this.professor = professor;
		this.nome = nome;
		this.resumo = resumo;
		this.alunos = alunos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TIPO_PROJETO_ID", nullable = false)
	public TipoProjeto getTipoProjeto() {
		return this.tipoProjeto;
	}

	public void setTipoProjeto(TipoProjeto tipoProjeto) {
		this.tipoProjeto = tipoProjeto;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PROFESSOR_ID", nullable = false)
	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Column(name = "NOME", nullable = false, length = 120)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "RESUMO", nullable = false, length = 65535)
	public String getResumo() {
		return this.resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "projeto")
	public Set<Aluno> getAlunos() {
		return this.alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}
}