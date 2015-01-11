package ps.gerpro.calp.controller;

import javax.inject.Inject;

import ps.gerpro.calp.model.TipoProjeto;
import ps.gerpro.calp.repository.TipoProjetoRepository;
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
@Path("/categorias")
public class TipoProjetoController {
	
	@Inject
	private Result result;
	
	@Inject
	private TipoProjetoRepository repository;
	
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
	public void salvar(TipoProjeto tipo) {
		repository.salvar(tipo);
		result.use(Results.json()).withoutRoot().from(tipo).serialize();
	}
	
	@Put("alterar/{tipo.id}")
	@Consumes("application/json")
	public void alterar(TipoProjeto tipo) {
		repository.alterar(tipo);
		result.nothing();
	}
	
	@Delete("/apagar/{tipo.id}")
	public void apagar(TipoProjeto tipo) {
		repository.remover(tipo);
		result.nothing();
	}
}