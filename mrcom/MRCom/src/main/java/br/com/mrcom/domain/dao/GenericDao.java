package br.com.mrcom.domain.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenericDao<T> {

	
	public void salva(T t);

	public void atualiza( T t);

	public void deleta(T t);
	
	public T busca(Serializable s);
	
	/**Retorna uma lista de , no máximo <code>quantidade</code> registros e seguindo um numero de pagina definido em <code>pagina</code>
	 * 
	 * @param quantidade quantidade de registros retornado por vez
	 * @param pagina numero de pagina
	 * @return uma lista de registros.
	 */
	public List<T> busca(int quantidade, int pagina);
	
	public List<T> buscaPorParametros(Map<String, String> parametroValor);
	
	public List<T> buscaOrdenadaPorParametros(Map<String, String> parametroValor);
	
	public List<T> buscaOrdenadaPorParametros(Map<String, String> parametroValor, T inicio);

	public List<T> buscaOrdenadaPorParametros(Map<String, String> parametroValor, int quantidade, int pagina);
	
	public Integer getTotalRegistrosConsulta();
}
