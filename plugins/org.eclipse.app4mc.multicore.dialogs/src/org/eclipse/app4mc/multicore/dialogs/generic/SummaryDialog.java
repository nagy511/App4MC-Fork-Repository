/**
 ********************************************************************************
 * Copyright (c) 2017 Dortmund University of Applied Sciences and Arts and others.
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *    Dortmund University of Applied Sciences and Arts - initial API and implementation
 ********************************************************************************
 */

package org.eclipse.app4mc.multicore.dialogs.generic;

import org.eclipse.app4mc.multicore.dialogs.AbstractDialogPage;
import org.eclipse.app4mc.multicore.dialogs.AbstractGroup;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Composite;

public class SummaryDialog extends AbstractDialogPage {
	/**
	 * Default group index
	 */
	public final static int DEFAULT_GROUP = 0;
	/**
	 * Max Group
	 */
	public final static int MAX_GROUP = 1;


	/**
	 * Constructor
	 *
	 * @param store
	 *            preferences store
	 */
	public SummaryDialog(final IPreferenceStore store) {
		super(store);
	}


	/**
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(final Composite parent) {
		this.groups = new AbstractGroup[MAX_GROUP];

		this.groups[DEFAULT_GROUP] = new SummaryGroup(parent, this.store);

	}

}
