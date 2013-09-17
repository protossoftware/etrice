package org.eclipse.etrice.examples.dynamicactors9;

import org.eclipse.etrice.runtime.java.config.IVariableService;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageService;
import org.eclipse.etrice.runtime.java.messaging.MessageService;
import org.eclipse.etrice.runtime.java.messaging.MessageServiceController;
import org.eclipse.etrice.runtime.java.messaging.RTServices;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.OptionalActorInterfaceBase;
import org.eclipse.etrice.runtime.java.modelbase.IOptionalActorFactory;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBroker;

import room.basic.service.timing.*;


public class Node_nodeRef1_subSysRef1 extends SubSystemClassBase {
	
	public static final int THREAD_PHYSICALTHREAD1 = 0;

	
	public Node_nodeRef1_subSysRef1(IRTObject parent, String name) {
		super(parent, name);
	}
	
	@Override
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data){
	}
	
	@Override	
	public void instantiateMessageServices() {
	
		IMessageService msgService;
		msgService = new MessageService(this, MessageService.ExecMode.MIXED, 100000000, 0, THREAD_PHYSICALTHREAD1, "MessageService_PhysicalThread1" /*, thread_prio */);
		RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(msgService);
	}

	@Override
	public void instantiateActors() {
		
		// thread mappings
		addPathToThread("/LogSys1/subSysRef1/actorRef1", THREAD_PHYSICALTHREAD1);
		addPathToThread("/LogSys1/subSysRef1/actorRef1/container", THREAD_PHYSICALTHREAD1);
		addPathToThread("/LogSys1/subSysRef1/timingService", THREAD_PHYSICALTHREAD1);
		
		// port to peer port mappings
		addPathToPeers("/LogSys1/subSysRef1/actorRef1/container/pp/room_basic_service_timing_PTimer", "/LogSys1/subSysRef1/timingService/timer");

		// sub actors
		DebuggingService.getInstance().addMessageActorCreate(this, "actorRef1");
		new PingPongTop(this, "actorRef1"); 
		DebuggingService.getInstance().addMessageActorCreate(this, "timingService");
		new ATimingService(this, "timingService"); 
		
		// wire optional actor interfaces with services
		{
			OptionalActorInterfaceBase oai = (OptionalActorInterfaceBase) getObject("/LogSys1/subSysRef1/actorRef1/container/pp");
			new InterfaceItemBroker(oai, "room_basic_service_timing_PTimer", 0);
		}
		
		// apply instance attribute configurations
	}
	
	@Override
	public void init(){
		DebuggingService.getInstance().addVisibleComment("begin sub system initialization");
		super.init();
		DebuggingService.getInstance().addVisibleComment("done sub system initialization");
	}
		
	@Override
	public void stop(){
		super.stop();
	}
	
	@Override
	public void destroy() {
		DebuggingService.getInstance().addVisibleComment("begin sub system destruction");
		super.destroy();
		DebuggingService.getInstance().addVisibleComment("done sub system destruction");
	}
	
	public IOptionalActorFactory getFactory(String optionalActorClass, String actorClass) {
		if (optionalActorClass.equals("PingPong")) {
			if ("PingPong".equals(actorClass)) {
				return new PingPongFactory();
			}
		}
		
		return null;
	}
};
