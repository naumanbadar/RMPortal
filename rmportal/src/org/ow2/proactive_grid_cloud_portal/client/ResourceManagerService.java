package org.ow2.proactive_grid_cloud_portal.client;

import org.ow2.proactive_grid_cloud_portal.shared.User;
import org.ow2.proactive_grid_cloud_portal.shared.exception.LoginException;
import org.ow2.proactive_grid_cloud_portal.shared.exception.LogoutException;
import org.ow2.proactive_grid_cloud_portal.shared.state.ResourceManagerState;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service in which there are listed all the RPC methods.
 */
@RemoteServiceRelativePath("scheduler")
public interface ResourceManagerService extends RemoteService {

	/**
	 * Login to the scheduler.
	 * 
	 * @param user the user object that is used for login to the scheduler.
	 * @return The session Id of the user
	 * @throws LoginException
	 */
	String login(User user) throws LoginException;
	
	/**
	 * Logout from the scheduler.
	 * 
	 * @param sessionId the user session id used to logout from the scheduler.
	 * @throws LoginException
	 */
	void logout(String sessionId) throws LogoutException;
	
	/**
	 * Get the user that is logged in.
	 * 
	 * @param sessionId The user session id
	 * @return The user that is logged in.
	 */
	User getUser(String sessionId);
	

	ResourceManagerState getResourceManagerStateFromRestService(String sessionId) throws Exception;
}
