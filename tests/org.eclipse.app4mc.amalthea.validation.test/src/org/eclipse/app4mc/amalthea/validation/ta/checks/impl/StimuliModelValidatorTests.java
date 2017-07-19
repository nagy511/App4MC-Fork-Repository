/*******************************************************************************
 * Copyright (c) 2016 Timing-Architects Embedded Systems GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Timing-Architects Embedded Systems GmbH - initial API and implementation
 *
 *******************************************************************************/

package org.eclipse.app4mc.amalthea.validation.ta.checks.impl;

import java.math.BigInteger;

import org.easymock.EasyMock;
import org.eclipse.app4mc.amalthea.model.Amalthea;
import org.eclipse.app4mc.amalthea.model.AmaltheaFactory;
import org.eclipse.app4mc.amalthea.model.AmaltheaPackage;
import org.eclipse.app4mc.amalthea.model.ArrivalCurve;
import org.eclipse.app4mc.amalthea.model.ArrivalCurveEntry;
import org.eclipse.app4mc.amalthea.model.Clock;
import org.eclipse.app4mc.amalthea.model.ClockMultiplierList;
import org.eclipse.app4mc.amalthea.model.ClockMultiplierListEntry;
import org.eclipse.app4mc.amalthea.model.ClockSinusFunction;
import org.eclipse.app4mc.amalthea.model.ClockTriangleFunction;
import org.eclipse.app4mc.amalthea.model.ModeLabel;
import org.eclipse.app4mc.amalthea.model.ModeValue;
import org.eclipse.app4mc.amalthea.model.ModeValueList;
import org.eclipse.app4mc.amalthea.model.ModeValueListEntry;
import org.eclipse.app4mc.amalthea.model.Periodic;
import org.eclipse.app4mc.amalthea.model.SWModel;
import org.eclipse.app4mc.amalthea.model.Single;
import org.eclipse.app4mc.amalthea.model.StimuliModel;
import org.eclipse.app4mc.amalthea.model.Synthetic;
import org.eclipse.app4mc.amalthea.model.Time;
import org.eclipse.app4mc.amalthea.model.TimeUnit;
import org.eclipse.app4mc.amalthea.model.TimestampList;
import org.eclipse.app4mc.amalthea.sphinx.validation.api.IssueCreator;
import org.eclipse.app4mc.amalthea.validation.ta.checks.StimuliModelValidator;
import org.junit.Before;
import org.junit.Test;

public class StimuliModelValidatorTests {

	private StimuliModelValidatorImpl classUnderTest;

	private IssueCreator issueCreator;

	@Before
	public void setUp() {
		/*
		 * Create mock of dependency class
		 */
		this.issueCreator = EasyMock.createMock(IssueCreator.class);
		// this.eObjectHelper = EasyMock.createMock(EObjectHelper.class);

		/*
		 * Create object from class to be tested
		 */
		this.classUnderTest = new StimuliModelValidatorImpl(this.issueCreator/*, this.eObjectHelper*/);
	}

	/**
	 * Test for validation method {@link StimuliModelValidator#checkQuartzFrequency(AMALTHEA)}
	 */
	@Test
	public void test_checkPeriodicRecurrence_negative() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Periodic periodic = AmaltheaFactory.eINSTANCE.createPeriodic();
		final Time recurrence = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.valueOf(-10);
		final TimeUnit unit = TimeUnit.MS;

		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(periodic);
		periodic.setRecurrence(recurrence);
		recurrence.setValue(value);
		recurrence.setUnit(unit);

		this.issueCreator.issue(periodic, AmaltheaPackage.eINSTANCE.getPeriodic_Recurrence(), value, unit);

		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkPeriodicRecurrence(amalthea);

