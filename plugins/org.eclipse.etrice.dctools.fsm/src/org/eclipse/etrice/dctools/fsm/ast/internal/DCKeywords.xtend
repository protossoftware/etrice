/*******************************************************************************
 * Copyright (c) 2018 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.dctools.fsm.ast.internal

class DCKeywords {
	
	static String[] cKeywords=#[
		"const",
		"unsigned",
		"sizeof",
		"typedef",
		"virtual",
		"struct",
		"union",
		"sizeof",
		"explicit",
		"export",
		"extern",
		"goto",
		"register",
		
		// preprocessor
		"#include",
		"#define",
		"#ifdef",
		"#endif",
		"#if",
		"#else",
		"#ifndef",
		"#undef",
		"#pragma"
	]
	static String[] cppKeywords=#[
		"mutable",
		"friend",
		"inline",
		"typeid",
		"typename",
		"namespace",
		"class",
		"using",
		"template",
		"this",
		
		// exceptions
		"throw",
		"try",
		"catch",
		"new",
		"delete",
		
		// visibility
		"public",
		"private",
		"protected"
	]
	static String[] javaKeywords=#[
		"class",
		"interface",
		"extends",
		"implements",
		"abstract",
		"this",
		"new",
		
		// visibility
		"public",
		"private",
		"protected",

		// exceptions
		"throw",
		"try",
		"catch",
		"final",
		"finally"
	]
	static String[] commonKeywords=#[
		// flow control
		"while",
		"do",
		"for",
		"if",
		"else",
		"break",
		"continue",
		"switch",
		"case",
		"default",
		"static",
		"return",
		
		"volatile",
		
		// types
		"void",
		"int",
		"float",
		"double",
		"short",
		"char",
		"long",
		"signed",
		
		// literals
		"true",
		"false"
	]
	
	static def getCKeywords() {
		(commonKeywords + cKeywords).toList
	}
	
	static def getCppKeywords() {
		(commonKeywords + cKeywords + cppKeywords).toList
	}
	
	static def getJavaKeywords() {
		(commonKeywords + javaKeywords).toList
	}
}
