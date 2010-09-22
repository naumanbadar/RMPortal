package org.ow2.proactive_grid_cloud_portal.client;

import org.ow2.proactive_grid_cloud_portal.shared.User;
import org.ow2.proactive_grid_cloud_portal.shared.exception.LoginException;
import org.ow2.proactive_grid_cloud_portal.shared.exception.LogoutException;
import org.ow2.proactive_grid_cloud_portal.shared.state.ResourceManagerState;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>SchedulerService</code> that is called from the client-side code.
 */
public interface ResourceManagerServiceAsync {

	/**
	 * Method used for making asynchronous calls to the server for login.
	 * @param user the object that is used for login
	 * @param callback the object used for notifying the caller when the asynchronous call completes.
	 * @throws LoginException
	 */
	void login(User user, AsyncCallback<String> callback) throws LoginException;
	
	/**
	 * Method used for making asynchronous calls to the server for logout.
	 * @param sessionId the sessionId used for logout
	 * @param callback the object used for notifying the caller when the asynchronous call completes.
	 * @throws LogoutException
	 */
	void logout(String sessionId, AsyncCallback<Void> callback) throws LogoutException;
	
	/**
	 * Method used for making asynchronous calls to the server for retrieving the jobs to be updated. 
	 * @param sessionId The user session id
	 * @param callback the object used for notifying the caller when the asynchronous call completes.
	 * @throws GettingJobException 
	 */
//	void getJobs(String sessionId, AsyncCallback<JobBag> callback) throws GettingJobException;
	
	/**
	 * Method used for making asynchronous calls to the server for returning the user that is logged in. 
	 * @param sessionId The user session id 
	 * @param callback the object used for notifying the caller when the asynchronous call completes.
	 */
	void getUser(String sessionId, AsyncCallback<User> callback);

	void getResourceManagerStateFromRestService(String sessionId, AsyncCallback<ResourceManagerState> callback);
}
