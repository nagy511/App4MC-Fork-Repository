/**
 ********************************************************************************
 * Copyright (c) 2017 Dortmund University of Applied Sciences and Arts and others.
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *    Dortmund University of Applied Sciences and Arts - initial API and implementation
 ********************************************************************************
 */

package org.eclipse.app4mc.multicore.execution.logic.systemproxy.scheduler.core;

import org.eclipse.app4mc.multicore.execution.logic.systemproxy.scheduler.ISchedulerEventListener;
import org.eclipse.app4mc.multicore.execution.logic.systemproxy.scheduler.ISchedulerTask;

public interface ISchedulerBase {
	public void init();
	public long getSimTime();
	public void addSchedulerEventListener(ISchedulerEventListener l);
	public void addTask(String name, long wcet,long period);
	public ISchedulerTask getTask(String name);

}
