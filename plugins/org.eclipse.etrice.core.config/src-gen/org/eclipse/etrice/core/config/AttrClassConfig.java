/**
 */
package org.eclipse.etrice.core.config;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attr Class Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.AttrClassConfig#getMin <em>Min</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.AttrClassConfig#getMax <em>Max</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.config.ConfigPackage#getAttrClassConfig()
 * @model
 * @generated
 */
public interface AttrClassConfig extends AttrConfig
{
  /**
   * Returns the value of the '<em><b>Min</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Min</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Min</em>' containment reference.
   * @see #setMin(NumberLiteral)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getAttrClassConfig_Min()
   * @model containment="true"
   * @generated
   */
  NumberLiteral getMin();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.AttrClassConfig#getMin <em>Min</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Min</em>' containment reference.
   * @see #getMin()
   * @generated
   */
  void setMin(NumberLiteral value);

  /**
   * Returns the value of the '<em><b>Max</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Max</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Max</em>' containment reference.
   * @see #setMax(NumberLiteral)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getAttrClassConfig_Max()
   * @model containment="true"
   * @generated
   */
  NumberLiteral getMax();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.AttrClassConfig#getMax <em>Max</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Max</em>' containment reference.
   * @see #getMax()
   * @generated
   */
  void setMax(NumberLiteral value);

} // AttrClassConfig
