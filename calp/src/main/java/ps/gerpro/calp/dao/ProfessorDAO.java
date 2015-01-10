package ps.gerpro.calp.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import ps.gerpro.calp.model.Professor;
import ps.gerpro.calp.repository.ProfessorRepository;

@Resource
public class ProfessorDAO implements ProfessorRepository {
	
	@Inject
	private Session session;
	
	public void salvar(Professor persist) {
		this.session.persist(persist);
	}

	public void alterar(Professor persist) {
		this.session.merge(persist);
	}

	public Professor getById(int id) {
		return (Professor) this.session.get(Professor.class, id);
	}

	public Professor getByColumn(String key, String value) {
		return (Professor) this.session.createCriteria(Professor.class).add(Restrictions.eq(key, value)).uniqueResult();
	}

	public void remover(Professor persist) {
		this.session.delete(persist);
	}
	
	@SuppressWarnings("unchecked")
	public List<Professor> getAll() {
		return this.session.createCriteria(Professor.class).list();
	}
}