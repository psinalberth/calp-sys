package ps.gerpro.calp.repository;

import javax.enterprise.context.RequestScoped;

import ps.gerpro.calp.model.Professor;

@RequestScoped
public interface ProfessorRepository extends GenericRepository<Professor> {

}
