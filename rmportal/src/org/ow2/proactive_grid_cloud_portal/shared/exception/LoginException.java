package org.ow2.proactive_grid_cloud_portal.shared.exception;

import org.ow2.proactive_grid_cloud_portal.shared.property.Properties;
import org.ow2.proactive_grid_cloud_portal.shared.User;

/**
 * @author ffonteno
 * 
 * Exception raised when a problem occurs during the login process
 */
public class LoginException extends SchedulerServiceException {

	private static final String MESSAGE = 
		"Exception occured while trying to to log on " +
		"the scheduler throught the REST service located at" 
		+ Properties.REST_URL;
	
	public LoginException() {
        super(MESSAGE);
	}

    public LoginException(User user) {
        super(user);
    }

    public LoginException(User user, String message) {
        super(user, MESSAGE);
    }

    public LoginException(User user, String message, Throwable cause) {
    	super(user, MESSAGE, cause);
    }

    public LoginException(User user, Throwable cause) {
    	super(user, MESSAGE, cause);
    }
	
}
