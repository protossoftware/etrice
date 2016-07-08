/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/

package org.eclipse.etrice.generator.fsm.generic;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.Pair;

import com.google.inject.spi.Message;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public interface ILanguageExtensionBase {

	/**
	 * This method is called to get a target language specific piece of
	 * code that defines a typed local variable holding the data passed with
	 * the message (if applicable). The name of the local variable should
	 * be that of the message parameter.
	 *
	 * @param msg the {@link Message}
	 * @return the variable definition
	 */
	String getTypedDataDefinition(EObject msg);

	/**
	 * unification of access level for all Languages before each member
	 * @return e.g. "private " for Java, nothing for C and C++ (no access level before the individual member)
	 */
	String accessLevelPrivate();

	/**
	 * unification of access level for all Languages before each member
	 * @return e.g. "protected " for Java, nothing for C and C++ (no access level before the individual member)
	 */
	String accessLevelProtected();

	/**
	 * unification of access level for all Languages before each member
	 * @return e.g. "public " for Java, nothing for C and C++ (no access level before the individual member)
	 */
	String accessLevelPublic();


	// Strings for member access

	/**
	 * unification of member access for different languages
	 * @return e.g. "this." for Java and C++ or "self->" for C
	 */
	String memberAccess();

	/**
	 * self pointer for building class mechanism in C,
	 * e.g. MyClass_function1(MyClass *self, int32 argument1)
	 * @param classname the class name
	 * @param hasArgs true if functions has further arguments
	 * @return "classname *self, " for C / for Java and C++ nothing
	 */
	String selfPointer(String classname, boolean hasArgs);

	/**
	 * self pointer for function calls
	 * @param hasArgs true if functions has further arguments
	 * @return "self, " for C / for Java and C++ nothing
	 */
	String selfPointer(boolean hasArgs);

	/**
	 * language specific scoping string for operations
	 * e.g. nothing in Java (only inside class declaration), nothing and classname:: for C++ and classname_ for C
	 * @param classname the class name
	 * @param isDeclaration true if it is a declaration
	 * @return "classname_" for C / for Java and C++ nothing
	 */
	String operationScope(String classname, boolean isDeclaration);

	/**
	 * member declaration
	 *
	 * @param namespace the namespace or class name
	 * @param member the member name
	 * @return for C: namespace_member, for Java namespace.member
	 */
	String memberInDeclaration(String namespace, String member);

	/**
	 * member usage
	 *
	 * @param namespace the namespace or class name
	 * @param member the member name
	 * @return for C: namespace_member, for Java namespace.member
	 */
	String memberInUse(String namespace, String member);

	/**
	 * does the target language offer inheritance
	 *
	 * @return true for C++ and Java, false for C
	 */
	boolean usesInheritance();

	/**
	 * produces the "virtual" keyword for C++ and the empty string else
	 */
	String makeOverridable();
	
	/**
	 * does the target language use pointers
	 *
	 * @return true for C++ and C, false for Java
	 */
	boolean usesPointers();

	/**
	 * generate an enumeration (enum in C, int constants in Java)
	 * @param name the enumeration name
	 * @param entries a list of name/value pairs
	 * @return a string defining the enumeration in the target language
	 */
	String genEnumeration(String name, List<Pair<String, String>> entries);

	/**
	 * literals for boolean constants
	 * @param b the boolean value
	 * @return TRUE/FALSE for C/C++, true/false for Java
	 */
	String booleanConstant(boolean b);


	/**
	 * literal for pointer
	 *
	 * @return * for C/C++, nothing for Java
	 */
	String pointerLiteral();

	/**
	 * a literal for the null pointer
	 *
	 * @return NULL for C/C++, null for Java
	 */
	String nullPointer();

	/**
	 * a generic pointer
	 *
	 * @return void* for C/C++, Object for Java
	 */
	String voidPointer();

	/**
	 * a literal turn a type into an array
	 *
	 * @return * for C/C++, [] for Java
	 */
	String typeArrayModifier();

	/**
	 * array declarations differ in Java and C/C++
	 * @param type
	 * @param size
	 * @param name
	 * @return a string that represents the declaration
	 */
	String arrayDeclaration(String type, int size, String name, boolean isRef);

	/**
	 * @param baseClassName the name of the base class
	 * @param method the method to be called
	 * @param arguments the argument list
	 * @return super.method for Java, baseClassName::method for C++, empty for C
	 */
	String superCall(String baseClassName, String method, String arguments);

	/**
	 * return three strings used by the generator
	 *
	 * @param data the variable declaration
	 * @return an array of three strings
	 * <ol>
	 *  <li>the string that performs the cast from generic_data to the correct type and assigns it to a new variable</li>
	 *  <li>the data as it appears in a method call</li>
	 *  <li>the data as it is used in the method declaration</li>
	 *  </ol>
	 */
	String[] generateArglistAndTypedData(EObject data);

}
