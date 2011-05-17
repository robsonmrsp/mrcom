package com.gis.client.actions;

import java.util.List;

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Info;
import com.gis.client.dtos.DtoUser;
import com.gis.client.services.UserService;
import com.gis.client.services.UserServiceAsync;
import com.gis.client.views.FormUser;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class HandlerFormUser{ 

	FormUser formUser;
	
	UserServiceAsync userService = GWT.create(UserService.class);
	
	public HandlerFormUser() {
		formUser = new FormUser();
		
		formUser.addSaveActionListener(new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				save();
			}
		});
	}
	
	public FormUser getFormUser() {
		return formUser;
	}
	
	public void postSave(List<DtoUser> list){
		formUser.loadGridElements(list);
	}
	
	private boolean save() {
		
			DtoUser user = formUser.getInputData();			
			userService.save(user, new AsyncCallback<List<DtoUser>>() {
			@Override
			public void onSuccess(List<DtoUser> result) {
				Info.display("Sucesso", "Usuário salvo com  sucesso");
				postSave(result);
			}
			@Override
			public void onFailure(Throwable caught) {
				Info.display("Erro", "Erro Ao salvar Usuário");
			}
		});
		return true;
	}
}
