package ps.gerpro.calp.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import ps.gerpro.calp.model.TipoProjeto;
import ps.gerpro.calp.repository.TipoProjetoRepository;

@Resource
public class TipoProjetoDAO implements TipoProjetoRepository {
	
	@Inject
	private Session session;
	
	public TipoProjetoDAO(Session session) {
		
		this.session = session;
	}

	public void salvar(TipoProjeto persist) {
		
		this.session.persist(persist);
	}

	public void alterar(TipoProjeto persist) {
		
		this.session.merge(persist);
	}

	public TipoProjeto getById(int id) {
		
		return (TipoProjeto) this.session.get(TipoProjeto.class, id);
	}

	public TipoProjeto getByColumn(String key, String value) {
		
		return (TipoProjeto) this.session.createCriteria(TipoProjeto.class).add(Restrictions.eq(key, value)).uniqueResult();
	}
	
	public void remover(TipoProjeto persist) {
		
		this.session.delete(persist);
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoProjeto> getAll() {
		
		return this.session.createCriteria(TipoProjeto.class).list();
	}
}