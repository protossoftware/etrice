package PedLightsController;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;

import room.basic.service.timing.*;

import room.basic.service.timing.PTimer.*;
import PedLightsController.PedControlProtocol.*;



public class PedLightsTop extends ActorClassBase {

	
	//--------------------- ports
	
	//--------------------- saps
	
	//--------------------- services

	//--------------------- interface item IDs

	/*--------------------- attributes ---------------------*/
	/*--------------------- operations ---------------------*/

	//--------------------- construction
	public PedLightsTop(IRTObject parent, String name) {
		super(parent, name);
		setClassName("PedLightsTop");
		
		// initialize attributes

		// own ports
		
		// own saps
		
		// own service implementations
		
		// sub actors
		new GuiAdapter(this, "adapter"); 
		new Controller(this, "controller"); 

	}
	
	//--------------------- attribute setters and getters
	
	
	//--------------------- port getters

	//--------------------- lifecycle functions
	public void stop(){
		stopUser();
		super.stop();
	}
	

	//--------------------- no state machine
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data) {
		handleSystemEvent(ifitem, evt, data);
	}
	
	public void executeInitTransition() {}
};
