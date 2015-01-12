package ps.gerpro.calp.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AGENDA", catalog = "labpesquisa")
public class Agenda implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private AgendaId id;
	private Aluno aluno;
	private Professor professor;
	private Horario horario;

	public Agenda() {
	}

	public Agenda(AgendaId id, Aluno aluno, Professor professor, Horario horario) {
		this.id = id;
		this.aluno = aluno;
		this.professor = professor;
		this.horario = horario;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "horarioId", column = @Column(name = "HORARIO_ID", nullable = false)),
			@AttributeOverride(name = "alunoId", column = @Column(name = "ALUNO_ID", nullable = false)) })
	public AgendaId getId() {
		return this.id;
	}

	public void setId(AgendaId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ALUNO_ID", nullable = false, insertable = false, updatable = false)
	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PROFESSOR_ID", nullable = false)
	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "HORARIO_ID", nullable = false, insertable = false, updatable = false)
	public Horario getHorario() {
		return this.horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}
}