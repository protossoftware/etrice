/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.base;

import java.util.ArrayList;
import java.util.List;

/**
 * helper class to associate indices with collection items
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public class Indexed<T> {

	private T value;
	private int index;
	private boolean first;
	private boolean last;

	/**
	 * @return the original item of the collection
	 */
	public T getValue() {
		return value;
	}

	/**
	 * @return the zero based index plus the offset
	 */
	public int getIndex0() {
		return index;
	}

	/**
	 * @return the one based index plus the offset
	 */
	public int getIndex1() {
		return index + 1;
	}

	/**
	 * @return true if this is the first element
	 */
	public boolean isFirst() {
		return first;
	}

	/**
	 * @return true if this is the last element
	 */
	public boolean isLast() {
		return last;
	}

	private Indexed(T value, int index, boolean first, boolean last) {
		super();
		this.value = value;
		this.index = index;
		this.first = first;
		this.last = last;
	}

	/**
	 * @param iterable the initial collection of items
	 * @return an indexed collection of items
	 */
	public static <T> Iterable<Indexed<T>> indexed(Iterable<T> iterable) {
		return indexed(iterable, 0);
	}
	
	/**
	 * @param iterable the initial collection of items
	 * @param offset index0 starts at offset, index1 at offset+1
	 * @return an indexed collection of items
	 */
	public static <T> Iterable<Indexed<T>> indexed(Iterable<T> iterable, int offset) {
		List<T> all = new ArrayList<T>();
		for (T t : iterable) {
			all.add(t);
		}
		List<Indexed<T>> result = new ArrayList<Indexed<T>>();
		int counter = 0;
		for (T e : all) {
			result.add(new Indexed<T>(e, offset+counter, counter == 0, counter == all.size() - 1));
			counter++;
		}
		return result;
	}

}