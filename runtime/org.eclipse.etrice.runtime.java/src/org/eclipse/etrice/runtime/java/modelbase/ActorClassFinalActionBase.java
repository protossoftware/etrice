/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.modelbase;

import org.eclipse.etrice.runtime.java.messaging.IRTObject;

/**
 * A base class that is used by the generator if the {@code -storeDataObj} switch is used.
 * After a state transition is completed {@link #finalAction()} is called which in turn
 * executes the {@link FinalAction} which was stored using {@link #setFinalAction(FinalAction)}.
 * If the final action is derived from {@link SingleFinalAction} then it is invoked only once.
 * If it is derived from {@link RepeatedFinalAction} it is invoked after every state transition
 * until {@link #setFinalAction(FinalAction)} is called with {@code null}.
 * 
 * @author Henrik Rentz-Reichert
 */
public abstract class ActorClassFinalActionBase extends ActorClassBase {

	/**
	 * The interface for final actions (called after a state transition is completed).
	 * This interface inherits from {@link Runnable}.
	 * 
	 * @author Henrik Rentz-Reichert
	 */
	public interface FinalAction extends Runnable {}
	
	/**
	 * @author Henrik Rentz-Reichert
	 *
	 */
	public interface SingleFinalAction extends FinalAction {}
	public interface RepeatedFinalAction extends FinalAction {}
	
	private FinalAction finalAction = null;

	/**
	 * @param parent
	 * @param name
	 */
	public ActorClassFinalActionBase(IRTObject parent, String name) {
		super(parent, name);
	}

	/**
	 * @param finalAction the final action to be executed or {@code null} if no action should be executed.
	 */
	public void setFinalAction(FinalAction finalAction) {
		this.finalAction  = finalAction;
	}

	/**
	 * This method is called right after a state transition occurred. It executes the {@link FinalAction} that
	 * was set with {@link #setFinalAction(FinalAction)}. If the final action is a {@link SingleFinalAction}
	 * it is executed only once.
	 */
	protected void finalAction() {
		if (finalAction==null)
			return;
		
		finalAction.run();
		
		if (finalAction instanceof SingleFinalAction)
			finalAction = null;
	}
}
