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
import org.eclipse.etrice.core.room.EnumLiteral;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.generator.fsm.generic.ILanguageExtensionBase;


/**
 * This interface is used to achieve target language independence of the
 * generic generator parts such as the {@link GenericActorClassGenerator},
 * the {@link GenericProtocolClassGenerator} and the {@link GenericStateMachineGenerator}.
 * 
 * @author Thomas Schuetz
 * @author Henrik Rentz-Reichert
 */
public interface ILanguageExtension extends ILanguageExtensionBase {

	static final String GENERIC_DATA_NAME = "transitionData";
	
	/**
	 * Produces necessary casts or data type keys for an attribute (array) value statement
	 * @param type ROOM PrimitiveType
	 * @param value User value statement, maybe array (with)out brackets
	 * @return for Java: <br>
	 * toPrimitve("PrimitiveType int64: ptInteger -> long (Long)", Long value = 99) -> 99L<br>
	 * toPrimitve("PrimitiveType int8: ptInteger -> byte (Byte)", Byte value = 12) -> (byte)12
	 */
	String toValueLiteral(PrimitiveType type, String value);
	
	/**
	 * User enum value to platform expression
	 * @param type ROOM EnumerationType
	 * @param value User value statement, maybe array (with)out brackets
	 * @return enum text expression
	 */
	String toEnumLiteral(EnumerationType type, String value);
	
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

	/**
	 * returns the target type for the enumeration type
	 * @param type the enumeration type
	 * @return the target type for the enumeration type
	 */
	String getTargetType(EnumerationType type);
	
	/**
	 * returns the casted value as string
	 * @param literal an enumeration type literal
	 * @return the casted value as string
	 */
	String getCastedValue(EnumLiteral literal);
	
	/**
	 * return the cast type of an enumeration type
	 * @param type the enumeration type
	 * @return the cast type of an enumeration type
	 */
	String getCastType(EnumerationType type);
}
