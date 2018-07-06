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
 * A representation of the model object '<em><b>IReferable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * IReferable: Computed ID for name based references
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.IReferable#getUniqueName <em>Unique Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getIReferable()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IReferable extends INamed {
	/**
	 * Returns the value of the '<em><b>Unique Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unique Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unique Name</em>' attribute.
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getIReferable_UniqueName()
	 * @model unique="false" id="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='Read only' propertyFilterFlags='org.eclipse.ui.views.properties.expert' get='return this.computeUniqueName();'"
	 * @generated
	 */
	String getUniqueName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Overwrite this method to define specific IDs (used by name-based references).
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.basicComputeUniqueName();'"
	 * @generated
	 */
	String computeUniqueName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.lang.String%&gt; _encode = this.encode(this.getName());\n&lt;%java.lang.String%&gt; _plus = (_encode + \"?type=\");\n&lt;%java.lang.String%&gt; _name = this.eClass().getName();\nreturn (_plus + _name);'"
	 * @generated
	 */
	String basicComputeUniqueName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" prefixUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.lang.String%&gt; _encode = this.encode(prefix);\n&lt;%java.lang.String%&gt; _plus = (_encode + \"/\");\n&lt;%java.lang.String%&gt; _basicComputeUniqueName = this.basicComputeUniqueName();\nreturn (_plus + _basicComputeUniqueName);'"
	 * @generated
	 */
	String basicComputeUniqueNameWithPrefix(String prefix);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" strUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='try\n{\n\t&lt;%java.lang.String%&gt; _xifexpression = null;\n\tboolean _isNullOrEmpty = &lt;%org.eclipse.xtext.xbase.lib.StringExtensions%&gt;.isNullOrEmpty(str);\n\tif (_isNullOrEmpty)\n\t{\n\t\t_xifexpression = \"no-name\";\n\t}\n\telse\n\t{\n\t\t_xifexpression = &lt;%java.net.URLEncoder%&gt;.encode(str, &lt;%java.nio.charset.StandardCharsets%&gt;.UTF_8.toString());\n\t}\n\treturn _xifexpression;\n}\ncatch (Throwable _e)\n{\n\tthrow org.eclipse.xtext.xbase.lib.Exceptions.sneakyThrow(_e);\n}'"
	 * @generated
	 */
	String encode(String str);

} // IReferable
