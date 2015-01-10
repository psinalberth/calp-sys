package ps.gerpro.calp.repository;

import javax.enterprise.context.RequestScoped;

import ps.gerpro.calp.model.Aluno;

@RequestScoped
public interface AlunoRepository extends GenericRepository<Aluno> {

}
