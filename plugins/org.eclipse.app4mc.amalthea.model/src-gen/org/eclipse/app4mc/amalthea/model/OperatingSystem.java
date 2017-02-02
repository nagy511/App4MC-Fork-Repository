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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operating System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.OperatingSystem#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.OperatingSystem#getOverhead <em>Overhead</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.OperatingSystem#getTaskSchedulers <em>Task Schedulers</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.OperatingSystem#getInterruptControllers <em>Interrupt Controllers</em>}</li>
 * </ul>
 *
 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getOperatingSystem()
 * @model
 * @generated
 */
public interface OperatingSystem extends BaseObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getOperatingSystem_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.OperatingSystem#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Overhead</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overhead</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overhead</em>' reference.
	 * @see #setOverhead(OsInstructions)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getOperatingSystem_Overhead()
	 * @model
	 * @generated
	 */
	OsInstructions getOverhead();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.OperatingSystem#getOverhead <em>Overhead</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overhead</em>' reference.
	 * @see #getOverhead()
	 * @generated
	 */
	void setOverhead(OsInstructions value);

	/**
	 * Returns the value of the '<em><b>Task Schedulers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.app4mc.amalthea.model.TaskScheduler}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Schedulers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Schedulers</em>' containment reference list.
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getOperatingSystem_TaskSchedulers()
	 * @model containment="true"
	 * @generated
	 */
	EList<TaskScheduler> getTaskSchedulers();

	/**
	 * Returns the value of the '<em><b>Interrupt Controllers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.app4mc.amalthea.model.InterruptController}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interrupt Controllers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interrupt Controllers</em>' containment reference list.
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getOperatingSystem_InterruptControllers()
	 * @model containment="true"
	 * @generated
	 */
	EList<InterruptController> getInterruptControllers();

} // OperatingSystem
