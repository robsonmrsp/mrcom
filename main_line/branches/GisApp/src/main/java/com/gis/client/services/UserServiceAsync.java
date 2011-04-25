package com.gis.client.services;

import com.gis.client.dtos.DtoUser;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserServiceAsync {

	void save(DtoUser user, AsyncCallback<Boolean> callback) ;
}
