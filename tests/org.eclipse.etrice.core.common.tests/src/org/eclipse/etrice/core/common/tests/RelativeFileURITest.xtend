/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.tests

import org.eclipse.emf.common.util.URI
import org.eclipse.etrice.core.common.scoping.RelativeFileURIHandler
import org.junit.Test

import static org.junit.Assert.assertEquals

class RelativeFileURITest {
	// uris copied from 
	// https://github.com/eclipse/emf/blob/master/tests/org.eclipse.emf.test.core/src/org/eclipse/emf/test/core/common/util/URITest.java
	
	val static ABSOLUTE_URLS = #[
		"file:/",
		"file:/bar",
		"file:/bar/",
		"file:/bar/baz",
		"file:/bar/baz/",
		"file:/c:",
		"file:/c:/",
		"file:/c:/bar",
		"file:/c:/bar/",
		"file:/c:/bar/baz",
		"file:/c:/bar/baz/",
		"file://foo",
		"file://foo/",
		"file://foo/bar",
		"file://foo/bar/",
		"file://foo/bar/baz",
		"file://foo/bar/baz/",
		"file://foo/c:",
		"file://foo/c:/",
		"file://foo/c:/bar",
		"file://foo/c:/bar/",
		"file://foo/c:/bar/baz",
		"file://foo/c:/bar/baz/"
	]

	val static RESOLVED_PRESERVE_ABOVE_ROOT_URIS = #["file:/a/../g", "file:/a/../../g"]

	val static RESOLVED_NO_PRESERVE_ABOVE_ROOT_URIS = #["file:/a/g", "file:/a/g/e"]

	val static ENCODED_URIS = #[
		"http://www.eclipse.org/foo",
		"http://server%231.eclipse.org/foo%20bar/baz#toc",
		"myscheme:my%20name",
		"file:/C:/My%20Documents/me/50%25+1.txt"
	]

	// require ResourcePlugin and actual files to test
	val static ENCODED_PLATFORM_PATH_URIS = #[
		"platform:/resource/project/myfile.txt",
		"platform:/resource/My%20Project%20%231/My%20File.txt",
		"platform:/resource/are%20you%20there%3F",
		"platform:/resource/are%20you%20there%3F.txt",
		"platform:/resource"
	]
	
	val static QUERIES = #["", "?q=huh"]
	val static FRAGMENTS = #["", "#toc", "#/a/b/c/d/e/f/g/h/i/j/k/l/m/n/o/p", "#1:2:3"]

	val static TEST_URI = URI.createURI("file:/a/b/c/d")

	def Iterable<URI> allURIs() {
		(ABSOLUTE_URLS + RESOLVED_PRESERVE_ABOVE_ROOT_URIS + RESOLVED_NO_PRESERVE_ABOVE_ROOT_URIS + ENCODED_URIS).map[ uri |
			QUERIES.map[query | FRAGMENTS.map[fragment | uri + query + fragment]]
		].flatten.flatten.map[URI.createURI(it)]
	}
	
	val handler = new RelativeFileURIHandler

	@Test
	def void resolveSelf() {
		allURIs.forEach[ uri |
			handler.baseURI = TEST_URI
			assertEquals(uri, handler.resolve(uri))
		]
	}
	
	@Test
	def void roundtripResolve() {
		allURIs.forEach[ uri |
			handler.baseURI = URI.createURI("file:/a/b/c/d")
			assertEquals(uri, handler.resolve(handler.deresolve(uri)))
		]
	}
	
	@Test
	def void deresolveBaseFile() {
		val testURI = TEST_URI.appendFragment('1:2:3')
		
		handler.baseURI = URI.createURI(RESOLVED_NO_PRESERVE_ABOVE_ROOT_URIS.get(0))
		assertEquals('b/c/d#1:2:3', handler.deresolve(testURI).toString)
		
		handler.baseURI = URI.createURI(RESOLVED_NO_PRESERVE_ABOVE_ROOT_URIS.get(1))
		assertEquals('../b/c/d#1:2:3', handler.deresolve(testURI).toString)
	}
	
	@Test
	def void interDocument() {
		val testURI = TEST_URI.appendFragment('1:2:3')
		
		handler.baseURI = TEST_URI
		assertEquals('#1:2:3', handler.deresolve(testURI).toString)
		
		handler.baseURI = TEST_URI.appendFragment('some')
		assertEquals('#1:2:3', handler.deresolve(testURI).toString)
	}
	
	// TODO add platform uri tests, how ?
}
