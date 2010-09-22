package org.ow2.proactive_grid_cloud_portal.client.presenter;

import org.ow2.proactive_grid_cloud_portal.client.ResourceManagerServiceAsync;
import org.ow2.proactive_grid_cloud_portal.client.event.ResourceManagerInitEvent;
import org.ow2.proactive_grid_cloud_portal.shared.User;
import org.ow2.proactive_grid_cloud_portal.shared.exception.LoginException;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * The class that contains the logic for the connect page.
 * @author ahagea
 *
 */
public class LoginPresenterImpl implements LoginPresenter {
	
//	private final SchedulerServiceAsync rpcService;
	private final ResourceManagerServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final Display display;
	
	private User user;
	/**
	 * Creates a new instance of LoginPresenterImpl.
	 * @param rpcService the RPC service
	 * @param eventBus the manager used in handling the events
	 * @param display the interface that is used for binding the presenter and the view
	 */
	public LoginPresenterImpl(ResourceManagerServiceAsync rpcService, HandlerManager eventBus, Display display){
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		this.display.setPresenter(this);
	}
	
	public void go(HasWidgets container) {
	    container.clear();
	    container.add(display.asWidget());
	}
	
	public void doLogin() {
		user = new User(display.getUsername().getValue(), display.getPassword().getValue());
		
		try {
			this.rpcService.login(user, new AsyncCallback<String>() {
				public void onSuccess(String result) {
					Log.info("login successful with sid: "+result);
					display.setMessage("login successful with sid: "+result);
//					display.setErrorMessage("");
					Cookies.setCookie(user.getUsername() + "-sid", result);
					eventBus.fireEvent(new ResourceManagerInitEvent(user.getUsername()));
					
				}
				public void onFailure(Throwable caught) {
					display.setErrorMessage("Authentification error.");
				}
			});
			

		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		display.setMessage("Waiting...");
	}
	

	public void doCancel() {
		History.back();
	}
}
