package Blinky;

import org.eclipse.etrice.runtime.java.config.IVariableService;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.MessageService;
import org.eclipse.etrice.runtime.java.messaging.MessageServiceController;
import org.eclipse.etrice.runtime.java.messaging.RTServices;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;

import room.basic.service.timing.*;


public class SubSystem_Blinky extends SubSystemClassBase {
	
	public final int THREAD__DEFAULT = 0;

	
	public SubSystem_Blinky(IRTObject parent, String name) {
		super(parent, name);
	}
	
	@Override
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data){
	}
	
	@Override	
	public void instantiateMessageServices() {
	
		RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(new MessageService(this, 0, THREAD__DEFAULT, "MessageService_Main"));
	}

	@Override
	public void instantiateActors() {
		
		MessageServiceController msgSvcCtrl = RTServices.getInstance().getMsgSvcCtrl();

		// thread mappings
		msgSvcCtrl.addPathToThread("/System_Blinky/subsystem", THREAD__DEFAULT);
		
		// port to peer port mappings
		msgSvcCtrl.addPathToPeer("/System_Blinky/subsystem/application/blinky/ControlPort", "/System_Blinky/subsystem/application/controller/ControlPort");
		msgSvcCtrl.addPathToPeer("/System_Blinky/subsystem/application/blinky/timer", "/System_Blinky/subsystem/timingService/timer");
		msgSvcCtrl.addPathToPeer("/System_Blinky/subsystem/application/controller/ControlPort", "/System_Blinky/subsystem/application/blinky/ControlPort");
		msgSvcCtrl.addPathToPeer("/System_Blinky/subsystem/application/controller/timer", "/System_Blinky/subsystem/timingService/timer");
		msgSvcCtrl.addPathToPeer("/System_Blinky/subsystem/timingService/timer", "/System_Blinky/subsystem/application/blinky/timer");
		msgSvcCtrl.addPathToPeer("/System_Blinky/subsystem/timingService/timer", "/System_Blinky/subsystem/application/controller/timer");

		// sub actors
		new BlinkyTop(this, "application"); 
		new ATimingService(this, "timingService"); 
		
		// apply instance attribute configurations
	}
	
	@Override
	public void init(){
		super.init();
	}
		
	@Override
	public void stop(){
		super.stop();
	}
		
};
