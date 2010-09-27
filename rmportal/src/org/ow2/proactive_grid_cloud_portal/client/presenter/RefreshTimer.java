/**
 * 
 */
package org.ow2.proactive_grid_cloud_portal.client.presenter;

import java.sql.Time;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;

/**
 * @author naumanbadar
 *
 */
public abstract class RefreshTimer extends Timer {

	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.Timer#run()
	 */
	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		exec();
		long elaspedTime = System.currentTimeMillis()-startTime;
		Log.info("Time elasped to refresh the statistics "+elaspedTime);
	}
	
	public abstract void exec();

}
