package WikiDiagrams;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.DataPortBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;


import WikiDiagrams.AProtocolClass.*;




public class ActorClass4 extends ActorClassBase {

	
	//--------------------- ports
	protected AProtocolClassConjPort fct = null;
	
	//--------------------- saps
	
	//--------------------- services
	
	//--------------------- optional actors
	
	//--------------------- interface item IDs
	public static final int IFITEM_fct = 1;
	
	/*--------------------- attributes ---------------------*/
	/*--------------------- operations ---------------------*/

	//--------------------- construction
	public ActorClass4(IRTObject parent, String name) {
		super(parent, name);
		setClassName("ActorClass4");
		
		// initialize attributes

		// own ports
		fct = new AProtocolClassConjPort(this, "fct", IFITEM_fct);
		
		// own saps
		
		// own service implementations
		
		// sub actors
		
		// wiring
		

	}
	
	/* --------------------- attribute setters and getters */
	
	
	//--------------------- port getters
	public AProtocolClassConjPort getFct (){
		return this.fct;
	}

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
};
