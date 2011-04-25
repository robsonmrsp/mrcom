package com.gis.server.business;

import javax.inject.Inject;
import javax.inject.Named;

import com.gis.server.beans.User;
import com.gis.server.persist.dao.DaoUser;

@Named("businessUser")
public class BusinessUser {

	@Inject
	DaoUser daoUser;

	public void saveUser(User user) {
		daoUser.saveBean(user);
	}
}
