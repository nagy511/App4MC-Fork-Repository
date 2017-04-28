/*******************************************************************************
 * Copyright (c) 2017 Dortmund University of Applied Sciences and Arts and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Dortmund University of Applied Sciences and Arts - initial API and implementation
 *******************************************************************************/
package org.eclipse.app4mc.multicore.execution.logic.systemproxy.scheduler;

import org.eclipse.app4mc.multicore.execution.logic.systemproxy.scheduler.core.ISchedulerBase;

public interface IStepScheduler extends ISchedulerBase{
	public void updateTaskSynchronisation();
	public void updateTaskSet();
	public void runTaskOrIdleStep();
}
