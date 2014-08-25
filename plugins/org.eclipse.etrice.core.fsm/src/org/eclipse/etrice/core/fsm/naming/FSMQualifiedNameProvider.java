/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.fsm.naming;

import java.util.HashMap;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.RefinedState;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class FSMQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {
	
	public FSMQualifiedNameProvider() {
		super();
	}
	
	private HashMap<RefinedState, String> rs2uuid = new HashMap<RefinedState, String>();
	
    public QualifiedName qualifiedName(RefinedState rs) {
    	// RefinedStates can never be in conflict, whether the target reference is resolved or not
    	String uuid = rs2uuid.get(rs);
    	if (uuid==null) {
    		uuid = EcoreUtil.generateUUID();
    		rs2uuid.put(rs, uuid);
    	}
    	return getFullyQualifiedName(rs.eContainer()).append(uuid);
    }
    
    public QualifiedName qualifiedName(StateGraph sg) {
    	if (sg.eContainer() instanceof State)
    		return getFullyQualifiedName(sg.eContainer()).append("sg");
    	else if (sg.eContainer() instanceof ModelComponent)
    		return getFullyQualifiedName(sg.eContainer()).append("sm");
    	
    	assert(false): "unexpected state graph container";
    	return null;
    }

}
