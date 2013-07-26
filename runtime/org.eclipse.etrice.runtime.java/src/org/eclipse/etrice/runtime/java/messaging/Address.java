/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/


package org.eclipse.etrice.runtime.java.messaging;

/**
 * An address used by the messaging for the routing of messages.
 * There are separate fields for node/process, thread and object.
 * The triple ensures uniqueness of IDs on each level.
 * 
 * @author Thomas Schuetz
 *
 */
public class Address {
	public Address(int nodeID, int threadID, int objectID){
		this.nodeID = nodeID;
		this.threadID = threadID;
		this.objectID = objectID;
	}

	public int nodeID;
	public int threadID;
	public int objectID;
	
	public String toString(){
		return "Address(n="+nodeID+",t="+threadID+",o="+objectID+")";
	}
	public String toID(){
		return nodeID+"_"+threadID+"_"+objectID;
	}
	
	public Address createInc(int i) {
		return new Address(nodeID, threadID, objectID+i);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Address) {
			Address other = (Address) obj;
			return nodeID==other.nodeID && threadID==other.threadID && objectID==other.objectID;
		}
		return super.equals(obj);
	}
}
