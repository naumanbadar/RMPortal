package org.ow2.proactive_grid_cloud_portal.client.event;

import com.google.gwt.event.shared.EventHandler;
/**
 * The interface used for defining the method signatures needed by the login event. 
 * @author ahagea
 *
 */
public interface LoginEventHandler extends EventHandler{
	/**
	 * Action performs when a new <code>LoginEvent</code> occurs
	 * 
	 * @param event
	 */
	void onLogin(LoginEvent event);
}
