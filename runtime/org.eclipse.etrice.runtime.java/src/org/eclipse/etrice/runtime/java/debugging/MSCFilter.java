/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 *******************************************************************************/


package org.eclipse.etrice.runtime.java.debugging;

import java.util.ArrayList;

/**
 * @author Thomas Schuetz
 *
 * Simple filtering that can be applied to MSCLogger to make the MSCs 
 * 
 * TODO: this is only a temporary solution for the current file based MSCLogger 
 */

public class MSCFilter {

	public MSCFilter() {
		filterList = new ArrayList<FilterItem>();
	}
	
	
	public void addFilter(FilterItem filter){
		filterList.add(filter);
	}

	public boolean applyTo(String text){
		if (filterList.isEmpty())
			return true; // no filters -> all messages will be logged
		for (FilterItem item : filterList){
			if (text.startsWith(item.filter))
				return !item.exclude;
		}
		return false;
	}

	public String reduceString(String string){
		if (filterList.size()==1)
			return string.replaceFirst(filterList.get(0).filter, "");
		else 
			return string;
	}
	
	private ArrayList<FilterItem> filterList= null;

	public static class FilterItem{
		private boolean exclude = false;
		private String filter = null;
		public FilterItem(String filter, boolean exclude) {
			super();
			this.exclude = exclude;
			this.filter = filter;
		}
	}
	
}
