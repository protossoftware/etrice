/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Eyrak Paen (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.base.util;

import java.util.Collections;
import java.util.List;

import org.eclipse.etrice.core.common.base.Annotation;
import org.eclipse.etrice.core.common.base.BooleanLiteral;
import org.eclipse.etrice.core.common.base.IntLiteral;
import org.eclipse.etrice.core.common.base.KeyValue;
import org.eclipse.etrice.core.common.base.Literal;
import org.eclipse.etrice.core.common.base.RealLiteral;
import org.eclipse.etrice.core.common.base.StringLiteral;

/**
 * This class provides a convenience methods for eTrice's common base language 
 * elements, such as Annotations and Literals.
 */
public class BaseHelpers {

	/**
	 * <code>true</code> if the named annotation is present in a list of {@link Annotation}s.
	 * 
	 * @param annotations the {@link List List&lt;Annotation>}
	 * @param name the name to be searched
	 * 
	 * @return <code>true</code> if the named annotation is present in a list of {@link Annotation}s
	 */
	public static boolean isAnnotationPresent(List<Annotation> annotations, String name) {
		for (Annotation annotation : annotations) {
			if (annotation.getType().getName().equals(name))
				return true;
		}
		return false;
	}

	/**
	 * Returns a list of the {@link Annotation} attributes of the named annotation of a list of annotations.
	 * Returns an empty list if no such annotation is found.
	 * 
	 * @param annotations the {@link List List&lt;Annotation>}
	 * @param name the name to be searched
	 * 
	 * @return a list of the {@link Annotation} attributes of the named annotation
	 */
	public static List<KeyValue> getAttributes(List<Annotation> annotations, String name) {
		for (Annotation annotation : annotations) {
			if (annotation.getType().getName().equals(name))
				return annotation.getAttributes();
		}
		return Collections.emptyList();
	}

	/**
	 * Searches the annotation attributes of list of annotations for a given name.
	 *  
	 * @param annotations the annotation list
	 * @param name the annotation name
	 * @param key the attribute name
	 * 
	 * @return <code>true</code> if such an attribute is present
	 */
	public static boolean isAttributePresent(List<Annotation> annotations, String name,
			String key) {
				List<KeyValue> attributes = getAttributes(annotations, name);
				for (KeyValue attrib : attributes) {
					if (attrib.getKey().equals(key))
						return true;
				}
				return false;
			}

	/**
	 * Returns the value of an annotation attribute of a list of annotations
	 * 
	 * @param annotations the list of annotations
	 * @param name the annotation name
	 * @param key the attribute name
	 * 
	 * @return the string value of the attribute or an empty string if not found
	 */
	public static String getAttribute(List<Annotation> annotations, String name, String key) {
		List<KeyValue> attributes = getAttributes(annotations, name);
		for (KeyValue attrib : attributes) {
			if (attrib.getKey().equals(key))
				return literalToString(attrib.getValue());
		}
		return "";
	}

	/**
	 * Checks for an annotation whether a named attribute is present
	 * 
	 * @param annotation the annotation
	 * @param key the attribute name
	 * 
	 * @return <code>true</code> if such an attribute is present
	 */
	public static boolean isAttributePresent(Annotation annotation, String key) {
		for (KeyValue attrib : annotation.getAttributes()) {
			if (attrib.getKey().equals(key))
				return true;
		}
		return false;
	}

	/**
	 * Returns the string value of an annotation attribute
	 * 
	 * @param annotation the annotation
	 * @param key the attribute name
	 * 
	 * @return the string value of the attribute or an empty string if not found
	 */
	public static String getAttribute(Annotation annotation, String key) {
		for (KeyValue attrib : annotation.getAttributes()) {
			if (attrib.getKey().equals(key))
				return literalToString(attrib.getValue());
		}
		return "";
	}

	/**
	 * @param l a {@link Literal}
	 * @return a string representation of the literal
	 */
	public static String literalToString(Literal l) {
		if (l instanceof BooleanLiteral) {
			return ((BooleanLiteral) l).isIsTrue()? "true":"false";
		}
		if (l instanceof IntLiteral) {
			return Long.toString(((IntLiteral) l).getValue());
		}
		if (l instanceof RealLiteral) {
			return Double.toString(((RealLiteral)l).getValue());
		}
		if (l instanceof StringLiteral) {
			return ((StringLiteral)l).getValue();
		}
		assert(false): "unexpected sub type";
		return "";
	}

}
