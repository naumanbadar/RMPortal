package org.ow2.proactive_grid_cloud_portal.shared.exception;

import org.ow2.proactive_grid_cloud_portal.shared.property.Properties;
import org.ow2.proactive_grid_cloud_portal.shared.User;

/**
 * @author ffonteno
 * 
 * Exception raised when a problem occurs during the logout process
 */
public class LogoutException extends SchedulerServiceException {

	private static final String MESSAGE = 
		"Exception occured while trying to to logout from " +
		"the scheduler throught the REST service located at" 
		+ Properties.REST_URL;
	
	public LogoutException() {
        super(MESSAGE);
	}

    public LogoutException(User user) {
        super(user);
    }

    public LogoutException(User user, String message) {
        super(user, MESSAGE);
    }

    public LogoutException(User user, String message, Throwable cause) {
    	super(user, MESSAGE, cause);
    }

    public LogoutException(User user, Throwable cause) {
    	super(user, MESSAGE, cause);
    }
	
}
