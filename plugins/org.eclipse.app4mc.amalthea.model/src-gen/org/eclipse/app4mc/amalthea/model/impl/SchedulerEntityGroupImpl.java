/**
 * *******************************************************************************
 *  Copyright (c) 2016 Robert Bosch GmbH and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *     Generated using Eclipse EMF
 * 
 * *******************************************************************************
 */
package org.eclipse.app4mc.amalthea.model.impl;

import java.util.Collection;

import org.eclipse.app4mc.amalthea.model.AmaltheaPackage;
import org.eclipse.app4mc.amalthea.model.Scheduler;
import org.eclipse.app4mc.amalthea.model.SchedulerEntityGroup;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scheduler Entity Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.impl.SchedulerEntityGroupImpl#getSchedulers <em>Schedulers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SchedulerEntityGroupImpl extends BaseObjectImpl implements SchedulerEntityGroup {
	/**
	 * The cached value of the '{@link #getSchedulers() <em>Schedulers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulers()
	 * @generated
	 * @ordered
	 */
	protected EList<Scheduler> schedulers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SchedulerEntityGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AmaltheaPackage.eINSTANCE.getSchedulerEntityGroup();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Scheduler> getSchedulers() {
		if (schedulers == null) {
			schedulers = new EObjectResolvingEList<Scheduler>(Scheduler.class, this, AmaltheaPackage.SCHEDULER_ENTITY_GROUP__SCHEDULERS);
		}
		return schedulers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AmaltheaPackage.SCHEDULER_ENTITY_GROUP__SCHEDULERS:
				return getSchedulers();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AmaltheaPackage.SCHEDULER_ENTITY_GROUP__SCHEDULERS:
				getSchedulers().clear();
				getSchedulers().addAll((Collection<? extends Scheduler>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AmaltheaPackage.SCHEDULER_ENTITY_GROUP__SCHEDULERS:
				getSchedulers().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AmaltheaPackage.SCHEDULER_ENTITY_GROUP__SCHEDULERS:
				return schedulers != null && !schedulers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SchedulerEntityGroupImpl
