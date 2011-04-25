package com.gis.client.services;

import com.gis.client.dtos.DtoUser;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("services/userService")
public interface UserService extends RemoteService {

	boolean save(DtoUser user) throws Exception;
}
