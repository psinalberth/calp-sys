package ps.gerpro.calp.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import ps.gerpro.calp.model.Aluno;
import ps.gerpro.calp.repository.AlunoRepository;

@Resource
public class AlunoDAO implements AlunoRepository {
	
	@Inject
	private Session session;
	
	public void salvar(Aluno persist) {		
		this.session.persist(persist);
	}

	public void alterar(Aluno persist) {
		this.session.merge(persist);
	}

	public Aluno getById(int id) {
		return (Aluno) this.session.get(Aluno.class, id);
	}

	public Aluno getByColumn(String key, String value) {
		return (Aluno) this.session.createCriteria(Aluno.class).add(Restrictions.like(key, value, MatchMode.ANYWHERE)).uniqueResult();
	}

	public void remover(Aluno persist) {
		this.session.delete(persist);
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> getAll() {
		return this.session.createCriteria(Aluno.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}
}