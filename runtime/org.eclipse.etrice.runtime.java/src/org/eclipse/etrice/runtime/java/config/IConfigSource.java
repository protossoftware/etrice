package org.eclipse.etrice.runtime.java.config;

import java.util.Map;

public interface IConfigSource {
	
	/**
	 * Polling interval [ms] <br>
	 * default case use <= 0
	 */
	public int getPolling();
	
	public Map<String, String> getValues();
	
	
}
