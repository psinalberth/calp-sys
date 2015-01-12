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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ALUNO", catalog = "labpesquisa")
public class Aluno implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Projeto projeto;
	private String nome;
	private Set<Horario> horarios = new HashSet<Horario>(0);

	public Aluno() {
	}

	public Aluno(Projeto projeto, String nome) {
		this.projeto = projeto;
		this.nome = nome;
	}

	public Aluno(Projeto projeto, String nome, Set<Horario> horarios) {
		this.projeto = projeto;
		this.nome = nome;
		this.horarios = horarios;
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
	@JoinColumn(name = "PROJETO_ID", nullable = false)
	public Projeto getProjeto() {
		return this.projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	@Column(name = "NOME", nullable = false, length = 100)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "")
	public Set<Horario> getHorarios() {
		return this.horarios;
	}

	public void setHorarios(Set<Horario> horarios) {
		this.horarios = horarios;
	}
}