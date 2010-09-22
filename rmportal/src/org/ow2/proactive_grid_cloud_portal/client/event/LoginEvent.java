package org.ow2.proactive_grid_cloud_portal.client.event;

import com.google.gwt.event.shared.GwtEvent;
/**
 * Class that is used for defining event that corresponds to the login action.
 * @author ahagea
 *
 */
public class LoginEvent extends GwtEvent<LoginEventHandler>{
	/**
	 * Type of LoginEvent 
	 */
	public static Type<LoginEventHandler> TYPE = new Type<LoginEventHandler>();

	@Override
	public Type<LoginEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(LoginEventHandler handler) {
		handler.onLogin(this);
	}
	
	
}
