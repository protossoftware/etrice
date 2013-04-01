/**
 */
package org.eclipse.etrice.core.etmap.eTMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>The import declares an imported model (given as a URI) and
 * an optional imported namespace.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.etmap.eTMap.Import#getImportedNamespace <em>Imported Namespace</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etmap.eTMap.Import#getImportURI <em>Import URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.etmap.eTMap.ETMapPackage#getImport()
 * @model
 * @generated
 */
public interface Import extends EObject
{
  /**
   * Returns the value of the '<em><b>Imported Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The imported name space has to be a dot separated qualified name followed by .*.
   * Example: my.namespace.*
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Imported Namespace</em>' attribute.
   * @see #setImportedNamespace(String)
   * @see org.eclipse.etrice.core.etmap.eTMap.ETMapPackage#getImport_ImportedNamespace()
   * @model
   * @generated
   */
  String getImportedNamespace();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.etmap.eTMap.Import#getImportedNamespace <em>Imported Namespace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Imported Namespace</em>' attribute.
   * @see #getImportedNamespace()
   * @generated
   */
  void setImportedNamespace(String value);

  /**
   * Returns the value of the '<em><b>Import URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The import URI can be a relative or absolute file system path.
   * It may contain environment variables in ${} which will be expanded.
   * <p>
   * Examples:
   * <ul>
   *   <li>import model "AnotherModel.room"</li>
   *   <li>import my.namespace.* from "AnotherModel.room"</li>
   *   <li>import my.namespace.* from "../../AnotherProject/models/AnotherModel.room"</li>
   *   <li>import my.namespace.* from "/${ROOM_MODELS}/SomeModel.room"</li>
   * </ul>
   * </p>
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Import URI</em>' attribute.
   * @see #setImportURI(String)
   * @see org.eclipse.etrice.core.etmap.eTMap.ETMapPackage#getImport_ImportURI()
   * @model
   * @generated
   */
  String getImportURI();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.etmap.eTMap.Import#getImportURI <em>Import URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Import URI</em>' attribute.
   * @see #getImportURI()
   * @generated
   */
  void setImportURI(String value);

} // Import
