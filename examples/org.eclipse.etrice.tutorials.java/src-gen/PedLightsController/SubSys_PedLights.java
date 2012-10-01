package PedLightsController;

import org.eclipse.etrice.runtime.java.messaging.MessageService;
import org.eclipse.etrice.runtime.java.messaging.RTServices;
import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.RTSystemServicesProtocol.*;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;

import room.basic.service.timing.*;



public class SubSys_PedLights extends SubSystemClassBase{

	
	public SubSys_PedLights(String name) {
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
		Address addr_item_SystemPort_0 = new Address(0,0,109);
		Address addr_item_SystemPort_1 = new Address(0,0,110);
		Address addr_item_SystemPort_2 = new Address(0,0,111);
		Address addr_item_SystemPort_3 = new Address(0,0,112);
		
		// actor instance /SubSys_PedLights/PedLightsTopRef itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSys_PedLights_PedLightsTopRef = new Address(0,0,101);
		// interface items of /SubSys_PedLights/PedLightsTopRef
		// actor instance /SubSys_PedLights/PedLightsTopRef/adapter itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSys_PedLights_PedLightsTopRef_adapter = new Address(0,0,102);
		// interface items of /SubSys_PedLights/PedLightsTopRef/adapter
		Address addr_item__SubSys_PedLights_PedLightsTopRef_adapter_ControlPort = new Address(0,0,103);
		// actor instance /SubSys_PedLights/PedLightsTopRef/controller itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSys_PedLights_PedLightsTopRef_controller = new Address(0,0,104);
		// interface items of /SubSys_PedLights/PedLightsTopRef/controller
		Address addr_item__SubSys_PedLights_PedLightsTopRef_controller_ControlPort = new Address(0,0,105);
		Address addr_item__SubSys_PedLights_PedLightsTopRef_controller_timer = new Address(0,0,106);
		// actor instance /SubSys_PedLights/timingService itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSys_PedLights_timingService = new Address(0,0,107);
		// interface items of /SubSys_PedLights/timingService
		Address addr_item__SubSys_PedLights_timingService_timer_0 = new Address(0,0,108);

		// instantiate all actor instances
		instances = new ActorClassBase[4];
		instances[0] = new PedLightsTop(
			this,
			"PedLightsTopRef",
			// own interface item addresses
			new Address[][] {{addr_item__SubSys_PedLights_PedLightsTopRef}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_0}
			}
		); 
		instances[1] = new GuiAdapter(
			instances[0],
			"adapter",
			// own interface item addresses
			new Address[][] {{addr_item__SubSys_PedLights_PedLightsTopRef_adapter},
				{
					addr_item__SubSys_PedLights_PedLightsTopRef_adapter_ControlPort
				}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_1},
				{
					addr_item__SubSys_PedLights_PedLightsTopRef_controller_ControlPort
				}
			}
		); 
		instances[2] = new Controller(
			instances[0],
			"controller",
			// own interface item addresses
			new Address[][] {{addr_item__SubSys_PedLights_PedLightsTopRef_controller},
				{
					addr_item__SubSys_PedLights_PedLightsTopRef_controller_ControlPort
				},
				{
					addr_item__SubSys_PedLights_PedLightsTopRef_controller_timer
				}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_2},
				{
					addr_item__SubSys_PedLights_PedLightsTopRef_adapter_ControlPort
				},
				{
					addr_item__SubSys_PedLights_timingService_timer_0
				}
			}
		); 
		instances[3] = new ATimingService(
			this,
			"timingService",
			// own interface item addresses
			new Address[][] {{addr_item__SubSys_PedLights_timingService},
				{
					addr_item__SubSys_PedLights_timingService_timer_0
				}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_3},
				{
					addr_item__SubSys_PedLights_PedLightsTopRef_controller_timer
				}
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
					addr_item__SubSys_PedLights_PedLightsTopRef,
					addr_item__SubSys_PedLights_PedLightsTopRef_adapter,
					addr_item__SubSys_PedLights_PedLightsTopRef_controller,
					addr_item__SubSys_PedLights_timingService
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
