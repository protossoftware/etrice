/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel.etricegen;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Port Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getPortKind()
 * @model
 * @generated
 */
public enum PortKind implements Enumerator {
	/**
	 * The '<em><b>External</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * It applies to an external end port.
	 * <!-- end-user-doc -->
	 * @see #EXTERNAL_VALUE
	 * @generated
	 * @ordered
	 */
	EXTERNAL(0, "external", "external"),

	/**
	 * The '<em><b>Internal</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * It applies to an internal end port.
	 * <!-- end-user-doc -->
	 * @see #INTERNAL_VALUE
	 * @generated
	 * @ordered
	 */
	INTERNAL(1, "internal", "internal"),

	/**
	 * The '<em><b>Relay</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * It applies to a relay port.
	 * <!-- end-user-doc -->
	 * @see #RELAY_VALUE
	 * @generated
	 * @ordered
	 */
	RELAY(2, "relay", "relay");

	/**
	 * The '<em><b>External</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXTERNAL
	 * @model name="external"
	 * @generated
	 * @ordered
	 */
	public static final int EXTERNAL_VALUE = 0;

	/**
	 * The '<em><b>Internal</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTERNAL
	 * @model name="internal"
	 * @generated
	 * @ordered
	 */
	public static final int INTERNAL_VALUE = 1;

	/**
	 * The '<em><b>Relay</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RELAY
	 * @model name="relay"
	 * @generated
	 * @ordered
	 */
	public static final int RELAY_VALUE = 2;

	/**
	 * An array of all the '<em><b>Port Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final PortKind[] VALUES_ARRAY =
		new PortKind[] {
			EXTERNAL,
			INTERNAL,
			RELAY,
		};

	/**
	 * A public read-only list of all the '<em><b>Port Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<PortKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Port Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PortKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PortKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Port Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PortKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PortKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Port Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PortKind get(int value) {
		switch (value) {
			case EXTERNAL_VALUE: return EXTERNAL;
			case INTERNAL_VALUE: return INTERNAL;
			case RELAY_VALUE: return RELAY;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private PortKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //PortKind
