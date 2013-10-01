package org.eclipse.etrice.examples.dynamicactors1;

import org.eclipse.etrice.runtime.java.config.IVariableService;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageService;
import org.eclipse.etrice.runtime.java.messaging.MessageService;
import org.eclipse.etrice.runtime.java.messaging.MessageServiceController;
import org.eclipse.etrice.runtime.java.messaging.RTServices;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.DataPortBase;
import org.eclipse.etrice.runtime.java.modelbase.OptionalActorInterfaceBase;
import org.eclipse.etrice.runtime.java.modelbase.IOptionalActorFactory;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBroker;



public class Node_nodeRef1_main extends SubSystemClassBase {
	
	public static final int THREAD_PHYSICALTHREAD1 = 0;

	
	public Node_nodeRef1_main(IRTObject parent, String name) {
		super(parent, name);
	}
	
	@Override
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data){
	}
	
	@Override	
	public void instantiateMessageServices() {
	
		IMessageService msgService;
		msgService = new MessageService(this, MessageService.ExecMode.BLOCKED, 0, THREAD_PHYSICALTHREAD1, "MessageService_PhysicalThread1" /*, thread_prio */);
		RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(msgService);
	}

	@Override
	public void instantiateActors() {
		
		// thread mappings
		addPathToThread("/LS/main/appl", THREAD_PHYSICALTHREAD1);
		addPathToThread("/LS/main/appl/cont", THREAD_PHYSICALTHREAD1);

		// sub actors
		new Appl(this, "appl"); 
		
		// create service brokers in optional actor interfaces
		{
			OptionalActorInterfaceBase oai = (OptionalActorInterfaceBase) getObject("/LS/main/appl/cont/opt");
		}
		
		// wiring
		
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
	
	public IOptionalActorFactory getFactory(String optionalActorClass, String actorClass) {
		if (optionalActorClass.equals("Optional")) {
			if ("Optional1".equals(actorClass)) {
				return new Optional1Factory();
			}
			else if ("Optional2".equals(actorClass)) {
				return new Optional2Factory();
			}
		}
		
		return null;
	}
};
