package org.eclipse.etrice.examples.dynamicactors8;

import org.eclipse.etrice.runtime.java.modelbase.IPersistable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.DataPortBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;


import org.eclipse.etrice.examples.dynamicactors8.PStep.*;




public class Optional1 extends Optional implements IPersistable {

	
	//--------------------- ports
	
	//--------------------- saps
	
	//--------------------- services
	
	//--------------------- optional actors
	
	//--------------------- interface item IDs
	
	/*--------------------- attributes ---------------------*/
	/*--------------------- operations ---------------------*/

	//--------------------- construction
	public Optional1(IRTObject parent, String name) {
		super(parent, name);
		setClassName("Optional1");
		
		// initialize attributes

		// own ports
		
		// own saps
		
		// own service implementations
		
		// sub actors
		DebuggingService.getInstance().addMessageActorCreate(this, "sub");
		new Sub1(this, "sub");
		
		// wiring
		

	}
	
	/* --------------------- attribute setters and getters */
	
	
	//--------------------- port getters

	//--------------------- lifecycle functions
	public void stop(){
		stopUser();
		super.stop();
	}
	
	public void destroy() {
		DebuggingService.getInstance().addMessageActorDestroy(this);
		super.destroy();
	}

	//--------------------- no state machine
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data) {
		handleSystemEvent(ifitem, evt, data);
	}
	
	public void executeInitTransition() {}
	
	@Override
	public void saveObject(ObjectOutput output) throws IOException {
		saveAttributes(output);
	}
	
	protected void saveAttributes(ObjectOutput output) throws IOException {
		super.saveAttributes(output);
		
	}
	
	@Override
	public void loadObject(ObjectInput input) throws IOException, ClassNotFoundException {
		loadAttributes(input);
	}
	
	protected void loadAttributes(ObjectInput input) throws IOException, ClassNotFoundException {
		super.loadAttributes(input);
		
	}
};
