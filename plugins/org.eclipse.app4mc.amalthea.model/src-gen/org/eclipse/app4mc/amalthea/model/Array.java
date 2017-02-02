/**
 * *******************************************************************************
 *  Copyright (c) 2017 Robert Bosch GmbH and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *     Generated using Eclipse EMF
 * 
 * *******************************************************************************
 */
package org.eclipse.app4mc.amalthea.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Representation of an array data type
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.Array#getNumberElements <em>Number Elements</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.Array#getDataType <em>Data Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getArray()
 * @model
 * @generated
 */
public interface Array extends CompoundType, BaseObject {
	/**
	 * Returns the value of the '<em><b>Number Elements</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Elements</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Elements</em>' attribute.
	 * @see #setNumberElements(int)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getArray_NumberElements()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getNumberElements();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.Array#getNumberElements <em>Number Elements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Elements</em>' attribute.
	 * @see #getNumberElements()
	 * @generated
	 */
	void setNumberElements(int value);

	/**
	 * Returns the value of the '<em><b>Data Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Type</em>' containment reference.
	 * @see #setDataType(DataType)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getArray_DataType()
	 * @model containment="true"
	 * @generated
	 */
	DataType getDataType();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.Array#getDataType <em>Data Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Type</em>' containment reference.
	 * @see #getDataType()
	 * @generated
	 */
	void setDataType(DataType value);

} // Array
