package org.ow2.proactive_grid_cloud_portal.client.presenter;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasValue;

/**
 * The interface needed to be implemented by the presenter of the login page.
 * @author ahagea
 *
 */
public interface LoginPresenter extends Presenter {
	/**
	 * Logins to the scheduler.
	 */
	void doLogin();
	/**
	 * Cancels the request for connecting to the scheduler.
	 */
	void doCancel();

	/**
	 * Interface for binding the presenter and the view for the login page.
	 * @author ahagea
	 *
	 */
	public interface Display extends Presenter.Display<LoginPresenter> {
		void setErrorMessage(String message);
		void setMessage(String message);
		/**
		 * Gets the button that is used for firing the login event.
		 * @return the clickable button used for login
		 */
		HasClickHandlers getLoginButton();
		/**
		 * Gets the input field that is used for writing the username of the person that 
		 * asks to login to the ProActive scheduler.
		 * @return the user input that is used for providing the username 
		 */
		HasValue<String> getUsername();
		/**
		 * Gets the input field that is used for writing the user's password.
		 * @return the user input that is used for providing the password of the user
		 */
		HasValue<String> getPassword();
	}
}
