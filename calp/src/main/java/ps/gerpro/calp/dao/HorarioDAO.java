package ps.gerpro.calp.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import ps.gerpro.calp.model.Horario;
import ps.gerpro.calp.repository.HorarioRepository;

@Resource
public class HorarioDAO implements HorarioRepository {
	
	@Inject
	private Session session;
	
	public void salvar(Horario persist) {
		this.session.persist(persist);
	}

	public void alterar(Horario persist) {
		this.session.merge(persist);
	}

	public Horario getById(int id) {
		return (Horario) this.session.get(Horario.class, id);
	}

	public Horario getByColumn(String key, String value) {
		return (Horario) this.session.createCriteria(Horario.class).add(Restrictions.eq(key, value)).uniqueResult();
	}

	public void remover(Horario persist) {
		this.session.delete(persist);
	}
	
	@SuppressWarnings("unchecked")
	public List<Horario> getAll() {
		return this.session.createCriteria(Horario.class).list();
	}
}