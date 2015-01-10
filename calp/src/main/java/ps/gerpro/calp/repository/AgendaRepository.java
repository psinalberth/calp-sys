package ps.gerpro.calp.repository;

import javax.enterprise.context.RequestScoped;

import ps.gerpro.calp.model.Agenda;

@RequestScoped
public interface AgendaRepository extends GenericRepository<Agenda> {

}
