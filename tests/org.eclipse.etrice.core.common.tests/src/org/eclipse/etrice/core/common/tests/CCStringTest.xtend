/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.core.common.tests

import com.google.inject.Inject
import org.eclipse.etrice.core.common.BaseTestInjectorProvider
import org.eclipse.etrice.core.common.converter.BaseConverterService
import org.eclipse.etrice.core.common.converter.CCStringIndentation
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
//import org.eclipse.xtext.junit4.InjectWith
//import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.util.Strings
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(BaseTestInjectorProvider)
class CCStringTest {

	val JAVA_NL = Strings.newLine
	val CRLF = "\r\n"
	val LF = "\n"
	val CR = "\r"

	val NL = JAVA_NL
	val DELIM = "'''"

	@Inject
	BaseConverterService baseConverterService

	protected def String toValue(String withoutDelim) {	
		baseConverterService.getCC_StringConverter.toValue(withoutDelim, null) => [ convertedWithoutDelim |
			val convertedWithDelim =  baseConverterService.getCC_StringConverter.toValue(DELIM + withoutDelim + DELIM, null)
			assertEquals(convertedWithoutDelim, convertedWithDelim)	
		]	
	}

	@Test
	def void noLineBreak() {
		assertEquals('', toValue(''''''))
		assertEquals(''''''.toString, toValue(''''''))

		assertEquals(' ', toValue(''' '''))
		assertEquals(''' '''.toString, toValue(''' '''))

		assertEquals('\t', toValue('''	'''))
		assertEquals('''	'''.toString, toValue('''	'''))

		assertEquals(' text ', toValue(''' text '''))
		assertEquals(''' text '''.toString, toValue(''' text '''))

		assertEquals("'", toValue("'"))
		assertEquals("''", toValue("''"))
		assertEquals('"', toValue('"'))
		assertTrue(new CCStringIndentation(' \t').hasConsistentIndentation)
	}

	@Test
	def void singleLineBreak() {
		assertEquals('', toValue('\r'))
		assertEquals('', toValue('\r\n'))
		assertEquals('', toValue('\n'))
		assertEquals('''
		'''.toString, toValue(NL))

		'\t' + NL => [ text |
			assertEquals('', toValue(text))
			assertEquals('''	
			'''.toString, toValue(text))
			assertTrue(new CCStringIndentation(text).hasConsistentIndentation)
		]

		'text' + NL => [ text |
			assertEquals('text' + NL, toValue(text))
			assertEquals('''text
			'''.toString, toValue(text))
			assertTrue(new CCStringIndentation(text).hasConsistentIndentation)
		]

		' text\t' + NL => [ text |

			assertEquals(' text\t' + NL, toValue(text))
			assertEquals(''' text	
			'''.toString, toValue(text))
			assertTrue(new CCStringIndentation(text).hasConsistentIndentation)
		]

		'text\\n' + NL + '\t' => [ text |
			assertEquals('text\\n' + NL, toValue(text))
			assertEquals('''text\n
			'''.toString, toValue(text))
			assertTrue(new CCStringIndentation(text).hasConsistentIndentation)
		]

		NL + 'text ' => [ text |
			assertEquals('text ', toValue(text))
			assertEquals('''
			text '''.toString, toValue(text))
			assertTrue(new CCStringIndentation(text).hasConsistentIndentation)
		]

		' ' + NL + 'text' => [ text |
			assertEquals('text', toValue(text))
			assertEquals(''' 
			text'''.toString, toValue(text))
			assertTrue(new CCStringIndentation(text).hasConsistentIndentation)
		]

		NL + ' text ' => [ text |
			assertEquals('text ', toValue(text))
			assertEquals('''
			text '''.toString, toValue(text))
			assertTrue(new CCStringIndentation(text).hasConsistentIndentation)
		]

	}

