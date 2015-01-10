package ps.gerpro.calp.controller;

import javax.inject.Inject;

import ps.gerpro.calp.model.Agenda;
import ps.gerpro.calp.repository.AgendaRepository;
import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Controller
@Path("/agenda")
public class AgendaController {
	
	@Inject
	private AgendaRepository repository;
	
	@Inject
	private Result result;
	
	@Get("/")
	public void listar() {
		result.use(Results.json()).withoutRoot().from(repository.getAll()).serialize();
	}
	
	@Get("/id/{id}")
	public void getById(int id) {
		result.use(Results.json()).withoutRoot().from(repository.getById(id)).serialize();
	}
	
	@Get("/{key}/{value}/")
	public void getByColumn(String key, String value) {
		result.use(Results.json()).withoutRoot().from(repository.getByColumn(key, value)).serialize();
	}
	
	@Post("/salvar/")
	@Consumes("application/json")
	public void salvar(Agenda agenda) {
		repository.salvar(agenda);
		result.use(Results.json()).withoutRoot().from(agenda).serialize();
	}
	
	@Put("alterar/{agenda.id}")
	@Consumes("application/json")
	public void alterar(Agenda agenda) {
		repository.alterar(agenda);
		result.nothing();
	}
	
	@Delete("apagar/{agenda.id}")
	public void apagar(Agenda agenda) {
		repository.remover(agenda);
		result.nothing();
	}
}