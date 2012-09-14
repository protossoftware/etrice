package PingPong;

import org.eclipse.etrice.runtime.java.messaging.MessageService;
import org.eclipse.etrice.runtime.java.messaging.RTServices;
import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.RTSystemServicesProtocol.*;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;

import room.basic.service.timing.*;



public class SubSystem_PingPong extends SubSystemClassBase{

	
	public SubSystem_PingPong(String name) {
		super(name);
	}
	
	@Override
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data){
	}
	
	@Override	
	public void instantiateMessageServices(){
	
		RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(new MessageService(this, new Address(0, 0, 0),"MessageService_Main"));
		RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(new MessageService(this, new Address(0, 1, 0),"MessageService_mrPingThread", 5));
		RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(new MessageService(this, new Address(0, 2, 0),"MessageService_mrPong1Thread", 5));
		}

	@Override
	public void instantiateActors(){
		
		// all addresses
		// Addresses for the Subsystem Systemport
		Address addr_item_SystemPort_0 = new Address(0,0,111);
		Address addr_item_SystemPort_1 = new Address(0,0,112);
		Address addr_item_SystemPort_2 = new Address(0,0,113);
		Address addr_item_SystemPort_3 = new Address(0,0,114);
		
		// actor instance /SubSystem_PingPong/application itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSystem_PingPong_application = new Address(0,0,101);
		// interface items of /SubSystem_PingPong/application
		// actor instance /SubSystem_PingPong/application/MrPing itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSystem_PingPong_application_MrPing = new Address(0,1,102);
		// interface items of /SubSystem_PingPong/application/MrPing
		Address addr_item__SubSystem_PingPong_application_MrPing_PingPongPort_0 = new Address(0,0,103);
		Address addr_item__SubSystem_PingPong_application_MrPing_timer = new Address(0,1,105);
		// actor instance /SubSystem_PingPong/application/MrPong1 itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSystem_PingPong_application_MrPong1 = new Address(0,2,106);
		// interface items of /SubSystem_PingPong/application/MrPong1
		Address addr_item__SubSystem_PingPong_application_MrPong1_PingPongPort = new Address(0,2,107);
		// actor instance /SubSystem_PingPong/services itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSystem_PingPong_services = new Address(0,0,108);
		// interface items of /SubSystem_PingPong/services
		Address addr_item__SubSystem_PingPong_services_timeout_0 = new Address(0,0,109);

		// instantiate all actor instances
		instances = new ActorClassBase[4];
		instances[0] = new PingPongTop(
			this,
			"application",
			// own interface item addresses
			new Address[][] {{addr_item__SubSystem_PingPong_application}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_0}
			}
		); 
		instances[1] = new MrPingActor(
			instances[0],
			"MrPing",
			// own interface item addresses
			new Address[][] {{addr_item__SubSystem_PingPong_application_MrPing},
				{
					addr_item__SubSystem_PingPong_application_MrPing_PingPongPort_0
				},
				{
					addr_item__SubSystem_PingPong_application_MrPing_timer
				}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_1},
				{
					addr_item__SubSystem_PingPong_application_MrPong1_PingPongPort
				},
				{
					addr_item__SubSystem_PingPong_services_timeout_0
				}
			}
		); 
		instances[2] = new MrPongActor1(
			instances[0],
			"MrPong1",
			// own interface item addresses
			new Address[][] {{addr_item__SubSystem_PingPong_application_MrPong1},
				{
					addr_item__SubSystem_PingPong_application_MrPong1_PingPongPort
				}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_2},
				{
					addr_item__SubSystem_PingPong_application_MrPing_PingPongPort_0
				}
			}
		); 
		instances[3] = new ATimingService(
			this,
			"services",
			// own interface item addresses
			new Address[][] {{addr_item__SubSystem_PingPong_services},
				{
					addr_item__SubSystem_PingPong_services_timeout_0
				},
				null
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_3},
				{
					addr_item__SubSystem_PingPong_application_MrPing_timer
				},
				null
			}
		); 
		
		// apply instance attribute configurations

		// create the subsystem system port	
		RTSystemPort = new RTSystemServicesProtocolConjPortRepl(this, "RTSystemPort",
				0, //local ID
				// own addresses
				new Address[]{
					addr_item_SystemPort_0,
					addr_item_SystemPort_1,
					addr_item_SystemPort_2,
					addr_item_SystemPort_3
				},
				// peer addresses
				new Address[]{
					addr_item__SubSystem_PingPong_application,
					addr_item__SubSystem_PingPong_application_MrPing,
					addr_item__SubSystem_PingPong_application_MrPong1,
					addr_item__SubSystem_PingPong_services
				});
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
