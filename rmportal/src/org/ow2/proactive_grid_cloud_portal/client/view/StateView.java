/**
 * 
 */
package org.ow2.proactive_grid_cloud_portal.client.view;

import org.ow2.proactive_grid_cloud_portal.client.presenter.StatePresenter;
import org.ow2.proactive_grid_cloud_portal.shared.state.ResourceManagerState;

import com.google.gwt.core.client.GWT;
import com.google.gwt.gen2.table.client.PagingScrollTable;
import com.google.gwt.gen2.table.override.client.FlexTable;
import com.google.gwt.gen2.table.override.client.HTMLTable.RowFormatter;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
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

	@UiField
	VerticalPanel panel;

	public StateView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

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
		table.setHTML(0, 0, "Resource Statistics"); // header
		table.getFlexCellFormatter().setColSpan(0, 0, 2);
		table.getRowFormatter().addStyleName(0, "headerStatTable");
		table.setHTML(1, 0, "Number Of All Resources");
		table.setHTML(2, 0, "Number Of Free Resources");
		table.setHTML(3, 0, "Free Nodes Number");
		table.setHTML(4, 0, "Total Alive Nodes Number");
		table.setHTML(5, 0, "Total Nodes Number");

		return table;
	}

	@Override
	public void setState(ResourceManagerState state) {
		FlexTable table = getFlexTable();

		table.setHTML(1, 1, Integer.toString(state.getNumberOfAllResources()));
		table.setHTML(2, 1, Integer.toString(state.getNumberOfFreeResources()));
		table.setHTML(3, 1, Integer.toString(state.getFreeNodesNumber()));
		table.setHTML(4, 1, Integer.toString(state.getTotalAliveNodesNumber()));
		table.setHTML(5, 1, Integer.toString(state.getTotalNodesNumber()));

		RowFormatter rf = table.getRowFormatter();
		int rowCount = table.getRowCount();
		// /TODO: hide model from view
		for (int i = 0; i < rowCount; i++) {

			rf.addStyleName(1 + i, "rowStatTable");
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
