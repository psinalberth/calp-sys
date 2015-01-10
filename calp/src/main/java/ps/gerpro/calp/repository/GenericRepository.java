package ps.gerpro.calp.repository;

import java.util.List;

/**
 * Interface que representa as operações básicas disponíveis no back-end, 
 * a ser implementada pelos Repositories da aplicação.
 * 
 * @author inalberth
 *
 * @param <T> Tipo a ser injetado
 */
public interface GenericRepository<T> {
	
	/**
	 * Persiste um novo objeto no repositório de dados.
	 * 
	 * @param persist Objeto a ser persistido no repositório.
	 */
	public void salvar(T persist);
	
	/**
	 * Altera um objeto existente no repositório de dados.
	 * 
	 * @param persist Objeto a ser alterado.
	 */
	public void alterar(T persist);
	
	/**
	 * Recupera um objeto no repositório de dados através de seu identificador primário.
	 * 
	 * @param id Identificador primário do objeto procurado.
	 * @return Retorna o <code>objeto procurado</code> caso esteja presente ou <code>null</code> caso 
	 * não esteja no repositório de dados.
	 */
	public T getById(int id);
	
	/**
	 * Recupera um objeto no repositório de dados através de qualquer coluna existente em uma tabela.
	 * 
	 * @param key Nome da coluna a ser utilizada como critério.
	 * @param value Valor da coluna utilizado como critério.
	 * @return Retorna o <code>objeto procurado</code> caso esteja presente ou <code>null</code> caso 
	 * não esteja no repositório de dados.
	 */
	public T getByColumn(String key, String value);
	
	/**
	 * Remove um objeto do repositório de dados.
	 * 
	 * @param persist Objeto a ser removido.
	 */
	public void remover(T persist);
	
	/**
	 * Recupera todos os objetos contidos em uma tabela do repositório de dados.
	 * 
	 * @return Retorna uma <code>coleção de objetos<code> presente no repositório ou <code>null</code>
	 * caso não existam objetos.
	 */
	public List<T> getAll();
}