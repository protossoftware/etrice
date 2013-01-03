package SendingData;

import org.eclipse.etrice.runtime.java.config.IVariableService;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.MessageService;
import org.eclipse.etrice.runtime.java.messaging.MessageServiceController;
import org.eclipse.etrice.runtime.java.messaging.RTServices;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;



public class SendingData_SubSystem extends SubSystemClassBase {
	
	public final int THREAD__DEFAULT = 0;

	
	public SendingData_SubSystem(IRTObject parent, String name) {
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
		msgSvcCtrl.addPathToThread("/SendingData_LogSystem/SendingDataAppl", THREAD__DEFAULT);
		msgSvcCtrl.addPathToThread("/SendingData_LogSystem/SendingDataAppl/SendigDataTopRef", THREAD__DEFAULT);
		msgSvcCtrl.addPathToThread("/SendingData_LogSystem/SendingDataAppl/SendigDataTopRef/ref0", THREAD__DEFAULT);
		msgSvcCtrl.addPathToThread("/SendingData_LogSystem/SendingDataAppl/SendigDataTopRef/ref1", THREAD__DEFAULT);
		
		// port to peer port mappings
		msgSvcCtrl.addPathToPeer("/SendingData_LogSystem/SendingDataAppl/SendigDataTopRef/ref0/PingPongPort", "/SendingData_LogSystem/SendingDataAppl/SendigDataTopRef/ref1/PingPongPort");
		msgSvcCtrl.addPathToPeer("/SendingData_LogSystem/SendingDataAppl/SendigDataTopRef/ref1/PingPongPort", "/SendingData_LogSystem/SendingDataAppl/SendigDataTopRef/ref0/PingPongPort");

		// sub actors
		new SendingDataTop(this, "SendigDataTopRef"); 
		
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
