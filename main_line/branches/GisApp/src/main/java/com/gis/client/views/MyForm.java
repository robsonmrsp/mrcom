package com.gis.client.views;

import java.util.List;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.LayoutData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.user.client.ui.Widget;

public abstract class MyForm<DTO extends BaseModelData> extends Window{
	
	
	private FormPanel inputDataPanel;
	private LayoutContainer outputDataPanel;

	private Button cancelButton;
	private Button saveButton;
	
	private Grid<DTO> grid;

	public MyForm() {
		super();
		setLayout(new RowLayout(Orientation.VERTICAL));
		add(createInputDataPanel());
		add(createOutputDataPanel());
	}
	
	protected abstract List<ColumnConfig> createColumnConfigGrid() ;
	public abstract DTO getInputData();
	
	private Button createSaveButton() {
		saveButton = new Button("Salvar");
		return saveButton;
	}
	
	private Button createCancelButton() {
		cancelButton = new Button("cancelar");
		return cancelButton;
	}

	private Component createInputDataPanel() {

		inputDataPanel = new FormPanel();
//		inputDataPanel.setLayout(new FormLayout());		
		inputDataPanel.setBorders(false);
		inputDataPanel.setHeaderVisible(false)	;
		inputDataPanel.addButton(createSaveButton());
		inputDataPanel.addButton(createCancelButton());		

		
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
		outputDataPanel.setSize(300, 400);
		outputDataPanel.setBorders(true);
		outputDataPanel.add(createPanelGrid());
		
		return outputDataPanel;
	}
	
	private Widget createGrid() {
		grid = new Grid<DTO>(createListStore(), createColumnModel());
		grid .setSize(320, 400);
		return grid;
	}
	
	protected Widget createPanelGrid() {

		LayoutContainer panelGrid = new LayoutContainer();  
		panelGrid.setSize(300, 400);  
		panelGrid.setLayout(new FitLayout());  
		panelGrid.add(createGrid());

		return panelGrid;
	}
	
	private ColumnModel createColumnModel() {
		
		return new ColumnModel(createColumnConfigGrid());
	}
	
	private ListStore<DTO> createListStore() {
		return new ListStore<DTO>();
	}

	public void addSaveActionListener(Listener<BaseEvent> listener){
		saveButton.addListener(Events.Select, listener);
	}
	public void loadGridElements(List<DTO> list){
		grid.getStore().removeAll();
		grid.getStore().add(list);
	}
}
