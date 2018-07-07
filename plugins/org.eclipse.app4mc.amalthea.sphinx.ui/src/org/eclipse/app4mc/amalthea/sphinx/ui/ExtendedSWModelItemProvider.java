/**
 ********************************************************************************
 * Copyright (c) 2015-2018 itemis AG and others.
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     itemis AG, Robert Bosch GmbH - initial API and implementation
 ********************************************************************************
 */

package org.eclipse.app4mc.amalthea.sphinx.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.app4mc.amalthea.model.AmaltheaPackage;
import org.eclipse.app4mc.amalthea.model.SWModel;
import org.eclipse.app4mc.amalthea.model.provider.SWModelItemProvider;
import org.eclipse.app4mc.amalthea.sphinx.ui.sw.container.ActivationsIP;
import org.eclipse.app4mc.amalthea.sphinx.ui.sw.container.ChannelsIP;
import org.eclipse.app4mc.amalthea.sphinx.ui.sw.container.CustomEntitiesIP;
import org.eclipse.app4mc.amalthea.sphinx.ui.sw.container.EventsIP;
import org.eclipse.app4mc.amalthea.sphinx.ui.sw.container.ISRsIP;
import org.eclipse.app4mc.amalthea.sphinx.ui.sw.container.LabelsIP;
import org.eclipse.app4mc.amalthea.sphinx.ui.sw.container.ModeLabelsIP;
import org.eclipse.app4mc.amalthea.sphinx.ui.sw.container.ModesIP;
import org.eclipse.app4mc.amalthea.sphinx.ui.sw.container.ProcessChainsIP;
import org.eclipse.app4mc.amalthea.sphinx.ui.sw.container.ProcessPrototypesIP;
import org.eclipse.app4mc.amalthea.sphinx.ui.sw.container.RunnablesIP;
import org.eclipse.app4mc.amalthea.sphinx.ui.sw.container.SectionsIP;
import org.eclipse.app4mc.amalthea.sphinx.ui.sw.container.TasksIP;
import org.eclipse.app4mc.amalthea.sphinx.ui.sw.container.TypeDefinitionsIP;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ViewerNotification;

public class ExtendedSWModelItemProvider extends SWModelItemProvider {

	protected RunnablesIP runnablesIP;
	protected LabelsIP labelsIP;
	protected ModesIP modesIP;
	protected ModeLabelsIP modeLabelsIP;
	protected TasksIP tasksIP;
	protected EventsIP eventsIP;
	protected SectionsIP sectionsIP;
	protected ProcessChainsIP processChainsIP;
	protected ProcessPrototypesIP prototypesIP;
	protected ISRsIP isrsIP;
	protected ActivationsIP activationsIP;
	protected TypeDefinitionsIP typesIP;
	protected ChannelsIP channelsIP;
	protected CustomEntitiesIP entitiesIP;

