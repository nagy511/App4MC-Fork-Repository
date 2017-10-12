/**
 * *******************************************************************************
 *  Copyright (c) 2017 Robert Bosch GmbH and others.
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
import org.eclipse.app4mc.amalthea.model.Deviation;
import org.eclipse.app4mc.amalthea.model.Measurement;
import org.eclipse.app4mc.amalthea.model.Time;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Measurement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.impl.MeasurementImpl#getRuntimes <em>Runtimes</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.impl.MeasurementImpl#getRuntimeDeviation <em>Runtime Deviation</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MeasurementImpl extends BaseObjectImpl implements Measurement {
	/**
	 * The cached value of the '{@link #getRuntimes() <em>Runtimes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuntimes()
	 * @generated
	 * @ordered
	 */
	protected EList<Time> runtimes;

	/**
	 * The cached value of the '{@link #getRuntimeDeviation() <em>Runtime Deviation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuntimeDeviation()
	 * @generated
	 * @ordered
	 */
	protected Deviation<Time> runtimeDeviation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MeasurementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AmaltheaPackage.eINSTANCE.getMeasurement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Time> getRuntimes() {
		if (runtimes == null) {
			runtimes = new EObjectContainmentEList<Time>(Time.class, this, AmaltheaPackage.MEASUREMENT__RUNTIMES);
		}
		return runtimes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Deviation<Time> getRuntimeDeviation() {
		return runtimeDeviation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRuntimeDeviation(Deviation<Time> newRuntimeDeviation, NotificationChain msgs) {
		Deviation<Time> oldRuntimeDeviation = runtimeDeviation;
		runtimeDeviation = newRuntimeDeviation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AmaltheaPackage.MEASUREMENT__RUNTIME_DEVIATION, oldRuntimeDeviation, newRuntimeDeviation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuntimeDeviation(Deviation<Time> newRuntimeDeviation) {
		if (newRuntimeDeviation != runtimeDeviation) {
			NotificationChain msgs = null;
			if (runtimeDeviation != null)
				msgs = ((InternalEObject)runtimeDeviation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AmaltheaPackage.MEASUREMENT__RUNTIME_DEVIATION, null, msgs);
			if (newRuntimeDeviation != null)
				msgs = ((InternalEObject)newRuntimeDeviation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AmaltheaPackage.MEASUREMENT__RUNTIME_DEVIATION, null, msgs);
			msgs = basicSetRuntimeDeviation(newRuntimeDeviation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AmaltheaPackage.MEASUREMENT__RUNTIME_DEVIATION, newRuntimeDeviation, newRuntimeDeviation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AmaltheaPackage.MEASUREMENT__RUNTIMES:
				return ((InternalEList<?>)getRuntimes()).basicRemove(otherEnd, msgs);
			case AmaltheaPackage.MEASUREMENT__RUNTIME_DEVIATION:
				return basicSetRuntimeDeviation(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AmaltheaPackage.MEASUREMENT__RUNTIMES:
				return getRuntimes();
			case AmaltheaPackage.MEASUREMENT__RUNTIME_DEVIATION:
				return getRuntimeDeviation();
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
			case AmaltheaPackage.MEASUREMENT__RUNTIMES:
				getRuntimes().clear();
				getRuntimes().addAll((Collection<? extends Time>)newValue);
				return;
			case AmaltheaPackage.MEASUREMENT__RUNTIME_DEVIATION:
				setRuntimeDeviation((Deviation<Time>)newValue);
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
			case AmaltheaPackage.MEASUREMENT__RUNTIMES:
				getRuntimes().clear();
				return;
			case AmaltheaPackage.MEASUREMENT__RUNTIME_DEVIATION:
				setRuntimeDeviation((Deviation<Time>)null);
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
			case AmaltheaPackage.MEASUREMENT__RUNTIMES:
				return runtimes != null && !runtimes.isEmpty();
			case AmaltheaPackage.MEASUREMENT__RUNTIME_DEVIATION:
				return runtimeDeviation != null;
		}
		return super.eIsSet(featureID);
	}

} //MeasurementImpl
