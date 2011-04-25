package com.gis.client;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;

public class CopyOfCadastroUsuario extends Window {

	public CopyOfCadastroUsuario() {
		setHeading("Usuários");
		setSize(325, 154);
//		setLayout(new RowLayout(Orientation.VERTICAL));
		
		setButtonAlign(HorizontalAlignment.LEFT);
		setLayout(new FormLayout());
		
		TextField<String> txtfldNewTextfield = new TextField<String>();
		add(txtfldNewTextfield);
		txtfldNewTextfield.setFieldLabel("Nome");
		
		TextField <String> txtfldNewTextfield_1 = new TextField<String>();
		add(txtfldNewTextfield_1);
		txtfldNewTextfield_1.setFieldLabel("Senha");
		txtfldNewTextfield_1.setPassword(true);
		
		TextField<String> txtfldNewTextfield_2 = new TextField<String>();
		add(txtfldNewTextfield_2);
		txtfldNewTextfield_2.setFieldLabel("Confirmar");
		txtfldNewTextfield_2.setPassword(true);
//		add(frmpnlNewFormpanel, new RowData(300.0, 130.0, new Margins()));
		
		addButton(new Button("Salvar"));
		addButton(new Button("Cancelar"));
//		addButton(new Button("Cancelar"));
		
		
	}

}
