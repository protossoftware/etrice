package PiModel;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;

import room.basic.service.tcp.*;
import room.basic.service.timing.*;
import trafficlight.connector.*;

import trafficlight.connector.PMqtt.*;
import room.basic.service.tcp.PTcpControl.*;
import room.basic.service.tcp.PTcpPayload.*;
import room.basic.service.timing.PTimer.*;
import trafficlight.connector.PTrafficLightInterface.*;



public class Application extends ActorClassBase {

	
	//--------------------- ports
	
	//--------------------- saps
	
	//--------------------- services

	//--------------------- interface item IDs

	/*--------------------- attributes ---------------------*/
	/*--------------------- operations ---------------------*/

	//--------------------- construction
	public Application(IRTObject parent, String name) {
		super(parent, name);
		setClassName("Application");
		
		// initialize attributes

		// own ports
		
		// own saps
		
		// own service implementations
		
		// sub actors
		new ATcpClient(this, "tcpIp"); 
		new TrafficLightInterface(this, "tfIf"); 
		new Comtroller(this, "controller"); 
		new MqttWrapperActor(this, "mqtt"); 

	}
	
	/* --------------------- attribute setters and getters */
	
	
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
