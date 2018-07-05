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
 *   <li>{@link org.eclipse.app4mc.amalthea.model.Runnable#getRunnableItems <em>Runnable Items</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.Runnable#getActivations <em>Activations</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.Runnable#getDeadline <em>Deadline</em>}</li>
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
	 * Returns the value of the '<em><b>Deadline</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Optional parameter for allocation to task or time slice.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Deadline</em>' containment reference.
	 * @see #setDeadline(Time)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getRunnable_Deadline()
	 * @model containment="true"
	 * @generated
	 */
	Time getDeadline();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.Runnable#getDeadline <em>Deadline</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deadline</em>' containment reference.
	 * @see #getDeadline()
	 * @generated
	 */
	void setDeadline(Time value);

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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Read only' propertyFilterFlags='org.eclipse.ui.views.properties.expert' get='return &lt;%org.eclipse.app4mc.amalthea.model.AmaltheaIndex%&gt;.&lt;&lt;%org.eclipse.app4mc.amalthea.model.RunnableCall%&gt;&gt;getInverseReferences(this, \n\t&lt;%org.eclipse.app4mc.amalthea.model.AmaltheaPackage%&gt;.eINSTANCE.getRunnable_RunnableCalls(), &lt;%org.eclipse.app4mc.amalthea.model.AmaltheaPackage%&gt;.eINSTANCE.getRunnableCall_Runnable());'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Read only' propertyFilterFlags='org.eclipse.ui.views.properties.expert' get='return &lt;%org.eclipse.app4mc.amalthea.model.AmaltheaIndex%&gt;.&lt;&lt;%org.eclipse.app4mc.amalthea.model.TaskRunnableCall%&gt;&gt;getInverseReferences(this, \n\t&lt;%org.eclipse.app4mc.amalthea.model.AmaltheaPackage%&gt;.eINSTANCE.getRunnable_TaskRunnableCalls(), &lt;%org.eclipse.app4mc.amalthea.model.AmaltheaPackage%&gt;.eINSTANCE.getTaskRunnableCall_Runnable());'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Read only' propertyFilterFlags='org.eclipse.ui.views.properties.expert' get='return &lt;%org.eclipse.app4mc.amalthea.model.AmaltheaIndex%&gt;.&lt;&lt;%org.eclipse.app4mc.amalthea.model.Component%&gt;&gt;getInverseReferences(this, \n\t&lt;%org.eclipse.app4mc.amalthea.model.AmaltheaPackage%&gt;.eINSTANCE.getRunnable_ReferringComponents(), &lt;%org.eclipse.app4mc.amalthea.model.AmaltheaPackage%&gt;.eINSTANCE.getComponent_Runnables());'"
	 * @generated
	 */
	EList<Component> getReferringComponents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%org.eclipse.app4mc.amalthea.model.Activation%&gt;&gt;head(this.getActivations());'"
	 * @generated
	 */
	Activation getFirstActivation();

} // Runnable
