/*******************************************************************************
 * Copyright (c) 2018 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.dctools.tests

interface TestConstants {
	
	static val TEST_STRING = "\"some test string\""
	static val TEST_C_COMMENT = "/* comment */"
	static val TEST_C_COMMENT2 = "/* comment\n\tnext line */"
	static val TEST_CPP_COMMENT = "// cpp comment"
	static val TEST_EMPTY_ROUND_BRACKET = "()"
	static val TEST_EMPTY_CURLY_BRACKET = "{}"
	static val TEST_EMPTY_SQUARE_BRACKET = "[]"
	static val CONTENTS1 = "/* comment */"
	static val CONTENTS2 = "/* another comment */"
	static val CONTENTS3 = "/* third comment */"
	static val TEST_EMPTY_ROUND_BRACKET_W_CONTENTS1 = "(" + CONTENTS1 + ")"
	static val TEST_NESTED_BRACKETS = "(" + CONTENTS1 + "(" + CONTENTS2 + ")" + CONTENTS3 + ")"
	static val TEST_IDENTIFIER = "someIdentifier_123_name"
	static val TEST_ARRAY_ACCESS = "array[]"
	static val TEST_OPERATION_CALL = "foo()"
	static val TEST_MEMBER_ACCESS = "field.member"
	static val TEST_ARRAY_MEMBER_ACCESS = "field[1+2].member"
	static val TEST_ARRAY_MEMBER_ACCESS_AND_CALL = TEST_ARRAY_MEMBER_ACCESS + ".op()"
	static val TEST_SPACIOUS_ARRAY_MEMBER_ACCESS_AND_CALL = "field [ 1 + 2 ]\n\t. member . op ( )"
	static val TEST_CODE = "DC var = new DC(); port.message(var);"
	static val TEST_CODE1 = "field.member1.member2[3].operation(x+4)"
	static val TEST_CODE2 = '''
			sendPort.ping(x /* comment */);
			ping.ping(1);
			// comment
			int local = 0;
			foo(foo(123+456+x)*2+foo(local));
			/* foo(i) */
			String t = "foo(i)";
		'''
	static val TEST_CODE3 = '''
			int result = 1;
			for (int i=0; i<10; ++i) {
				if (i>=5) {
					result = result * 3;
				}
				result = foo(result*2);
			}
		'''
	
	// incomplete sequences
	static val TEST_UNCLOSED_STRING = "\"the closing quotes are missing"
	static val TEST_UNCLOSED_BRACKETS = "(/* the closing round bracket is missing*/"
	static val TEST_UNCLOSED_NESTED_BRACKETS = "((/* nested */)/* the outer closing round bracket is missing*/"
	static val TEST_INCOMPLETE_FEATURE_CALL = "field.member."
}