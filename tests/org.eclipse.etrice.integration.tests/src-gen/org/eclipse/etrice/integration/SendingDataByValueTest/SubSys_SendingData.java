package org.eclipse.etrice.integration.SendingDataByValueTest;

import org.eclipse.etrice.runtime.java.messaging.MessageService;
import org.eclipse.etrice.runtime.java.messaging.RTServices;
import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.RTSystemServicesProtocol.*;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;




public class SubSys_SendingData extends SubSystemClassBase{

	
	public SubSys_SendingData(IRTObject parent, String name) {
		super(parent, name);
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
		Address addr_item_SystemPort_0 = new Address(0,0,106);
		Address addr_item_SystemPort_1 = new Address(0,0,107);
		Address addr_item_SystemPort_2 = new Address(0,0,108);
		
		// actor instance /SubSys_SendingData/top itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSys_SendingData_top = new Address(0,0,101);
		// interface items of /SubSys_SendingData/top
		// actor instance /SubSys_SendingData/top/mrPing itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSys_SendingData_top_mrPing = new Address(0,0,102);
		// interface items of /SubSys_SendingData/top/mrPing
		Address addr_item__SubSys_SendingData_top_mrPing_PingPongPort = new Address(0,0,103);
		// actor instance /SubSys_SendingData/top/mrPong itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSys_SendingData_top_mrPong = new Address(0,0,104);
		// interface items of /SubSys_SendingData/top/mrPong
		Address addr_item__SubSys_SendingData_top_mrPong_PingPongPort = new Address(0,0,105);

		// instantiate all actor instances
		instances = new ActorClassBase[3];
		instances[0] = new SendingDataTop(
			this,
			"top",
			// own interface item addresses
			new Address[][] {{addr_item__SubSys_SendingData_top}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_0}
			}
		); 
		instances[1] = new MrPing(
			instances[0],
			"mrPing",
			// own interface item addresses
			new Address[][] {{addr_item__SubSys_SendingData_top_mrPing},
				{
					addr_item__SubSys_SendingData_top_mrPing_PingPongPort
				}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_1},
				{
					addr_item__SubSys_SendingData_top_mrPong_PingPongPort
				}
			}
		); 
		instances[2] = new MrPong(
			instances[0],
			"mrPong",
			// own interface item addresses
			new Address[][] {{addr_item__SubSys_SendingData_top_mrPong},
				{
					addr_item__SubSys_SendingData_top_mrPong_PingPongPort
				}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_2},
				{
					addr_item__SubSys_SendingData_top_mrPing_PingPongPort
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
					addr_item_SystemPort_2
				},
				// peer addresses
				new Address[]{
					addr_item__SubSys_SendingData_top,
					addr_item__SubSys_SendingData_top_mrPing,
					addr_item__SubSys_SendingData_top_mrPong
				});
				
	}
};
