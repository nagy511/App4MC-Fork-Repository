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
 * A representation of the model object '<em><b>Hw Memory Conjunction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.HwMemoryConjunction#getConjunction <em>Conjunction</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.HwMemoryConjunction#getFirstConstraint <em>First Constraint</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.HwMemoryConjunction#getSecondConstraint <em>Second Constraint</em>}</li>
 * </ul>
 *
 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getHwMemoryConjunction()
 * @model
 * @generated
 */
public interface HwMemoryConjunction extends HwMemoryConstraint {
	/**
	 * Returns the value of the '<em><b>Conjunction</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.app4mc.amalthea.model.ConjunctionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conjunction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conjunction</em>' attribute.
	 * @see org.eclipse.app4mc.amalthea.model.ConjunctionType
	 * @see #setConjunction(ConjunctionType)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getHwMemoryConjunction_Conjunction()
	 * @model unique="false"
	 * @generated
	 */
	ConjunctionType getConjunction();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.HwMemoryConjunction#getConjunction <em>Conjunction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conjunction</em>' attribute.
	 * @see org.eclipse.app4mc.amalthea.model.ConjunctionType
	 * @see #getConjunction()
	 * @generated
	 */
	void setConjunction(ConjunctionType value);

	/**
	 * Returns the value of the '<em><b>First Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Constraint</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Constraint</em>' containment reference.
	 * @see #setFirstConstraint(HwMemoryConstraint)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getHwMemoryConjunction_FirstConstraint()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	HwMemoryConstraint getFirstConstraint();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.HwMemoryConjunction#getFirstConstraint <em>First Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Constraint</em>' containment reference.
	 * @see #getFirstConstraint()
	 * @generated
	 */
	void setFirstConstraint(HwMemoryConstraint value);

	/**
	 * Returns the value of the '<em><b>Second Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Second Constraint</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second Constraint</em>' containment reference.
	 * @see #setSecondConstraint(HwMemoryConstraint)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getHwMemoryConjunction_SecondConstraint()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	HwMemoryConstraint getSecondConstraint();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.HwMemoryConjunction#getSecondConstraint <em>Second Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Constraint</em>' containment reference.
	 * @see #getSecondConstraint()
	 * @generated
	 */
	void setSecondConstraint(HwMemoryConstraint value);

} // HwMemoryConjunction
