/**
 * *******************************************************************************
 *  Copyright (c) 2013 Robert Bosch GmbH and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Robert Bosch GmbH - initial API and implementation
 *     
 * *******************************************************************************
 */
package org.eclipse.app4mc.amalthea.sphinx.ui.editors.search;

import java.text.MessageFormat;

import org.eclipse.app4mc.amalthea.sphinx.ui.editors.messages.Messages;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.text.AbstractTextSearchResult;
import org.eclipse.search.ui.text.IEditorMatchAdapter;
import org.eclipse.search.ui.text.IFileMatchAdapter;

/**
 * 
 * 
 */
public class ModelSearchResult extends AbstractTextSearchResult {

	private final ISearchQuery query;

	@SuppressWarnings("javadoc")
	public ModelSearchResult(final ISearchQuery query) {
		this.query = query;
	}

	/**
	 * @see org.eclipse.search.ui.ISearchResult#getLabel()
	 */
	@Override
	public String getLabel() {
		if (getMatchCount() == 1) {
			return Messages.ModelSearchResult_label;
		}
		return MessageFormat.format(Messages.ModelSearchResult_results, getMatchCount());
	}

	/**
	 * @see org.eclipse.search.ui.ISearchResult#getTooltip()
	 */
	@Override
	public String getTooltip() {
		return getLabel();
	}

	/**
	 * @see org.eclipse.search.ui.ISearchResult#getImageDescriptor()
	 */
	@Override
	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	/**
	 * @see org.eclipse.search.ui.ISearchResult#getQuery()
	 */
	@Override
	public ISearchQuery getQuery() {
		return this.query;
	}

	/**
	 * @see org.eclipse.search.ui.text.AbstractTextSearchResult#getEditorMatchAdapter()
	 */
	@Override
	public IEditorMatchAdapter getEditorMatchAdapter() {
		return null;
	}

	/**
	 * @see org.eclipse.search.ui.text.AbstractTextSearchResult#getFileMatchAdapter()
	 */
	@Override
	public IFileMatchAdapter getFileMatchAdapter() {
		return null;
	}

}
