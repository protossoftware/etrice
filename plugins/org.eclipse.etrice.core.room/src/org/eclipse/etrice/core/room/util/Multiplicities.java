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

package org.eclipse.etrice.core.room.util;

/**
 * This class provides utility functions for calculating with multiplicities of
 * ports and actor references. Multiplicities are represented using an
 * {@code int} where {@code -1} denotes the special multiplicity * that
 * symbolizes any or arbitrary multiplicity. Only non-negative multiplicities
 * and the special * multiplicity are considered valid. Multiplicities can be
 * thought of as the semiring of extended natural numbers.
 */
public class Multiplicities {

	/**
	 * Compares two multiplicities. The multiplicity * is greater than every other
	 * multiplicity except itself.
	 * 
	 * @param m the first multiplicity to be compared
	 * @param n the second multiplicity to be compared
	 * @return a negative integer, zero, or a positive integer as the first argument
	 *         is less than, equal to, or greater than the second
	 * @throws IllegalArgumentException if one of the arguments is not a valid
	 *                                  multiplicity
	 * @see java.util.Comparator#compare(Object, Object)
	 */
	public static int compare(int m, int n) {
		if (m >= 0 && n >= 0)
			return m - n;
		else if (m >= -1 && n >= -1)
			return n - m;
		throw new IllegalArgumentException();
	}

	/**
	 * Sums two multiplicities. The sum is * if at least one of the summands is *.
	 * 
	 * @param m the first summand
	 * @param n the second summand
	 * @return the sum
	 * @throws IllegalArgumentException if one of the arguments is not a valid
	 *                                  multiplicity
	 */
	public static int plus(int m, int n) {
		if (m >= 0 && n >= 0)
			return m + n;
		else if (m >= -1 && n >= -1)
			return -1;
		throw new IllegalArgumentException();
	}

	/**
	 * Subtracts two multiplicities if the subtrahend is less than or equal to the
	 * minuend with respect to the ordering induced by
	 * {@link Multiplicities#compare(int, int)}. The difference is always * if the
	 * minuend is *.
	 * 
	 * @param m the minuend
	 * @param n the subtrahend
	 * @return the difference
	 * @throws IllegalArgumentException if one of the arguments is not a valid
	 *                                  multiplicity or if the subtrahend is greater
	 *                                  than the minuend
	 */
	public static int minus(int m, int n) {
		if (m >= 0 && n >= 0 && m >= n)
			return m - n;
		else if (m == -1 && n >= -1)
			return -1;
		throw new IllegalArgumentException();
	}

	/**
	 * Multiplies two multiplicities. The product is * if at least one of the
	 * factors is * and none of them is zero.
	 * 
	 * @param m the first factor
	 * @param n the second factor
	 * @return the product
	 * @throws IllegalArgumentException if one the arguments is not a valid
	 *                                  multiplicity
	 */
	public static int times(int m, int n) {
		if (m >= 0 && n >= 0)
			return m * n;
		else if (m >= -1 && n >= -1)
			return m == 0 || n == 0 ? 0 : -1;
		throw new IllegalArgumentException();
	}

	/**
	 * Computes the minimum of two multiplicities with respect to the ordering
	 * induced by {@link Multiplicities#compare(int, int)}.
	 * 
	 * @param m first argument
	 * @param n second argument
	 * @return the minimum
	 * @throws IllegalArgumentException if one of the arguments is not a valid
	 *                                  multiplicity
	 */
	public static int minimum(int m, int n) {
		if (m >= 0 && n >= 0)
			return Math.min(m, n);
		else if (m >= -1 && n >= -1)
			return m == -1 ? n : m;
		throw new IllegalArgumentException();
	}

	/**
	 * @param m a multiplicity
	 * @return the string representation of the multiplicity
	 * @throws IllegalArgumentException if the argument is not a valid multiplicity
	 */
	public static String toString(int m) {
		if (m >= 0)
			return Integer.toString(m);
		else if (m == -1)
			return "*";
		throw new IllegalArgumentException();
	}
}
