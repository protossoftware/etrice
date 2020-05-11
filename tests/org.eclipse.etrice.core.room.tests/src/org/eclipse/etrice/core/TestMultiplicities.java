/*******************************************************************************
 * Copyright (c) 2020 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.core;

import static org.eclipse.etrice.core.room.util.Multiplicities.compare;
import static org.eclipse.etrice.core.room.util.Multiplicities.minimum;
import static org.eclipse.etrice.core.room.util.Multiplicities.minus;
import static org.eclipse.etrice.core.room.util.Multiplicities.plus;
import static org.eclipse.etrice.core.room.util.Multiplicities.times;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestMultiplicities {
	@Test
	public void testCompare() {
		assertTrue(compare(0, 0) == 0);
		assertTrue(compare(1, 0) > 0);
		assertTrue(compare(0, 1) < 0);
		assertTrue(compare(1, 1) == 0);
		assertTrue(compare(2, 1) > 0);
		assertTrue(compare(1, 2) < 0);
		assertTrue(compare(2, 2) == 0);
		assertTrue(compare(100, 23) > 0);
		assertTrue(compare(23, 100) < 0);
		assertTrue(compare(-1, 0) > 0);
		assertTrue(compare(0, -1) < 0);
		assertTrue(compare(1, -1) < 0);
		assertTrue(compare(-1, 1) > 0);
		assertTrue(compare(-1, 2) > 0);
		assertTrue(compare(2, -1) < 0);
		assertTrue(compare(-1, -1) == 0);
	}
	
	@Test
	public void testPlus() {
		assertEquals(0, plus(0, 0));
		assertEquals(1, plus(1, 0));
		assertEquals(1, plus(0, 1));
		assertEquals(2, plus(1, 1));
		assertEquals(3, plus(2, 1));
		assertEquals(3, plus(1, 2));
		assertEquals(4, plus(2, 2));
		assertEquals(123, plus(100, 23));
		assertEquals(123, plus(23, 100));
		assertEquals(-1, plus(-1, 0));
		assertEquals(-1, plus(0, -1));
		assertEquals(-1, plus(1, -1));
		assertEquals(-1, plus(-1, 1));
		assertEquals(-1, plus(-1, 2));
		assertEquals(-1, plus(2, -1));
		assertEquals(-1, plus(-1, -1));
	}
	
	@Test
	public void testMinus() {
		assertEquals(0, minus(0, 0));
		assertEquals(1, minus(1, 0));
		assertEquals(0, minus(1, 1));
		assertEquals(1, minus(2, 1));
		assertEquals(0, minus(2, 2));
		assertEquals(77, minus(100, 23));
		assertEquals(-1, minus(-1, 0));
		assertEquals(-1, minus(-1, 1));
		assertEquals(-1, minus(-1, 2));
		assertEquals(-1, minus(-1, -1));
	}
	
	@Test
	public void testTimes() {
		assertEquals(0, times(0, 0));
		assertEquals(0, times(1, 0));
		assertEquals(0, times(0, 1));
		assertEquals(1, times(1, 1));
		assertEquals(2, times(2, 1));
		assertEquals(2, times(1, 2));
		assertEquals(4, times(2, 2));
		assertEquals(2300, times(100, 23));
		assertEquals(2300, times(23, 100));
		assertEquals(0, times(-1, 0));
		assertEquals(0, times(0, -1));
		assertEquals(-1, times(1, -1));
		assertEquals(-1, times(-1, 1));
		assertEquals(-1, times(-1, 2));
		assertEquals(-1, times(2, -1));
		assertEquals(-1, times(-1, -1));
	}
	
	@Test
	public void testMinimum() {
		assertEquals(0, minimum(0, 0));
		assertEquals(0, minimum(1, 0));
		assertEquals(0, minimum(0, 1));
		assertEquals(1, minimum(1, 1));
		assertEquals(1, minimum(2, 1));
		assertEquals(1, minimum(1, 2));
		assertEquals(2, minimum(2, 2));
		assertEquals(23, minimum(100, 23));
		assertEquals(23, minimum(23, 100));
		assertEquals(0, minimum(-1, 0));
		assertEquals(0, minimum(0, -1));
		assertEquals(1, minimum(1, -1));
		assertEquals(1, minimum(-1, 1));
		assertEquals(2, minimum(-1, 2));
		assertEquals(2, minimum(2, -1));
		assertEquals(-1, minimum(-1, -1));
	}
}