		// evaluate
		EasyMock.verify(this.issueCreator);
	}

	/**
	 * Test for validation method {@link StimuliModelValidator#checkQuartzFrequency(AMALTHEA)}
	 */
	@Test
	public void test_checkPeriodicRecurrence_zero() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Periodic periodic = AmaltheaFactory.eINSTANCE.createPeriodic();
		final Time recurrence = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.ZERO;
		final TimeUnit unit = TimeUnit.MS;

		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(periodic);
		periodic.setRecurrence(recurrence);
		recurrence.setValue(value);
		recurrence.setUnit(unit);

		this.issueCreator.issue(periodic, AmaltheaPackage.eINSTANCE.getPeriodic_Recurrence(), value, unit);

		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkPeriodicRecurrence(amalthea);

		// evaluate
		EasyMock.verify(this.issueCreator);
	}

	/**
	 * Test for validation method {@link StimuliModelValidator#checkQuartzFrequency(AMALTHEA)}
	 */
	@Test
	public void test_checkPeriodicRecurrence_positive() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Periodic periodic = AmaltheaFactory.eINSTANCE.createPeriodic();
		final Time recurrence = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.TEN;
		final TimeUnit unit = TimeUnit.MS;

		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(periodic);
		periodic.setRecurrence(recurrence);
		recurrence.setValue(value);
		recurrence.setUnit(unit);

		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkPeriodicRecurrence(amalthea);

		// evaluate
		EasyMock.verify(this.issueCreator);
	}

	// /**
	// * Test for validation method {@link StimuliModelValidator#checkClockReferenceOfPeriodic(AMALTHEA)}
	// */
	// @Test
	// public void test_checkClockReferenceOfPeriodic_null() {
	// // prepare
	// final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
	// final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
	// final Periodic periodic = AmaltheaFactory.eINSTANCE.createPeriodic();
	// final Time recurrence = AmaltheaFactory.eINSTANCE.createTime();
	// int value = 10;
	// TimeUnit unit = TimeUnit.MS;
	//
	// amalthea.setStimuliModel(stimuliModel);
	// stimuliModel.getStimuli().add(periodic);
	// periodic.setRecurrence(recurrence);
	// recurrence.setValue(value);
	// recurrence.setUnit(unit);
	//
	// EasyMock.replay(this.issueCreator);
	//
	// // test
	// this.classUnderTest.checkClockReferenceOfPeriodic(amalthea);
	//
	// // evaluate
	// EasyMock.verify(this.issueCreator);
	// }

	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockReferenceOfPeriodic(AMALTHEA)}
	 */
	@Test
	public void test_checkQuartzReferenceOfPrescaler_null() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Periodic periodic = AmaltheaFactory.eINSTANCE.createPeriodic();

		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(periodic);

		this.issueCreator.issue(periodic, AmaltheaPackage.eINSTANCE.getPeriodic_Clock());

		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockReferenceOfPeriodic(amalthea);

		// evaluate
		EasyMock.verify(this.issueCreator);
	}

	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockReferenceOfPeriodic(AMALTHEA)}
	 */
	@Test
	public void test_checkQuartzReferenceOfPrescaler_notExisting() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Clock clock = AmaltheaFactory.eINSTANCE.createClockSinusFunction();
		final Periodic periodic = AmaltheaFactory.eINSTANCE.createPeriodic();

		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(periodic);
		periodic.setClock(clock);

		this.issueCreator.issue(periodic, AmaltheaPackage.eINSTANCE.getPeriodic_Clock());

		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockReferenceOfPeriodic(amalthea);

		// evaluate
		EasyMock.verify(this.issueCreator);
	}

	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockReferenceOfPeriodic(AMALTHEA)}
	 */
	@Test
	public void test_checkQuartzReferenceOfPrescaler_Existing() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Clock clock = AmaltheaFactory.eINSTANCE.createClockSinusFunction();
		final Periodic periodic = AmaltheaFactory.eINSTANCE.createPeriodic();

		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getClocks().add(clock);
		stimuliModel.getStimuli().add(periodic);
		periodic.setClock(clock);

		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockReferenceOfPeriodic(amalthea);

		// evaluate
		EasyMock.verify(this.issueCreator);
	}

	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockTriangleFunctionConstraint(AMALTHEA)}
	 */
	@Test
	public void test_checkClockTriangleFunctionConstraint_null() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final ClockTriangleFunction clock = AmaltheaFactory.eINSTANCE.createClockTriangleFunction();

		stimuliModel.getClocks().add(clock);
		amalthea.setStimuliModel(stimuliModel);

		this.issueCreator.issue(clock, AmaltheaPackage.eINSTANCE.getClockTriangleFunction_Max());

		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockTriangleFunction(amalthea);

		// evaluate
		EasyMock.verify(this.issueCreator);
	}

	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockTriangleFunctionConstraint(AMALTHEA)}
	 */
	@Test
	public void test_checkClockTriangleFunctionConstraint_minNegative() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final ClockTriangleFunction clock = AmaltheaFactory.eINSTANCE.createClockTriangleFunction();
		final int min = -1;

		clock.setMin(min);
		stimuliModel.getClocks().add(clock);
		amalthea.setStimuliModel(stimuliModel);

		this.issueCreator.issue(clock, AmaltheaPackage.eINSTANCE.getClockTriangleFunction_Min());

		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockTriangleFunction(amalthea);

		// evaluate
		EasyMock.verify(this.issueCreator);
	}

	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockTriangleFunctionConstraint(AMALTHEA)}
	 */
	@Test
	public void test_checkClockTriangleFunctionConstraint_minPositive() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final ClockTriangleFunction clock = AmaltheaFactory.eINSTANCE.createClockTriangleFunction();
		final int min = 1;

		clock.setMin(min);
		stimuliModel.getClocks().add(clock);
		amalthea.setStimuliModel(stimuliModel);

		this.issueCreator.issue(clock, AmaltheaPackage.eINSTANCE.getClockTriangleFunction_Max());

		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockTriangleFunction(amalthea);

		// evaluate
		EasyMock.verify(this.issueCreator);
	}

	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockTriangleFunctionConstraint(AMALTHEA)}
	 */
	@Test
	public void test_checkClockTriangleFunctionConstraint_maxNegative() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final ClockTriangleFunction clock = AmaltheaFactory.eINSTANCE.createClockTriangleFunction();
		final int max = -1;

		clock.setMax(max);
		stimuliModel.getClocks().add(clock);
		amalthea.setStimuliModel(stimuliModel);

		this.issueCreator.issue(clock, AmaltheaPackage.eINSTANCE.getClockTriangleFunction_Max());

		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockTriangleFunction(amalthea);

		// evaluate
		EasyMock.verify(this.issueCreator);
	}

	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockTriangleFunctionConstraint(AMALTHEA)}
	 */
	@Test
	public void test_checkClockTriangleFunctionConstraint_maxPositive() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final ClockTriangleFunction clock = AmaltheaFactory.eINSTANCE.createClockTriangleFunction();
		final int max = 1;

		clock.setMax(max);
		stimuliModel.getClocks().add(clock);
		amalthea.setStimuliModel(stimuliModel);

		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockTriangleFunction(amalthea);

		// evaluate
		EasyMock.verify(this.issueCreator);
	}

	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockTriangleFunctionConstraint(AMALTHEA)}
	 */
	@Test
	public void test_checkClockTriangleFunctionConstraint_minMaxIncorrect() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final ClockTriangleFunction clock = AmaltheaFactory.eINSTANCE.createClockTriangleFunction();
		final int min = 2;
		final int max = 1;

		clock.setMin(min);
		clock.setMax(max);
		stimuliModel.getClocks().add(clock);
		amalthea.setStimuliModel(stimuliModel);

		this.issueCreator.issue(clock, AmaltheaPackage.eINSTANCE.getClockTriangleFunction_Min());

		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockTriangleFunction(amalthea);

		// evaluate
		EasyMock.verify(this.issueCreator);
	}

	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockTriangleFunctionConstraint(AMALTHEA)}
	 */
	@Test
	public void test_checkClockTriangleFunctionConstraint_minMaxCorrect() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final ClockTriangleFunction clock = AmaltheaFactory.eINSTANCE.createClockTriangleFunction();
		final int min = 1;
		final int max = 2;

		clock.setMin(min);
		clock.setMax(max);
		stimuliModel.getClocks().add(clock);
		amalthea.setStimuliModel(stimuliModel);

		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockTriangleFunction(amalthea);

		// evaluate
		EasyMock.verify(this.issueCreator);
	}

	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockTriangleFunctionConstraint(AMALTHEA)}
	 */
	@Test
	public void test_checkClockSinusFunctionConstraint_null() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final ClockSinusFunction clock = AmaltheaFactory.eINSTANCE.createClockSinusFunction();

		stimuliModel.getClocks().add(clock);
		amalthea.setStimuliModel(stimuliModel);

		this.issueCreator.issue(clock, AmaltheaPackage.eINSTANCE.getClockSinusFunction_YOffset());

		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockSinusFunction(amalthea);

		// evaluate
		EasyMock.verify(this.issueCreator);
	}

	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockTriangleFunctionConstraint(AMALTHEA)}
	 */
	@Test
	public void test_checkClockSinusFunctionConstraint_amplitudeNegative() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final ClockSinusFunction clock = AmaltheaFactory.eINSTANCE.createClockSinusFunction();
		final int amplitude = -1;

		clock.setAmplitude(amplitude);
		stimuliModel.getClocks().add(clock);
		amalthea.setStimuliModel(stimuliModel);

		this.issueCreator.issue(clock, AmaltheaPackage.eINSTANCE.getClockSinusFunction_Amplitude());

		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockSinusFunction(amalthea);

		// evaluate
		EasyMock.verify(this.issueCreator);
	}

	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockTriangleFunctionConstraint(AMALTHEA)}
	 */
	@Test
	public void test_checkClockSinusFunctionConstraint_amplitudePositive() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final ClockSinusFunction clock = AmaltheaFactory.eINSTANCE.createClockSinusFunction();
		final int amplitude = 1;

		clock.setAmplitude(amplitude);
		stimuliModel.getClocks().add(clock);
		amalthea.setStimuliModel(stimuliModel);

		this.issueCreator.issue(clock, AmaltheaPackage.eINSTANCE.getClockSinusFunction_YOffset());

		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockSinusFunction(amalthea);

		// evaluate
		EasyMock.verify(this.issueCreator);
	}

	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockTriangleFunctionConstraint(AMALTHEA)}
	 */
	@Test
	public void test_checkClockSinusFunctionConstraint_yOffsetNegative() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final ClockSinusFunction clock = AmaltheaFactory.eINSTANCE.createClockSinusFunction();
		final int yOffset = -1;

		clock.setYOffset(yOffset);
		stimuliModel.getClocks().add(clock);
		amalthea.setStimuliModel(stimuliModel);

		this.issueCreator.issue(clock, AmaltheaPackage.eINSTANCE.getClockSinusFunction_YOffset());

		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockSinusFunction(amalthea);

		// evaluate
		EasyMock.verify(this.issueCreator);
	}

	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockTriangleFunctionConstraint(AMALTHEA)}
	 */
	@Test
	public void test_checkClockSinusFunctionConstraint_yOffsetPositive() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final ClockSinusFunction clock = AmaltheaFactory.eINSTANCE.createClockSinusFunction();
		final int yOffset = 1;

		clock.setYOffset(yOffset);
		stimuliModel.getClocks().add(clock);
		amalthea.setStimuliModel(stimuliModel);

		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockSinusFunction(amalthea);

		// evaluate
		EasyMock.verify(this.issueCreator);
	}

	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockTriangleFunctionConstraint(AMALTHEA)}
	 */
	@Test
	public void test_checkClockSinusFunctionConstraint_amplitudeYOffsetIncorrect() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final ClockSinusFunction clock = AmaltheaFactory.eINSTANCE.createClockSinusFunction();
		final int amplitude = 2;
		final int yOffset = 1;

		clock.setAmplitude(amplitude);
		clock.setYOffset(yOffset);
		stimuliModel.getClocks().add(clock);
		amalthea.setStimuliModel(stimuliModel);

		this.issueCreator.issue(clock, AmaltheaPackage.eINSTANCE.getClockSinusFunction_Amplitude());

		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockSinusFunction(amalthea);

		// evaluate
		EasyMock.verify(this.issueCreator);
	}

	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockTriangleFunctionConstraint(AMALTHEA)}
	 */
	@Test
	public void test_checkClockSinusFunctionConstraint_amplitudeYOffsetCorrect() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final ClockSinusFunction clock = AmaltheaFactory.eINSTANCE.createClockSinusFunction();
		final int amplitude = 1;
		final int yOffset = 2;

		clock.setAmplitude(amplitude);
		clock.setYOffset(yOffset);
		stimuliModel.getClocks().add(clock);
		amalthea.setStimuliModel(stimuliModel);

		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockSinusFunction(amalthea);

		// evaluate
		EasyMock.verify(this.issueCreator);
	}

	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockMultiplierListConstraint(AMALTHEA)}
	 */
	@Test
	public void test_checkClockMultiplierListConstraint_null() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final ClockMultiplierList clock = AmaltheaFactory.eINSTANCE.createClockMultiplierList();
		final ClockMultiplierListEntry entry = AmaltheaFactory.eINSTANCE.createClockMultiplierListEntry();

		clock.getEntries().add(entry);
		stimuliModel.getClocks().add(clock);
		amalthea.setStimuliModel(stimuliModel);

		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockMultiplierList(amalthea);

		// evaluate
		EasyMock.verify(this.issueCreator);
	}

	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockMultiplierListConstraint(AMALTHEA)}
	 */
	@Test
	public void test_checkClockMultiplierListConstraint_negative() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final ClockMultiplierList clock = AmaltheaFactory.eINSTANCE.createClockMultiplierList();
		final ClockMultiplierListEntry entry = AmaltheaFactory.eINSTANCE.createClockMultiplierListEntry();
		final double value = -1;

		entry.setMultiplier(value);
		clock.getEntries().add(entry);
		stimuliModel.getClocks().add(clock);
		amalthea.setStimuliModel(stimuliModel);

		this.issueCreator.issue(clock, AmaltheaPackage.eINSTANCE.getClockMultiplierListEntry_Multiplier());

		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockMultiplierList(amalthea);

		// evaluate
		EasyMock.verify(this.issueCreator);
	}

	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockMultiplierListConstraint(AMALTHEA)}
	 */
	@Test
	public void test_checkClockMultiplierListConstraint_positive() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final ClockMultiplierList clock = AmaltheaFactory.eINSTANCE.createClockMultiplierList();
		final ClockMultiplierListEntry entry = AmaltheaFactory.eINSTANCE.createClockMultiplierListEntry();
		final double value = 1;

		entry.setMultiplier(value);
		clock.getEntries().add(entry);
		stimuliModel.getClocks().add(clock);
		amalthea.setStimuliModel(stimuliModel);

		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockMultiplierList(amalthea);

		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkPeriodicOffsetUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkPeriodicOffsetUnsigned_null() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Periodic periodic = AmaltheaFactory.eINSTANCE.createPeriodic();
		final Time offset = null;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(periodic);
		periodic.setOffset(offset);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkPeriodicOffsetUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkPeriodicOffsetUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkPeriodicOffsetUnsigned_negative() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Periodic periodic = AmaltheaFactory.eINSTANCE.createPeriodic();
		final Time offset = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.valueOf(-10);
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(periodic);
		periodic.setOffset(offset);
		offset.setValue(value);
		offset.setUnit(unit);
		
		this.issueCreator.issue(offset, AmaltheaPackage.eINSTANCE.getPeriodic_Offset(), value);
		
		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkPeriodicOffsetUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkPeriodicOffsetUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkPeriodicOffsetUnsigned_zero() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Periodic periodic = AmaltheaFactory.eINSTANCE.createPeriodic();
		final Time offset = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.ZERO;
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(periodic);
		periodic.setOffset(offset);
		offset.setValue(value);
		offset.setUnit(unit);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkPeriodicOffsetUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkPeriodicOffsetUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkPeriodicOffsetUnsigned_positive() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Periodic periodic = AmaltheaFactory.eINSTANCE.createPeriodic();
		final Time offset = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.TEN;
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(periodic);
		periodic.setOffset(offset);
		offset.setValue(value);
		offset.setUnit(unit);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkPeriodicOffsetUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkPeriodicRecurrenceUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkPeriodicRecurrenceUnsigned_null() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Periodic periodic = AmaltheaFactory.eINSTANCE.createPeriodic();
		final Time recurrence = null;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(periodic);
		periodic.setRecurrence(recurrence);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkPeriodicRecurrenceUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkPeriodicRecurrenceUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkPeriodicRecurrenceUnsigned_negative() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Periodic periodic = AmaltheaFactory.eINSTANCE.createPeriodic();
		final Time recurrence = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.valueOf(-10);
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(periodic);
		periodic.setRecurrence(recurrence);
		recurrence.setValue(value);
		recurrence.setUnit(unit);
		
		this.issueCreator.issue(recurrence, AmaltheaPackage.eINSTANCE.getPeriodic_Recurrence(), value);
		
		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkPeriodicRecurrenceUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkPeriodicRecurrenceUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkPeriodicRecurrenceUnsigned_zero() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Periodic periodic = AmaltheaFactory.eINSTANCE.createPeriodic();
		final Time recurrence = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.ZERO;
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(periodic);
		periodic.setRecurrence(recurrence);
		recurrence.setValue(value);
		recurrence.setUnit(unit);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkPeriodicRecurrenceUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkPeriodicRecurrenceUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkPeriodicRecurrenceUnsigned_positive() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Periodic periodic = AmaltheaFactory.eINSTANCE.createPeriodic();
		final Time recurrence = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.TEN;
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(periodic);
		periodic.setRecurrence(recurrence);
		recurrence.setValue(value);
		recurrence.setUnit(unit);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkPeriodicRecurrenceUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkSyntheticOffsetUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkSyntheticOffsetUnsigned_null() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Synthetic synthetic = AmaltheaFactory.eINSTANCE.createSynthetic();
		final Time offset = null;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(synthetic);
		synthetic.setOffset(offset);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkSyntheticOffsetUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkSyntheticOffsetUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkSyntheticOffsetUnsigned_negative() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Synthetic synthetic = AmaltheaFactory.eINSTANCE.createSynthetic();
		final Time offset = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.valueOf(-10);
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(synthetic);
		synthetic.setOffset(offset);
		offset.setValue(value);
		offset.setUnit(unit);
		
		this.issueCreator.issue(offset, AmaltheaPackage.eINSTANCE.getSynthetic_Offset(), value);
		
		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkSyntheticOffsetUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkSyntheticOffsetUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkSyntheticOffsetUnsigned_zero() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Synthetic synthetic = AmaltheaFactory.eINSTANCE.createSynthetic();
		final Time offset = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.ZERO;
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(synthetic);
		synthetic.setOffset(offset);
		offset.setValue(value);
		offset.setUnit(unit);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkSyntheticOffsetUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkSyntheticOffsetUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkSyntheticOffsetUnsigned_positive() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Synthetic synthetic = AmaltheaFactory.eINSTANCE.createSynthetic();
		final Time offset = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.TEN;
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(synthetic);
		synthetic.setOffset(offset);
		offset.setValue(value);
		offset.setUnit(unit);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkSyntheticOffsetUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkSyntheticPeriodUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkSyntheticPeriodUnsigned_null() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Synthetic synthetic = AmaltheaFactory.eINSTANCE.createSynthetic();
		final Time period = null;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(synthetic);
		synthetic.setPeriod(period);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkSyntheticPeriodUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkSyntheticPeriodUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkSyntheticPeriodUnsigned_negative() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Synthetic synthetic = AmaltheaFactory.eINSTANCE.createSynthetic();
		final Time period = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.valueOf(-10);
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(synthetic);
		synthetic.setPeriod(period);
		period.setValue(value);
		period.setUnit(unit);
		
		this.issueCreator.issue(period, AmaltheaPackage.eINSTANCE.getSynthetic_Period(), value);
		
		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkSyntheticPeriodUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkSyntheticPeriodUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkSyntheticPeriodUnsigned_zero() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Synthetic synthetic = AmaltheaFactory.eINSTANCE.createSynthetic();
		final Time period = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.ZERO;
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(synthetic);
		synthetic.setPeriod(period);
		period.setValue(value);
		period.setUnit(unit);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkSyntheticPeriodUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkSyntheticPeriodUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkSyntheticPeriodUnsigned_positive() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Synthetic synthetic = AmaltheaFactory.eINSTANCE.createSynthetic();
		final Time period = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.TEN;
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(synthetic);
		synthetic.setPeriod(period);
		period.setValue(value);
		period.setUnit(unit);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkSyntheticPeriodUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkTimestampListTimestampsUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkTimestampListTimestampsUnsigned_empty() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Synthetic synthetic = AmaltheaFactory.eINSTANCE.createSynthetic();
		TimestampList timestampList = AmaltheaFactory.eINSTANCE.createTimestampList();
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(synthetic);
		synthetic.setTriggerTimes(timestampList);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkTimestampListTimestampsUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkTimestampListTimestampsUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkTimestampListTimestampsUnsigned_negative() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Synthetic synthetic = AmaltheaFactory.eINSTANCE.createSynthetic();
		final TimestampList timestampList = AmaltheaFactory.eINSTANCE.createTimestampList();
		final Time timestamp = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.valueOf(-10);
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(synthetic);
		synthetic.setTriggerTimes(timestampList);
		timestampList.getTimestamps().add(timestamp);
		timestamp.setValue(value);
		timestamp.setUnit(unit);
		
		this.issueCreator.issue(timestamp, AmaltheaPackage.eINSTANCE.getTimestampList_Timestamps(), value);
		
		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkTimestampListTimestampsUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkTimestampListTimestampsUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkTimestampListTimestampsUnsigned_zero() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Synthetic synthetic = AmaltheaFactory.eINSTANCE.createSynthetic();
		final TimestampList timestampList = AmaltheaFactory.eINSTANCE.createTimestampList();
		final Time timestamp = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.ZERO;
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(synthetic);
		synthetic.setTriggerTimes(timestampList);
		timestampList.getTimestamps().add(timestamp);
		timestamp.setValue(value);
		timestamp.setUnit(unit);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkTimestampListTimestampsUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkTimestampListTimestampsUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkTimestampListTimestampsUnsigned_positive() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Synthetic synthetic = AmaltheaFactory.eINSTANCE.createSynthetic();
		final TimestampList timestampList = AmaltheaFactory.eINSTANCE.createTimestampList();
		final Time timestamp = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.TEN;
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(synthetic);
		synthetic.setTriggerTimes(timestampList);
		timestampList.getTimestamps().add(timestamp);
		timestamp.setValue(value);
		timestamp.setUnit(unit);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkTimestampListTimestampsUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkSingleActivationUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkSingleActivationUnsigned_null() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Single single = AmaltheaFactory.eINSTANCE.createSingle();
		final Time activation = null;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(single);
		single.setActivation(activation);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkSingleActivationUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkSingleActivationUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkSingleActivationUnsigned_negative() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Single single = AmaltheaFactory.eINSTANCE.createSingle();
		final Time activation = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.valueOf(-10);
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(single);
		single.setActivation(activation);
		activation.setValue(value);
		activation.setUnit(unit);
		
		this.issueCreator.issue(activation, AmaltheaPackage.eINSTANCE.getSingle_Activation(), value);
		
		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkSingleActivationUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkSingleActivationUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkSingleActivationUnsigned_zero() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Single single = AmaltheaFactory.eINSTANCE.createSingle();
		final Time activation = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.ZERO;
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(single);
		single.setActivation(activation);
		activation.setValue(value);
		activation.setUnit(unit);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkSingleActivationUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkSingleActivationUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkSingleActivationUnsigned_positive() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Single single = AmaltheaFactory.eINSTANCE.createSingle();
		final Time activation = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.TEN;
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(single);
		single.setActivation(activation);
		activation.setValue(value);
		activation.setUnit(unit);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkSingleActivationUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkArrivalCurveEntryLowerUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkArrivalCurveEntryLowerUnsigned_null() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final ArrivalCurve arrivalCurve = AmaltheaFactory.eINSTANCE.createArrivalCurve();
		final ArrivalCurveEntry entry = AmaltheaFactory.eINSTANCE.createArrivalCurveEntry();
		final Time lower = null;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(arrivalCurve);
		arrivalCurve.getEntries().add(entry);
		entry.setLowerTimeBorder(lower);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkArrivalCurveEntryLowerUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkArrivalCurveEntryLowerUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkArrivalCurveEntryLowerUnsigned_negative() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final ArrivalCurve arrivalCurve = AmaltheaFactory.eINSTANCE.createArrivalCurve();
		final ArrivalCurveEntry entry = AmaltheaFactory.eINSTANCE.createArrivalCurveEntry();
		final Time lower = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.valueOf(-10);
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(arrivalCurve);
		arrivalCurve.getEntries().add(entry);
		entry.setLowerTimeBorder(lower);
		lower.setValue(value);
		lower.setUnit(unit);
		
		this.issueCreator.issue(lower, AmaltheaPackage.eINSTANCE.getArrivalCurveEntry_LowerTimeBorder(), value);
		
		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkArrivalCurveEntryLowerUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkArrivalCurveEntryLowerUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkArrivalCurveEntryLowerUnsigned_zero() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final ArrivalCurve arrivalCurve = AmaltheaFactory.eINSTANCE.createArrivalCurve();
		final ArrivalCurveEntry entry = AmaltheaFactory.eINSTANCE.createArrivalCurveEntry();
		final Time lower = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.ZERO;
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(arrivalCurve);
		arrivalCurve.getEntries().add(entry);
		entry.setLowerTimeBorder(lower);
		lower.setValue(value);
		lower.setUnit(unit);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkArrivalCurveEntryLowerUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkArrivalCurveEntryLowerUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkArrivalCurveEntryLowerUnsigned_positive() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final ArrivalCurve arrivalCurve = AmaltheaFactory.eINSTANCE.createArrivalCurve();
		final ArrivalCurveEntry entry = AmaltheaFactory.eINSTANCE.createArrivalCurveEntry();
		final Time lower = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.TEN;
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(arrivalCurve);
		arrivalCurve.getEntries().add(entry);
		entry.setLowerTimeBorder(lower);
		lower.setValue(value);
		lower.setUnit(unit);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkArrivalCurveEntryLowerUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkArrivalCurveEntryUpperUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkArrivalCurveEntryUpperUnsigned_null() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final ArrivalCurve arrivalCurve = AmaltheaFactory.eINSTANCE.createArrivalCurve();
		final ArrivalCurveEntry entry = AmaltheaFactory.eINSTANCE.createArrivalCurveEntry();
		final Time upper = null;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(arrivalCurve);
		arrivalCurve.getEntries().add(entry);
		entry.setUpperTimeBorder(upper);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkArrivalCurveEntryUpperUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkArrivalCurveEntryUpperUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkArrivalCurveEntryUpperUnsigned_negative() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final ArrivalCurve arrivalCurve = AmaltheaFactory.eINSTANCE.createArrivalCurve();
		final ArrivalCurveEntry entry = AmaltheaFactory.eINSTANCE.createArrivalCurveEntry();
		final Time upper = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.valueOf(-10);
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(arrivalCurve);
		arrivalCurve.getEntries().add(entry);
		entry.setUpperTimeBorder(upper);
		upper.setValue(value);
		upper.setUnit(unit);
		
		this.issueCreator.issue(upper, AmaltheaPackage.eINSTANCE.getArrivalCurveEntry_UpperTimeBorder(), value);
		
		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkArrivalCurveEntryUpperUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkArrivalCurveEntryUpperUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkArrivalCurveEntryUpperUnsigned_zero() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final ArrivalCurve arrivalCurve = AmaltheaFactory.eINSTANCE.createArrivalCurve();
		final ArrivalCurveEntry entry = AmaltheaFactory.eINSTANCE.createArrivalCurveEntry();
		final Time upper = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.ZERO;
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(arrivalCurve);
		arrivalCurve.getEntries().add(entry);
		entry.setUpperTimeBorder(upper);
		upper.setValue(value);
		upper.setUnit(unit);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkArrivalCurveEntryUpperUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkArrivalCurveEntryUpperUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkArrivalCurveEntryUpperUnsigned_positive() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final ArrivalCurve arrivalCurve = AmaltheaFactory.eINSTANCE.createArrivalCurve();
		final ArrivalCurveEntry entry = AmaltheaFactory.eINSTANCE.createArrivalCurveEntry();
		final Time upper = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.TEN;
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(arrivalCurve);
		arrivalCurve.getEntries().add(entry);
		entry.setUpperTimeBorder(upper);
		upper.setValue(value);
		upper.setUnit(unit);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkArrivalCurveEntryUpperUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockTriangleFunctionPeriodUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkClockTriangleFunctionPeriodUnsigned_null() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		ClockTriangleFunction clockTriangleFunction = AmaltheaFactory.eINSTANCE.createClockTriangleFunction();
		final Time period = null;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getClocks().add(clockTriangleFunction);
		clockTriangleFunction.setPeriod(period);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockTriangleFunctionPeriodUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockTriangleFunctionPeriodUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkClockTriangleFunctionPeriodUnsigned_negative() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		ClockTriangleFunction clockTriangleFunction = AmaltheaFactory.eINSTANCE.createClockTriangleFunction();
		final Time period = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.valueOf(-10);
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getClocks().add(clockTriangleFunction);
		clockTriangleFunction.setPeriod(period);
		period.setValue(value);
		period.setUnit(unit);
		
		this.issueCreator.issue(period, AmaltheaPackage.eINSTANCE.getClockTriangleFunction_Period(), value);
		
		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockTriangleFunctionPeriodUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockTriangleFunctionPeriodUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkClockTriangleFunctionPeriodUnsigned_zero() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		ClockTriangleFunction clockTriangleFunction = AmaltheaFactory.eINSTANCE.createClockTriangleFunction();
		final Time period = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.ZERO;
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getClocks().add(clockTriangleFunction);
		clockTriangleFunction.setPeriod(period);
		period.setValue(value);
		period.setUnit(unit);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockTriangleFunctionPeriodUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockTriangleFunctionPeriodUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkClockTriangleFunctionPeriodUnsigned_positive() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		ClockTriangleFunction clockTriangleFunction = AmaltheaFactory.eINSTANCE.createClockTriangleFunction();
		final Time period = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.TEN;
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getClocks().add(clockTriangleFunction);
		clockTriangleFunction.setPeriod(period);
		period.setValue(value);
		period.setUnit(unit);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockTriangleFunctionPeriodUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockSinusFunctionPeriodUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkClockSinusFunctionPeriodUnsigned_null() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		ClockSinusFunction clockSinusFunction = AmaltheaFactory.eINSTANCE.createClockSinusFunction();
		final Time period = null;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getClocks().add(clockSinusFunction);
		clockSinusFunction.setPeriod(period);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockSinusFunctionPeriodUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockSinusFunctionPeriodUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkClockSinusFunctionPeriodUnsigned_negative() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		ClockSinusFunction clockSinusFunction = AmaltheaFactory.eINSTANCE.createClockSinusFunction();
		final Time period = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.valueOf(-10);
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getClocks().add(clockSinusFunction);
		clockSinusFunction.setPeriod(period);
		period.setValue(value);
		period.setUnit(unit);
		
		this.issueCreator.issue(period, AmaltheaPackage.eINSTANCE.getClockSinusFunction_Period(), value);
		
		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockSinusFunctionPeriodUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockSinusFunctionPeriodUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkClockSinusFunctionPeriodUnsigned_zero() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		ClockSinusFunction clockSinusFunction = AmaltheaFactory.eINSTANCE.createClockSinusFunction();
		final Time period = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.ZERO;
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getClocks().add(clockSinusFunction);
		clockSinusFunction.setPeriod(period);
		period.setValue(value);
		period.setUnit(unit);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockSinusFunctionPeriodUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockSinusFunctionPeriodUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkClockSinusFunctionPeriodUnsigned_positive() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		ClockSinusFunction clockSinusFunction = AmaltheaFactory.eINSTANCE.createClockSinusFunction();
		final Time period = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.TEN;
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getClocks().add(clockSinusFunction);
		clockSinusFunction.setPeriod(period);
		period.setValue(value);
		period.setUnit(unit);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockSinusFunctionPeriodUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockMultiplierListEntryTimeUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkClockMultiplierListEntryTimeUnsigned_null() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		ClockMultiplierList clockMultiplierList = AmaltheaFactory.eINSTANCE.createClockMultiplierList();
		ClockMultiplierListEntry clockMultiplierListEntry = AmaltheaFactory.eINSTANCE.createClockMultiplierListEntry();
		final Time time = null;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getClocks().add(clockMultiplierList);
		clockMultiplierList.getEntries().add(clockMultiplierListEntry);
		clockMultiplierListEntry.setTime(time);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockMultiplierListEntryTimeUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockMultiplierListEntryTimeUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkClockMultiplierListEntryTimeUnsigned_negative() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		ClockMultiplierList clockMultiplierList = AmaltheaFactory.eINSTANCE.createClockMultiplierList();
		ClockMultiplierListEntry clockMultiplierListEntry = AmaltheaFactory.eINSTANCE.createClockMultiplierListEntry();
		final Time time = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.valueOf(-10);
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getClocks().add(clockMultiplierList);
		clockMultiplierList.getEntries().add(clockMultiplierListEntry);
		clockMultiplierListEntry.setTime(time);
		time.setValue(value);
		time.setUnit(unit);
		
		this.issueCreator.issue(time, AmaltheaPackage.eINSTANCE.getClockMultiplierListEntry_Time(), value);
		
		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockMultiplierListEntryTimeUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockMultiplierListEntryTimeUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkClockMultiplierListEntryTimeUnsigned_zero() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		ClockMultiplierList clockMultiplierList = AmaltheaFactory.eINSTANCE.createClockMultiplierList();
		ClockMultiplierListEntry clockMultiplierListEntry = AmaltheaFactory.eINSTANCE.createClockMultiplierListEntry();
		final Time time = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.ZERO;
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getClocks().add(clockMultiplierList);
		clockMultiplierList.getEntries().add(clockMultiplierListEntry);
		clockMultiplierListEntry.setTime(time);
		time.setValue(value);
		time.setUnit(unit);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockMultiplierListEntryTimeUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkClockMultiplierListEntryTimeUnsigned(AMALTHEA)}
	 */
	@Test
	public void test_checkClockMultiplierListEntryTimeUnsigned_positive() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		ClockMultiplierList clockMultiplierList = AmaltheaFactory.eINSTANCE.createClockMultiplierList();
		ClockMultiplierListEntry clockMultiplierListEntry = AmaltheaFactory.eINSTANCE.createClockMultiplierListEntry();
		final Time time = AmaltheaFactory.eINSTANCE.createTime();
		final BigInteger value = BigInteger.TEN;
		final TimeUnit unit = TimeUnit.MS;
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getClocks().add(clockMultiplierList);
		clockMultiplierList.getEntries().add(clockMultiplierListEntry);
		clockMultiplierListEntry.setTime(time);
		time.setValue(value);
		time.setUnit(unit);
		
		EasyMock.replay(this.issueCreator);

		// test
		this.classUnderTest.checkClockMultiplierListEntryTimeUnsigned(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkModeValueListEntryModeLabelConstraint(AMALTHEA)}
	 */
	@Test
	public void test_ModeValueListEntryModeLabelConstraint_null() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final Single single = AmaltheaFactory.eINSTANCE.createSingle();
		final ModeValueList modeValueList = AmaltheaFactory.eINSTANCE.createModeValueList();
		final ModeValue modeValue = AmaltheaFactory.eINSTANCE.createModeValue();
		
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(single);
		single.setSetModeValueList(modeValueList);
		modeValueList.getEntries().add(modeValue);

		this.issueCreator.issue(modeValue, AmaltheaPackage.eINSTANCE.getModeValue_ValueProvider());
		
		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);
		
		// test
		this.classUnderTest.checkModeValueListEntryModeLabelConstraint(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkModeValueListEntryModeLabelConstraint(AMALTHEA)}
	 */
	@Test
	public void test_ModeValueListEntryModeLabelConstraint_positive() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final SWModel swModel = AmaltheaFactory.eINSTANCE.createSWModel();
		final ModeLabel modeLabel = AmaltheaFactory.eINSTANCE.createModeLabel();
		final Single single = AmaltheaFactory.eINSTANCE.createSingle();
		final ModeValueList modeValueList = AmaltheaFactory.eINSTANCE.createModeValueList();
		final ModeValue modeValue = AmaltheaFactory.eINSTANCE.createModeValue();
		
		amalthea.setSwModel(swModel);
		swModel.getModeLabels().add(modeLabel);
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(single);
		single.setSetModeValueList(modeValueList);
		modeValueList.getEntries().add(modeValue);
		modeValue.setValueProvider(modeLabel);

		EasyMock.replay(this.issueCreator);
		
		// test
		this.classUnderTest.checkModeValueListEntryModeLabelConstraint(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
	
	/**
	 * Test for validation method {@link StimuliModelValidator#checkModeValueListEntryModeLabelConstraint(AMALTHEA)}
	 */
	@Test
	public void test_ModeValueListEntryModeLabelConstraint_negative() {
		// prepare
		final Amalthea amalthea = AmaltheaFactory.eINSTANCE.createAmalthea();
		final StimuliModel stimuliModel = AmaltheaFactory.eINSTANCE.createStimuliModel();
		final SWModel swModel = AmaltheaFactory.eINSTANCE.createSWModel();
		final ModeLabel modeLabel = AmaltheaFactory.eINSTANCE.createModeLabel();
		final Single single = AmaltheaFactory.eINSTANCE.createSingle();
		final ModeValueList modeValueList = AmaltheaFactory.eINSTANCE.createModeValueList();
		final ModeValue modeValue = AmaltheaFactory.eINSTANCE.createModeValue();
		
		amalthea.setSwModel(swModel);
		amalthea.setStimuliModel(stimuliModel);
		stimuliModel.getStimuli().add(single);
		single.setSetModeValueList(modeValueList);
		modeValueList.getEntries().add(modeValue);
		modeValue.setValueProvider(modeLabel);

		this.issueCreator.issue(modeValue, AmaltheaPackage.eINSTANCE.getModeValue_ValueProvider());
		
		EasyMock.expectLastCall().times(1);
		EasyMock.replay(this.issueCreator);
		
		// test
		this.classUnderTest.checkModeValueListEntryModeLabelConstraint(amalthea);
		
		// evaluate
		EasyMock.verify(this.issueCreator);
	}
}
