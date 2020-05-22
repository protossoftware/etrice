/**
 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ref Segment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>A segment of a {@link RefPath}. It consists of a name and an optional index.
 * If the index is not set it will be {@code -1}.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.RefSegment#getRef <em>Ref</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.RefSegment#getIdx <em>Idx</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getRefSegment()
 * @model
 * @generated
 */
public interface RefSegment extends RoomElement
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The segment name corresponding to an actor reference.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Ref</em>' attribute.
   * @see #setRef(String)
   * @see org.eclipse.etrice.core.room.RoomPackage#getRefSegment_Ref()
   * @model
   * @generated
   */
  String getRef();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.RefSegment#getRef <em>Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' attribute.
   * @see #getRef()
   * @generated
   */
  void setRef(String value);

  /**
   * Returns the value of the '<em><b>Idx</b></em>' attribute.
   * The default value is <code>"-1"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The optional index of the reference (for replicated actors).
   * If not set the index is {@code -1}.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Idx</em>' attribute.
   * @see #setIdx(int)
   * @see org.eclipse.etrice.core.room.RoomPackage#getRefSegment_Idx()
   * @model default="-1"
   * @generated
   */
  int getIdx();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.RefSegment#getIdx <em>Idx</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Idx</em>' attribute.
   * @see #getIdx()
   * @generated
   */
  void setIdx(int value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return getRef() + ((getIdx()&gt;=0)? \":\"+getIdx() : \"\");\r\n'"
   * @generated
   */
  String toString();

} // RefSegment
