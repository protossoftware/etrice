/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.modelbase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class PathToPeers extends HashMap<String, ArrayList<String>> {
	
	private static final long serialVersionUID = 1L;
	
	public void put(String key, String value) {
		ArrayList<String> list = get(key);
		if (list==null) {
			list = new ArrayList<String>();
			put(key, list);
		}
		list.add(value);
	}
	
	public void put(String key, Collection<String> values) {
		ArrayList<String> list = get(key);
		if (list==null) {
			list = new ArrayList<String>(values);
			put(key, list);
		}
		else
			list.addAll(values);
	}
	
	public void put(String key, String[] values) {
		List<String> list = Arrays.asList(values);
		put(key, list);
	}
	
}