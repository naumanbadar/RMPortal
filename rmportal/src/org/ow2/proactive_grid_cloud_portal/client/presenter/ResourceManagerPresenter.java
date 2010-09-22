package org.ow2.proactive_grid_cloud_portal.client.presenter;

import org.ow2.proactive_grid_cloud_portal.client.view.StateView;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

/**
 * The interface that defines the signature of the presenter's methods for the scheduler view.
 * @author ahagea
 *
 */
public interface ResourceManagerPresenter extends Presenter {
	
	/**
	 * Logouts from the scheduler.
	 */
	void doLogout();
	
	/**
	 * Getter for the session id of the user which is logged in.
	 * @return the session id
	 */
	String getSessionId();
	
	/**
	 * Setter for the content which is displayed on the left part of the page.
	 * @param w the widget that will be displayed.
	 */
	void setContent(Widget w);
	
	/**
	 * Interface for binding the presenter and the view for the scheduler main page.
	 * @author ahagea
	 *
	 */
	public interface Display extends Presenter.Display<ResourceManagerPresenter>{
		
		/**
		 * Gets the button that is used for firing the logout event.
		 * @return the clickable button used for login
		 */
		HasClickHandlers getLogoutButton();
		
		/**
		 * Sets the label that contains the username of the person who is logged in.
		 * @param userName
		 */
		void setUsername(String userName);
		
		/**
		 * Getter of the panel that is displayed on the right part of the page where
		 * the operation stack will be displayed. 
		 * @return the stack panel
		 */
//		SchedulerOperationView getSchedulerOperations();
		
		/**
		 * Getter of the panel that is displayed on the left part of the page. This 
		 * content changes accordingly with the stack that is opened in the right part
		 * of the page.    
		 * @return the panel where the widgets will be placed.
		 */
		
		StateView getStateView();
	}
}
