package com.gis.client.actions;

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Info;
import com.gis.client.dtos.DtoUser;
import com.gis.client.forms.FormUser;
import com.gis.client.services.UserService;
import com.gis.client.services.UserServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ActionFormUser{ 

	FormUser formUser;
	UserServiceAsync userService = GWT.create(UserService.class);
	public ActionFormUser() {
		formUser = new FormUser();
		formUser.getSaveButton().addListener(Events.Select, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				saveUser();
			}
		});
	}

	public FormUser getFormUser() {
		return formUser;
	}

	private boolean saveUser() {
		DtoUser user = new DtoUser();
		user.setName(formUser.getUserName());
		user.setPassword(formUser.getUserPassword());

		userService.save(user, new AsyncCallback<Boolean>() {
			@Override
			public void onSuccess(Boolean result) {
				Info.display("Sucesso", "Usuário salvo com  Usuário");
				System.out.println("ActionFormUser.saveUser().new AsyncCallback<Boolean>() {...}.onSuccess()");
			}
			@Override
			public void onFailure(Throwable caught) {
				Info.display("Erro", "Erro Ao salvar Usuário");
				System.out.println("ActionFormUser.saveUser().new AsyncCallback<Boolean>() {...}.onFailure()");
			}
		});

		return true;
	}


}
