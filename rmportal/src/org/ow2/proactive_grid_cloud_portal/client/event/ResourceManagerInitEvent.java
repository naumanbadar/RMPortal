package org.ow2.proactive_grid_cloud_portal.client.event;

import com.google.gwt.event.shared.GwtEvent;
/**
 * Class that is used for defining event that corresponds to the scheduler initialization.
 * @author ahagea
 *
 */
public class ResourceManagerInitEvent extends GwtEvent<ResourceManagerInitEventHandler>{
	/**
	 * Type of <code>ResourceManagerInitEvent</code>
	 */
	public static Type<ResourceManagerInitEventHandler> TYPE = new Type<ResourceManagerInitEventHandler>();
	
	// The user name linked to this event 
	private String username;

	/**
	 * Constructor
	 * 
	 * @param username user name attached to this event.
	 */
	public ResourceManagerInitEvent(String username) {
		this.username = username;
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ResourceManagerInitEventHandler> getAssociatedType() {
		return TYPE;
	}
	
	@Override
	protected void dispatch(ResourceManagerInitEventHandler handler) {
		handler.init(this);
	}

	/**
	 * Gets the user name of this event
	 * 
	 * @return <code>username</code>
	 */
	public String getUsername() {
		return username;
	}

}
