package org.ow2.proactive_grid_cloud_portal.shared.exception;

import org.ow2.proactive_grid_cloud_portal.shared.property.Properties;
import org.ow2.proactive_grid_cloud_portal.shared.User;


/**
 * @author ffonteno
 * 
 * Exception raised when a problem occurs while creating the Scheduler service
 */
public class ServiceCreationException extends SchedulerServiceException {

	private static final String MESSAGE = 
		"Exception occured while trying to create the Scheduler service" +
		"for communication with the scheduler throught the REST service located at" 
		+ Properties.REST_URL;
	
	public ServiceCreationException() {
        super(MESSAGE);
	}

    public ServiceCreationException(User user) {
        super(user);
    }

    public ServiceCreationException(User user, String message) {
        super(user, MESSAGE);
    }

    public ServiceCreationException(User user, String message, Throwable cause) {
    	super(user, MESSAGE, cause);
    }

    public ServiceCreationException(User user, Throwable cause) {
    	super(user, MESSAGE, cause);
    }
		
}
