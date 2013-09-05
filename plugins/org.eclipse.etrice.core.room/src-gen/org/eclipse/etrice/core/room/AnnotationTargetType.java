/**
 */
package org.eclipse.etrice.core.room;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Annotation Target Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.core.room.RoomPackage#getAnnotationTargetType()
 * @model
 * @generated
 */
public enum AnnotationTargetType implements Enumerator
{
  /**
   * The '<em><b>DATA CLASS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DATA_CLASS_VALUE
   * @generated
   * @ordered
   */
  DATA_CLASS(0, "DATA_CLASS", "DataClass"),

  /**
   * The '<em><b>ACTOR CLASS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ACTOR_CLASS_VALUE
   * @generated
   * @ordered
   */
  ACTOR_CLASS(1, "ACTOR_CLASS", "ActorClass"),

  /**
   * The '<em><b>ACTOR BEHAVIOR</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ACTOR_BEHAVIOR_VALUE
   * @generated
   * @ordered
   */
  ACTOR_BEHAVIOR(2, "ACTOR_BEHAVIOR", "ActorBehavior"),

  /**
   * The '<em><b>PROTOCOL CLASS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PROTOCOL_CLASS_VALUE
   * @generated
   * @ordered
   */
  PROTOCOL_CLASS(3, "PROTOCOL_CLASS", "ProtocolClass"),

  /**
   * The '<em><b>COMPOUND PROTOCOL CLASS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #COMPOUND_PROTOCOL_CLASS_VALUE
   * @generated
   * @ordered
   */
  COMPOUND_PROTOCOL_CLASS(4, "COMPOUND_PROTOCOL_CLASS", "CompoundProtocolClass"),

  /**
   * The '<em><b>SUBSYSTEM CLASS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SUBSYSTEM_CLASS_VALUE
   * @generated
   * @ordered
   */
  SUBSYSTEM_CLASS(5, "SUBSYSTEM_CLASS", "SubSystemClass"),

  /**
   * The '<em><b>LOGICAL SYSTEM CLASS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #LOGICAL_SYSTEM_CLASS_VALUE
   * @generated
   * @ordered
   */
  LOGICAL_SYSTEM_CLASS(6, "LOGICAL_SYSTEM_CLASS", "LogicalSystem");

  /**
   * The '<em><b>DATA CLASS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DATA CLASS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DATA_CLASS
   * @model literal="DataClass"
   * @generated
   * @ordered
   */
  public static final int DATA_CLASS_VALUE = 0;

  /**
   * The '<em><b>ACTOR CLASS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ACTOR CLASS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ACTOR_CLASS
   * @model literal="ActorClass"
   * @generated
   * @ordered
   */
  public static final int ACTOR_CLASS_VALUE = 1;

  /**
   * The '<em><b>ACTOR BEHAVIOR</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ACTOR BEHAVIOR</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ACTOR_BEHAVIOR
   * @model literal="ActorBehavior"
   * @generated
   * @ordered
   */
  public static final int ACTOR_BEHAVIOR_VALUE = 2;

  /**
   * The '<em><b>PROTOCOL CLASS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PROTOCOL CLASS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PROTOCOL_CLASS
   * @model literal="ProtocolClass"
   * @generated
   * @ordered
   */
  public static final int PROTOCOL_CLASS_VALUE = 3;

  /**
   * The '<em><b>COMPOUND PROTOCOL CLASS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>COMPOUND PROTOCOL CLASS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #COMPOUND_PROTOCOL_CLASS
   * @model literal="CompoundProtocolClass"
   * @generated
   * @ordered
   */
  public static final int COMPOUND_PROTOCOL_CLASS_VALUE = 4;

  /**
   * The '<em><b>SUBSYSTEM CLASS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SUBSYSTEM CLASS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SUBSYSTEM_CLASS
   * @model literal="SubSystemClass"
   * @generated
   * @ordered
   */
  public static final int SUBSYSTEM_CLASS_VALUE = 5;

  /**
   * The '<em><b>LOGICAL SYSTEM CLASS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LOGICAL SYSTEM CLASS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #LOGICAL_SYSTEM_CLASS
   * @model literal="LogicalSystem"
   * @generated
   * @ordered
   */
  public static final int LOGICAL_SYSTEM_CLASS_VALUE = 6;

  /**
   * An array of all the '<em><b>Annotation Target Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final AnnotationTargetType[] VALUES_ARRAY =
    new AnnotationTargetType[]
    {
      DATA_CLASS,
      ACTOR_CLASS,
      ACTOR_BEHAVIOR,
      PROTOCOL_CLASS,
      COMPOUND_PROTOCOL_CLASS,
      SUBSYSTEM_CLASS,
      LOGICAL_SYSTEM_CLASS,
    };

  /**
   * A public read-only list of all the '<em><b>Annotation Target Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<AnnotationTargetType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Annotation Target Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AnnotationTargetType get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      AnnotationTargetType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Annotation Target Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AnnotationTargetType getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      AnnotationTargetType result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Annotation Target Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AnnotationTargetType get(int value)
  {
    switch (value)
    {
      case DATA_CLASS_VALUE: return DATA_CLASS;
      case ACTOR_CLASS_VALUE: return ACTOR_CLASS;
      case ACTOR_BEHAVIOR_VALUE: return ACTOR_BEHAVIOR;
      case PROTOCOL_CLASS_VALUE: return PROTOCOL_CLASS;
      case COMPOUND_PROTOCOL_CLASS_VALUE: return COMPOUND_PROTOCOL_CLASS;
      case SUBSYSTEM_CLASS_VALUE: return SUBSYSTEM_CLASS;
      case LOGICAL_SYSTEM_CLASS_VALUE: return LOGICAL_SYSTEM_CLASS;
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
  private AnnotationTargetType(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //AnnotationTargetType
