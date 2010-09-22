/**
 * 
 */
package org.ow2.proactive_grid_cloud_portal.client.view;

import org.ow2.proactive_grid_cloud_portal.shared.state.ResourceManagerState;

import com.google.gwt.gen2.table.client.MutableTableModel;
import com.google.gwt.gen2.table.client.TableModelHelper.Request;


/**
 * @author naumanbadar
 *
 */
public class StateTableModel extends MutableTableModel<ResourceManagerState> {

	@Override
	protected boolean onRowInserted(int beforeRow) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean onRowRemoved(int row) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean onSetRowValue(int row, ResourceManagerState rowValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void requestRows(Request request, com.google.gwt.gen2.table.client.TableModel.Callback<ResourceManagerState> callback) {
		// TODO Auto-generated method stub
		
	}

}
