/**
 ********************************************************************************
 * Copyright (c) 2019 Robert Bosch GmbH and others.
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     Robert Bosch GmbH - initial API and implementation
 ********************************************************************************
 */

package org.eclipse.app4mc.validation.ui.provider;

import org.eclipse.app4mc.validation.core.IProfile;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeNode;

public class ProfileLabelProvider extends LabelProvider {

	@SuppressWarnings("unchecked")
	@Override
	public String getText(Object element) {
		if (element instanceof TreeNode) {
			TreeNode node = (TreeNode) element;
			Class<? extends IProfile> cls = (Class<? extends IProfile>) node.getValue();
			return cls.getSimpleName();
		}
		return super.getText(element);
	}

}
