/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.etunit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import junit.framework.TestCase;

import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class EtUnitTest extends TestCase {
	
	public void doTestExpect(int id) {
		EXPECT_TRUE(id, "EXPECT_TRUE", true);
		EXPECT_FALSE(id, "EXPECT_FALSE", false);

		/* signed integer values */
		EXPECT_EQUAL_INT8(id, "EXPECT_EQUAL_INT8", (byte) -122, (byte) -123);	// produces a failure
		EXPECT_EQUAL_INT16(id, "EXPECT_EQUAL_INT16", (short) -12345, (short) -12345);
		EXPECT_EQUAL_INT32(id, "EXPECT_EQUAL_INT32", -1234567, -1234567);

		/* unsigned integer values */
		EXPECT_EQUAL_UINT8(id, "EXPECT_EQUAL_INT8", (char) 123, (char) 123);
		EXPECT_EQUAL_UINT16(id, "EXPECT_EQUAL_INT16", (short) 12345, (short) 12345);
		EXPECT_EQUAL_UINT32(id, "EXPECT_EQUAL_INT32", 1234567, 1234567);

		/* float values */
		EXPECT_EQUAL_FLOAT32(id, "EXPECT_EQUAL_FLOAT32", 123.456f, 123.456f, 0.0001f);
		EXPECT_EQUAL_FLOAT32(id, "EXPECT_EQUAL_FLOAT32", 123.456f, 123.456f, 0.0001f);

		/* Pointers */
		Integer value = new Integer(123);
		Integer valuePtr = value;

		EXPECT_EQUAL_PTR(id, "EXPECT_EQUAL_PTR", value, valuePtr);
	}
	
	public void doTestOrder(int id) {
		int list[] = {1,2,3,4};
		EXPECT_ORDER_START(id, list, 4);
		EXPECT_ORDER(id, "id=1", 1);
		EXPECT_ORDER(id, "id=2", 2);
		EXPECT_ORDER(id, "id=3", 3);
		EXPECT_ORDER_END(id, "id=4", 4);
	}

	public void testSuite() throws IOException {
		etUnit_open(null, "test.etu");
		etUnit_openTestSuite("TestEtUnit");
		
		int id = etUnit_openTestCase("doTestExpect");
		doTestExpect(id);
		etUnit_closeTestCase(id);
		
		id = etUnit_openTestCase("doTestOrder");
		doTestOrder(id);
		etUnit_closeTestCase(id);
		
		etUnit_closeTestSuite();
		etUnit_close();
		
		FileReader fr = new FileReader("test.etu");
		BufferedReader br = new BufferedReader(fr);
		
		ArrayList<String> lines = new ArrayList<String>();
		String line;
		while ((line=br.readLine())!=null)
			lines.add(line);
		
		assertEquals("#lines in test output", 6, lines.size());
		assertEquals("contents of line 3", "tc fail 1: #-122#-123#org.eclipse.etrice.runtime.java.etunit.EtUnitTest:36#EXPECT_EQUAL_INT8: expected=-122, actual=-123", lines.get(2));
	}
}
