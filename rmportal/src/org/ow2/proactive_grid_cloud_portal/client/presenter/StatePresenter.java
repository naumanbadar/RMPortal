/**
 * 
 */
package org.ow2.proactive_grid_cloud_portal.client.presenter;

import org.ow2.proactive_grid_cloud_portal.shared.state.ResourceManagerState;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author naumanbadar
 * 
 */
public interface StatePresenter extends Presenter {

	void retrieveSate();

	public interface Display extends Presenter.Display<StatePresenter> {

		void setState(ResourceManagerState state);

		/**
		 * Getter for the table that contains the list of tasks.
		 * 
		 * @return the table
		 */
		Widget getTable();

		HasWidgets getPanel();
		
		/**
		 * Setter for the text that is displayed once the table is empty.
		 * 
		 * @param msg
		 *            the text message
		 */
		void setEmptyMessage(String msg);
	}
}
