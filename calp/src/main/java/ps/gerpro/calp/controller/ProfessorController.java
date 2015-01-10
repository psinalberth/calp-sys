package ps.gerpro.calp.controller;

import javax.inject.Inject;

import ps.gerpro.calp.model.Professor;
import ps.gerpro.calp.repository.ProfessorRepository;
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
@Path("/professores")
public class ProfessorController {
	
	@Inject
	private Result result;
	
	@Inject
	private ProfessorRepository repository;
	
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
	public void salvar(Professor professor) {
		repository.salvar(professor);
		result.use(Results.json()).withoutRoot().from(professor).serialize();
	}
	
	@Put("alterar/{professor.id}")
	@Consumes("application/json")
	public void alterar(Professor professor) {
		repository.alterar(professor);
		result.nothing();
	}
	
	@Delete("apagar/{professor.id}")
	public void apagar(Professor professor) {
		repository.remover(professor);
		result.nothing();
	}
}