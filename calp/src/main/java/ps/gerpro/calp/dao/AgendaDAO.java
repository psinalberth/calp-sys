package ps.gerpro.calp.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import ps.gerpro.calp.model.Agenda;
import ps.gerpro.calp.repository.AgendaRepository;

@Resource
public class AgendaDAO implements AgendaRepository {
	
	@Inject
	private Session session;

	public void salvar(Agenda persist) {
		this.session.persist(persist);
	}

	public void alterar(Agenda persist) {
		this.session.merge(persist);
	}

	public Agenda getById(int id) {
		return (Agenda) this.session.get(Agenda.class, id);
	}

	public Agenda getByColumn(String key, String value) {
		return (Agenda) this.session.createCriteria(Agenda.class).add(Restrictions.eq(key, value)).uniqueResult();
	}

	public void remover(Agenda persist) {
		this.session.delete(persist);
	}

	@SuppressWarnings("unchecked")
	public List<Agenda> getAll() {
		return this.session.createCriteria(Agenda.class).list();
	}
}