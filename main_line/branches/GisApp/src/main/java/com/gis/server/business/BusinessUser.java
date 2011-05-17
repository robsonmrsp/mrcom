package com.gis.server.business;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.gis.client.dtos.DtoUser;
import com.gis.server.beans.User;
import com.gis.server.persist.dao.DaoUser;

@Named("businessUser")
public class BusinessUser {

	@Inject
	DaoUser daoUser;

	public void saveUser(User user) {
		daoUser.saveBean(user);
	}

	public List<DtoUser> loadAll() {
		List<DtoUser> listDtoUsers = new ArrayList<DtoUser>();
		List<User> listUsers = daoUser.findAll();

		for(User user : listUsers){
			listDtoUsers.add(obtainDtoFromEntity(user));
		}
		return listDtoUsers;
	}

	private DtoUser obtainDtoFromEntity(User user) {
		DtoUser ret = new DtoUser();

		ret.setId(user.getId());
		ret.setName(user.getName());
		ret.setPassword(user.getPassword());

		return ret;
	}
}
