/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.config;

import java.util.Map;

public interface IConfigSource {
	
	/**
	 * Polling interval [ms] <br>
	 * default case use <= 0
	 */
	public int getPolling();
	
	Map<String, Object> readValues();
	
	void writeValues(Map<String, Object> values);
	
	/**
	 * initial call to write values to config, without override of existing entries
	 * @param values
	 */
	void createConfig(Map<String, Object> values);
	
	/**
	 * called at shutdown
	 */
	void close();
}
