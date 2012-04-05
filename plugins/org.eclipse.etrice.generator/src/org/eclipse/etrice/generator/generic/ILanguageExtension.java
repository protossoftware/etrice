
package org.eclipse.etrice.generator.generic;

import org.eclipse.etrice.core.room.Message;
import java.util.List;
import org.eclipse.xtext.util.Pair;


/**
 * @author hrentz
 *
 */
public interface ILanguageExtension {

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
	
	String constructorName(String cls);
	String destructorName(String cls);
	String constructorReturnType();
	String destructorReturnType();
}