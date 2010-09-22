/**
 * 
 */
package org.ow2.proactive_grid_cloud_portal.client.view;

import org.ow2.proactive_grid_cloud_portal.client.presenter.StatePresenter;
import org.ow2.proactive_grid_cloud_portal.shared.state.ResourceManagerState;

import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.gen2.table.client.PagingScrollTable;
import com.google.gwt.gen2.table.override.client.FlexTable;
import com.google.gwt.gen2.table.override.client.HTMLTable;
import com.google.gwt.gen2.table.override.client.HTMLTable.RowFormatter;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author naumanbadar
 * 
 */
public class StateView extends AbstractView<StatePresenter> implements StatePresenter.Display {

	private PagingScrollTable<ResourceManagerState> pagingScrollTable;
	
	private FlexTable flexTable;
	
	private String emptyMessage = "There is no data to display";

	private static DateTimeFormat dateFormat = DateTimeFormat.getFormat("HH:mm:ss MM/dd/yy");

	private static StateViewUiBinder uiBinder = GWT.create(StateViewUiBinder.class);

	interface StateViewUiBinder extends UiBinder<Widget, StateView> {
	}

	public StateView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	VerticalPanel panel;

	/**
	 * Gets the unique instance of <code>pagingScrollTable</code>.
	 */
//	private PagingScrollTable<ResourceManagerState> getScrollTable() {
//		if (this.pagingScrollTable == null) {
//			pagingScrollTable = newScrollTable();
//		}
//		return pagingScrollTable;
//	}
//	
	private FlexTable getFlexTable() {
		if (this.flexTable == null) {
			flexTable = newflexTable();
		}
		return flexTable;
	}

	private FlexTable newflexTable() {
		FlexTable table = new FlexTable();
		table.setCellSpacing(0);
		table.setCellPadding(2);
		table.setHTML(0, 0, "Resource Statistics"); //header
		table.getFlexCellFormatter().setColSpan(0, 0, 2);
		table.getRowFormatter().addStyleName(0, "headerStatTable");
		table.setHTML(1, 0, "Number Of All Resources");
		table.setHTML(2, 0, "Number Of Free Resources");
		table.setHTML(3, 0, "Free Nodes Number");
		table.setHTML(4, 0, "Total Alive Nodes Number");
		table.setHTML(5, 0, "Total Nodes Number");

		return table;
}


	/// try with pagingscrolltable also
/*	private PagingScrollTable<ResourceManagerState> newScrollTable() {

		// create the header
		FixedWidthFlexTable headerTable = createTableHeader();

		// create the data table
		FixedWidthGrid dataTable = createDataTable(headerTable.getColumnCount());

		// create the table model
		TaskSourceTableModel tableModel = createTableModel(dataTable);

		// create the table definition
		DefaultTableDefinition<Task> tableDefinition = createTableDefinition();

		// create the paging scroll table
		pagingScrollTable = new PagingScrollTable<Task>(tableModel, dataTable, headerTable, tableDefinition);

		pagingScrollTable.setEmptyTableWidget(new HTML(emptyMessage));

		pagingScrollTable.getDataTable().setSelectionPolicy(SelectionPolicy.MULTI_ROW);

		// setup the bulk renderer (used for performance improvement, according
		// to GWT developers)
		FixedWidthGridBulkRenderer<Task> bulkRenderer = new FixedWidthGridBulkRenderer<Task>(pagingScrollTable.getDataTable(), pagingScrollTable);
		pagingScrollTable.setBulkRenderer(bulkRenderer);

		// setup the formatting
		pagingScrollTable.setCellPadding(3);
		pagingScrollTable.setCellSpacing(0);

		pagingScrollTable.setHeight("100%");
		pagingScrollTable.setWidth("100%");

		pagingScrollTable.setResizePolicy(ResizePolicy.FILL_WIDTH);
		pagingScrollTable.setSortPolicy(SortPolicy.SINGLE_CELL);

		pagingScrollTable.gotoPage(0, true);

		return pagingScrollTable;
	}

	private FixedWidthFlexTable createTableHeader() {
		FixedWidthFlexTable headerTable = new FixedWidthFlexTable();

		headerTable.setHTML(0, 0, "numberOfAllResources");
		headerTable.setHTML(0, 1, "numberOfFreeResources");
		headerTable.setHTML(0, 2, "freeNodesNumber");
		headerTable.setHTML(0, 3, "totalAliveNodesNumber");
		headerTable.setHTML(0, 4, "totalNodesNumber");
		headerTable.setHeight("27px");

		return headerTable;
		
	}
	
	private FixedWidthGrid createDataTable(int nbColumns) {
		 final FixedWidthGrid dataTable =  new FixedWidthGrid(0,nbColumns);
		 
		 
		  * The following lines show how to add handle the event of
		  * selecting on a row.
		  
		 dataTable.addRowSelectionHandler(new RowSelectionHandler() {
				
				public void onRowSelection(RowSelectionEvent event) {
					
				}
		 });
		 return dataTable;
	}
	
	private TaskSourceTableModel createTableModel(FixedWidthGrid dataTable){
		return new TaskSourceTableModel(dataTable);
	}
*/	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// public StateView(String firstName) {
	//
	// initWidget(uiBinder.createAndBindUi(this));
	//
	// // Can access @UiField after calling createAndBindUi
	// button.setText(firstName);
	// }

	@Override
	public void setState(ResourceManagerState state) {
		FlexTable table = getFlexTable();
		
		table.setHTML(1, 1, Integer.toString(state.getNumberOfAllResources()));
		table.setHTML(2, 1, Integer.toString(state.getNumberOfFreeResources()));
		table.setHTML(3, 1, Integer.toString(state.getFreeNodesNumber()));
		table.setHTML(4, 1, Integer.toString(state.getTotalAliveNodesNumber()));
		table.setHTML(5, 1, Integer.toString(state.getTotalNodesNumber()));
		
//		table.getRowFormatter().addStyleName(1, "rowStatTable");
//		table.getRowFormatter().addStyleName(2, "rowStatTable");
//		table.getRowFormatter().addStyleName(3, "rowStatTable");
//		table.getRowFormatter().addStyleName(4, "rowStatTable");
//		table.getRowFormatter().addStyleName(5, "rowStatTable");
		
		
		
		
		RowFormatter rf = table.getRowFormatter();
		int rowCount = table.getRowCount();
		///TODO: hide model from view
	    for (int i = 0; i < rowCount; i++) {
			
	    	rf.addStyleName(1+i, "rowStatTable");
		}
		

	}

	@Override
	public Widget getTable() {
		return getFlexTable();
	}

	@Override
	public void setEmptyMessage(String msg) {
		getFlexTable().setHTML(1, 1, msg);

	}

	@Override
	public HasWidgets getPanel() {
		return panel;
	}


}
