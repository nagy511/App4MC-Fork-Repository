/**
 * *******************************************************************************
 *  Copyright (c) 2016 Robert Bosch GmbH and others.
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
 * A representation of the model object '<em><b>Reference Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Object for using object reference as generic parameter
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.ReferenceObject#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getReferenceObject()
 * @model
 * @generated
 */
public interface ReferenceObject extends Value {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(IReferable)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getReferenceObject_Value()
	 * @model
	 * @generated
	 */
	IReferable getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.ReferenceObject#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(IReferable value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.app4mc.amalthea.model.IReferable%> _value = this.getValue();\nboolean _equals = <%com.google.common.base.Objects%>.equal(_value, null);\nif (_equals)\n{\n\treturn \"(Reference) null\";\n}\nelse\n{\n\t<%org.eclipse.app4mc.amalthea.model.IReferable%> _value_1 = this.getValue();\n\t<%org.eclipse.emf.ecore.EClass%> _eClass = _value_1.eClass();\n\t<%java.lang.String%> _name = _eClass.getName();\n\t<%java.lang.String%> _plus = (\"(Reference) \" + _name);\n\t<%java.lang.String%> _plus_1 = (_plus + \" \\\"\");\n\t<%org.eclipse.app4mc.amalthea.model.IReferable%> _value_2 = this.getValue();\n\t<%java.lang.String%> _name_1 = _value_2.getName();\n\t<%java.lang.String%> _plus_2 = (_plus_1 + _name_1);\n\treturn (_plus_2 + \"\\\"\");\n}'"
	 * @generated
	 */
	String toString();

} // ReferenceObject
