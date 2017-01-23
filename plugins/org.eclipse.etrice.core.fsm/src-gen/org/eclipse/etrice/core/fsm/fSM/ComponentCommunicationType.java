/**
 */
package org.eclipse.etrice.core.fsm.fSM;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Component Communication Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getComponentCommunicationType()
 * @model
 * @generated
 */
public enum ComponentCommunicationType implements Enumerator
{
  /**
   * The '<em><b>EVENT DRIVEN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #EVENT_DRIVEN_VALUE
   * @generated
   * @ordered
   */
  EVENT_DRIVEN(0, "EVENT_DRIVEN", "eventdriven"),

  /**
   * The '<em><b>DATA DRIVEN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DATA_DRIVEN_VALUE
   * @generated
   * @ordered
   */
  DATA_DRIVEN(1, "DATA_DRIVEN", "datadriven"),

  /**
   * The '<em><b>ASYNCHRONOUS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ASYNCHRONOUS_VALUE
   * @generated
   * @ordered
   */
  ASYNCHRONOUS(2, "ASYNCHRONOUS", "async"),

  /**
   * The '<em><b>SYNCHRONOUS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SYNCHRONOUS_VALUE
   * @generated
   * @ordered
   */
  SYNCHRONOUS(3, "SYNCHRONOUS", "sync");

  /**
   * The '<em><b>EVENT DRIVEN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>EVENT DRIVEN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #EVENT_DRIVEN
   * @model literal="eventdriven"
   * @generated
   * @ordered
   */
  public static final int EVENT_DRIVEN_VALUE = 0;

  /**
   * The '<em><b>DATA DRIVEN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DATA DRIVEN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DATA_DRIVEN
   * @model literal="datadriven"
   * @generated
   * @ordered
   */
  public static final int DATA_DRIVEN_VALUE = 1;

  /**
   * The '<em><b>ASYNCHRONOUS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ASYNCHRONOUS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ASYNCHRONOUS
   * @model literal="async"
   * @generated
   * @ordered
   */
  public static final int ASYNCHRONOUS_VALUE = 2;

  /**
   * The '<em><b>SYNCHRONOUS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SYNCHRONOUS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SYNCHRONOUS
   * @model literal="sync"
   * @generated
   * @ordered
   */
  public static final int SYNCHRONOUS_VALUE = 3;

  /**
   * An array of all the '<em><b>Component Communication Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final ComponentCommunicationType[] VALUES_ARRAY =
    new ComponentCommunicationType[]
    {
      EVENT_DRIVEN,
      DATA_DRIVEN,
      ASYNCHRONOUS,
      SYNCHRONOUS,
    };

  /**
   * A public read-only list of all the '<em><b>Component Communication Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<ComponentCommunicationType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Component Communication Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ComponentCommunicationType get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ComponentCommunicationType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Component Communication Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ComponentCommunicationType getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ComponentCommunicationType result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Component Communication Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ComponentCommunicationType get(int value)
  {
    switch (value)
    {
      case EVENT_DRIVEN_VALUE: return EVENT_DRIVEN;
      case DATA_DRIVEN_VALUE: return DATA_DRIVEN;
      case ASYNCHRONOUS_VALUE: return ASYNCHRONOUS;
      case SYNCHRONOUS_VALUE: return SYNCHRONOUS;
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
  private ComponentCommunicationType(int value, String name, String literal)
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
  
} //ComponentCommunicationType
