/**
 ********************************************************************************
 * Copyright (c) 2018 Robert Bosch GmbH and others.
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

package org.eclipse.app4mc.amalthea.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;

public class AmaltheaCrossReferenceAdapter extends ECrossReferenceAdapter {

	private final Map<String, Set<IReferable>> nameIndex = new HashMap<>();

	public <T extends IReferable> Set<? extends T> getElements(final String name, final Class<T> targetClass) {
		final Set<T> result = new HashSet<>();
		final Set<IReferable> values = this.nameIndex.get(name);
		if (values != null) {
			for (final IReferable referable : values) {
				if (targetClass.isInstance(referable)) {
					result.add(targetClass.cast(referable));
				}
			}
		}
		return result;
	}

	public <T extends IReferable> Set<? extends T> getElements(final Pattern namePattern, final Class<T> targetClass) {
		final Set<T> result = new HashSet<>();
		for (final Map.Entry<String, Set<IReferable>> entry : this.nameIndex.entrySet()) {
			if (namePattern.matcher(entry.getKey()).matches()) {
				for (final IReferable referable : entry.getValue()) {
					if (targetClass.isInstance(referable)) {
						result.add(targetClass.cast(referable));
					}
				}
			}
		}
		return result;
	}

	@Override
	protected void selfAdapt(final Notification notification) {
		final Object notifier = notification.getNotifier();
		if (notifier instanceof IReferable && notification.getFeature() == AmaltheaPackage.eINSTANCE.getINamed_Name()) {
			// Update the name index if an IReferable's name is changed.
			final IReferable referable = (IReferable) notifier;
			switch (notification.getEventType()) {
			case Notification.UNSET: {
				final String oldValue = notification.getOldStringValue();
				removeFromNameIndex(referable, oldValue);
				break;
			}
			case Notification.SET: {
				final String oldValue = notification.getOldStringValue();
				removeFromNameIndex(referable, oldValue);
				final String newValue = notification.getNewStringValue();
				addToNameIndex(referable, newValue);
				break;
			}
			}
		}
		else {
			super.selfAdapt(notification);
		}
	}

	@Override
	protected void setTarget(final EObject target) {
		super.setTarget(target);

		if (target instanceof IReferable) {
			// Add the IReferable's name to the name index.
			final IReferable referable = (IReferable) target;
			addToNameIndex(referable, referable.getName());
		}
	}

	@Override
	protected void unsetTarget(final EObject target) {
		super.unsetTarget(target);

		if (target instanceof IReferable) {
			// Remove the IReferable's name to the name index.
			final IReferable referable = (IReferable) target;
			removeFromNameIndex(referable, referable.getName());
		}
	}

	private void addToNameIndex(final IReferable eObject, final String name) {
		if (name != null) {
			Set<IReferable> objSet = this.nameIndex.get(name);
			if (objSet == null) {
				objSet = new HashSet<>();
				this.nameIndex.put(name, objSet);
			}
			objSet.add(eObject);
		}
	}

	private void removeFromNameIndex(final IReferable eObject, final String name) {
		if (name != null) {
			final Set<IReferable> objSet = this.nameIndex.get(name);
			if (objSet != null) {
				objSet.remove(eObject);
				if (objSet.isEmpty()) {
					this.nameIndex.remove(name);
				}
			}
		}
	}


	/**
	 * Handles a containment change by adding and removing the adapter just like
	 * {@link EContentAdapter#handleContainment(Notification)}.
	 */
	@Override
	protected void handleContainment(final Notification notification) {
		switch (notification.getEventType()) {
		case Notification.RESOLVE: {
			// We need to be careful that the proxy may be resolved while we are attaching this adapter.
			// We need to avoid attaching the adapter during the resolve
			// and also attaching it again as we walk the eContents() later.
			// Checking here avoids having to check during addAdapter.
			//
			final Notifier oldValue = (Notifier) notification.getOldValue();
			if (oldValue.eAdapters().contains(this)) {
				removeAdapter(oldValue);
				final Notifier newValue = (Notifier) notification.getNewValue();
				addAdapter(newValue);
			}
			break;
		}
		case Notification.UNSET: {
			final Object oldValue = notification.getOldValue();
			if (oldValue != Boolean.TRUE && oldValue != Boolean.FALSE) {
				if (oldValue != null) {
					removeAdapter((Notifier) oldValue);
				}
				final Notifier newValue = (Notifier) notification.getNewValue();
				if (newValue != null) {
					addAdapter(newValue);
				}
			}
			break;
		}
		case Notification.SET: {
			final Notifier oldValue = (Notifier) notification.getOldValue();
			if (oldValue != null) {
				removeAdapter(oldValue);
			}
			final Notifier newValue = (Notifier) notification.getNewValue();
			if (newValue != null) {
				addAdapter(newValue);
			}
			break;
		}
		case Notification.ADD: {
			final Notifier newValue = (Notifier) notification.getNewValue();
			if (newValue != null) {
				addAdapter(newValue);
			}
			break;
		}
		case Notification.ADD_MANY: {
			@SuppressWarnings("unchecked")
			final Collection<Notifier> newValues = (Collection<Notifier>) notification.getNewValue();
			for (final Notifier newValue : newValues) {
				addAdapter(newValue);
			}
			break;
		}
		case Notification.REMOVE: {
			final Notifier oldValue = (Notifier) notification.getOldValue();
			if (oldValue != null) {
				removeAdapter(oldValue);
			}
			break;
		}
		case Notification.REMOVE_MANY: {
			@SuppressWarnings("unchecked")
			final Collection<Notifier> oldValues = (Collection<Notifier>) notification.getOldValue();
			for (final Notifier oldContentValue : oldValues) {
				removeAdapter(oldContentValue);
			}
			break;
		}
		}
	}
}
