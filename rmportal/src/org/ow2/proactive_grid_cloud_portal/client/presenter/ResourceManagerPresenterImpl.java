package org.ow2.proactive_grid_cloud_portal.client.presenter;

import org.ow2.proactive_grid_cloud_portal.client.ResourceManagerServiceAsync;
import org.ow2.proactive_grid_cloud_portal.client.event.LoginEvent;
import org.ow2.proactive_grid_cloud_portal.client.view.ResourceManagerView;
import org.ow2.proactive_grid_cloud_portal.shared.User;
import org.ow2.proactive_grid_cloud_portal.shared.exception.LogoutException;
import org.ow2.proactive_grid_cloud_portal.shared.state.ResourceManagerState;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

/**
 * The class that contains the logic for the scheduler page.
 * @author ahagea
 *
 */
public class ResourceManagerPresenterImpl implements ResourceManagerPresenter {

	private final ResourceManagerServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final Display display;
	private final String sessionId;
	private StatePresenter statePresenter;
//	private final SchedulerOperationPresenter schedulerOperationPresenter;
	
	/**
	 * The class that contains the logic for the Scheduler page.
	 * @param rpcService the RPC service
	 * @param eventBus the manager used in managing the events
	 * @param display the interface that is used for binding the presenter and the view
	 * @param sessionId the session id of the user that is logged in
	 */
	public ResourceManagerPresenterImpl(
			final ResourceManagerServiceAsync rpcService,
			final HandlerManager eventBus,
			final ResourceManagerView display,
			final String sessionId) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		this.display.setPresenter(this);
		
		rpcService.getUser(sessionId, new AsyncCallback<User>() {
			public void onSuccess(User result) {
				setUser(result);
			}
			
			public void onFailure(Throwable caught) {
//				Window.alert("Error retrieving user!");
				eventBus.fireEvent(new LoginEvent());
			}
		});
		
		
		rpcService.getResourceManagerStateFromRestService(sessionId, new AsyncCallback<ResourceManagerState>() {

			public void onSuccess(ResourceManagerState result) {
				Log.info("State retrieved"); ///TODO: set state in the view
				
			}
			
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
		
		statePresenter = new StatePresenterImpl(rpcService, eventBus, this.display.getStateView(), sessionId);
//		this.display.getStateView().getPanel().clear();
//		this.display.getStateView().getPanel().add(this.display.getStateView().getTable());
		
		

		this.sessionId = sessionId;
		//create the logic for the left panel which displays the Visualization options
//		this.schedulerOperationPresenter = new SchedulerOperationPresenterImpl(rpcService, eventBus, display.getSchedulerOperations(), this);
		//create the logic for the panel that contains the table for listing the jobs that exist on the scheduler 
		//JobPresenter<Job> jobPresenter = new JobPresenterImpl(rpcService, eventBus, display.getJobTable(), JobsRowDefinitionsImpl.getInstance(), sessionId);
		
		
	}
	
	/**
	 * Sets the user that is logged in.
	 * @param user The User object.
	 */
	private void setUser(User user){
		display.setUsername(user.getUsername());
	}
	
	public String getSessionId(){
		return this.sessionId;
	}
	
	public void go(HasWidgets container) {
		container.clear();
	    container.add(display.asWidget());
	}
	
	public void doLogout() {
		try {
			this.rpcService.logout(this.sessionId, new AsyncCallback<Void>() {
				public void onSuccess(Void result) {
//					schedulerOperationPresenter.logout();
//					eventBus.fireEvent(new LogoutEvent(LogoutCause.NORMAL));
				}
				public void onFailure(Throwable caught) {
				}
			});
		} catch (LogoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void setContent(Widget w) {
//		display.getContentPage().clear();
//		display.getContentPage().add(w);
	}
}
