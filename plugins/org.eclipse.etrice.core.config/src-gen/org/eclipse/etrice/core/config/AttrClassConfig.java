/**
 */
package org.eclipse.etrice.core.config;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attr Class Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>This class models a configuration for an {@link org.eclipse.etrice.core.room.Attribute attribute}.
 * The configuration defines a default value for all instances of the attribute.
 * The values are applied at generation time.
 * <br>If the type of the given {@link org.eclipse.etrice.core.config.AttrConfig#getAttribute attribute} is
 * <ul>
 * 	<li>primitive, then a {@link org.eclipse.etrice.core.config.AttrConfig#getValue value} might exist and {@link #getAttributes attributes} is empty</li>
 * 	<li>compound attribute (e.g. {@link org.eclipse.etrice.core.room.DataClass data class}), then {@link org.eclipse.etrice.core.config.AttrConfig#getValue value} is null and configurations for children {@link #getAttributes attributes} might exist</li>
 * </ul>				
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.AttrClassConfig#getMin <em>Min</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.AttrClassConfig#getMax <em>Max</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.AttrClassConfig#getAttributes <em>Attributes</em>}</li>
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the lower bound of {@link org.eclipse.etrice.core.config.AttrConfig#getValue value} , in case the {@link org.eclipse.etrice.core.config.AttrConfig#getAttribute attribute} has a numerical value.
   * 
   * <!-- end-model-doc -->
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the upper bound of {@link org.eclipse.etrice.core.config.AttrConfig#getValue value} , in case the {@link org.eclipse.etrice.core.config.AttrConfig#getAttribute attribute} has a numerical value.
   * 
   * <!-- end-model-doc -->
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

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.config.AttrClassConfig}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of attribute configurations of children attributes, in case the {@link org.eclipse.etrice.core.config.AttrConfig#getAttribute attribute} is compound.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see org.eclipse.etrice.core.config.ConfigPackage#getAttrClassConfig_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<AttrClassConfig> getAttributes();

} // AttrClassConfig
