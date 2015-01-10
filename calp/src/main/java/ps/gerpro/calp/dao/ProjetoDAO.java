package ps.gerpro.calp.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import ps.gerpro.calp.model.Projeto;
import ps.gerpro.calp.repository.ProjetoRepository;

@Resource
public class ProjetoDAO implements ProjetoRepository {

	@Inject
	private Session session;
	
	public void salvar(Projeto persist) {
		this.session.persist(persist);
	}

	public void alterar(Projeto persist) {
		this.session.merge(persist);
	}

	public Projeto getById(int id) {
		return (Projeto) this.session.get(Projeto.class, id);
	}

	public Projeto getByColumn(String key, String value) {
		return (Projeto) this.session.createCriteria(Projeto.class).add(Restrictions.eq(key, value)).uniqueResult();
	}

	public void remover(Projeto persist) {
		this.session.delete(persist);
	}
	
	@SuppressWarnings("unchecked")
	public List<Projeto> getAll() {
		return this.session.createCriteria(Projeto.class).list();
	}
}