/**
 * *******************************************************************************
 *  Copyright (c) 2015-2018 Robert Bosch GmbH and others.
 * 
 *  This program and the accompanying materials are made
 *  available under the terms of the Eclipse Public License 2.0
 *  which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *     Generated using Eclipse EMF
 * 
 * *******************************************************************************
 */
package org.eclipse.app4mc.amalthea.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Runnable Mode Switch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.RunnableModeSwitch#getEntries <em>Entries</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.RunnableModeSwitch#getDefaultEntry <em>Default Entry</em>}</li>
 * </ul>
 *
 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getRunnableModeSwitch()
 * @model
 * @generated
 */
public interface RunnableModeSwitch extends RunnableItem {
	/**
	 * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.app4mc.amalthea.model.ModeSwitchEntry}<code>&lt;org.eclipse.app4mc.amalthea.model.RunnableItem&gt;</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entries</em>' containment reference list.
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getRunnableModeSwitch_Entries()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModeSwitchEntry<RunnableItem>> getEntries();

	/**
	 * Returns the value of the '<em><b>Default Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Entry</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Entry</em>' containment reference.
	 * @see #setDefaultEntry(ModeSwitchDefault)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getRunnableModeSwitch_DefaultEntry()
	 * @model containment="true"
	 * @generated
	 */
	ModeSwitchDefault<RunnableItem> getDefaultEntry();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.RunnableModeSwitch#getDefaultEntry <em>Default Entry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Entry</em>' containment reference.
	 * @see #getDefaultEntry()
	 * @generated
	 */
	void setDefaultEntry(ModeSwitchDefault<RunnableItem> value);

} // RunnableModeSwitch
