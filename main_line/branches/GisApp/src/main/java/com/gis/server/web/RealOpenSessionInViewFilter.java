package com.gis.server.web;

import org.hibernate.Transaction;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.support.OpenSessionInViewFilter;

public class RealOpenSessionInViewFilter extends OpenSessionInViewFilter{
	
	 Transaction t = null;
	protected Session getSession(SessionFactory sessionFactory) throws DataAccessResourceFailureException {
		Session session = SessionFactoryUtils.getSession(sessionFactory, true);
		session.beginTransaction();
		t = session.getTransaction();
		FlushMode flushMode = getFlushMode();
		if (flushMode != null) {
			session.setFlushMode(flushMode);
		}
		return session;
	}
	
	@Override
	protected void closeSession(Session session, SessionFactory sessionFactory) {
		try {
			session.flush();
			t.commit();
		}
		catch (HibernateException ex) {
			logger.debug("Could not close Hibernate Session", ex);
		}
		catch (Throwable ex) {
			logger.debug("Unexpected exception on closing Hibernate Session", ex);
		}

	}

}
