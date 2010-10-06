/**
 * 
 */
package org.ow2.proactive_grid_cloud_portal.shared.state;

import java.io.Serializable;

/**
 * @author naumanbadar
 *
 */
public class NodeEvents implements Serializable {
	
	private String hostName;
	private String nodeSource;          
	private String nodeUrl;             
	private String padname;             
	private String vnName;              
	private String vmname;              
	private String nodeState;           
	private String previousNodeState;   
	private String nodeProvider;        
	private String nodeOwner;           
	private String timeStamp;           
	private String eventType;           
	private String rmurl;               
	private String timeStampFormatted;
	
	public NodeEvents() {}
	
	public NodeEvents(String hostName, String nodeSource, String nodeUrl, String padname, String vnName, String vmname, String nodeState, String previousNodeState, String nodeProvider, String nodeOwner, String timeStamp, String eventType, String rmurl, String timeStampFormatted) {
		super();
		this.hostName = hostName;
		this.nodeSource = nodeSource;
		this.nodeUrl = nodeUrl;
		this.padname = padname;
		this.vnName = vnName;
		this.vmname = vmname;
		this.nodeState = nodeState;
		this.previousNodeState = previousNodeState;
		this.nodeProvider = nodeProvider;
		this.nodeOwner = nodeOwner;
		this.timeStamp = timeStamp;
		this.eventType = eventType;
		this.rmurl = rmurl;
		this.timeStampFormatted = timeStampFormatted;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getNodeSource() {
		return nodeSource;
	}

	public void setNodeSource(String nodeSource) {
		this.nodeSource = nodeSource;
	}

	public String getNodeUrl() {
		return nodeUrl;
	}

	public void setNodeUrl(String nodeUrl) {
		this.nodeUrl = nodeUrl;
	}

	public String getPadname() {
		return padname;
	}

	public void setPadname(String padname) {
		this.padname = padname;
	}

	public String getVnName() {
		return vnName;
	}

	public void setVnName(String vnName) {
		this.vnName = vnName;
	}

	public String getVmname() {
		return vmname;
	}

	public void setVmname(String vmname) {
		this.vmname = vmname;
	}

	public String getNodeState() {
		return nodeState;
	}

	public void setNodeState(String nodeState) {
		this.nodeState = nodeState;
	}

	public String getPreviousNodeState() {
		return previousNodeState;
	}

	public void setPreviousNodeState(String previousNodeState) {
		this.previousNodeState = previousNodeState;
	}

	public String getNodeProvider() {
		return nodeProvider;
	}

	public void setNodeProvider(String nodeProvider) {
		this.nodeProvider = nodeProvider;
	}

	public String getNodeOwner() {
		return nodeOwner;
	}

	public void setNodeOwner(String nodeOwner) {
		this.nodeOwner = nodeOwner;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getRmurl() {
		return rmurl;
	}

	public void setRmurl(String rmurl) {
		this.rmurl = rmurl;
	}

	public String getTimeStampFormatted() {
		return timeStampFormatted;
	}

	public void setTimeStampFormatted(String timeStampFormatted) {
		this.timeStampFormatted = timeStampFormatted;
	}
	
		
	
}
