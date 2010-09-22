package org.ow2.proactive_grid_cloud_portal.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ProActiveGridCloudPortal implements EntryPoint {
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		ResourceManagerServiceAsync rpcService = GWT.create(ResourceManagerService.class);
	    HandlerManager eventBus = new HandlerManager(null);
	    AppController appViewer = new AppController(rpcService, eventBus);
	    //RootPanel.get().setStyleName("body");
	    //RootPanel.get("widgetContainer").setHeight((Window.getClientHeight()-100)+"px");
	    
	    //RootPanel rp = RootPanel.get("widgetContainer");
	    
	    //the RootLayoutPanel is used (instead of using the RootPanel) because the widgets
	    //are arranged in panels
	    appViewer.go( RootLayoutPanel.get());

	}
	
}
