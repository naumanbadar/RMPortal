package org.ow2.proactive_grid_cloud_portal.client.presenter;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
/**
 * The main interface that should be extended by each interface of the presenters that exist on 
 * the business logic layer of the application.
 * @author ahagea
 *
 */
public interface Presenter {
	/**
	 * Sets the initial state and checks the existing history token together with routing to 
	 * the appropriate view. 
	 */
	public void go(final HasWidgets container);
	
	public interface Display<T extends Presenter> { 
		
		/**
		 * Sets the presenter that handles the business logic of the view.
		 * @param presenter the presenter object
		 */
		void setPresenter(T presenter);
		
		/**
		 * Returns the view in form of a GWT widget.
		 * @return the widget
		 */
		Widget asWidget();
	}
}
