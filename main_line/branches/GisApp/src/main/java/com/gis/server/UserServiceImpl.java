package com.gis.server;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.gis.client.dtos.DtoUser;
import com.gis.client.services.UserService;
import com.gis.server.beans.User;
import com.gis.server.business.BusinessUser;

@Named("userService")
public class UserServiceImpl implements UserService {

	private static final long serialVersionUID = 1L;

	@Inject
	BusinessUser businessUser;

	@Transactional
	public boolean save(DtoUser dtoUser) throws Exception {
		User user = new User();
		user.setId(3l);
		user.setName("Marcio");
		user.setPassword("Marcio");

		businessUser.saveUser(user);
		return true;
	}
}
