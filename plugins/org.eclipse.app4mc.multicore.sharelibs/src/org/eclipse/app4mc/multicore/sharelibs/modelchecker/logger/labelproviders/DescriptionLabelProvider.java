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
 *   Dortmund University of Applied Sciences and Arts - initial API and implementation
 ********************************************************************************
 */

package org.eclipse.app4mc.multicore.sharelibs.modelchecker.logger.labelproviders;

import org.eclipse.app4mc.multicore.sharelibs.modelchecker.logger.CategoryTreeNodeInfo;
import org.eclipse.app4mc.multicore.sharelibs.modelchecker.logger.LoggerEntry;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.swt.graphics.Image;

public class DescriptionLabelProvider extends ColumnLabelProvider {

	/**
	 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(final Object element) {
		if (!(element instanceof TreeNode)) {
			return "";
		}

		final TreeNode node = (TreeNode) element;
		final Object value = node.getValue();

		if (value instanceof CategoryTreeNodeInfo) {
			final CategoryTreeNodeInfo info = (CategoryTreeNodeInfo) value;
			return info.toString();
		}

		if (value instanceof LoggerEntry) {
			final LoggerEntry entry = (LoggerEntry) value;
			return entry.getMessage();
		}

		return "";

	}

	/**
	 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(final Object element) {
		if (!(element instanceof TreeNode)) {
			return null;
		}

		final TreeNode node = (TreeNode) element;
		final Object value = node.getValue();

		if (value instanceof CategoryTreeNodeInfo) {
			final CategoryTreeNodeInfo info = (CategoryTreeNodeInfo) value;
			return info.getImage();
		}

		if (value instanceof LoggerEntry) {
			final CategoryTreeNodeInfo parentIfo = (CategoryTreeNodeInfo) node.getParent().getValue();
			return parentIfo.getImage();
		}

		return null;
	}
}
