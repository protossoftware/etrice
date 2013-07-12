/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Eyrak Paen (initial contribution)
 * 
 *******************************************************************************/

package PingPong_Model.aspects.trace;

import org.eclipse.etrice.runtime.java.aspects.AbstractRTTrace;

public aspect PingPongRTTrace extends AbstractRTTrace {
	
	// concrete definition of abstract pointcut in super
	public pointcut traceScope(): rtClasses();
	
	// concrete definition of abstract pointcut in super
	public pointcut traceFilter();
}
