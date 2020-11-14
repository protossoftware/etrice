
package org.eclipse.etrice.core

import com.google.common.io.CharStreams
import java.io.InputStreamReader
import java.util.Map
import java.util.regex.Pattern
import org.eclipse.core.runtime.FileLocator
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.formatter.FormatterTestHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*
import static org.junit.Assert.assertNotEquals
import org.eclipse.etrice.core.tests.RoomInjectorProvider

@RunWith(XtextRunner)
@InjectWith(RoomInjectorProvider)
class FormatterTest extends FormatterTestHelper {
	
	// does not work with comments or ccstring
	val patterns = #[
		Pattern.compile('''([^\w\s])\s+(\w)'''),
		Pattern.compile('''([^\w\s])\s+([^\w\s])'''),
		Pattern.compile('''(\w)\s+([^\w\s])''')
	]
	
	@Test
	def void unformatEqualsFormat(){
		
		val expectedContents = newArrayList => [contents |
			val entries = CoreTestsActivator.getInstance().getBundle().findEntries("models/formatting/unformatEqualsFormat/", "*.room", false)
			while(entries.hasMoreElements) {
				contents += CharStreams.toString(new InputStreamReader(FileLocator.toFileURL(entries.nextElement).openStream))	
			}
		]
		assertTrue(!expectedContents.empty)
		
		// expectation == format(unformat(expectation))
		val (String) => String unformatter = [content | 
			val unformatted = patterns.fold(content, [replaced, pattern |pattern.matcher(replaced).replaceAll('$1$2')])
			assertNotEquals(content, unformatted)
			unformatted.replace('\r\n', ' ').replace('\n', ' ')
		]
		expectedContents.forEach[expected |
			println(unformatter.apply(expected))
			assertFormatted[
				expectation = expected
				toBeFormatted = unformatter.apply(expected)
			]	
		]	
	}
	
	@Test
	def void testManual(){
		
		val (String) => Map<String, String> collector = [path | 
			val entries = CoreTestsActivator.getInstance().getBundle().findEntries(path, '*.room', false)		
			newHashMap => [contentMap |
				while(entries.hasMoreElements) {
					val entry = entries.nextElement
					val name = URI.createURI(entry.toURI.toString).lastSegment
					contentMap.put(name, CharStreams.toString(new InputStreamReader(FileLocator.toFileURL(entry).openStream)))		
				}
			]
		]
		
		// fileName -> unformattedContent
		val unformattedContents = collector.apply('models/formatting/expected/')
		// fileName -> expectedContent
		val expectedContents = collector.apply('models/formatting/expected/')
		
		assertTrue(!unformattedContents.empty && expectedContents.keySet == unformattedContents.keySet)
		
		// expectedContent == format(unformattedContent)
		expectedContents.keySet.forEach[fileName |
			assertFormatted[
				expectation = expectedContents.get(fileName)
				toBeFormatted = unformattedContents.get(fileName)
			]	
		]	
	}
	

}
