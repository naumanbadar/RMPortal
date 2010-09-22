package org.ow2.proactive_grid_cloud_portal.client.view;

import org.ow2.proactive_grid_cloud_portal.client.presenter.Presenter;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public abstract class AbstractView<T extends Presenter> extends Composite {

	protected T presenter;
	
	/**
	 * Sets the presenter that handles the business logic of the view.
	 * @param presenter the presenter object
	 */
	public void setPresenter(T presenter) {
		this.presenter = presenter;
	}
	
	/**
	 * Returns the view in form of a GWT widget.
	 * @return the widget
	 */
	public Widget asWidget() {
		return this;
	}
}
