package org.ow2.proactive_grid_cloud_portal.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response.Status;

import net.sourceforge.htmlunit.corejs.javascript.ast.ForInLoop;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;
import org.ow2.proactive_grid_cloud_portal.client.ResourceManagerService;
import org.ow2.proactive_grid_cloud_portal.shared.User;
import org.ow2.proactive_grid_cloud_portal.shared.exception.LoginException;
import org.ow2.proactive_grid_cloud_portal.shared.exception.LogoutException;
import org.ow2.proactive_grid_cloud_portal.shared.exception.ServiceCreationException;
import org.ow2.proactive_grid_cloud_portal.shared.property.Properties;
import org.ow2.proactive_grid_cloud_portal.shared.state.MonitoredEvents;
import org.ow2.proactive_grid_cloud_portal.shared.state.NodeEvents;
import org.ow2.proactive_grid_cloud_portal.shared.state.NodeSource;
import org.ow2.proactive_grid_cloud_portal.shared.state.ResourceManagerState;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class ResourceManagerServiceImpl extends RemoteServiceServlet implements ResourceManagerService {

	// /**
	// * Map of all jobs. The key String is the job Id
	// */
	// private static JobBag jobs;
	//
	// /**
	// * Map of jobs to be updated to the user identified by his session id. The
	// key String is the session Id
	// */
	// private static Map<String, JobBag> updates;

	/**
	 * Map of connected users. The key String is the session Id
	 */
	public static Map<String, User> users = new HashMap<String, User>();

	/**
	 * REST client used for request the Scheduler REST service.
	 */
	private final RestClient client;

	/**
	 * Creates the service and begins the job synchronization with the scheduler
	 * 
	 * @throws ServiceCreationException
	 */
	public ResourceManagerServiceImpl() throws ServiceCreationException {
		super();

		// Loads the properties
		loadProperties();

		User user = new User("admin", "admin");
		this.client = ProxyFactory.create(RestClient.class, Properties.REST_URL.getValueAsString());

	}

	/**
	 * Loads properties defined in JVM arguments.
	 */
	private void loadProperties() {
		for (Properties property : Properties.values()) {
			String propertyValue = System.getProperty(property.getName());
			if (propertyValue != null)
				property.setValue(propertyValue);
		}
	}

	public String login(User user) throws LoginException {
		synchronized (client) {

			ClientResponse<String> clientResponse = client.loginRM(user.getUsername(), user.getPassword());
			Log.info("login request sent to rest client");
			try {

				Status status = clientResponse.getResponseStatus();
				String response = clientResponse.getEntity();

				switch (status) {
				case OK:
					user.setSessionId(response);
					ResourceManagerServiceImpl.users.put(response, user);

					// if
					// (Properties.SERVER_JOBS_SYNCHRONIZATION.getValueAsBoolean())
					// {
					// ResourceManagerServiceImpl.updates.put(response, new
					// JobBagImpl());
					// }
					break;
				default:
					throw new LoginException(user, "[status = " + status + ", response = " + response + "]");
				}

				return response;
			} finally {
				clientResponse.releaseConnection();
			}
		}
	}

	public void logout(String sessionId) throws LogoutException {

		// TODO Calls the REST service to logout from the Scheduler

		User user = ResourceManagerServiceImpl.users.get(sessionId);
		if (user == null) {
			user = new User();
			user.setUsername("NullUser");
			user.setSessionId(sessionId);
			throw new LogoutException(user);
		}
		ResourceManagerServiceImpl.users.remove(sessionId);

	}

	/**
	 * The method used for returning the InputStream given in a String form.
	 * 
	 * @param inputStream
	 *            the InputStream
	 * @return the InputStream in a String representation
	 * @throws IOException
	 */
	private String convertToString(InputStream inputStream) throws IOException {
		StringBuilder sb = new StringBuilder();
		String line;

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(inputStream));

			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (reader != null)
				reader.close();
		}
		return sb.toString();
	}

	public User getUser(String sessionId) {

		// Should be placed somewhere else.
		// if (Properties.SERVER_JOBS_SYNCHRONIZATION.getValueAsBoolean())
		// ResourceManagerServiceImpl.updates.get(sessionId).empty();

		return ResourceManagerServiceImpl.users.get(sessionId);
	}

	public ResourceManagerState getResourceManagerStateFromRestService(String sessionId) throws Exception {
		Log.info("retriving state as jsonObject with id: " + sessionId);
		ResourceManagerState state = null;

		synchronized (client) {
			ClientResponse<InputStream> clientResponse = client.state(sessionId);
			Status status = clientResponse.getResponseStatus();
			InputStream response = clientResponse.getEntity();

			try {
				switch (status) {
				case OK:
					if (response != null) {
						state = parseState(convertToString(response));
					}
					break;
				default:
					throw new Exception("Cant get state from rest");
					// /TODO: create appropriate exception
				}

			} catch (Exception e) {
				// throw new GettingJobException();
				Log.info(e.getMessage());
			} finally {
				clientResponse.releaseConnection();
				if (response != null) {
					try {
						response.close();
					} catch (IOException e) {
						// throw new GettingJobException();
					}
				}
			}
		}
		return state;
	}

	private ResourceManagerState parseState(String jsonString) throws JSONException {

		JSONObject jsonStateObject = new JSONObject(jsonString);

		JSONObject numberofAllResourcesObject = jsonStateObject.getJSONObject("numberOfAllResources");
		JSONObject numberOfFreeResourcesObject = jsonStateObject.getJSONObject("numberOfFreeResources");
		int numberofAllResources = numberofAllResourcesObject.getInt("value");
		int numberOfFreeResources = numberOfFreeResourcesObject.getInt("value");
		int freeNodesNumber = jsonStateObject.getInt("freeNodesNumber");
		int totalAliveNodesNumber = jsonStateObject.getInt("totalAliveNodesNumber");
		int totalNodesNumber = jsonStateObject.getInt("totalNodesNumber");

		return new ResourceManagerState(numberofAllResources, numberOfFreeResources, freeNodesNumber, totalAliveNodesNumber, totalNodesNumber);
	}

	private MonitoredEvents getMonitoredEventsFromJson(String jsonString) throws JSONException {

		JSONObject jsonMonitoredEventsObject = new JSONObject(jsonString);
		JSONArray jsonNodeEventsArray = jsonMonitoredEventsObject.getJSONArray("nodesEvents");
		JSONArray jsonNodeSourceArray = jsonMonitoredEventsObject.getJSONArray("nodeSource");
		
		MonitoredEvents monitoredEvents= new MonitoredEvents(); 
		
		for (int i = 0; i < jsonNodeEventsArray.length(); i++) {
			NodeEvents nodeEvent = parseNodeEvents(jsonNodeEventsArray.getJSONObject(i));
			monitoredEvents.getNodeEvents().add(nodeEvent);
		}
		
		return monitoredEvents;
	}
	public static NodeEvents parseNodeEvents(JSONObject jsonNodeEvents) throws JSONException {

		String hostName = jsonNodeEvents.getString("hostName");
		String nodeSource = jsonNodeEvents.getString("nodeSource");
		String nodeUrl = jsonNodeEvents.getString("nodeUrl");
		String padname = jsonNodeEvents.getString("padname");
		String vnName = jsonNodeEvents.getString("vnName");
		String vmname = jsonNodeEvents.getString("vmname");
		String nodeState = jsonNodeEvents.getString("nodeState");
		String previousNodeState = jsonNodeEvents.getString("previousNodeState");
		String nodeProvider = jsonNodeEvents.getString("nodeProvider");
		String nodeOwner = jsonNodeEvents.getString("nodeOwner");
		String timeStamp = jsonNodeEvents.getString("timeStamp");
		String eventType = jsonNodeEvents.getString("eventType");
		String rmurl = jsonNodeEvents.getString("rmurl");
		String timeStampFormatted = jsonNodeEvents.getString("timeStampFormatted");

		return new NodeEvents(hostName, nodeSource, nodeUrl, padname, vnName, vmname, nodeState, previousNodeState, nodeProvider, nodeOwner, timeStamp, eventType, rmurl, timeStampFormatted);
	}

	public static NodeSource parseNodeSource(JSONObject jsonNodeEvents) throws JSONException {

		String sourceName = jsonNodeEvents.getString("sourceName");
		String sourceDescription = jsonNodeEvents.getString("sourceDescription");
		String nodeSourceProvider = jsonNodeEvents.getString("nodeSourceProvider");
		String timeStamp = jsonNodeEvents.getString("timeStamp");
		String eventType = jsonNodeEvents.getString("eventType");
		String rmurl = jsonNodeEvents.getString("rmurl");
		String timeStampFormatted = jsonNodeEvents.getString("timeStampFormatted");

		return new NodeSource(sourceName, sourceDescription, nodeSourceProvider, timeStamp, eventType, rmurl, timeStampFormatted);

	}

}
