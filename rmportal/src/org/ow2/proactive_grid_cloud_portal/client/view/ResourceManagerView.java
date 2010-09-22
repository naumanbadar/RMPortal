package org.ow2.proactive_grid_cloud_portal.client.view;


import org.ow2.proactive_grid_cloud_portal.client.presenter.ResourceManagerPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ResourceManagerView extends AbstractView<ResourceManagerPresenter> implements ResourceManagerPresenter.Display{
	private static ResourceManagerView_UiBinder uiBinder = GWT.create(ResourceManagerView_UiBinder.class);
	
	@UiField Label userName; 
//	@UiField FlowPanel pageContent;
	@UiField Button disconnectButton;
//	@UiField SchedulerOperationView schedulerOpView;
	@UiField StateView stateView;
	
	@UiTemplate("ResourceManagerView.ui.xml")
	interface ResourceManagerView_UiBinder extends UiBinder<Widget, ResourceManagerView> {}

	/**
	 * Creates a new instance of the ResourceManagerView.
	 */
	public ResourceManagerView(){
		initWidget(uiBinder.createAndBindUi(this));
	}


	public void setUsername(String userName) {
		this.userName.setText("You are connected as "+userName);		
	}
	
	
	public HasClickHandlers getLogoutButton() {
		return this.disconnectButton;
	}
	
	@UiHandler("disconnectButton")
	void onLogoutButton(ClickEvent event){
		if (presenter!=null){
			presenter.doLogout();
		}
	}

	@Override
	public StateView getStateView() {
		return stateView;
	}
	
}
