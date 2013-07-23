/**
 */
package org.eclipse.etrice.core.etphys.eTPhys;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Thread Model</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getThreadModel()
 * @model
 * @generated
 */
public enum ThreadModel implements Enumerator
{
  /**
   * The '<em><b>SINGLE THREADED</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SINGLE_THREADED_VALUE
   * @generated
   * @ordered
   */
  SINGLE_THREADED(0, "SINGLE_THREADED", "singleThreaded"),

  /**
   * The '<em><b>MULTI THREADED</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MULTI_THREADED_VALUE
   * @generated
   * @ordered
   */
  MULTI_THREADED(1, "MULTI_THREADED", "multiThreaded");

  /**
   * The '<em><b>SINGLE THREADED</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SINGLE THREADED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SINGLE_THREADED
   * @model literal="singleThreaded"
   * @generated
   * @ordered
   */
  public static final int SINGLE_THREADED_VALUE = 0;

  /**
   * The '<em><b>MULTI THREADED</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MULTI THREADED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MULTI_THREADED
   * @model literal="multiThreaded"
   * @generated
   * @ordered
   */
  public static final int MULTI_THREADED_VALUE = 1;

  /**
   * An array of all the '<em><b>Thread Model</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final ThreadModel[] VALUES_ARRAY =
    new ThreadModel[]
    {
      SINGLE_THREADED,
      MULTI_THREADED,
    };

  /**
   * A public read-only list of all the '<em><b>Thread Model</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<ThreadModel> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Thread Model</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ThreadModel get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ThreadModel result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Thread Model</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ThreadModel getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ThreadModel result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Thread Model</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ThreadModel get(int value)
  {
    switch (value)
    {
      case SINGLE_THREADED_VALUE: return SINGLE_THREADED;
      case MULTI_THREADED_VALUE: return MULTI_THREADED;
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
  private ThreadModel(int value, String name, String literal)
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
  
} //ThreadModel