	@Test
	def void twoLineBreaks() {
		NL + NL => [ text |
			assertEquals(NL, toValue(text))
			assertEquals('''

			'''.toString, toValue(text))
			assertTrue(new CCStringIndentation(text).hasConsistentIndentation)
		]

		'text' + NL + NL => [ text |
			assertEquals('text' + NL + NL, toValue(text))
			assertEquals('''text

			'''.toString, toValue(text))
			assertTrue(new CCStringIndentation(text).hasConsistentIndentation)
		]
		
		'text' + NL + '\t\t\t\tindent' + NL => [ text |
			assertEquals('text' + NL + '\t\t\t\tindent' + NL, toValue(text))
			assertEquals('''text
				indent
			'''.toString, toValue(text))
			assertTrue(new CCStringIndentation(text).hasConsistentIndentation)
		]

		NL + 'text' + NL => [ text |
			assertEquals('text' + NL, toValue(text))
			assertEquals('''
text
			'''.toString, toValue(text))
			assertTrue(new CCStringIndentation(text).hasConsistentIndentation)
		]

		NL + '\t\t\t\ttext\t' + NL => [ text |
			assertEquals('text\t' + NL, toValue(text))
			assertEquals('''
				text	
			'''.toString, toValue(text))
			assertTrue(new CCStringIndentation(text).hasConsistentIndentation)
		]
		
		NL + 'text' + NL + 'text2 ' => [ text |
			assertEquals('text' + NL + 'text2 ', toValue(text))
			assertEquals('''
				text
				text2 '''.toString, toValue(text))
			assertTrue(new CCStringIndentation(text).hasConsistentIndentation)
		]
		
		CRLF + 'text\\r' + LF + 'text2 ' => [ text |
			assertEquals('text\\r' + LF + 'text2 ', toValue(text))
			assertTrue(new CCStringIndentation(text).hasConsistentIndentation)
		]
		
		LF + 'text' + CR + 'text2 ' => [ text |
			assertEquals('text' + CR + 'text2 ', toValue(text))
			assertTrue(new CCStringIndentation(text).hasConsistentIndentation)
		]
		
		LF + 'text' + CRLF + 'text2 ' => [ text |
			assertEquals('text' + CRLF + 'text2 ', toValue(text))
			assertTrue(new CCStringIndentation(text).hasConsistentIndentation)
		]
		
		NL + '\ttext' + NL + 'text2 ' => [ text |
			assertEquals('\ttext' + NL + 'text2 ', toValue(text))
			assertEquals('''
				text
			text2 '''.toString, toValue(text))
			assertTrue(new CCStringIndentation(text).hasConsistentIndentation)
		]
		
		NL + 'text' + NL + '\t\t\tindent' => [ text |
			assertEquals('text' + NL + '\t\t\tindent', toValue(text))
			assertEquals('''
text
			indent'''.toString, toValue(text))
			assertTrue(new CCStringIndentation(text).hasConsistentIndentation)
		]
		
		assertTrue(new CCStringIndentation('\r \r\t\n').hasConsistentIndentation)
		assertFalse(new CCStringIndentation('\r Text\r\tText\n').hasConsistentIndentation)
	}
	
	@Test
	def void multiLineBreaks() {		
		NL + '\t\t\t   ' + NL + NL + '\t\t ' + NL + '\t\t\ttext' + NL => [ text |
			assertEquals('   ' + NL + NL + '\t\t ' + NL + 'text' + NL, toValue(text))
			assertEquals('''
			   
			
					 
			text
			'''.toString, toValue(text))
			assertFalse(new CCStringIndentation(text).hasConsistentIndentation)
		]

	}
	
	@Test
	def void testReplaceEditorIndentation() {
	
		new CCStringIndentation('\r\t\t\tText\r\n\t\t\t\n') => [
			#['\t', ' '].forEach [ indent |
				#[CRLF, LF, CR].forEach [ lineSep |
					val replaced = replaceEditorIndentation(indent, lineSep)
					assertEquals(3, Strings.countLineBreaks(replaced))
					#[CRLF, LF, CR].filter[it != lineSep].forEach [ otherLineSep |
						assertFalse(replaced.matches(otherLineSep))
					]
					assertEquals(-1, replaced.indexOf('\t\t\t'))
					assertTrue(replaced.indexOf(indent) > 0)
				]
			]
		]
		new CCStringIndentation('\r\t\t\tText\r\n\t\t\t\n') => [
			#[CRLF, LF, CR].forEach [ lineSep |
				val replaced = replaceEditorIndentation(null, lineSep)
				assertEquals(3, Strings.countLineBreaks(replaced))
				#[CRLF, LF, CR].filter[it != lineSep].forEach [ otherLineSep |
					assertFalse(replaced.matches(otherLineSep))
				]
				assertTrue(replaced.indexOf('\t\t\t') > 0)
			]
		]
		new CCStringIndentation('\r\t\t\tText\r\n\t\t\t\n') => [
			#['\t', ' '].forEach [ indent |
				val replaced = replaceEditorIndentation(indent, null)
				assertEquals(-1, replaced.indexOf('\t\t\t'))
				assertTrue(replaced.indexOf(indent) > 0)
			]
		]	
		assertEquals('\r\tText\n\r\t\n', new CCStringIndentation('\r\tText\n\r\t\n').replaceEditorIndentation(null, null))
	}

}
