package ps.gerpro.calp.controller;

import javax.inject.Inject;

import ps.gerpro.calp.model.Aluno;
import ps.gerpro.calp.repository.AlunoRepository;
import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Controller
@Path("/alunos")
public class AlunoController {
	
	@Inject
	private AlunoRepository repository;
	
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
	public void getByNome(String key, String value) {
		result.use(Results.json()).withoutRoot().from(repository.getByColumn(key, value)).serialize();
	}
	
	@Post("/salvar/")
	@Consumes("application/json")
	public void salvar(Aluno aluno) {
		repository.salvar(aluno);
		result.use(Results.json()).withoutRoot().from(aluno).serialize();
	}
	
	@Put("alterar/{aluno.id}")
	@Consumes("application/json")
	public void alterar(Aluno aluno) {
		repository.alterar(aluno);
		result.nothing();
	}
	
	@Delete("/apagar/{aluno.id}")
	public void apagar(Aluno aluno) {
		repository.remover(aluno);
		result.nothing();
	}
}