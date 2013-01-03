package PedLightsController;

import org.eclipse.etrice.runtime.java.config.IVariableService;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.MessageService;
import org.eclipse.etrice.runtime.java.messaging.MessageServiceController;
import org.eclipse.etrice.runtime.java.messaging.RTServices;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;

import room.basic.service.timing.*;


public class SubSys_PedLights extends SubSystemClassBase {
	
	public final int THREAD__DEFAULT = 0;

	
	public SubSys_PedLights(IRTObject parent, String name) {
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
		msgSvcCtrl.addPathToThread("/LogSys_PedLights/application", THREAD__DEFAULT);
		msgSvcCtrl.addPathToThread("/LogSys_PedLights/application/PedLightsTopRef", THREAD__DEFAULT);
		msgSvcCtrl.addPathToThread("/LogSys_PedLights/application/PedLightsTopRef/adapter", THREAD__DEFAULT);
		msgSvcCtrl.addPathToThread("/LogSys_PedLights/application/PedLightsTopRef/controller", THREAD__DEFAULT);
		msgSvcCtrl.addPathToThread("/LogSys_PedLights/application/timingService", THREAD__DEFAULT);
		
		// port to peer port mappings
		msgSvcCtrl.addPathToPeer("/LogSys_PedLights/application/PedLightsTopRef/adapter/ControlPort", "/LogSys_PedLights/application/PedLightsTopRef/controller/ControlPort");
		msgSvcCtrl.addPathToPeer("/LogSys_PedLights/application/PedLightsTopRef/controller/ControlPort", "/LogSys_PedLights/application/PedLightsTopRef/adapter/ControlPort");
		msgSvcCtrl.addPathToPeer("/LogSys_PedLights/application/PedLightsTopRef/controller/timer", "/LogSys_PedLights/application/timingService/timer");
		msgSvcCtrl.addPathToPeer("/LogSys_PedLights/application/timingService/timer", "/LogSys_PedLights/application/PedLightsTopRef/controller/timer");

		// sub actors
		new PedLightsTop(this, "PedLightsTopRef"); 
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
