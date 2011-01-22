package br.com.mrcom.domain.dao.imp;

import br.com.mrcom.domain.dao.AbstractDaoFactory;
import br.com.mrcom.domain.dao.ClienteDao;
import br.com.mrcom.domain.dao.EnderecoDao;
import br.com.mrcom.domain.dao.EstadoDao;

public class DaoFactory extends AbstractDaoFactory {

    private HibernateGenericDao<?> instantiateDAO(Class<?> daoClass) {
        try {
            return (HibernateGenericDao<?>)daoClass.newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Can not instantiate DAO: " + daoClass, ex);
        }
    }
	
	@Override
	public EstadoDao getEstadoDao() {
		return (EstadoDao)instantiateDAO(HibernateEstadoDao.class);
	}

	@Override
	public ClienteDao getClienteDao() {
		return (ClienteDao)instantiateDAO(HibernateClienteDao.class);
	}

	@Override
	public EnderecoDao getEnderecoDao() {
		return (EnderecoDao)instantiateDAO(HibernateEnderecoDao.class);
	}

}
