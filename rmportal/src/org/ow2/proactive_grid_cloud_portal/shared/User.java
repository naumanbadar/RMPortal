package org.ow2.proactive_grid_cloud_portal.shared;

import java.io.Serializable;

/**
 * Representation for the user business object.
 * 
 * @author ahagea
 */
@SuppressWarnings("serial")
public class User implements Serializable{
	
	private String username;
	private String password;
	private String sessionId;
	
	/**
	 * Empty no-arg constructor
	 */
	public User(){}

	/**
	 * Creates a new instance for the User.
	 * @param username the username
	 * @param password the password
	 */
	public User(String username, String password){
		this.username = username;
		this.password = password;
	}
	/**
	 * Setter for the user name.
	 * @param username the user name that is going to be set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * Getter for the user name.
	 * @return the user name
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * Setter of the user's password.
	 * @param password the password that is going to be set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Getter of the user's password.
	 * @return the user's password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Setter of the user's session id.
	 * @param sessionId
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	/**
	 * Getter for the user's session id.
	 * @return the user's session id
	 */
	public String getSessionID() {
		return sessionId;
	}
	
	public String toString() {
		return "[username = " + this.username + ", " +
			"sessionId = " + this.sessionId + "]";
	}

}
