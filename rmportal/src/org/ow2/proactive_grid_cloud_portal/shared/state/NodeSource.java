package org.ow2.proactive_grid_cloud_portal.shared.state;

import java.io.Serializable;

public class NodeSource implements Serializable {

	private String sourceName;
	private String sourceDescription;
	private String nodeSourceProvider;
	private String timeStamp;
	private String eventType;
	private String rmurl;
	private String timeStampFormatted;
	/**
	 * @param sourceName
	 * @param sourceDescription
	 * @param nodeSourceProvider
	 * @param timeStamp
	 * @param eventType
	 * @param rmurl
	 * @param timeStampFormatted
	 */
	public NodeSource(String sourceName, String sourceDescription, String nodeSourceProvider, String timeStamp, String eventType, String rmurl, String timeStampFormatted) {
		super();
		this.sourceName = sourceName;
		this.sourceDescription = sourceDescription;
		this.nodeSourceProvider = nodeSourceProvider;
		this.timeStamp = timeStamp;
		this.eventType = eventType;
		this.rmurl = rmurl;
		this.timeStampFormatted = timeStampFormatted;
	}
	/**
	 * @return the sourceName
	 */
	public String getSourceName() {
		return sourceName;
	}
	/**
	 * @param sourceName the sourceName to set
	 */
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	/**
	 * @return the sourceDescription
	 */
	public String getSourceDescription() {
		return sourceDescription;
	}
	/**
	 * @param sourceDescription the sourceDescription to set
	 */
	public void setSourceDescription(String sourceDescription) {
		this.sourceDescription = sourceDescription;
	}
	/**
	 * @return the nodeSourceProvider
	 */
	public String getNodeSourceProvider() {
		return nodeSourceProvider;
	}
	/**
	 * @param nodeSourceProvider the nodeSourceProvider to set
	 */
	public void setNodeSourceProvider(String nodeSourceProvider) {
		this.nodeSourceProvider = nodeSourceProvider;
	}
	/**
	 * @return the timeStamp
	 */
	public String getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	/**
	 * @return the eventType
	 */
	public String getEventType() {
		return eventType;
	}
	/**
	 * @param eventType the eventType to set
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	/**
	 * @return the rmurl
	 */
	public String getRmurl() {
		return rmurl;
	}
	/**
	 * @param rmurl the rmurl to set
	 */
	public void setRmurl(String rmurl) {
		this.rmurl = rmurl;
	}
	/**
	 * @return the timeStampFormatted
	 */
	public String getTimeStampFormatted() {
		return timeStampFormatted;
	}
	/**
	 * @param timeStampFormatted the timeStampFormatted to set
	 */
	public void setTimeStampFormatted(String timeStampFormatted) {
		this.timeStampFormatted = timeStampFormatted;
	}

	

	
	
}
