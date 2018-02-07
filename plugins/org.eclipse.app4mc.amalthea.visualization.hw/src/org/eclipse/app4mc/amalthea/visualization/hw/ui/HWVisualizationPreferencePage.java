package org.eclipse.app4mc.amalthea.visualization.hw.ui;

import org.eclipse.app4mc.amalthea.visualization.hw.Activator;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

 

public class HWVisualizationPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {

	public HWVisualizationPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription(
				"Preference page to specify the Graphviz (dot executable) location");
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common GUI blocks needed to manipulate various
	 * types of preferences. Each field editor knows how to save and restore itself.
	 */
	@Override
	public void createFieldEditors() {

		addField(new FileFieldEditor(PreferenceConstants.P_DOT_PATH, "&Path to the dot executable of Graphviz:",
				getFieldEditorParent()));

		 

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(final IWorkbench workbench) {
	}

}