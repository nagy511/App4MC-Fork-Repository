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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Runnable Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.RunnableParameter#getContainingRunnable <em>Containing Runnable</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.RunnableParameter#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.RunnableParameter#getDataType <em>Data Type</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.RunnableParameter#getDependsOn <em>Depends On</em>}</li>
 * </ul>
 *
 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getRunnableParameter()
 * @model
 * @generated
 */
public interface RunnableParameter extends ReferableBaseObject {
	/**
	 * Returns the value of the '<em><b>Containing Runnable</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.app4mc.amalthea.model.Runnable#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containing Runnable</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containing Runnable</em>' container reference.
	 * @see #setContainingRunnable(org.eclipse.app4mc.amalthea.model.Runnable)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getRunnableParameter_ContainingRunnable()
	 * @see org.eclipse.app4mc.amalthea.model.Runnable#getParameters
	 * @model opposite="parameters" transient="false"
	 * @generated
	 */
	org.eclipse.app4mc.amalthea.model.Runnable getContainingRunnable();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.RunnableParameter#getContainingRunnable <em>Containing Runnable</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containing Runnable</em>' container reference.
	 * @see #getContainingRunnable()
	 * @generated
	 */
	void setContainingRunnable(org.eclipse.app4mc.amalthea.model.Runnable value);

	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.app4mc.amalthea.model.DirectionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see org.eclipse.app4mc.amalthea.model.DirectionType
	 * @see #setDirection(DirectionType)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getRunnableParameter_Direction()
	 * @model unique="false"
	 * @generated
	 */
	DirectionType getDirection();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.RunnableParameter#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see org.eclipse.app4mc.amalthea.model.DirectionType
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(DirectionType value);

	/**
	 * Returns the value of the '<em><b>Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Type</em>' reference.
	 * @see #setDataType(TypeDefinition)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getRunnableParameter_DataType()
	 * @model
	 * @generated
	 */
	TypeDefinition getDataType();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.RunnableParameter#getDataType <em>Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Type</em>' reference.
	 * @see #getDataType()
	 * @generated
	 */
	void setDataType(TypeDefinition value);

	/**
	 * Returns the value of the '<em><b>Depends On</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depends On</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depends On</em>' containment reference.
	 * @see #setDependsOn(DataDependency)
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getRunnableParameter_DependsOn()
	 * @model containment="true"
	 * @generated
	 */
	DataDependency getDependsOn();

	/**
	 * Sets the value of the '{@link org.eclipse.app4mc.amalthea.model.RunnableParameter#getDependsOn <em>Depends On</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depends On</em>' containment reference.
	 * @see #getDependsOn()
	 * @generated
	 */
	void setDependsOn(DataDependency value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.app4mc.amalthea.model.Runnable%&gt; _containingRunnable = this.getContainingRunnable();\n&lt;%java.lang.String%&gt; _name = null;\nif (_containingRunnable!=null)\n{\n\t_name=_containingRunnable.getName();\n}\nreturn this.basicComputeUniqueNameWithPrefix(_name);'"
	 * @generated
	 */
	String computeUniqueName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.app4mc.amalthea.model.Runnable%&gt; _containingRunnable = this.getContainingRunnable();\n&lt;%java.lang.String%&gt; _name = null;\nif (_containingRunnable!=null)\n{\n\t_name=_containingRunnable.getName();\n}\nfinal &lt;%java.lang.String%&gt; runName = _name;\n&lt;%java.lang.String%&gt; _xifexpression = null;\nboolean _isNullOrEmpty = &lt;%org.eclipse.xtext.xbase.lib.StringExtensions%&gt;.isNullOrEmpty(runName);\nif (_isNullOrEmpty)\n{\n\t_xifexpression = \"&lt;runnable&gt;\";\n}\nelse\n{\n\t_xifexpression = runName;\n}\n&lt;%java.lang.String%&gt; _plus = (_xifexpression + \"::\");\n&lt;%java.lang.String%&gt; _xifexpression_1 = null;\nboolean _isNullOrEmpty_1 = &lt;%org.eclipse.xtext.xbase.lib.StringExtensions%&gt;.isNullOrEmpty(this.getName());\nif (_isNullOrEmpty_1)\n{\n\t_xifexpression_1 = \"&lt;parameter&gt;\";\n}\nelse\n{\n\t_xifexpression_1 = this.getName();\n}\nreturn (_plus + _xifexpression_1);'"
	 * @generated
	 */
	String toString();

} // RunnableParameter
