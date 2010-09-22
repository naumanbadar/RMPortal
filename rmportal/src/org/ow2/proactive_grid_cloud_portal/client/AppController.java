package org.ow2.proactive_grid_cloud_portal.client;



import org.ow2.proactive_grid_cloud_portal.client.event.LoginEvent;
import org.ow2.proactive_grid_cloud_portal.client.event.LoginEventHandler;
import org.ow2.proactive_grid_cloud_portal.client.event.ResourceManagerInitEvent;
import org.ow2.proactive_grid_cloud_portal.client.event.ResourceManagerInitEventHandler;
import org.ow2.proactive_grid_cloud_portal.client.history.ItemParser;
import org.ow2.proactive_grid_cloud_portal.client.presenter.LoginPresenterImpl;
import org.ow2.proactive_grid_cloud_portal.client.presenter.Presenter;
import org.ow2.proactive_grid_cloud_portal.client.presenter.ResourceManagerPresenterImpl;
import org.ow2.proactive_grid_cloud_portal.client.view.LoginView;
import org.ow2.proactive_grid_cloud_portal.client.view.ResourceManagerView;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
/**
 * Component used for handling the logic that is not specific to any presenter.
 * @author ahagea
 *
 */
public class AppController implements Presenter, ValueChangeHandler<String>{
	private final HandlerManager eventBus;
//	private final SchedulerServiceAsync rpcService;
	private final ResourceManagerServiceAsync rpcService;
	private HasWidgets container;
	/**
	 * Create a new instance of AppController.
	 * @param rpcService the RPC service
	 * @param eventBus the manager used in handling the events
	 */
	public AppController(ResourceManagerServiceAsync rpcService, HandlerManager eventBus) {
	    this.eventBus = eventBus;
	    this.rpcService = rpcService;
	    bind();
	  }
	/**
	 * Adds handlers for the history and for the events that occur. 
	 */
	private void bind() {
		History.addValueChangeHandler(this);
		
		//add handler for the login event
		eventBus.addHandler(LoginEvent.TYPE, new LoginEventHandler() {
			public void onLogin(LoginEvent event) {
				doLogin();
			}
		});
		
//		//add handler for the logout event
//		eventBus.addHandler(LogoutEvent.TYPE, new LogoutEventHandler() {
//			public void onLogout(LogoutEvent event) {
//				doLogout(event.getCause().getCode());
//			}
//		});
//		
		//add handler for the scheduler initialization
		eventBus.addHandler(ResourceManagerInitEvent.TYPE, new ResourceManagerInitEventHandler() {
			public void init(ResourceManagerInitEvent event) {
				doInitResourceManager(event.getUsername());
			}
		});
	}
	
	/**
	 * Adds a new item in the history for the login event.
	 */
	private void doLogin(){
		History.newItem("login");
	}
	
	/**
	 * Adds a new item in the history for the logout event.
	 */
	private void doLogout(int code){
		History.newItem("logout?code="+code);
	}
	
	/**
	 * Add a new item in the history for the scheduler initialization event.
	 */
	private void doInitResourceManager(String username){
		History.newItem("rmanager?username=" + username);
	}
	
	public void go(HasWidgets container) {
		
		this.container = container;
		
		if ("".equals(History.getToken())) {
			History.newItem("login");
		}else{
			History.fireCurrentHistoryState();
		}
	}
	/**
	 * Adds the logic needed when the "Back" and "Forward" buttons are clicked.
	 */
	public void onValueChange(ValueChangeEvent<String> event) {

		ItemParser itemParser = new ItemParser(event.getValue());
		String token = itemParser.getPath();
	    if (token != null) {
	      Presenter presenter = null;

	      if (token.equals("login")) {
	    	  presenter = new LoginPresenterImpl(rpcService, eventBus, new LoginView());
	      } else if (token.equals("logout")) {
//	    	  String message = LogoutCause.getCause(Integer.parseInt(itemParser.getParameterValue("code"))).getMessage();
//	    	  presenter = new LoginPresenterImpl(rpcService, eventBus, new LoginView(message));
	      } else if (token.equals("rmanager")){
			  String sessionId = Cookies.getCookie(itemParser.getParameterValue("username") + "-sid");
			  if (sessionId == null) {
//				  History.newItem("logout?code="+ LogoutCause.SESSION_EXPIRED);
				  return;
			  }
			  presenter = new ResourceManagerPresenterImpl(rpcService, eventBus, new ResourceManagerView(), sessionId);
	      } else if (token.equals("test")){
	    	  //used for testing how the jobs table look 
	    	  //presenter = new JobPresenterImpl(rpcService, eventBus, new JobsView<Job>(), JobsRowDefinitionsImpl.getInstance());
	    	  //presenter = new SchedulerOperationPresenterImpl(rpcService, eventBus, new SchedulerOperationView());
	    	  //presenter = new JobVisualizationPresenterImpl(rpcService, eventBus, new JobVisualizationView());
	    	 // presenter = new OperationPresenterImpl(rpcService, eventBus, new OperationsView());
	    	  /*JobTableView jtv = new JobTableView(createJobs(10));
	    	  
	    	  //presenter = new JobTablePresenterImpl(rpcService, eventBus, jtv);
	    	  PagingScrollTable<Job> pagingScrollTable = jtv.getScrollTable();
	    	  pagingScrollTable.gotoPage(0, true);
	    	  pagingScrollTable.setHeight("100%");
	    	  pagingScrollTable.setWidth("100%");
	    	  pagingScrollTable.setPageSize(200);
	    	  pagingScrollTable.setTitle("scroll");
	    	  RootLayoutPanel.get().add(pagingScrollTable);*/
	      }
	      
	      if (presenter != null) {
	        presenter.go(container);
	      }
	    }
	}

}
