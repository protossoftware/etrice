/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz
 * 
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.messaging;

import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;

/**
 * RTServices is the single point of access to all runtime services in one SubSystem
 * e.g. MessageServices, DebuggingService, ...
 * 
 * @author Thomas Schuetz
 *
 */
public class RTServices {
	
	private RTServices(){
		messageServiceController = new MessageServiceController();
	}
	
	public static RTServices getInstance(){
		if (instance == null){
			instance = new RTServices();
		}
		return instance;
	}
	
	public void destroy(){
		// TODO: also clean up all sub elements
		subSystem = null;
		messageServiceController = null;
		instance = null;
	}

	public MessageServiceController getMsgSvcCtrl(){
		assert(messageServiceController != null);
		return messageServiceController;
	}
	
	public SubSystemClassBase getSubSystem() {
		return subSystem;
	}
	public void setSubSystem(SubSystemClassBase subSystem) {
		this.subSystem = subSystem;
	}
	private static RTServices instance = null;
	private MessageServiceController messageServiceController = null;
	private SubSystemClassBase subSystem = null;
}
