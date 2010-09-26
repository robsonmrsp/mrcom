package br.com.mrcom.domain.dao.imp;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import org.hibernate.criterion.*;

import br.com.mrcom.domain.dao.GenericDao;
import br.com.mrcom.persistence.HibernateUtil;

public class HibernateGenericDao<T>  implements GenericDao<T>{

	private Session session;
	Class<T> clazz;

	public HibernateGenericDao(Class<T> clazz) {
		System.out.println("HibernateGenericDao.HibernateGenericDao()");
		this.clazz = clazz;
		this.session = HibernateUtil.getSessionFactory().getCurrentSession();
	}

    protected Session getSession(){
        return this.session;
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
        //Obtenho uma sess�o
        //Nesse momento temos um POJO (Serializable pojo) transiente.
        Session sess = getSession();
        //Nesse momento o meu pojo que era transiente agora � persistente.
        sess.save(t);
        //Obtenho a transa��o no qual minha session est� inserida
        //e fa�o a inser��o no banco de dados.
        //Vale lembrar que uma session pertence a uma transa��o.
        //E uma transa��o pode ter mais de uma session.
        //Atrav�s do m�todo commit() � que h� a sincroniza��o com o banco de dados.
        sess.getTransaction().commit();
        //Fecho a minha sess�o.
        sess.close();
        //Quando a session fecha o POJO (Serializable pojo)
        //nesse momento deixou de ser persistente para ser desligado.
		
	}

	public void atualiza(T t) {
        Session sess = getSession();
        sess.update(t);
        sess.getTransaction().commit();
        sess.close();
	}

	public void deleta(T t) {
        Session sess = getSession();
        sess.delete(t);
        sess.getTransaction().commit();
        sess.close();
		
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
