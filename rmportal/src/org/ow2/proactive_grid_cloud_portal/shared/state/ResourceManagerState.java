/**
 * 
 */
package org.ow2.proactive_grid_cloud_portal.shared.state;

import java.io.Serializable;

/**
 * @author naumanbadar
 *
 */
public class ResourceManagerState implements Serializable {
	int numberOfAllResources;
	int numberOfFreeResources;
	int freeNodesNumber;
	int totalAliveNodesNumber;
	int totalNodesNumber;
	
	public ResourceManagerState() {

	}
	/**
	 * @param numberOfAllResources
	 * @param numberOfFreeResources
	 * @param freeNodesNumber
	 * @param totalAliveNodesNumber
	 * @param totalNodesNumber
	 */
	public ResourceManagerState(int numberOfAllResources, int numberOfFreeResources, int freeNodesNumber, int totalAliveNodesNumber, int totalNodesNumber) {
		super();
		this.numberOfAllResources = numberOfAllResources;
		this.numberOfFreeResources = numberOfFreeResources;
		this.freeNodesNumber = freeNodesNumber;
		this.totalAliveNodesNumber = totalAliveNodesNumber;
		this.totalNodesNumber = totalNodesNumber;
	}
	/**
	 * @return the numberOfAllResources
	 */
	public int getNumberOfAllResources() {
		return numberOfAllResources;
	}
	/**
	 * @param numberOfAllResources the numberOfAllResources to set
	 */
	public void setNumberOfAllResources(int numberOfAllResources) {
		this.numberOfAllResources = numberOfAllResources;
	}
	/**
	 * @return the numberOfFreeResources
	 */
	public int getNumberOfFreeResources() {
		return numberOfFreeResources;
	}
	/**
	 * @param numberOfFreeResources the numberOfFreeResources to set
	 */
	public void setNumberOfFreeResources(int numberOfFreeResources) {
		this.numberOfFreeResources = numberOfFreeResources;
	}
	/**
	 * @return the freeNodesNumber
	 */
	public int getFreeNodesNumber() {
		return freeNodesNumber;
	}
	/**
	 * @param freeNodesNumber the freeNodesNumber to set
	 */
	public void setFreeNodesNumber(int freeNodesNumber) {
		this.freeNodesNumber = freeNodesNumber;
	}
	/**
	 * @return the totalAliveNodesNumber
	 */
	public int getTotalAliveNodesNumber() {
		return totalAliveNodesNumber;
	}
	/**
	 * @param totalAliveNodesNumber the totalAliveNodesNumber to set
	 */
	public void setTotalAliveNodesNumber(int totalAliveNodesNumber) {
		this.totalAliveNodesNumber = totalAliveNodesNumber;
	}
	/**
	 * @return the totalNodesNumber
	 */
	public int getTotalNodesNumber() {
		return totalNodesNumber;
	}
	/**
	 * @param totalNodesNumber the totalNodesNumber to set
	 */
	public void setTotalNodesNumber(int totalNodesNumber) {
		this.totalNodesNumber = totalNodesNumber;
	}
	
	
}
