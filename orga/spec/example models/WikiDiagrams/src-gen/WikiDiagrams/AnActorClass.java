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




public class AnActorClass extends ActorClassBase {

	
	//--------------------- ports
	protected AProtocolClassConjPort fct = null;
	protected AProtocolClassPort a4 = null;
	
	//--------------------- saps
	
	//--------------------- services
	
	//--------------------- optional actors
	
	//--------------------- interface item IDs
	public static final int IFITEM_fct = 1;
	public static final int IFITEM_a4 = 2;
	
	/*--------------------- attributes ---------------------*/
	/*--------------------- operations ---------------------*/

	//--------------------- construction
	public AnActorClass(IRTObject parent, String name) {
		super(parent, name);
		setClassName("AnActorClass");
		
		// initialize attributes

		// own ports
		fct = new AProtocolClassConjPort(this, "fct", IFITEM_fct);
		a4 = new AProtocolClassPort(this, "a4", IFITEM_a4);
		
		// own saps
		
		// own service implementations
		
		// sub actors
		DebuggingService.getInstance().addMessageActorCreate(this, "actor2");
		new ActorClass2(this, "actor2");
		DebuggingService.getInstance().addMessageActorCreate(this, "actor3A");
		new ActorClass3(this, "actor3A");
		DebuggingService.getInstance().addMessageActorCreate(this, "actor3B");
		new ActorClass3(this, "actor3B");
		DebuggingService.getInstance().addMessageActorCreate(this, "actor4");
		new ActorClass4(this, "actor4");
		
		// wiring
		InterfaceItemBase.connect(this, "actor2/fct1", "actor3A/fct");
		InterfaceItemBase.connect(this, "actor2/fct2", "actor3B/fct");
		InterfaceItemBase.connect(this, "actor4/fct", "a4");
		

	}
	
	/* --------------------- attribute setters and getters */
	
	
	//--------------------- port getters
	public AProtocolClassConjPort getFct (){
		return this.fct;
	}
	public AProtocolClassPort getA4 (){
		return this.a4;
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
