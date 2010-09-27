/**
 * 
 */
package org.ow2.proactive_grid_cloud_portal.client.presenter;

import org.ow2.proactive_grid_cloud_portal.client.ResourceManagerServiceAsync;
import org.ow2.proactive_grid_cloud_portal.client.presenter.ResourceManagerPresenter.Display;
import org.ow2.proactive_grid_cloud_portal.shared.state.ResourceManagerState;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * @author naumanbadar
 *
 */
public class StatePresenterImpl implements StatePresenter {

	
	private final ResourceManagerServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final Display display;
	private final String sessionId;
	
	private ResourceManagerState state;
	
	
	/**
	 * @param rpcService
	 * @param eventBus
	 * @param display
	 * @param sessionId
	 */
	public StatePresenterImpl(final ResourceManagerServiceAsync rpcService, final HandlerManager eventBus, final Display display, final String sessionId) {
		super();
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		this.sessionId = sessionId;
		this.display.setPresenter(this);
		
		this.display.getPanel().clear();
		this.display.getPanel().add(display.getTable());
		retrieveSate();
		
		RefreshTimer timer = new RefreshTimer() {
			
			@Override
			public void exec() {
				rpcService.getResourceManagerStateFromRestService(sessionId, new AsyncCallback<ResourceManagerState>() {
					
					@Override
					public void onSuccess(ResourceManagerState result) {
						display.setState(result);
						
					}
					
					@Override
					public void onFailure(Throwable caught) {
						display.setEmptyMessage("Can't retrieve state");
						cancel();
					}
				});
				
			}
		};
		timer.scheduleRepeating(1000);
		
	}

	/* (non-Javadoc)
	 * @see org.ow2.proactive_grid_cloud_portal.client.presenter.Presenter#go(com.google.gwt.user.client.ui.HasWidgets)
	 */
	@Override
	public void go(HasWidgets container) {
	    container.clear();
	    container.add(display.asWidget());

	}

	/* (non-Javadoc)
	 * @see org.ow2.proactive_grid_cloud_portal.client.presenter.StatePresenter#retrieveSate()
	 */
	
	@Override
	public void retrieveSate() {
		
		rpcService.getResourceManagerStateFromRestService(sessionId, new AsyncCallback<ResourceManagerState>() {
			
			@Override
			public void onSuccess(ResourceManagerState result) {

				display.setState(result);
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				display.setEmptyMessage("Can't retrieve state");
				
			}
		});

	}
	

}
