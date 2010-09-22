package org.ow2.proactive_grid_cloud_portal.shared.exception;

import java.io.Serializable;

import org.ow2.proactive_grid_cloud_portal.shared.User;

/**
 * @author ffonteno
 *
 * Super class of exceptions returned by the scheduler service.
 */
@SuppressWarnings("serial")
public abstract class SchedulerServiceException extends Exception implements Serializable {

	private User user;
	
	public SchedulerServiceException() {
        super();
	}
	
	public SchedulerServiceException(String message) {
        super(message);
	}

    public SchedulerServiceException(User user) {
        super("[username = " + user.getUsername() 
        		+ "; sessionId = " + user.getSessionID() + "]");
        this.user = user;
    }

    public SchedulerServiceException(User user, String message) {
        super("[username = " + user.getUsername() 
        		+ "; sessionId = " + user.getSessionID() + "]: " 
        		+ message);
        this.user = user;
    }

    public SchedulerServiceException(User user, String message, Throwable cause) {
    	super("[username = " + user.getUsername() 
        		+ "; sessionId = " + user.getSessionID() + "]: " 
        		+ message, cause);
        this.user = user;
    }

    public SchedulerServiceException(User user, Throwable cause) {
    	super(cause);
        this.user = user;
    }
    
    public User getUser() {
    	return this.user;
    }
}
