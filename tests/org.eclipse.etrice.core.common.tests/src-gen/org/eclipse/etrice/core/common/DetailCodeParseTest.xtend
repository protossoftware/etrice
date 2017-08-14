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

package org.eclipse.etrice.core.common

import com.google.inject.Inject
import org.eclipse.etrice.core.common.converter.BaseConverterService
import org.eclipse.etrice.core.common.converter.CC_StringConverter
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.util.Strings
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(BaseTestInjectorProvider)
class DetailCodeParseTest {

	val NL = Strings.newLine
	val DELIM = CC_StringConverter.DELIM

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
		]

		'text' + NL => [ text |
			assertEquals('text' + NL, toValue(text))
			assertEquals('''text
			'''.toString, toValue(text))
		]

		' text\t' + NL => [ text |

			assertEquals(' text\t' + NL, toValue(text))
			assertEquals(''' text	
			'''.toString, toValue(text))
		]

		'text' + NL + '\t' => [ text |
			assertEquals('text' + NL, toValue(text))
			assertEquals('''text
			'''.toString, toValue(text))
		]

		NL + 'text ' => [ text |
			assertEquals('text ', toValue(text))
			assertEquals('''
			text '''.toString, toValue(text))
		]

		' ' + NL + 'text' => [ text |
			assertEquals('text', toValue(text))
			assertEquals(''' 
			text'''.toString, toValue(text))
		]

		NL + ' text ' => [ text |
			assertEquals('text ', toValue(text))
			assertEquals('''
			text '''.toString, toValue(text))
		]

	}

	@Test
	def void twoLineBreaks() {
		NL + NL => [ text |
			assertEquals(NL, toValue(text))
			assertEquals('''

			'''.toString, toValue(text))
		]

		'text' + NL + NL => [ text |
			assertEquals('text' + NL + NL, toValue(text))
			assertEquals('''text

			'''.toString, toValue(text))
		]
		
		'text' + NL + '\t\t\t\tindent' + NL => [ text |
			assertEquals('text' + NL + '\t\t\t\tindent' + NL, toValue(text))
			assertEquals('''text
				indent
			'''.toString, toValue(text))
		]

		NL + 'text' + NL => [ text |
			assertEquals('text' + NL, toValue(text))
			assertEquals('''
text
			'''.toString, toValue(text))
		]

		NL + '\t\t\t\ttext\t' + NL => [ text |
			assertEquals('text\t' + NL, toValue(text))
			assertEquals('''
				text	
			'''.toString, toValue(text))
		]
		
		NL + 'text' + NL + 'text2 ' => [ text |
			assertEquals('text' + NL + 'text2 ', toValue(text))
			assertEquals('''
				text
				text2 '''.toString, toValue(text))
		]
		
		NL + '\ttext' + NL + 'text2 ' => [ text |
			assertEquals('\ttext' + NL + 'text2 ', toValue(text))
			assertEquals('''
				text
			text2 '''.toString, toValue(text))
		]
		
		NL + 'text' + NL + '\t\t\tindent' => [ text |
			assertEquals('text' + NL + '\t\t\tindent', toValue(text))
			assertEquals('''
text
			indent'''.toString, toValue(text))
		]
	}
	
	@Test
	def void multiLineBreaks() {		
		NL + '\t\t\t   ' + NL + NL + '\t\t ' + NL + '\t\t\ttext' + NL => [ text |
			assertEquals('   ' + NL + NL + '\t\t ' + NL + 'text' + NL, toValue(text))
			assertEquals('''
			   
			
		 
			text
			'''.toString, toValue(text))
		]
	}

}
