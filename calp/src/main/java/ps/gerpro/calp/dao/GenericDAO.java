package ps.gerpro.calp.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import ps.gerpro.calp.repository.GenericRepository;

@Resource
public abstract class GenericDAO implements GenericRepository<Serializable> {
	
	public void salvar(Serializable persist) {
		
		getSession().persist(persist);
	}

	public void alterar(Serializable persist) {
		
		getSession().merge(persist);
	}

	public Serializable getById(int id) {

		return (Serializable) getSession().get(Serializable.class, id);
	}
	
	public Serializable getByColumn(String key, String value) {
		
		return (Serializable) getSession().createCriteria(Serializable.class).add(Restrictions.eq(key, value)).uniqueResult();
	}

	public void remover(Serializable persist) {
		
		getSession().delete(persist);
	}
	
	@SuppressWarnings("unchecked")
	public List<Serializable> getAll() {

		return getSession().createCriteria(Serializable.class).list();
	}
	
	public abstract Session getSession();
}
