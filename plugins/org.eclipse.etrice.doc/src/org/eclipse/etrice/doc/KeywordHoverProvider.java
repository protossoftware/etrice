/*******************************************************************************
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.doc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class KeywordHoverProvider {

	private static final String CONTENT_DIR;
	static {
		if(ETriceHelp.DEV_MODE)
			CONTENT_DIR = "/feature-gen/keyword-hover/";
		else
			CONTENT_DIR = "/targets/keyword-hover/";
	}
	
	private final Map<String, String> cache = new HashMap<String, String>();

	public String getHTMLContent(String name) {
		if (!ETriceHelp.DEV_MODE && cache.containsKey(name))
			return cache.get(name);

		URL fileURL = ETriceHelp.getDefault().getBundle().getEntry(CONTENT_DIR + name + ".html");
		String result = null;
		if (fileURL != null) {
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new InputStreamReader(fileURL.openStream()));
				StringBuffer buffer = new StringBuffer(1500);
				String line = reader.readLine();
				while (line != null) {
					buffer.append(line);
					buffer.append('\n');
					line = reader.readLine();
				}
				result = buffer.toString();
			}
			catch (IOException ex) {
			}
			finally {
				try {
					if (reader != null)
						reader.close();
				}
				catch (IOException e) {
				}
			}
		}

		cache.put(name, result);
		return result;
	}
}
