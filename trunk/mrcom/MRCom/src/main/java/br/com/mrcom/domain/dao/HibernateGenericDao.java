package br.com.mrcom.domain.dao;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import org.hibernate.criterion.*;

import br.com.mrcom.persistence.HibernateUtil;

public class HibernateGenericDao<T>  implements GenericDao<T>{

	private Session session;
	Class<T> clazz;

	public HibernateGenericDao(Class<T> clazz) {
		System.out.println("HibernateGenericDao.HibernateGenericDao()");
		this.clazz = clazz;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T busca(Serializable id){

		T t = (T)HibernateUtil.getSessionFactory().getCurrentSession().get(clazz, id);
		return t; 
	}

	@SuppressWarnings("unchecked")
	public List<T> buscaTodos(){

		List<T> lista = HibernateUtil.getSessionFactory().getCurrentSession().createCriteria(clazz).setMaxResults(10).list();

		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<T> buscaPorParametros(String propriedade, String valor){

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(clazz);

		List<T> retorno = criteria		
		.add(Restrictions.eq(propriedade, valor))
		.setMaxResults(10).list();

		return retorno;
	}
	@SuppressWarnings("unchecked")
	public List<T> buscaPorParametrosLike(String propriedade, String valor){

		valor = "%"+valor+"%";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(clazz);

		List<T> retorno = criteria
		.setMaxResults(10)
		.setFirstResult(10)
		.add(Restrictions.ilike(propriedade, valor))
		.addOrder(Order.asc(propriedade))																		
		.list();		
		return retorno;
	}

	/**
	 * 
	 * @param propriedade nome da propriedade pela qual se deseja ordenar a consulta.
	 * @param quantidade numero maximo de registros a serem lidos
	 * @param valorIn
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> buscaOrdenadoPorParametro(String propriedade, Integer quantidade, int numPagina){

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(clazz);

		List<T> retorno = criteria
		.setFirstResult(numPagina * quantidade)
		.addOrder(Order.asc(propriedade))
		.setMaxResults(quantidade)								
		.list();		
		return retorno;
	}
	public Integer getTotalRegistrosConsulta() {

		return null;
	}

	public List<T> busca(int quantidade, int pagina) {
		// TODO Auto-generated method stub
		return null;
	}

	public void salva(T t) {
		// TODO Auto-generated method stub
		
	}

	public void atualiza(T t) {
		// TODO Auto-generated method stub
		
	}

	public void deleta(T t) {
		// TODO Auto-generated method stub
		
	}

	public List<T> buscaPorParametros(Map<String, String> parametroValor) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> buscaOrdenadaPorParametros(Map<String, String> parametroValor) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> buscaOrdenadaPorParametros(
			Map<String, String> parametroValor, T inicio) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> buscaOrdenadaPorParametros(
			Map<String, String> parametroValor, int quantidade, int pagina) {
		// TODO Auto-generated method stub
		return null;
	}
}
