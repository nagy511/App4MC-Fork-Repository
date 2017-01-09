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

import org.eclipse.app4mc.amalthea.model.AmaltheaPackage;
import org.eclipse.app4mc.amalthea.model.Scheduler;
import org.eclipse.app4mc.amalthea.model.SchedulingUnit;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scheduler</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.impl.SchedulerImpl#getSchedulingUnit <em>Scheduling Unit</em>}</li>
 *   <li>{@link org.eclipse.app4mc.amalthea.model.impl.SchedulerImpl#getScheduleUnitPriority <em>Schedule Unit Priority</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SchedulerImpl extends ReferableBaseObjectImpl implements Scheduler {
	/**
	 * The cached value of the '{@link #getSchedulingUnit() <em>Scheduling Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulingUnit()
	 * @generated
	 * @ordered
	 */
	protected SchedulingUnit schedulingUnit;

	/**
	 * The default value of the '{@link #getScheduleUnitPriority() <em>Schedule Unit Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScheduleUnitPriority()
	 * @generated
	 * @ordered
	 */
	protected static final int SCHEDULE_UNIT_PRIORITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getScheduleUnitPriority() <em>Schedule Unit Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScheduleUnitPriority()
	 * @generated
	 * @ordered
	 */
	protected int scheduleUnitPriority = SCHEDULE_UNIT_PRIORITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SchedulerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AmaltheaPackage.eINSTANCE.getScheduler();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingUnit getSchedulingUnit() {
		return schedulingUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSchedulingUnit(SchedulingUnit newSchedulingUnit, NotificationChain msgs) {
		SchedulingUnit oldSchedulingUnit = schedulingUnit;
		schedulingUnit = newSchedulingUnit;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AmaltheaPackage.SCHEDULER__SCHEDULING_UNIT, oldSchedulingUnit, newSchedulingUnit);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchedulingUnit(SchedulingUnit newSchedulingUnit) {
		if (newSchedulingUnit != schedulingUnit) {
			NotificationChain msgs = null;
			if (schedulingUnit != null)
				msgs = ((InternalEObject)schedulingUnit).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AmaltheaPackage.SCHEDULER__SCHEDULING_UNIT, null, msgs);
			if (newSchedulingUnit != null)
				msgs = ((InternalEObject)newSchedulingUnit).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AmaltheaPackage.SCHEDULER__SCHEDULING_UNIT, null, msgs);
			msgs = basicSetSchedulingUnit(newSchedulingUnit, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AmaltheaPackage.SCHEDULER__SCHEDULING_UNIT, newSchedulingUnit, newSchedulingUnit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getScheduleUnitPriority() {
		return scheduleUnitPriority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScheduleUnitPriority(int newScheduleUnitPriority) {
		int oldScheduleUnitPriority = scheduleUnitPriority;
		scheduleUnitPriority = newScheduleUnitPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AmaltheaPackage.SCHEDULER__SCHEDULE_UNIT_PRIORITY, oldScheduleUnitPriority, scheduleUnitPriority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AmaltheaPackage.SCHEDULER__SCHEDULING_UNIT:
				return basicSetSchedulingUnit(null, msgs);
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
			case AmaltheaPackage.SCHEDULER__SCHEDULING_UNIT:
				return getSchedulingUnit();
			case AmaltheaPackage.SCHEDULER__SCHEDULE_UNIT_PRIORITY:
				return getScheduleUnitPriority();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AmaltheaPackage.SCHEDULER__SCHEDULING_UNIT:
				setSchedulingUnit((SchedulingUnit)newValue);
				return;
			case AmaltheaPackage.SCHEDULER__SCHEDULE_UNIT_PRIORITY:
				setScheduleUnitPriority((Integer)newValue);
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
			case AmaltheaPackage.SCHEDULER__SCHEDULING_UNIT:
				setSchedulingUnit((SchedulingUnit)null);
				return;
			case AmaltheaPackage.SCHEDULER__SCHEDULE_UNIT_PRIORITY:
				setScheduleUnitPriority(SCHEDULE_UNIT_PRIORITY_EDEFAULT);
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
			case AmaltheaPackage.SCHEDULER__SCHEDULING_UNIT:
				return schedulingUnit != null;
			case AmaltheaPackage.SCHEDULER__SCHEDULE_UNIT_PRIORITY:
				return scheduleUnitPriority != SCHEDULE_UNIT_PRIORITY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (scheduleUnitPriority: ");
		result.append(scheduleUnitPriority);
		result.append(')');
		return result.toString();
	}

} //SchedulerImpl
