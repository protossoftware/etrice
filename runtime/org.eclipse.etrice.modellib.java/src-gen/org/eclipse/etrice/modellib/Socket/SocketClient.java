package org.eclipse.etrice.modellib.Socket;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;


import org.eclipse.etrice.modellib.Socket.PSocket.*;



public class SocketClient extends ActorClassBase {

	
	
	//--------------------- ports
	protected PSocketPort fct = null;
	
	//--------------------- saps
	
	//--------------------- services

	//--------------------- interface item IDs
	public static final int IFITEM_fct = 1;

	/*--------------------- attributes ---------------------*/
	/*--------------------- operations ---------------------*/

	//--------------------- construction
	public SocketClient(IRTObject parent, String name) {
		super(parent, name);
		setClassName("SocketClient");
		
		// initialize attributes

		// own ports
		fct = new PSocketPort(this, "fct", IFITEM_fct); 
		
		// own saps
		
		// own service implementations
	}

	
	//--------------------- attribute setters and getters
	
	
	//--------------------- port getters
	public PSocketPort getFct (){
		return this.fct;
	}

	//--------------------- lifecycle functions
	public void init(){
		initUser();
	}

	public void start(){
		startUser();
	}

	public void stop(){
		stopUser();
	}
	
	public void destroy(){
	}

	//--------------------- no state machine
	@Override
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data) {
	handleSystemEvent(ifitem, evt, data);
	}
	
	@Override
	public void executeInitTransition(){
	}
};
