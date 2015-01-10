package ps.gerpro.calp.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AgendaId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int horarioId;
	private int alunoId;

	public AgendaId() {
	}

	public AgendaId(int horarioId, int alunoId) {
		this.horarioId = horarioId;
		this.alunoId = alunoId;
	}

	@Column(name = "HORARIO_ID", nullable = false)
	public int getHorarioId() {
		return this.horarioId;
	}

	public void setHorarioId(int horarioId) {
		this.horarioId = horarioId;
	}

	@Column(name = "ALUNO_ID", nullable = false)
	public int getAlunoId() {
		return this.alunoId;
	}

	public void setAlunoId(int alunoId) {
		this.alunoId = alunoId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AgendaId))
			return false;
		AgendaId castOther = (AgendaId) other;

		return (this.getHorarioId() == castOther.getHorarioId())
				&& (this.getAlunoId() == castOther.getAlunoId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getHorarioId();
		result = 37 * result + this.getAlunoId();
		return result;
	}
}