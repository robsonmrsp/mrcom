package com.gis.client.services;

import java.util.List;

import com.gis.client.dtos.DtoUser;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("services/userService")
public interface UserService extends RemoteService {

	List<DtoUser> save(DtoUser user) throws Exception;
}
