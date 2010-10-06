/**
 * 
 */
package org.ow2.proactive_grid_cloud_portal.shared.state;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author naumanbadar
 * 
 */
public class MonitoredEvents implements Serializable {

	private ArrayList<NodeEvents> nodeEvents;
	private ArrayList<NodeSource> nodeSources;

	public MonitoredEvents() {
	}

	/**
	 * @param nodeEvents
	 * @param nodeSources
	 */
	public MonitoredEvents(ArrayList<NodeEvents> nodeEvents, ArrayList<NodeSource> nodeSources) {
		super();
		this.nodeEvents = nodeEvents;
		this.nodeSources = nodeSources;
	}

	/**
	 * @return the nodeEvents
	 */
	public ArrayList<NodeEvents> getNodeEvents() {
		return nodeEvents;
	}

	/**
	 * @param nodeEvents
	 *            the nodeEvents to set
	 */
	public void setNodeEvents(ArrayList<NodeEvents> nodeEvents) {
		this.nodeEvents = nodeEvents;
	}

	/**
	 * @return the nodeSources
	 */
	public ArrayList<NodeSource> getNodeSources() {
		return nodeSources;
	}

	/**
	 * @param nodeSources
	 *            the nodeSources to set
	 */
	public void setNodeSources(ArrayList<NodeSource> nodeSources) {
		this.nodeSources = nodeSources;
	}

}
