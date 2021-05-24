/*******************************************************************************
 * Copyright (c) 2021 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Jan Belle (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.ide.modelpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;

/**
 * Helper class to parse modelpath description files.
 */
public class ModelPathDescriptionLexer {
	
	public static final String MODELPATH_KEYWORD_SRCDIR = "srcDir";
	public static final String MODELPATH_KEYWORD_PROJECT = "project";
	
	private static final Pattern ENTRY_PATTERN = Pattern.compile("^\\s*(?<key>\\S+)\\s*(?<value>.*?)\\s*$");
	
	/**
	 * Parses the entries of a modelpath description file.
	 * 
	 * @param input input stream to read from
	 * @return all parsed modelpath description entries
	 * 
	 * @throws IOException if an io exception occurs
	 */	
	public static List<ModelPathDescriptionEntry> read(InputStream input) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		List<ModelPathDescriptionEntry> entries = new ArrayList<>();
		int lineNumber = 0;
		for(String line = reader.readLine(); line != null; line = reader.readLine()) {
			// Remove comment
			int index = line.indexOf("//");
			if(index != -1) {
				line = line.substring(0, index);
			}
			// Parse key and value
			Matcher matcher = ENTRY_PATTERN.matcher(line);
			if(matcher.matches()) {
				ModelPathDescriptionEntry entry = new ModelPathDescriptionEntry(
					matcher.group("key"), matcher.group("value"),
					lineNumber, matcher.start("key"), matcher.start("value"));
				entries.add(entry);
					
			}
			lineNumber++;
		}
		return entries;
	}
	
	/** Represents an entry in a modelpath description file */
	public static class ModelPathDescriptionEntry {
		public final String key;
		public final String value;
		public final int lineNumber;
		public final int keyStart;
		public final int valueStart;
		
		private ModelPathDescriptionEntry(String key, String value, int lineNumber, int keyStart, int valueStart) {
			this.key = key;
			this.value = value;
			this.lineNumber = lineNumber;
			this.keyStart = keyStart;
			this.valueStart = valueStart;
		}
		
		public Range getRange() {
			return new Range(new Position(lineNumber, keyStart), new Position(lineNumber, valueStart + value.length()));
		}
		
		public Range getKeyRange() {
			return new Range(new Position(lineNumber, keyStart), new Position(lineNumber, keyStart + key.length()));
		}
		
		public Range getValueRange() {
			return new Range(new Position(lineNumber, valueStart), new Position(lineNumber, valueStart + value.length()));
		}
	}
}