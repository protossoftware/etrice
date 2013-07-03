package PiModel;

import org.eclipse.etrice.runtime.java.config.IVariableService;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.MessageService;
import org.eclipse.etrice.runtime.java.messaging.MessageServiceController;
import org.eclipse.etrice.runtime.java.messaging.RTServices;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;

import room.basic.service.tcp.*;
import room.basic.service.timing.*;
import trafficlight.connector.*;


public class PiSubSys extends SubSystemClassBase {
	
	public final int THREAD__DEFAULT = 0;
	public final int THREAD_DEFAULTTHREAD = 1;

	
	public PiSubSys(IRTObject parent, String name) {
		super(parent, name);
	}
	
	@Override
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data){
	}
	
	@Override	
	public void instantiateMessageServices() {
	
		RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(new MessageService(this, 0, THREAD__DEFAULT, "MessageService_Main"));
		RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(new MessageService(this, 0, THREAD_DEFAULTTHREAD, "MessageService_defaultThread" /*, thread_prio */));
	}

	@Override
	public void instantiateActors() {
		
		MessageServiceController msgSvcCtrl = RTServices.getInstance().getMsgSvcCtrl();

		// thread mappings
		msgSvcCtrl.addPathToThread("/PiSystem/piSubSys", THREAD__DEFAULT);
		
		// port to peer port mappings
		msgSvcCtrl.addPathToPeers("/PiSystem/piSubSys/application/tcpIp/ControlPort", "/PiSystem/piSubSys/application/tfIf/control");
		msgSvcCtrl.addPathToPeers("/PiSystem/piSubSys/application/tcpIp/PayloadPort", "/PiSystem/piSubSys/application/tfIf/payload");
		msgSvcCtrl.addPathToPeers("/PiSystem/piSubSys/application/tfIf/payload", "/PiSystem/piSubSys/application/tcpIp/PayloadPort");
		msgSvcCtrl.addPathToPeers("/PiSystem/piSubSys/application/tfIf/control", "/PiSystem/piSubSys/application/tcpIp/ControlPort");
		msgSvcCtrl.addPathToPeers("/PiSystem/piSubSys/application/tfIf/fct", "/PiSystem/piSubSys/application/controller/traffic");
		msgSvcCtrl.addPathToPeers("/PiSystem/piSubSys/application/controller/traffic", "/PiSystem/piSubSys/application/tfIf/fct");
		msgSvcCtrl.addPathToPeers("/PiSystem/piSubSys/application/controller/mqtt", "/PiSystem/piSubSys/application/mqtt/fct");
		msgSvcCtrl.addPathToPeers("/PiSystem/piSubSys/application/controller/timer", "/PiSystem/piSubSys/timing/timer");
		msgSvcCtrl.addPathToPeers("/PiSystem/piSubSys/application/mqtt/fct", "/PiSystem/piSubSys/application/controller/mqtt");
		msgSvcCtrl.addPathToPeers("/PiSystem/piSubSys/timing/timer", "/PiSystem/piSubSys/application/controller/timer");

		// sub actors
		new Application(this, "application"); 
		new ATimingService(this, "timing"); 
		
		// apply instance attribute configurations
		{
			TrafficLightInterface inst = (TrafficLightInterface) getObject("/PiSystem/piSubSys/application/tfIf");
			if (inst!=null) {
				inst.getTcpConfig().setIPAddr("192.168.137.1");
				inst.getTcpConfig().setTcpPort(4441);
			}
		}
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
