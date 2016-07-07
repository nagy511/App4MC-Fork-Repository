/*******************************************************************************
 * Copyright (c) 2016 Robert Bosch GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Robert Bosch GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.app4mc.amalthea.converters.common.utils;

import java.util.ArrayList;
import java.util.List;

public class SchemaUtils {

	private static final List<String> multipleOccurances_110 = new ArrayList<String>();

	private static final List<String> multipleOccurances_111 = new ArrayList<String>();

	static {
		multipleOccurances_110.add("taskSchedulers");
		multipleOccurances_110.add("operatingSystems");


		multipleOccurances_111.add("components");
		multipleOccurances_111.add("systems");
		multipleOccurances_111.add("elements");
		multipleOccurances_111.add("ports");
		multipleOccurances_111.add("componentInstances");
		multipleOccurances_111.add("modeLabels");
	}

	public static boolean isMultiOccuranceElement_110(final String elementName) {

		return multipleOccurances_110.contains(elementName);
	}

	public static boolean isMultiOccuranceElement_111(final String elementName) {

		return multipleOccurances_111.contains(elementName);
	}

	public static boolean isMultiOccuranceElement(final String elementName, final ModelVersion modelVersion) {

		if (modelVersion.equals(ModelVersion._110)) {
			return isMultiOccuranceElement_110(elementName);
		}
		else if (modelVersion.equals(ModelVersion._111)) {
			return isMultiOccuranceElement_111(elementName);
		}
		return false;
	}


}
