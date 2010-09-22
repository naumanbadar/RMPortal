package org.ow2.proactive_grid_cloud_portal.client.view;

import org.ow2.proactive_grid_cloud_portal.client.presenter.LoginPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class LoginView extends AbstractView<LoginPresenter> implements LoginPresenter.Display {
	private static LoginView_UiBinder uiBinder = GWT.create(LoginView_UiBinder.class);
	private boolean userTextBoxType = false;
	private boolean passwordTextBoxType = false;
	
	@UiTemplate("LoginView.ui.xml")
	interface LoginView_UiBinder extends UiBinder<Widget, LoginView> {}
	
	@UiField Label messageLabel;
	@UiField TextBox userTextBox;
	@UiField TextBox passwordTextBox;
	@UiField Button okButton;
	/**
	 * Creates a new instance of the LoginView.
	 */
	public LoginView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	/**
	 * Creates a new instance of the LoginView.
	 * 
	 * @param message Message overriding the default "You are not connected message".
	 */
	public LoginView(String message) {
		initWidget(uiBinder.createAndBindUi(this));
		this.messageLabel.setText(message);
	}
	
	public HasClickHandlers getLoginButton() {
		return okButton;
	}
	
	@UiHandler("okButton")
	void onLoginButton(ClickEvent event){
		if (presenter!=null){
			messageLabel.setStyleName("messageLabel");
			presenter.doLogin();
		}
	}
	
	@UiHandler("userTextBox")
	void onUserKeyPressed(KeyPressEvent event) {
		if (presenter != null && KeyCodes.KEY_ENTER == event.getNativeEvent().getKeyCode()) {
			messageLabel.setStyleName("messageLabel");
			presenter.doLogin();
		}
	}
	
	@UiHandler("passwordTextBox")
	void onPasswordKeyPressed(KeyPressEvent event) {
		if (presenter != null && KeyCodes.KEY_ENTER == event.getNativeEvent().getKeyCode()) {
			messageLabel.setStyleName("messageLabel");
			presenter.doLogin();
		}
	}
	
	public HasValue<String> getUsername() {
		return userTextBox;
	}

	public HasValue<String> getPassword() {
		return passwordTextBox;
	}

	public void setMessage(String message) {
		messageLabel.setText(message);
	}

	public void setErrorMessage(String message) {
		messageLabel.setText(message);
		messageLabel.setStyleName("errorLabel");
	}
	
	@UiHandler("userTextBox")
	public void onUserTextBoxClicked(ClickEvent event){
		if (!userTextBoxType){
			userTextBox.setSelectionRange(0, userTextBox.getText().length());
		}
	}
	
	@UiHandler("userTextBox")
	public void onUserTextBoxType(KeyDownEvent event){
		//check if the key that was pressed is not the Tab one
		if (event.getNativeKeyCode() != 9){
			userTextBoxType = true;
			userTextBox.setStyleName("textBoxUsernameAndPassword");
		}
	}
	
	@UiHandler("passwordTextBox")
	public void onPasswordTextBoxClicked(ClickEvent event){
		if (!passwordTextBoxType){
			passwordTextBox.setSelectionRange(0, passwordTextBox.getText().length());
		}
	}
	
	@UiHandler("passwordTextBox")
	public void onPasswordTextBoxType(KeyDownEvent event){
		if (event.getNativeKeyCode() != 9){
			passwordTextBoxType = true;
			passwordTextBox.setStyleName("textBoxUsernameAndPassword");
		}
	}
}
