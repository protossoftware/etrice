package Blinky;

import org.eclipse.etrice.runtime.java.messaging.MessageService;
import org.eclipse.etrice.runtime.java.messaging.RTServices;
import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.RTSystemServicesProtocol.*;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;

import room.basic.service.timing.*;



public class SubSystem_Blinky extends SubSystemClassBase{

	
	public SubSystem_Blinky(String name) {
		super(name);
	}
	
	@Override
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data){
	}
	
	@Override	
	public void instantiateMessageServices(){
	
		RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(new MessageService(this, new Address(0, 0, 0),"MessageService_Main"));
		}

	@Override
	public void instantiateActors(){
		
		// all addresses
		// Addresses for the Subsystem Systemport
		Address addr_item_SystemPort_0 = new Address(0,0,112);
		Address addr_item_SystemPort_1 = new Address(0,0,113);
		Address addr_item_SystemPort_2 = new Address(0,0,114);
		Address addr_item_SystemPort_3 = new Address(0,0,115);
		
		// actor instance /SubSystem_Blinky/application itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSystem_Blinky_application = new Address(0,0,101);
		// interface items of /SubSystem_Blinky/application
		// actor instance /SubSystem_Blinky/application/blinky itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSystem_Blinky_application_blinky = new Address(0,0,102);
		// interface items of /SubSystem_Blinky/application/blinky
		Address addr_item__SubSystem_Blinky_application_blinky_ControlPort = new Address(0,0,103);
		Address addr_item__SubSystem_Blinky_application_blinky_timer = new Address(0,0,104);
		// actor instance /SubSystem_Blinky/application/controller itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSystem_Blinky_application_controller = new Address(0,0,105);
		// interface items of /SubSystem_Blinky/application/controller
		Address addr_item__SubSystem_Blinky_application_controller_ControlPort = new Address(0,0,106);
		Address addr_item__SubSystem_Blinky_application_controller_timer = new Address(0,0,107);
		// actor instance /SubSystem_Blinky/timingService itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSystem_Blinky_timingService = new Address(0,0,108);
		// interface items of /SubSystem_Blinky/timingService
		Address addr_item__SubSystem_Blinky_timingService_timeout_0 = new Address(0,0,109);
		Address addr_item__SubSystem_Blinky_timingService_timeout_1 = new Address(0,0,110);

		// instantiate all actor instances
		instances = new ActorClassBase[4];
		instances[0] = new BlinkyTop(
			this,
			"application",
			// own interface item addresses
			new Address[][] {{addr_item__SubSystem_Blinky_application}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_0}
			}
		); 
		instances[1] = new Blinky(
			instances[0],
			"blinky",
			// own interface item addresses
			new Address[][] {{addr_item__SubSystem_Blinky_application_blinky},
				{
					addr_item__SubSystem_Blinky_application_blinky_ControlPort
				},
				{
					addr_item__SubSystem_Blinky_application_blinky_timer
				}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_1},
				{
					addr_item__SubSystem_Blinky_application_controller_ControlPort
				},
				{
					addr_item__SubSystem_Blinky_timingService_timeout_0
				}
			}
		); 
		instances[2] = new BlinkyController(
			instances[0],
			"controller",
			// own interface item addresses
			new Address[][] {{addr_item__SubSystem_Blinky_application_controller},
				{
					addr_item__SubSystem_Blinky_application_controller_ControlPort
				},
				{
					addr_item__SubSystem_Blinky_application_controller_timer
				}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_2},
				{
					addr_item__SubSystem_Blinky_application_blinky_ControlPort
				},
				{
					addr_item__SubSystem_Blinky_timingService_timeout_1
				}
			}
		); 
		instances[3] = new ATimingService(
			this,
			"timingService",
			// own interface item addresses
			new Address[][] {{addr_item__SubSystem_Blinky_timingService},
				{
					addr_item__SubSystem_Blinky_timingService_timeout_0,
					addr_item__SubSystem_Blinky_timingService_timeout_1
				},
				null
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_3},
				{
					addr_item__SubSystem_Blinky_application_blinky_timer,
					addr_item__SubSystem_Blinky_application_controller_timer
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
					addr_item__SubSystem_Blinky_application,
					addr_item__SubSystem_Blinky_application_blinky,
					addr_item__SubSystem_Blinky_application_controller,
					addr_item__SubSystem_Blinky_timingService
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
