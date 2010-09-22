package org.ow2.proactive_grid_cloud_portal.client.event;

import com.google.gwt.event.shared.EventHandler;
/**
 * The interface used for defining the method signatures needed by the scheduler initialization event. 
 * @author ahagea
 *
 */
public interface ResourceManagerInitEventHandler extends EventHandler{
	/**
	 * Method called when the initialization of the scheduler page is done.
	 * @param event the event that occurs when the initialization of the scheduler page is done. 
	 */
	void init(ResourceManagerInitEvent event);
}


