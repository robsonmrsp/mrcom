package com.gis.client.forms;

import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.gis.client.dtos.DtoUser;
import com.google.gwt.user.client.ui.Widget;

public class FormUser extends Window {

	private LayoutContainer form;
	private TextField <String> userName;
	private TextField <String> userPassword;
	private TextField <String> userPasswordConfirm;
	private Button cancelButton;
	private Button saveButton;

	public FormUser() {
		setLayout(new RowLayout(Orientation.VERTICAL));
		setHeading("Usuários");

		add(createForm(), new RowData(Style.DEFAULT, 95.0, new Margins()));
		addButton(createSaveButton());
		addButton(createCancelButton());
	}

	private Button createCancelButton() {

		cancelButton = new Button("Cancelar");
		return cancelButton;
	}

	private Button createSaveButton() {
		saveButton = new Button("Salvar");
		return saveButton;
	}

	private Widget createForm() {
		form = new LayoutContainer();
		form.setStyleAttribute("padding", "10px"); 
		form.setLayout(new FormLayout());
		form.setBorders(false);

		form.add(createUserName(), new FormData("100%"));
		form.add(createUserPassword(), new FormData("100%"));
		form.add(createUserPasswordConfirm(), new FormData("100%"));

		return form;
	}

	private Widget createUserPasswordConfirm() {
		userPasswordConfirm = new TextField<String>();
		userPasswordConfirm.setFieldLabel("Confirmar");
		userPasswordConfirm.setLabelSeparator("");

		return userPasswordConfirm;
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
}
