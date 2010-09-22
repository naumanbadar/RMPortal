package org.ow2.proactive_grid_cloud_portal.shared.property;


public enum Properties {
	/**
	 * Url of the REST service
	 */
	REST_URL(new PropertyString("rest.url", "http://localhost:8080/proactive_grid_cloud_portal")),
	
	/**
	 * Refresh time between the client and the server side
	 */
	CLIENT_REFRESH_TIME(new PropertyInteger("client.refresh.time", 2000)),
	
	/**
	 * Refresh time between the client and the server side
	 */
	SERVER_REFRESH_TIME(new PropertyInteger("server.refresh.time", 1000)),
	
	/**
	 * Whether or not you use on the server side a job list synchronized with the scheduler.
	 * If yes, when a client refresh his list of jobs, he only gets the list of the jobs that has to be
	 * updated (not every job).
	 * If no, each time a client refresh his list of jobs, a request to the rest service is send to
	 * get the whole list of jobs. 
	 */
	SERVER_JOBS_SYNCHRONIZATION(new PropertyBoolean("server.jobs.synchronization", true));
	
	
	
	private Property property;
		
	Properties(Property property) {
		this.property = property;
	}
	
	public String getName() {
		return this.property.getName();
	}
	
	public Object getValue() {
		return this.property.getValue();
	}
	
	public String getValueAsString() {
		return this.property.getValueAsString();
	}
	
	public Integer getValueAsInteger() {
		if (!this.property.isOfType(Property.Type.INTEGER ))
			return null;
		
		return (Integer) this.property.getValue();
	}
	
	public Boolean getValueAsBoolean() {
		if (!this.property.isOfType(Property.Type.BOOLEAN ))
			return null;
		
		return (Boolean) this.property.getValue();
	}
	
	public void setValue(String value) {
		this.property.setValue(value);
	}
}
