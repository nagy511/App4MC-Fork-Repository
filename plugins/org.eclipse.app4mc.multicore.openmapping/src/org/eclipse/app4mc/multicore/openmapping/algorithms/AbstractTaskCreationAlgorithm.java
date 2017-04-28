/*******************************************************************************
 * Copyright (c) 2015 Dortmund University of Applied Sciences and Arts and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dortmund University of Applied Sciences and Arts - initial API and implementation
 *
 ******************************************************************************/
package org.eclipse.app4mc.multicore.openmapping.algorithms;


import org.eclipse.app4mc.amalthea.model.AmaltheaFactory;
import org.eclipse.app4mc.amalthea.model.CommonElements;
import org.eclipse.app4mc.amalthea.model.ConstraintsModel;
import org.eclipse.app4mc.amalthea.model.HWModel;
import org.eclipse.app4mc.amalthea.model.MappingModel;
import org.eclipse.app4mc.amalthea.model.OSModel;
import org.eclipse.app4mc.amalthea.model.PropertyConstraintsModel;
import org.eclipse.app4mc.amalthea.model.SWModel;
import org.eclipse.app4mc.amalthea.model.StimuliModel;


public abstract class AbstractTaskCreationAlgorithm {
	
	/**
	 * Pragmatic Task Creation
	 */
	public final static String PRAGMATIC_TASK_CREATION = "0";
	
	// models
	private CommonElements commonElements;
	private SWModel swModel;
	private HWModel hwModel;
	private OSModel osModel;
	private MappingModel mmModel;
	private PropertyConstraintsModel pcModel;
	private StimuliModel stiModel;
	private ConstraintsModel conModel;
	private final AmaltheaFactory factoryInstance = AmaltheaFactory.eINSTANCE;

	abstract public void createTasks();

	// getter and setter methods for model handlers
	public AmaltheaFactory getSwInstance() {
		return this.factoryInstance;
	}

	public AmaltheaFactory getStimuliInstance() {
		return this.factoryInstance;
	}

	public AmaltheaFactory getConstraintsInstance() {
		return this.factoryInstance;
	}

	// getter and setter methods for models
	public CommonElements getCommonElements() {
		return commonElements;
	}
	
	public SWModel getSwModel() {
		return this.swModel;
	}

	public HWModel getHwModel() {
		return this.hwModel;
	}

	public ConstraintsModel getConstraintsModel() {
		return this.conModel;
	}

	public OSModel getOsModel() {
		return this.osModel;
	}

	public MappingModel getMappingModel() {
		return this.mmModel;
	}

	public PropertyConstraintsModel getPropertyConstraintsModel() {
		return this.pcModel;
	}

	public StimuliModel getStimuliModel() {
		return this.stiModel;
	}

	public void setCommonElements(CommonElements commonElements) {
		this.commonElements = commonElements;
	}

	public void setSwModel(final SWModel swModel) {
		this.swModel = swModel;
	}

	public void setHwModel(final HWModel hwModel) {
		this.hwModel = hwModel;
	}

	public void setConstraintsModel(final ConstraintsModel conModel) {
		this.conModel = conModel;
	}

	public void setOsModel(final OSModel osModel) {
		this.osModel = osModel;
	}

	public void setMappingModel(final MappingModel mmModel) {
		this.mmModel = mmModel;
	}

	public void setPropertyConstraintsModel(final PropertyConstraintsModel pcModel) {
		this.pcModel = pcModel;
	}

	public void setStimuliModel(final StimuliModel stiModel) {
		this.stiModel = stiModel;
	}
}
