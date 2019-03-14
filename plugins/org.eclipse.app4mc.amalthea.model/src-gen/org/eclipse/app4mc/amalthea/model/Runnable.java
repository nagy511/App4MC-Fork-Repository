/**
 * *******************************************************************************
 *  Copyright (c) 2015-2019 Robert Bosch GmbH and others.
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
 * A representation of the model object '<em><b>Runnable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Smallest allocatable unit, which provides additional (optional) attributes for allocation algorithms.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.Runnable#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.Runnable#getRunnableItems <em>Runnable Items</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.Runnable#getActivations <em>Activations</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.Runnable#isCallback <em>Callback</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.Runnable#isService <em>Service</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.Runnable#getAsilLevel <em>Asil Level</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.Runnable#getSection <em>Section</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.Runnable#getRunnableCalls <em>Runnable Calls</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.Runnable#getTaskRunnableCalls <em>Task Runnable Calls</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.Runnable#getReferringComponents <em>Referring Components</em>}</li>
 * </ul>
 *
 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getRunnable()
 * @model
 * @generated
 */
public interface Runnable extends AbstractMemoryElement {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.app4mc.amalthea.model.RunnableParameter}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.app4mc.amalthea.model.RunnableParameter#getContainingRunnable <em>Containing Runnable</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getRunnable_Parameters()
	 * @see org.eclipse.app4mc.amalthea.model.RunnableParameter#getContainingRunnable
	 * @model opposite="containingRunnable" containment="true"
	 * @generated
	 */
	EList<RunnableParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Runnable Items</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.app4mc.amalthea.model.RunnableItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Runnable Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runnable Items</em>' containment reference list.
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getRunnable_RunnableItems()
	 * @model containment="true"
	 * @generated
	 */
	EList<RunnableItem> getRunnableItems();

	/**
	 * Returns the value of the '<em><b>Activations</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.app4mc.amalthea.model.Activation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activations</em>' reference list.
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getRunnable_Activations()
	 * @model
	 * @generated
	 */
	EList<Activation> getActivations();

	/**
	 * Returns the value of the '<em><b>Callback</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Marker if runnable is used as callback.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Callback</em>' attribute.
	 * @see #setCallback(boolean)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getRunnable_Callback()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isCallback();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.Runnable#isCallback <em>Callback</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Callback</em>' attribute.
	 * @see #isCallback()
	 * @generated
	 */
	void setCallback(boolean value);

	/**
	 * Returns the value of the '<em><b>Service</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Marker if runnable is used as a service.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Service</em>' attribute.
	 * @see #setService(boolean)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getRunnable_Service()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isService();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.Runnable#isService <em>Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service</em>' attribute.
	 * @see #isService()
	 * @generated
	 */
	void setService(boolean value);

	/**
	 * Returns the value of the '<em><b>Asil Level</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.app4mc.amalthea.model.ASILType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ASIL level for the runnable entity
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Asil Level</em>' attribute.
	 * @see org.eclipse.app4mc.amalthea.model.ASILType
	 * @see #setAsilLevel(ASILType)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getRunnable_AsilLevel()
	 * @model unique="false"
	 * @generated
	 */
	ASILType getAsilLevel();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.Runnable#getAsilLevel <em>Asil Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Asil Level</em>' attribute.
	 * @see org.eclipse.app4mc.amalthea.model.ASILType
	 * @see #getAsilLevel()
	 * @generated
	 */
	void setAsilLevel(ASILType value);

	/**
	 * Returns the value of the '<em><b>Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Section</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Section</em>' reference.
	 * @see #setSection(Section)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getRunnable_Section()
	 * @model
	 * @generated
	 */
	Section getSection();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.Runnable#getSection <em>Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Section</em>' reference.
	 * @see #getSection()
	 * @generated
	 */
	void setSection(Section value);

	/**
	 * Returns the value of the '<em><b>Runnable Calls</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.app4mc.amalthea.model.RunnableCall}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p><b>Returns an <em>immutable</em> list of callers (RunnableCalls).</b></p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Runnable Calls</em>' reference list.
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getRunnable_RunnableCalls()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Read only' propertyFilterFlags='org.eclipse.ui.views.properties.expert'"
	 * @generated
	 */
	EList<RunnableCall> getRunnableCalls();

	/**
	 * Returns the value of the '<em><b>Task Runnable Calls</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.app4mc.amalthea.model.TaskRunnableCall}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p><b>Returns an <em>immutable</em> list of callers (TaskRunnableCalls).</b></p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Task Runnable Calls</em>' reference list.
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getRunnable_TaskRunnableCalls()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Read only' propertyFilterFlags='org.eclipse.ui.views.properties.expert'"
	 * @generated
	 */
	EList<TaskRunnableCall> getTaskRunnableCalls();

	/**
	 * Returns the value of the '<em><b>Referring Components</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.app4mc.amalthea.model.Component}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p><b>Returns an <em>immutable</em> list of components the runnable belongs to.</b></p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referring Components</em>' reference list.
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getRunnable_ReferringComponents()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Read only' propertyFilterFlags='org.eclipse.ui.views.properties.expert'"
	 * @generated
	 */
	EList<Component> getReferringComponents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	Activation getFirstActivation();

} // Runnable
