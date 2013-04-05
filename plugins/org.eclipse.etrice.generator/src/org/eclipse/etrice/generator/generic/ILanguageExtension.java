/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.generic;

import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.VarDecl;

import java.util.List;
import org.eclipse.xtext.util.Pair;


/**
 * This interface is used to achieve target language independence of the
 * generic generator parts such as the {@link GenericActorClassGenerator},
 * the {@link GenericProtocolClassGenerator} and the {@link GenericStateMachineGenerator}.
 * 
 * @author Thomas Schuetz
 * @author Henrik Rentz-Reichert
 */
public interface ILanguageExtension {

	/**
	 * This method is called to get a target language specific piece of
	 * code that defines a typed local variable holding the data passed with
	 * the message (if applicable). The name of the local variable should
	 * be that of the message parameter.
	 * 
	 * @param m the {@link Message}
	 * @return the variable definition
	 */
	String getTypedDataDefinition(Message m);

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
	 *  literal for pointer
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
	 * array declarations differ in Java and C/C++
	 * @param type
	 * @param size
	 * @param name
	 * @return a string that represents the declaration
	 */
	String arrayDeclaration(String type, int size, String name, boolean isRef);
	
	/**
	 * name for the constructor (without namespace if applicable)
	 * 
	 * @param cls the class name
	 * @return the constructor name
	 */
	String constructorName(String cls);
	
	/**
	 * name for the destructor (without namespace if applicable)
	 * 
	 * @param cls the class name
	 * @return the destructor name
	 */
	String destructorName(String cls);
	
	/**
	 * @return a typename for the return type (might be empty)
	 */
	String constructorReturnType();
	
	/**
	 * @return a typename for the return type (might be empty)
	 */
	String destructorReturnType();
	
	/**
	 * @param baseClassName the name of the base class
	 * @param method the method to be called
	 * @param arguments the argument list
	 * @return super.method for Java, baseClassName::method for C++, empty for C
	 */
	String superCall(String baseClassName, String method, String arguments);
	
	/**
	 * Produces necessary casts or data type keys for primitive values
	 * @param type ROOM PrimitiveType
	 * @param value Java Primitive e.g. Long, Byte, String
	 * @return for Java: <br>
	 * toPrimitve("PrimitiveType int64: ptInteger -> long (Long)", Long value = 99) -> 99L<br>
	 * toPrimitve("PrimitiveType int8: ptInteger -> byte (Byte)", Byte value = 12) -> (byte)12
	 */
	String toValueLiteral(PrimitiveType type, String value);
	
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
	String[] generateArglistAndTypedData(VarDecl data);
	
	/**
	 * returns a default value for a type
	 * @param dt the data type
	 * @return the default value string
	 */
	String defaultValue(DataType dt);
	
	/**
	 * returns an initializer for an array with default values
	 * @param dt the data type
	 * @param size
	 * @return the array initializer
	 */
	String initializationWithDefaultValues(DataType dt, int size);
}
