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
package org.eclipse.app4mc.amalthea.converters080.test;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.app4mc.amalthea.converters080.impl.RootElementConverter;
import org.eclipse.app4mc.amalthea.converters080.impl.SwConverter;
import org.jdom2.Document;
import org.jdom2.output.XMLOutputter;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Parameterized.class)
public class SignedTimeConverterTest extends AbstractConverterTest {


	@Parameterized.Parameters(name = "{index}: Test data ID: {0}. Description : {3}")
	public static Collection<Object[]> getTestData() {

		final String[] inputFiles_swModeLabels = new String[] { "/signedTime/signedTime.amxmi" };


		return Arrays.asList(new Object[][] { { "ModeLabel", true, inputFiles_swModeLabels,
				"Migration of Amalthea models containing ModeLabels (both simple and cross references)" } });
	}

	public SignedTimeConverterTest(final String testDataID, final boolean canExecuteTestCase, final String[] xmlFiles,
			final String description) {

		super(testDataID, xmlFiles, canExecuteTestCase);
	}


	@Test
	public void testConversion() {
		super.testConversion(org.eclipse.app4mc.amalthea.converters080.impl.NamespaceConverter.class,
				RootElementConverter.class, SwConverter.class);
	}


	@Override
	@Test
	public void verification() {
		super.verification();
	}

	@Override
	protected void modelFileVerificationHook(final Document document) {
		super.modelFileVerificationHook(document);

		final XMLOutputter outputter = new XMLOutputter();
		final String docBufferString = outputter.outputString(document);


		assertTrue(
				"Model migration of \"SignedTime\" element is not successful in model file : " + document.getBaseURI(),
				!docBufferString.contains("SignedTime"));

	}


}
