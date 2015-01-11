package ps.gerpro.calp.controller;

import javax.inject.Inject;

import ps.gerpro.calp.model.Projeto;
import ps.gerpro.calp.repository.ProjetoRepository;
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
@Path("/projetos")
public class ProjetoController {
	
	@Inject
	private ProjetoRepository repository;
	
	@Inject
	private Result result;
	
	@Get("/")
	public void listar() {
		
		result.use(Results.json()).withoutRoot().from(repository.getAll()).recursive().serialize();
	}
	
	@Get("/id/{id}")
	public void getById(int id) {
		result.use(Results.json()).withoutRoot().from(repository.getById(id)).recursive().serialize();
	}
	
	@Get("/{key}/{value}/")
	public void getByColumn(String key, String value) {
		result.use(Results.json()).withoutRoot().from(repository.getByColumn(key, value)).serialize();
	}
	
	@Post("/salvar/")
	@Consumes("application/json")
	public void salvar(Projeto projeto) {
		repository.salvar(projeto);
		result.use(Results.json()).withoutRoot().from(projeto).serialize();
	}
	
	@Put("alterar/{projeto.id}")
	@Consumes("application/json")
	public void alterar(Projeto projeto) {
		repository.alterar(projeto);
		result.nothing();
	}
	
	@Delete("/apagar/{projeto.id}")
	public void apagar(Projeto projeto) {
		repository.remover(projeto);
		result.nothing();
	}
}