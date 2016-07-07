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
 * A representation of the model object '<em><b>Semaphore Access</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Describes an semaphore access
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.SemaphoreAccess#getSemaphore <em>Semaphore</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.SemaphoreAccess#getAccess <em>Access</em>}</li>
 * </ul>
 *
 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getSemaphoreAccess()
 * @model
 * @generated
 */
public interface SemaphoreAccess extends RunnableItem {
	/**
	 * Returns the value of the '<em><b>Semaphore</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Semaphore</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Semaphore</em>' reference.
	 * @see #setSemaphore(Semaphore)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getSemaphoreAccess_Semaphore()
	 * @model required="true"
	 * @generated
	 */
	Semaphore getSemaphore();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.SemaphoreAccess#getSemaphore <em>Semaphore</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Semaphore</em>' reference.
	 * @see #getSemaphore()
	 * @generated
	 */
	void setSemaphore(Semaphore value);

	/**
	 * Returns the value of the '<em><b>Access</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.app4mc.amalthea.model.SemaphoreAccessEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access</em>' attribute.
	 * @see org.eclipse.app4mc.amalthea.model.SemaphoreAccessEnum
	 * @see #setAccess(SemaphoreAccessEnum)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getSemaphoreAccess_Access()
	 * @model unique="false"
	 * @generated
	 */
	SemaphoreAccessEnum getAccess();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.SemaphoreAccess#getAccess <em>Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access</em>' attribute.
	 * @see org.eclipse.app4mc.amalthea.model.SemaphoreAccessEnum
	 * @see #getAccess()
	 * @generated
	 */
	void setAccess(SemaphoreAccessEnum value);

} // SemaphoreAccess
