package PingPong;

import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.MessageService;
import org.eclipse.etrice.runtime.java.messaging.MessageServiceController;
import org.eclipse.etrice.runtime.java.messaging.RTServices;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;

import room.basic.service.timing.*;



public class SubSystem_PingPong extends SubSystemClassBase {
	
	public final int THREAD__DEFAULT = 0;
	public final int THREAD_MRPINGTHREAD = 1;
	public final int THREAD_MRPONG1THREAD = 2;

	
	public SubSystem_PingPong(IRTObject parent, String name) {
		super(parent, name);
	}
	
	@Override
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data){
	}
	
	@Override	
	public void instantiateMessageServices() {
	
		RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(new MessageService(this, 0, THREAD__DEFAULT, "MessageService_Main"));
		RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(new MessageService(this, 0, THREAD_MRPINGTHREAD, "MessageService_mrPingThread" /*, thread_prio */));
		RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(new MessageService(this, 0, THREAD_MRPONG1THREAD, "MessageService_mrPong1Thread" /*, thread_prio */));
	}

	@Override
	public void instantiateActors() {
		
		MessageServiceController msgSvcCtrl = RTServices.getInstance().getMsgSvcCtrl();

		// thread mappings
		msgSvcCtrl.addPathToThread("/System_PingPong/subsystem", THREAD__DEFAULT);
		msgSvcCtrl.addPathToThread("/System_PingPong/subsystem/application", THREAD__DEFAULT);
		msgSvcCtrl.addPathToThread("/System_PingPong/subsystem/application/MrPing", THREAD_MRPINGTHREAD);
		msgSvcCtrl.addPathToThread("/System_PingPong/subsystem/application/MrPong1", THREAD_MRPONG1THREAD);
		msgSvcCtrl.addPathToThread("/System_PingPong/subsystem/services", THREAD__DEFAULT);
		
		// port to peer port mappings
		msgSvcCtrl.addPathToPeer("/System_PingPong/subsystem/application/MrPing/PingPongPort", "/System_PingPong/subsystem/application/MrPong1/PingPongPort");
		msgSvcCtrl.addPathToPeer("/System_PingPong/subsystem/application/MrPing/timer", "/System_PingPong/subsystem/services/timer");
		msgSvcCtrl.addPathToPeer("/System_PingPong/subsystem/application/MrPong1/PingPongPort", "/System_PingPong/subsystem/application/MrPing/PingPongPort");
		msgSvcCtrl.addPathToPeer("/System_PingPong/subsystem/services/timer", "/System_PingPong/subsystem/application/MrPing/timer");

		// instantiate all actor instances
		instances = new ActorClassBase[4];
		instances[0] = new PingPongTop(
			this,
			"application"
		); 
		instances[1] = new MrPingActor(
			instances[0],
			"MrPing"
		); 
		instances[2] = new MrPongActor1(
			instances[0],
			"MrPong1"
		); 
		instances[3] = new ATimingService(
			this,
			"services"
		); 
		
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
