package trafficlight.example;

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


public class SSTraffic extends SubSystemClassBase {
	
	public final int THREAD__DEFAULT = 0;
	public final int THREAD_DFLT_THREAD = 1;

	
	public SSTraffic(IRTObject parent, String name) {
		super(parent, name);
	}
	
	@Override
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data){
	}
	
	@Override	
	public void instantiateMessageServices() {
	
		RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(new MessageService(this, 0, THREAD__DEFAULT, "MessageService_Main"));
		RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(new MessageService(this, 0, THREAD_DFLT_THREAD, "MessageService_dflt_thread" /*, thread_prio */));
	}

	@Override
	public void instantiateActors() {
		
		MessageServiceController msgSvcCtrl = RTServices.getInstance().getMsgSvcCtrl();

		// thread mappings
		msgSvcCtrl.addPathToThread("/LSTraffic/main", THREAD__DEFAULT);
		
		// port to peer port mappings
		msgSvcCtrl.addPathToPeers("/LSTraffic/main/application/light1/controller", "/LSTraffic/main/application/controller/light1");
		msgSvcCtrl.addPathToPeers("/LSTraffic/main/application/light1/tcpCtrl", "/LSTraffic/main/application/light1/trafficLightSocket/ControlPort");
		msgSvcCtrl.addPathToPeers("/LSTraffic/main/application/light1/tcpPayload", "/LSTraffic/main/application/light1/trafficLightSocket/PayloadPort");
		msgSvcCtrl.addPathToPeers("/LSTraffic/main/application/light1/timeout", "/LSTraffic/main/TimingService/timer");
		msgSvcCtrl.addPathToPeers("/LSTraffic/main/application/light1/blinkerTimeout", "/LSTraffic/main/TimingService/timer");
		msgSvcCtrl.addPathToPeers("/LSTraffic/main/application/light1/trafficLightSocket/ControlPort", "/LSTraffic/main/application/light1/tcpCtrl");
		msgSvcCtrl.addPathToPeers("/LSTraffic/main/application/light1/trafficLightSocket/PayloadPort", "/LSTraffic/main/application/light1/tcpPayload");
		msgSvcCtrl.addPathToPeers("/LSTraffic/main/application/light2/controller", "/LSTraffic/main/application/controller/light2");
		msgSvcCtrl.addPathToPeers("/LSTraffic/main/application/light2/tcpCtrl", "/LSTraffic/main/application/light2/trafficLightSocket/ControlPort");
		msgSvcCtrl.addPathToPeers("/LSTraffic/main/application/light2/tcpPayload", "/LSTraffic/main/application/light2/trafficLightSocket/PayloadPort");
		msgSvcCtrl.addPathToPeers("/LSTraffic/main/application/light2/timeout", "/LSTraffic/main/TimingService/timer");
		msgSvcCtrl.addPathToPeers("/LSTraffic/main/application/light2/blinkerTimeout", "/LSTraffic/main/TimingService/timer");
		msgSvcCtrl.addPathToPeers("/LSTraffic/main/application/light2/trafficLightSocket/ControlPort", "/LSTraffic/main/application/light2/tcpCtrl");
		msgSvcCtrl.addPathToPeers("/LSTraffic/main/application/light2/trafficLightSocket/PayloadPort", "/LSTraffic/main/application/light2/tcpPayload");
		msgSvcCtrl.addPathToPeers("/LSTraffic/main/application/controller/light1", "/LSTraffic/main/application/light1/controller");
		msgSvcCtrl.addPathToPeers("/LSTraffic/main/application/controller/light2", "/LSTraffic/main/application/light2/controller");
		msgSvcCtrl.addPathToPeers("/LSTraffic/main/application/controller/timeout", "/LSTraffic/main/TimingService/timer");
		msgSvcCtrl.addPathToPeers("/LSTraffic/main/TimingService/timer", "/LSTraffic/main/application/light1/timeout","/LSTraffic/main/application/light1/blinkerTimeout","/LSTraffic/main/application/light2/timeout","/LSTraffic/main/application/light2/blinkerTimeout","/LSTraffic/main/application/controller/timeout");

		// sub actors
		new TrafficlightExampleApplication(this, "application"); 
		new ATimingService(this, "TimingService"); 
		
		// apply instance attribute configurations
		{
			TrafficLight inst = (TrafficLight) getObject("/LSTraffic/main/application/light1");
			if (inst!=null) {
				inst.getIpConfig().setIPAddr("127.0.0.1");
				inst.getIpConfig().setTcpPort(4441);
			}
		}
		{
			TrafficLight inst = (TrafficLight) getObject("/LSTraffic/main/application/light2");
			if (inst!=null) {
				inst.getIpConfig().setIPAddr("127.0.0.1");
				inst.getIpConfig().setTcpPort(4442);
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
