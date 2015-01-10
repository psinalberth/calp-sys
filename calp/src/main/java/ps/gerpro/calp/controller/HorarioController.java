package ps.gerpro.calp.controller;

import javax.inject.Inject;

import ps.gerpro.calp.model.Horario;
import ps.gerpro.calp.repository.HorarioRepository;
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
@Path("/horarios")
public class HorarioController {
	
	@Inject
	private HorarioRepository repository;
	
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
	public void salvar(Horario horario) {
		repository.salvar(horario);
		result.use(Results.json()).withoutRoot().from(horario).serialize();
	}
	
	@Put("alterar/{horario.id}")
	@Consumes("application/json")
	public void alterar(Horario horario) {
		repository.alterar(horario);
		result.nothing();
	}
	
	@Delete("apagar/{horario.id}")
	public void apagar(Horario horario) {
		repository.remover(horario);
		result.nothing();
	}
}