package ps.gerpro.calp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HORARIO", catalog = "labpesquisa")
public class Horario implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String dia;
	private String turno;
	private Set<Aluno> alunos = new HashSet<Aluno>(0);

	public Horario() {
	}

	public Horario(String dia, String turno) {
		this.dia = dia;
		this.turno = turno;
	}

	public Horario(String dia, String turno, Set<Aluno> alunos) {
		this.dia = dia;
		this.turno = turno;
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

	@Column(name = "DIA", nullable = false, length = 45)
	public String getDia() {
		return this.dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	@Column(name = "TURNO", nullable = false, length = 45)
	public String getTurno() {
		return this.turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "AGENDA", catalog = "labpesquisa",
	joinColumns = {@JoinColumn(name = "HORARIO_ID", nullable = false, updatable = false)},
	inverseJoinColumns = {@JoinColumn(name = "ALUNO_ID", nullable = false, updatable = false)})
	public Set<Aluno> getAlunos() {
		return this.alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}
}