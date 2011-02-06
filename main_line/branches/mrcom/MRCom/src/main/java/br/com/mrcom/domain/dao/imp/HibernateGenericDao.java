package br.com.mrcom.domain.dao.imp;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.mrcom.domain.dao.GenericDao;
import br.com.mrcom.persistence.HibernateUtil;

public class HibernateGenericDao<T> implements GenericDao<T> {

	private Session session;
	Class<T> clazz;

	@SuppressWarnings("unchecked")
	public HibernateGenericDao() {
		System.out.println("HibernateGenericDao.HibernateGenericDao()");
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.session = HibernateUtil.getSessionFactory().getCurrentSession();
	}

	protected Session getSession() {
		return this.session;
	}

	@SuppressWarnings("unchecked")
	public T busca(Serializable id) {

		//Problemas no teste unitario. Lança excessão quando vai buscar no banco.
/*		T t = (T) HibernateUtil.getSessionFactory().getCurrentSession()
				.get(clazz, id);
		return t;*/
		
		T t = null;
		Session sess = getSession();
		try {
			sess.getTransaction().begin();
			t = (T) sess.get(clazz, id);		
			sess.getTransaction().commit();
			return t;
		} catch (Exception e) {
			sess.getTransaction().rollback();
			e.printStackTrace();
		}
		return t;
	}

	@SuppressWarnings("unchecked")
	public List<T> buscaTodos() {

		List<T> lista = HibernateUtil.getSessionFactory().getCurrentSession()
				.createCriteria(clazz).setMaxResults(10).list();

		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<T> buscaPorParametros(String propriedade, String valor) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(clazz);

		List<T> retorno = criteria.add(Restrictions.eq(propriedade, valor))
				.setMaxResults(10).list();

		return retorno;
	}

	@SuppressWarnings("unchecked")
	public List<T> buscaPorParametrosLike(String propriedade, String valor) {

		valor = "%" + valor + "%";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(clazz);

		List<T> retorno = criteria.setMaxResults(10).setFirstResult(10)
				.add(Restrictions.ilike(propriedade, valor))
				.addOrder(Order.asc(propriedade)).list();
		return retorno;
	}

	/**
	 * 
	 * @param propriedade
	 *            nome da propriedade pela qual se deseja ordenar a consulta.
	 * @param quantidade
	 *            numero maximo de registros a serem lidos
	 * @param valorIn
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> buscaOrdenadoPorParametro(String propriedade,
			Integer quantidade, int numPagina) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(clazz);

		List<T> retorno = criteria.setFirstResult(numPagina * quantidade)
				.addOrder(Order.asc(propriedade)).setMaxResults(quantidade)
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
		Session sess = getSession();
		try {
			sess.getTransaction().begin();
			sess.save(t);		
			sess.getTransaction().commit();
		} catch (Exception e) {
			sess.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public void atualiza(T t) {
		Session sess = getSession();
		try {
			sess.getTransaction().begin();
			sess.update(t);
			sess.getTransaction().commit();
		} catch (Exception e) {
			sess.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public void deleta(T t) {
		Session sess = getSession();
		try {
			sess.getTransaction().begin();
			sess.delete(t);
			sess.getTransaction().commit();
		} catch (Exception e) {
			sess.getTransaction().rollback();
			e.printStackTrace();
		}
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
