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
 * A representation of the model object '<em><b>Periodic Activation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Min and Max execution frequency within a task or timeslice
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.PeriodicActivation#getMin <em>Min</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.PeriodicActivation#getMax <em>Max</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.PeriodicActivation#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.PeriodicActivation#getDeadline <em>Deadline</em>}</li>
 * </ul>
 *
 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getPeriodicActivation()
 * @model
 * @generated
 */
public interface PeriodicActivation extends Activation {
	/**
	 * Returns the value of the '<em><b>Min</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min</em>' containment reference.
	 * @see #setMin(Time)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getPeriodicActivation_Min()
	 * @model containment="true"
	 * @generated
	 */
	Time getMin();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.PeriodicActivation#getMin <em>Min</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min</em>' containment reference.
	 * @see #getMin()
	 * @generated
	 */
	void setMin(Time value);

	/**
	 * Returns the value of the '<em><b>Max</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max</em>' containment reference.
	 * @see #setMax(Time)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getPeriodicActivation_Max()
	 * @model containment="true"
	 * @generated
	 */
	Time getMax();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.PeriodicActivation#getMax <em>Max</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max</em>' containment reference.
	 * @see #getMax()
	 * @generated
	 */
	void setMax(Time value);

	/**
	 * Returns the value of the '<em><b>Offset</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset</em>' containment reference.
	 * @see #setOffset(Time)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getPeriodicActivation_Offset()
	 * @model containment="true"
	 * @generated
	 */
	Time getOffset();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.PeriodicActivation#getOffset <em>Offset</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' containment reference.
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(Time value);

	/**
	 * Returns the value of the '<em><b>Deadline</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deadline</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deadline</em>' containment reference.
	 * @see #setDeadline(Time)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getPeriodicActivation_Deadline()
	 * @model containment="true"
	 * @generated
	 */
	Time getDeadline();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.PeriodicActivation#getDeadline <em>Deadline</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deadline</em>' containment reference.
	 * @see #getDeadline()
	 * @generated
	 */
	void setDeadline(Time value);

} // PeriodicActivation
