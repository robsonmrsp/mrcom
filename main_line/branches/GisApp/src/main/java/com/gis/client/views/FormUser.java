package com.gis.client.views;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.gis.client.dtos.DtoUser;
import com.google.gwt.user.client.ui.Widget;

public class FormUser extends MyForm<DtoUser>{

	private TextField <String> userName;
	private TextField <String> userPassword;
	private TextField <String> userPasswordConfirm;
	private Button cancelButton;
	private Button saveButton;

	public FormUser() {
		super();
		setHeading("Usuários");
		addFormComponent(createUserName());
		addFormComponent(createUserPassword());
		addFormComponent(createUserPasswordConfirm());
	}

	private Widget createUserPasswordConfirm() {
		userPasswordConfirm = new TextField<String>();
		userPasswordConfirm.setFieldLabel("Confirmar");
		userPasswordConfirm.setLabelSeparator("");
		return userPasswordConfirm;
	}

	protected List<ColumnConfig> createColumnConfigGrid() {
		ColumnConfig configName = new ColumnConfig(DtoUser.USER_NAME,DtoUser.USER_NAME_DISPLAY, 120);
		ColumnConfig configPass = new ColumnConfig(DtoUser.USER_PASSWORD, DtoUser.USER_PASSWORD_DISPLAY, 180);

		List<ColumnConfig> columnConfigs = new ArrayList<ColumnConfig>();
		columnConfigs.add(configName);
		columnConfigs.add(configPass);

		return columnConfigs;
	}

	private Widget createUserPassword() {
		userPassword = new TextField<String>();
		userPassword.setFieldLabel("Senha");
		userPassword.setLabelSeparator("");
		return userPassword;
	}

	private Widget createUserName() {
		userName = new TextField<String>();
		userName.setFieldLabel("Usuário");
		userName.setLabelSeparator("");

		return userName;
	}

	public String getUserName() {
		return userName.getValue();
	}

	public String getUserPassword() {
		return userPassword.getValue();
	}

	public Button getSaveButton() {
		return saveButton;
	}

	public Button getCancelButton() {
		return cancelButton;
	}

	@Override
	public	DtoUser getInputData() {
		DtoUser user = new DtoUser();
		
		user.setName(getUserName());
		user.setPassword(getUserPassword());
		
		return user;
	}
}
