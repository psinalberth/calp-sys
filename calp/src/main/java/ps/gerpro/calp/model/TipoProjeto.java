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
@Table(name = "TIPO_PROJETO", catalog = "labpesquisa")
public class TipoProjeto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Set<Projeto> projetos = new HashSet<Projeto>(0);

	public TipoProjeto() {
	}

	public TipoProjeto(String nome) {
		this.nome = nome;
	}

	public TipoProjeto(String nome, Set<Projeto> projetos) {
		this.nome = nome;
		this.projetos = projetos;
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

	@Column(name = "NOME", nullable = false, length = 30)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoProjeto")
	public Set<Projeto> getProjetos() {
		return this.projetos;
	}

	public void setProjetos(Set<Projeto> projetos) {
		this.projetos = projetos;
	}
}