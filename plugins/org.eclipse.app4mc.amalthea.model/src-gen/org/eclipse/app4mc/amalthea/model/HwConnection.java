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
 * A representation of the model object '<em><b>Hw Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.HwConnection#getReadLatency <em>Read Latency</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.HwConnection#getWriteLatency <em>Write Latency</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.HwConnection#getReadDataRate <em>Read Data Rate</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.HwConnection#getWriteDataRate <em>Write Data Rate</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.HwConnection#getPort1 <em>Port1</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.HwConnection#getPort2 <em>Port2</em>}</li>
 * </ul>
 *
 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getHwConnection()
 * @model
 * @generated
 */
public interface HwConnection extends ReferableBaseObject, HwPathElement, ITaggable {
	/**
	 * Returns the value of the '<em><b>Read Latency</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Latency</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Latency</em>' containment reference.
	 * @see #setReadLatency(HwLatency)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getHwConnection_ReadLatency()
	 * @model containment="true"
	 * @generated
	 */
	HwLatency getReadLatency();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.HwConnection#getReadLatency <em>Read Latency</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Latency</em>' containment reference.
	 * @see #getReadLatency()
	 * @generated
	 */
	void setReadLatency(HwLatency value);

	/**
	 * Returns the value of the '<em><b>Write Latency</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Write Latency</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Write Latency</em>' containment reference.
	 * @see #setWriteLatency(HwLatency)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getHwConnection_WriteLatency()
	 * @model containment="true"
	 * @generated
	 */
	HwLatency getWriteLatency();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.HwConnection#getWriteLatency <em>Write Latency</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Write Latency</em>' containment reference.
	 * @see #getWriteLatency()
	 * @generated
	 */
	void setWriteLatency(HwLatency value);

	/**
	 * Returns the value of the '<em><b>Read Data Rate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Data Rate</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Data Rate</em>' containment reference.
	 * @see #setReadDataRate(DataRate)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getHwConnection_ReadDataRate()
	 * @model containment="true"
	 * @generated
	 */
	DataRate getReadDataRate();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.HwConnection#getReadDataRate <em>Read Data Rate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Data Rate</em>' containment reference.
	 * @see #getReadDataRate()
	 * @generated
	 */
	void setReadDataRate(DataRate value);

	/**
	 * Returns the value of the '<em><b>Write Data Rate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Write Data Rate</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Write Data Rate</em>' containment reference.
	 * @see #setWriteDataRate(DataRate)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getHwConnection_WriteDataRate()
	 * @model containment="true"
	 * @generated
	 */
	DataRate getWriteDataRate();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.HwConnection#getWriteDataRate <em>Write Data Rate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Write Data Rate</em>' containment reference.
	 * @see #getWriteDataRate()
	 * @generated
	 */
	void setWriteDataRate(DataRate value);

	/**
	 * Returns the value of the '<em><b>Port1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port1</em>' reference.
	 * @see #setPort1(HwPort)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getHwConnection_Port1()
	 * @model
	 * @generated
	 */
	HwPort getPort1();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.HwConnection#getPort1 <em>Port1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port1</em>' reference.
	 * @see #getPort1()
	 * @generated
	 */
	void setPort1(HwPort value);

	/**
	 * Returns the value of the '<em><b>Port2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port2</em>' reference.
	 * @see #setPort2(HwPort)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getHwConnection_Port2()
	 * @model
	 * @generated
	 */
	HwPort getPort2();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.HwConnection#getPort2 <em>Port2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port2</em>' reference.
	 * @see #getPort2()
	 * @generated
	 */
	void setPort2(HwPort value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.ecore.EObject%&gt; _eContainer = this.eContainer();\n&lt;%java.lang.String%&gt; _name = null;\nif (((&lt;%org.eclipse.app4mc.amalthea.model.INamed%&gt;) _eContainer)!=null)\n{\n\t_name=((&lt;%org.eclipse.app4mc.amalthea.model.INamed%&gt;) _eContainer).getName();\n}\nreturn this.basicComputeUniqueNameWithPrefix(_name);'"
	 * @generated
	 */
	String computeUniqueName();

} // HwConnection
