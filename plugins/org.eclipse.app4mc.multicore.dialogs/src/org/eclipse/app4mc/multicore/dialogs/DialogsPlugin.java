/*******************************************************************************
 * Copyright (c) 2017 Dortmund University of Applied Sciences and Arts and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *     Generated by Eclipse New Plugin-Project wizard
 *
 ******************************************************************************/
package org.eclipse.app4mc.multicore.dialogs;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class DialogsPlugin extends AbstractUIPlugin {

	/**
	 * The shared instance
	 */
	private static DialogsPlugin plugin;

	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(final BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static DialogsPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the preference store
	 *
	 * @return preference store
	 */
	public static IPreferenceStore getDefaultPreferenceStore() {
		return plugin.getPreferenceStore();
	}

	/**
	 * @return the plugin's id.
	 */
	public static String getPluginId() {
		if (null == plugin) {
			return "WF.org.eclipse.app4mc.multicore.dialogs";
		}
		return plugin.getBundle().getSymbolicName();
	}

}
