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
 * A representation of the model object '<em><b>Runnable Pairing Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A runnable-pairing-constraint
 * runnables describes the group of runnables that should be paired on the target
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.RunnablePairingConstraint#getRunnables <em>Runnables</em>}</li>
 * </ul>
 *
 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getRunnablePairingConstraint()
 * @model
 * @generated
 */
public interface RunnablePairingConstraint extends PairingConstraint, RunnableConstraint, BaseObject {
	/**
	 * Returns the value of the '<em><b>Runnables</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Runnables</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runnables</em>' containment reference.
	 * @see #setRunnables(RunnableGroup)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getRunnablePairingConstraint_Runnables()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	RunnableGroup getRunnables();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.RunnablePairingConstraint#getRunnables <em>Runnables</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Runnables</em>' containment reference.
	 * @see #getRunnables()
	 * @generated
	 */
	void setRunnables(RunnableGroup value);

} // RunnablePairingConstraint
