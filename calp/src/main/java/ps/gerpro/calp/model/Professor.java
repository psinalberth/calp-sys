package ps.gerpro.calp.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PROFESSOR", catalog = "labpesquisa")
public class Professor implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private boolean admin;
	private String email;
	private String senha;
	private Set<Projeto> projetos = new HashSet<Projeto>(0);
	private Set<Agenda> agendas = new HashSet<Agenda>(0);

	public Professor() {
	}

	public Professor(String nome, boolean admin, String email, String senha) {
		this.nome = nome;
		this.admin = admin;
		this.email = email;
		this.senha = senha;
	}

	public Professor(String nome, boolean admin, String email, String senha,
			Set<Projeto> projetos, Set<Agenda> agendas) {
		this.nome = nome;
		this.admin = admin;
		this.email = email;
		this.senha = senha;
		this.projetos = projetos;
		this.agendas = agendas;
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

	@Column(name = "NOME", nullable = false, length = 45)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "ADMIN", nullable = false)
	public boolean isAdmin() {
		return this.admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Column(name = "EMAIL", nullable = false, length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "SENHA", nullable = false, length = 45)
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "professor")
	public Set<Projeto> getProjetos() {
		return this.projetos;
	}

	public void setProjetos(Set<Projeto> projetos) {
		this.projetos = projetos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "professor")
	public Set<Agenda> getAgendas() {
		return this.agendas;
	}

	public void setAgendas(Set<Agenda> agendas) {
		this.agendas = agendas;
	}
}