/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.documentation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocumentationMarkup {

	public static final String MARKUP_ASCIIDOC = "asciidoc";
	public static final String MARKUP_HTML = "html";
	
	private static final Pattern MARKUP_PATTERN = Pattern.compile("\\A\\s*\\<\\!\\-\\-\\s*(\\w+)\\s*\\-\\-\\>\\s*");
	
	/**
	 * Determine the markup style of the documentation string. Default is html.
	 * The tag must appear on the first line and must be commented using html, e.g.
	 *  <code>&lt;!-- html --></code> or <code>&lt;!-- asciidoc --></code>
	 * 
	 * @param text not null
	 */
	public static String getMarkupType(String text) {
		Matcher markupMatcher = MARKUP_PATTERN.matcher(text);
		
		String markup = (markupMatcher.find()) ? markupMatcher.group(1) : null;
		if (markup != null && markup.matches("adoc|asciidoc|asciidoctor")) {
			return MARKUP_ASCIIDOC;
		}
		
		return MARKUP_HTML;
	}
	
	/**
	 *  Remove markup tag if present. Also removes surrounding whitespace.
	 *  
	 *  @param text not null
	 */
	public static String trimMarkupTag(String text) {
		Matcher markupMatcher = MARKUP_PATTERN.matcher(text);
		return markupMatcher.replaceFirst("");
	}
		
}
