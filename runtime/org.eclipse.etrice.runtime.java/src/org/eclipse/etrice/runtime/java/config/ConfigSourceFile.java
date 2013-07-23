/*******************************************************************************
 * Copyright (c) 2012 Juergen Haug
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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfigSourceFile implements IConfigSource {

	private final static Pattern pattern = Pattern
			.compile("(\\s*(^|,)\\s*\")(\"|(.*?[^\\\\]\"))");
	private final static int leadingMatchingGroup = 1;

	private long lastRead = Long.MAX_VALUE;
	private String filePath;

	public ConfigSourceFile(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public int getPollingTimer() {
		return 0;
	}

	@Override
	public synchronized Map<String, Object> readValues() {
		Map<String, String> splittedLines = splitLines(readLines());
		Map<String, Object> map = new HashMap<String, Object>(
				splittedLines.size());
		for (Entry<String, String> entry : splittedLines.entrySet())
			try {
				map.put(entry.getKey(), s2o(entry.getValue()));
			} catch (IllegalArgumentException e) {
			}

		return map;
	}

	@Override
	public synchronized void writeValues(Map<String, Object> values) {
		writeValues(values, true);
	}

	@Override
	public synchronized void createConfig(Map<String, Object> values) {
		writeValues(values, false);
	}

	@Override
	public void close() {
	}

	private List<String> readLines() {
		List<String> lines = new ArrayList<String>();
		File file = new File(filePath);
		if (!file.exists())
			return lines;

		try {
			BufferedReader fis = new BufferedReader(new FileReader(file));
			String s = null;
			while ((s = fis.readLine()) != null)
				lines.add(s);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return lines;
	}

	private Map<String, String> splitLines(List<String> lines) {
		Map<String, String> map = new HashMap<String, String>(lines.size());
		for (String l : lines) {
			String[] entry = l.split("=", 2);
			if (entry.length != 2)
				continue;
			String s1 = entry[0].trim();
			String s2 = entry[1].trim();
			if (!s1.isEmpty() && !s2.isEmpty()) {
				if (!(s2.startsWith("{") ^ s2.endsWith("}")))
					map.put(s1, s2);
			}
		}

		return map;
	}

	private void writeValues(Map<String, Object> values, boolean override) {
		File file = new File(filePath);
		try {
			file.createNewFile();
			// do not override changes (e.g. from user)
			if (lastRead < file.lastModified())
				return;
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}

		Map<String, String> writeValues = new HashMap<String, String>();
		for (Entry<String, Object> entry : values.entrySet())
			writeValues.put(entry.getKey(), o2s(entry.getValue()));
		Map<String, String> oldValues = splitLines(readLines());
		if (override) {
			oldValues.putAll(writeValues);
			writeValues = oldValues;
		} else {
			writeValues.putAll(oldValues);
		}

		List<String> sortedKeys = new ArrayList<String>(writeValues.keySet());
		Collections.sort(sortedKeys);

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write("");
			for (String key : sortedKeys) {
				writer.append(key + "=" + writeValues.get(key));
				writer.newLine();
			}
			writer.flush();
			writer.close();
			lastRead = System.currentTimeMillis();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private Object s2o(String string) throws IllegalArgumentException {
		string = string.trim();
		if (!(string.startsWith("{"))) {
			if (string.startsWith("\""))
				return deEscape(string.substring(1, string.length() - 1));
			return string;
		}

		string = string.substring(1, string.length() - 1);
		List<String> array = new ArrayList<String>();
		Matcher matcher = pattern.matcher(string);
		while (matcher.find()) {
			array.add(deEscape(string.substring(matcher.start()
					+ matcher.group(leadingMatchingGroup).length(),
					matcher.end() - 1)));
		}
		if (array.isEmpty()) {
			String[] values = string.split(",");
			for (String v : values)
				array.add(v.trim());
		}

		if (!array.isEmpty())
			return array.toArray(new String[0]);

		throw new IllegalArgumentException();
	}

	private String o2s(Object object) {
		if (!object.getClass().isArray() || object instanceof char[]) {
			if (object instanceof char[] || object instanceof Character
					|| object instanceof String)
				return "\"" + escape(object.toString()) + "\"";
			return object.toString();
		}

		StringBuilder sb = new StringBuilder();
		Object[] objects = (Object[]) object;
		sb.append("{ ");
		for (int i = 0; i < objects.length; i++) {
			if (objects[i] instanceof String)
				sb.append(((i > 0) ? "," : "") + "\""
						+ escape(objects[i].toString()) + "\"");
			else
				sb.append(((i > 0) ? "," : "") + objects[i]);
		}
		sb.append(" }");
		return sb.toString();
	}

	private String escape(String s) {
		String tmp = s.replace("\\", "\\\\");
		return tmp.replace("\"", "\\\"");
	}

	private String deEscape(String s) {
		String tmp = s.replace("\\\\", "\\");
		return tmp.replace("\\\"", "\"");
	}

}
