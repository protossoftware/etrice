/*******************************************************************************
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.abstractexec.behavior.util;

import org.eclipse.etrice.core.fsm.FSMRuntimeModule;
import org.eclipse.etrice.core.genmodel.fsm.ICommonDataCalculator;

public class AbstractExecutionRuntimeModule extends FSMRuntimeModule {
	
    public Class<? extends ICommonDataCalculator> bindICommonDataCalculator() {
        return DummyDataCalculator.class;
    }

}