	public ExtendedSWModelItemProvider(final AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	public RunnablesIP getRunnables(final SWModel swModel) {
		if (this.runnablesIP == null) {
			this.runnablesIP = new RunnablesIP(this.adapterFactory, swModel);
		}
		return this.runnablesIP;
	}

	public LabelsIP getLabels(final SWModel swModel) {
		if (this.labelsIP == null) {
			this.labelsIP = new LabelsIP(this.adapterFactory, swModel);
		}
		return this.labelsIP;
	}

	public ModesIP getModes(final SWModel swModel) {
		if (this.modesIP == null) {
			this.modesIP = new ModesIP(this.adapterFactory, swModel);
		}
		return this.modesIP;
	}

	public ModeLabelsIP getModeLabels(final SWModel swModel) {
		if (this.modeLabelsIP == null) {
			this.modeLabelsIP = new ModeLabelsIP(this.adapterFactory, swModel);
		}
		return this.modeLabelsIP;
	}

	public TasksIP getTasks(final SWModel swModel) {
		if (this.tasksIP == null) {
			this.tasksIP = new TasksIP(this.adapterFactory, swModel);
		}
		return this.tasksIP;
	}

	public EventsIP getEvents(final SWModel swModel) {
		if (this.eventsIP == null) {
			this.eventsIP = new EventsIP(this.adapterFactory, swModel);
		}
		return this.eventsIP;
	}

	public SectionsIP getSections(final SWModel swModel) {
		if (this.sectionsIP == null) {
			this.sectionsIP = new SectionsIP(this.adapterFactory, swModel);
		}
		return this.sectionsIP;
	}

	public ProcessPrototypesIP getPrototypes(final SWModel swModel) {
		if (this.prototypesIP == null) {
			this.prototypesIP = new ProcessPrototypesIP(this.adapterFactory, swModel);
		}
		return this.prototypesIP;
	}

	public ProcessChainsIP getProcessChains(final SWModel swModel) {
		if (this.processChainsIP == null) {
			this.processChainsIP = new ProcessChainsIP(this.adapterFactory, swModel);
		}
		return this.processChainsIP;
	}

	public ISRsIP getISRs(final SWModel swModel) {
		if (this.isrsIP == null) {
			this.isrsIP = new ISRsIP(this.adapterFactory, swModel);
		}
		return this.isrsIP;
	}

	public ActivationsIP getActivations(final SWModel swModel) {
		if (this.activationsIP == null) {
			this.activationsIP = new ActivationsIP(this.adapterFactory, swModel);
		}
		return this.activationsIP;
	}
	
	public TypeDefinitionsIP getTypes(final SWModel swModel) {
		if (this.typesIP == null) {
			this.typesIP = new TypeDefinitionsIP(this.adapterFactory, swModel);
		}
		return this.typesIP;
	}

	public ChannelsIP getChannels(final SWModel swModel) {
		if (this.channelsIP == null) {
			this.channelsIP = new ChannelsIP(this.adapterFactory, swModel);
		}
		return this.channelsIP;
	}

	public CustomEntitiesIP getEntities(final SWModel swModel) {
		if (this.entitiesIP == null) {
			this.entitiesIP = new CustomEntitiesIP(this.adapterFactory, swModel);
		}
		return this.entitiesIP;
	}

	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(final Object object) {
		super.getChildrenFeatures(object);
		this.childrenFeatures.remove(AmaltheaPackage.eINSTANCE.getSWModel_Runnables()); // SW_MODEL__RUNNABLES
		this.childrenFeatures.remove(AmaltheaPackage.eINSTANCE.getSWModel_Labels()); // SW_MODEL__LABELS
		this.childrenFeatures.remove(AmaltheaPackage.eINSTANCE.getSWModel_Tasks()); // SW_MODEL__TASKS
		this.childrenFeatures.remove(AmaltheaPackage.eINSTANCE.getSWModel_Isrs()); // SW_MODEL__ISRS
		this.childrenFeatures.remove(AmaltheaPackage.eINSTANCE.getSWModel_Events()); // SW_MODEL__EVENTS
		this.childrenFeatures.remove(AmaltheaPackage.eINSTANCE.getSWModel_ProcessChains()); // SW_MODEL__PROCESS_CHAINS
		this.childrenFeatures.remove(AmaltheaPackage.eINSTANCE.getSWModel_ProcessPrototypes()); // SW_MODEL__PROCESS_PROTOTYPES
		this.childrenFeatures.remove(AmaltheaPackage.eINSTANCE.getSWModel_Activations()); // SW_MODEL__ACTIVATIONS
		this.childrenFeatures.remove(AmaltheaPackage.eINSTANCE.getSWModel_Sections()); // SW_MODEL__SECTIONS
		this.childrenFeatures.remove(AmaltheaPackage.eINSTANCE.getSWModel_Modes()); // SW_MODEL__MODES
		this.childrenFeatures.remove(AmaltheaPackage.eINSTANCE.getSWModel_ModeLabels()); // SW_MODEL__MODE_LABELS
		this.childrenFeatures.remove(AmaltheaPackage.eINSTANCE.getSWModel_TypeDefinitions()); // SW_MODEL__TYPE_DEFINITIONS
		this.childrenFeatures.remove(AmaltheaPackage.eINSTANCE.getSWModel_Channels()); // SW_MODEL__CHANNELS
		this.childrenFeatures.remove(AmaltheaPackage.eINSTANCE.getSWModel_CustomEntities()); // SW_MODEL__CUSTOM_ENTITIES
		return this.childrenFeatures;
	}

	@Override
	public Collection<?> getChildren(final Object object) {
		final List<Object> children = new ArrayList<Object>(super.getChildren(object));
		final SWModel swModel = (SWModel) object;
		
		// only display virtual folders if not empty
		if (!swModel.getRunnables().isEmpty())
			children.add(getRunnables(swModel));
		if (!swModel.getLabels().isEmpty())
			children.add(getLabels(swModel));
		if (!swModel.getTasks().isEmpty())
			children.add(getTasks(swModel));
		if (!swModel.getIsrs().isEmpty())
			children.add(getISRs(swModel));
		if (!swModel.getEvents().isEmpty())
			children.add(getEvents(swModel));
		if (!swModel.getProcessChains().isEmpty())
			children.add(getProcessChains(swModel));
		if (!swModel.getProcessPrototypes().isEmpty())
			children.add(getPrototypes(swModel));
		if (!swModel.getActivations().isEmpty())
			children.add(getActivations(swModel));
		if (!swModel.getSections().isEmpty())
			children.add(getSections(swModel));
		if (!swModel.getModes().isEmpty())
			children.add(getModes(swModel));
		if (!swModel.getModeLabels().isEmpty())
			children.add(getModeLabels(swModel));
		if (!swModel.getTypeDefinitions().isEmpty())
			children.add(getTypes(swModel));
		if (!swModel.getChannels().isEmpty())
			children.add(getChannels(swModel));
		if (!swModel.getCustomEntities().isEmpty())
			children.add(getEntities(swModel));
		return children;
	}

	@Override
	protected Command createAddCommand(final EditingDomain domain, final EObject owner,
			final EStructuralFeature feature, final Collection<?> collection, final int index) {
		return createWrappedCommand(super.createAddCommand(domain, owner, feature, collection, index), owner, feature);
	}

	@Override
	protected Command createRemoveCommand(final EditingDomain domain, final EObject owner,
			final EStructuralFeature feature, final Collection<?> collection) {
		return createWrappedCommand(super.createRemoveCommand(domain, owner, feature, collection), owner, feature);
	}

	protected Command createWrappedCommand(final Command command, final EObject owner,
			final EStructuralFeature feature) {
		if (feature.getFeatureID() == AmaltheaPackage.SW_MODEL__RUNNABLES
				|| feature.getFeatureID() == AmaltheaPackage.SW_MODEL__LABELS
				|| feature.getFeatureID() == AmaltheaPackage.SW_MODEL__MODES
				|| feature.getFeatureID() == AmaltheaPackage.SW_MODEL__MODE_LABELS
				|| feature.getFeatureID() == AmaltheaPackage.SW_MODEL__TASKS
				|| feature.getFeatureID() == AmaltheaPackage.SW_MODEL__EVENTS
				|| feature.getFeatureID() == AmaltheaPackage.SW_MODEL__SECTIONS
				|| feature.getFeatureID() == AmaltheaPackage.SW_MODEL__PROCESS_PROTOTYPES
				|| feature.getFeatureID() == AmaltheaPackage.SW_MODEL__PROCESS_CHAINS
				|| feature.getFeatureID() == AmaltheaPackage.SW_MODEL__ISRS
				|| feature.getFeatureID() == AmaltheaPackage.SW_MODEL__ACTIVATIONS
				|| feature.getFeatureID() == AmaltheaPackage.SW_MODEL__TYPE_DEFINITIONS
				|| feature.getFeatureID() == AmaltheaPackage.SW_MODEL__CHANNELS
				|| feature.getFeatureID() == AmaltheaPackage.SW_MODEL__CUSTOM_ENTITIES) {
			return new CommandWrapper(command) {
				@Override
				public Collection<?> getAffectedObjects() {
					Collection<?> affected = super.getAffectedObjects();
					if (affected.contains(owner)) {
						if (feature.getFeatureID() == AmaltheaPackage.SW_MODEL__RUNNABLES) {
							affected = Collections.singleton(getRunnables((SWModel) owner));
						}
						else if (feature.getFeatureID() == AmaltheaPackage.SW_MODEL__LABELS) {
							affected = Collections.singleton(getLabels((SWModel) owner));
						}
						else if (feature.getFeatureID() == AmaltheaPackage.SW_MODEL__MODES) {
							affected = Collections.singleton(getModes((SWModel) owner));
						}
						else if (feature.getFeatureID() == AmaltheaPackage.SW_MODEL__MODE_LABELS) {
							affected = Collections.singleton(getModeLabels((SWModel) owner));
						}
						else if (feature.getFeatureID() == AmaltheaPackage.SW_MODEL__TASKS) {
							affected = Collections.singleton(getTasks((SWModel) owner));
						}
						else if (feature.getFeatureID() == AmaltheaPackage.SW_MODEL__EVENTS) {
							affected = Collections.singleton(getEvents((SWModel) owner));
						}
						else if (feature.getFeatureID() == AmaltheaPackage.SW_MODEL__SECTIONS) {
							affected = Collections.singleton(getSections((SWModel) owner));
						}
						else if (feature.getFeatureID() == AmaltheaPackage.SW_MODEL__PROCESS_PROTOTYPES) {
							affected = Collections.singleton(getPrototypes((SWModel) owner));
						}
						else if (feature.getFeatureID() == AmaltheaPackage.SW_MODEL__PROCESS_CHAINS) {
							affected = Collections.singleton(getProcessChains((SWModel) owner));
						}
						else if (feature.getFeatureID() == AmaltheaPackage.SW_MODEL__ISRS) {
							affected = Collections.singleton(getISRs((SWModel) owner));
						}
						else if (feature.getFeatureID() == AmaltheaPackage.SW_MODEL__ACTIVATIONS) {
							affected = Collections.singleton(getActivations((SWModel) owner));
						}
						else if (feature.getFeatureID() == AmaltheaPackage.SW_MODEL__TYPE_DEFINITIONS) {
							affected = Collections.singleton(getTypes((SWModel) owner));
						}
						else if (feature.getFeatureID() == AmaltheaPackage.SW_MODEL__CHANNELS) {
							affected = Collections.singleton(getChannels((SWModel) owner));
						}
						else if (feature.getFeatureID() == AmaltheaPackage.SW_MODEL__CUSTOM_ENTITIES) {
							affected = Collections.singleton(getEntities((SWModel) owner));
						}
					}
					return affected;
				}
			};
		}
		return command;
	}

	@Override
	public void dispose() {
		if (this.runnablesIP != null) {
			this.runnablesIP.dispose();
		}
		if (this.labelsIP != null) {
			this.labelsIP.dispose();
		}
		if (this.modesIP != null) {
			this.modesIP.dispose();
		}
		if (this.modeLabelsIP != null) {
			this.modeLabelsIP.dispose();
		}
		if (this.tasksIP != null) {
			this.tasksIP.dispose();
		}
		if (this.eventsIP != null) {
			this.eventsIP.dispose();
		}
		if (this.sectionsIP != null) {
			this.sectionsIP.dispose();
		}
		if (this.prototypesIP != null) {
			this.prototypesIP.dispose();
		}
		if (this.processChainsIP != null) {
			this.processChainsIP.dispose();
		}
		if (this.isrsIP != null) {
			this.isrsIP.dispose();
		}
		if (this.activationsIP != null) {
			this.activationsIP.dispose();
		}
		if (this.typesIP != null) {
			this.typesIP.dispose();
		}
		if (this.channelsIP != null) {
			this.channelsIP.dispose();
		}
		if (this.entitiesIP != null) {
			this.entitiesIP.dispose();
		}
		super.dispose();
	}


	@Override
	public void notifyChanged(final Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(SWModel.class)) {
		case AmaltheaPackage.SW_MODEL__ISRS:
		case AmaltheaPackage.SW_MODEL__TASKS:
		case AmaltheaPackage.SW_MODEL__RUNNABLES:
		case AmaltheaPackage.SW_MODEL__LABELS:
		case AmaltheaPackage.SW_MODEL__MODES:
		case AmaltheaPackage.SW_MODEL__MODE_LABELS:
		case AmaltheaPackage.SW_MODEL__PROCESS_PROTOTYPES:
		case AmaltheaPackage.SW_MODEL__PROCESS_CHAINS:
		case AmaltheaPackage.SW_MODEL__SECTIONS:
		case AmaltheaPackage.SW_MODEL__ACTIVATIONS:
		case AmaltheaPackage.SW_MODEL__EVENTS:
		case AmaltheaPackage.SW_MODEL__TYPE_DEFINITIONS:
		case AmaltheaPackage.SW_MODEL__CHANNELS:
		case AmaltheaPackage.SW_MODEL__CUSTOM_ENTITIES:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, true));
			return;
		}
		super.notifyChanged(notification);
	}
}
