package com.gis.client.views;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.LayoutData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.user.client.ui.Widget;

public class TesteFormPadrao extends LayoutContainer {

	private LayoutContainer inputDataPanel;
	private LayoutContainer outputDataPanel;

	public TesteFormPadrao() {
		setLayout(new RowLayout(Orientation.VERTICAL));

		add(createInputDataPanel());
		add(createOutputDataPanel());
	}

	
	private Component createInputDataPanel() {

		inputDataPanel = new LayoutContainer();
		inputDataPanel.setLayout(new FormLayout());		
		inputDataPanel.setBorders(true);
		
		return inputDataPanel;
	}

	protected void addFormComponent(Widget w, LayoutData l){
		inputDataPanel.add(w, l);
	}
	
	protected void addFormComponent(Widget w){
		addFormComponent(w, new FormData("100%"));
	}
	
	private Component createOutputDataPanel() {
		outputDataPanel = new LayoutContainer();
		outputDataPanel.setLayout(new FitLayout());
		outputDataPanel.setBorders(true);
		
		return outputDataPanel;
	}
}
