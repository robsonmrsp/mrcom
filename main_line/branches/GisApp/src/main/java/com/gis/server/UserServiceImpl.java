package com.gis.server;

import java.util.List;

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
	public List<DtoUser> save(DtoUser dtoUser) throws Exception {
		User user = new User();
		
		user.setName(dtoUser.getName());
		user.setPassword(dtoUser.getPassword());

		businessUser.saveUser(user);
		return businessUser.loadAll();
	}
}
