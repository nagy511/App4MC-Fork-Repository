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
import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mode Value Disjunction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.ModeValueDisjunction#getEntries <em>Entries</em>}</li>
 * </ul>
 *
 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getModeValueDisjunction()
 * @model
 * @generated
 */
public interface ModeValueDisjunction extends BaseObject {
	/**
	 * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.app4mc.amalthea.model.ModeValueDisjunctionEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entries</em>' containment reference list.
	 * @see org.eclipse.app4mc.amalthea.model.AmaltheaPackage#getModeValueDisjunction_Entries()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ModeValueDisjunctionEntry> getEntries();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" assignmentMapType="org.eclipse.app4mc.amalthea.model.ModeValueMapEntry&lt;org.eclipse.app4mc.amalthea.model.ModeLabel, org.eclipse.app4mc.amalthea.model.ModeLiteral&gt;"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%org.eclipse.app4mc.amalthea.model.ModeValueDisjunctionEntry%&gt;&gt; _entries = this.getEntries();\nfor (final &lt;%org.eclipse.app4mc.amalthea.model.ModeValueDisjunctionEntry%&gt; entry : _entries)\n{\n\tboolean _isSatisfiedBy = entry.isSatisfiedBy(assignment);\n\tif (_isSatisfiedBy)\n\t{\n\t\treturn true;\n\t}\n}\nreturn false;'"
	 * @generated
	 */
	boolean isSatisfiedBy(EMap<ModeLabel, ModeLiteral> assignment);

} // ModeValueDisjunction
