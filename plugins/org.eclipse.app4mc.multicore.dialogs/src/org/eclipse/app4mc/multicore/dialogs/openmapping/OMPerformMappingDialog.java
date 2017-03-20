/*******************************************************************************
 * Copyright (c) 2017 Dortmund University of Applied Sciences and Arts and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dortmund University of Applied Sciences and Arts - initial API and implementation
 *
 ******************************************************************************/
package org.eclipse.app4mc.multicore.dialogs.openmapping;

import org.eclipse.app4mc.multicore.dialogs.AbstractDialogPage;
import org.eclipse.app4mc.multicore.dialogs.AbstractGroup;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Composite;

public class OMPerformMappingDialog extends AbstractDialogPage {
	/**
	 * Logging group
	 */
	public final static int DEFAULT_GROUP = 0;
	/**
	 * Max group
	 */
	public final static int MAX_GROUP = 1;

	/**
	 * Constructor
	 *
	 * @param store
	 *            preferences store
	 */
	public OMPerformMappingDialog(final IPreferenceStore store) {
		super(store);
	}

	/**
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(final Composite parent) {

		this.groups = new AbstractGroup[MAX_GROUP];

		// Perform Mapping group
		this.groups[DEFAULT_GROUP] = new OMPerformMappingGroup(parent, this.store);

	}
}
