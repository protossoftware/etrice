package org.eclipse.etrice.integration.ConfigTest;

import org.eclipse.etrice.runtime.java.messaging.MessageService;
import org.eclipse.etrice.runtime.java.messaging.RTServices;
import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.RTSystemServicesProtocol.*;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;




public class SubSystemConfigTest extends SubSystemClassBase{

	
	public SubSystemConfigTest(IRTObject parent, String name) {
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
		Address addr_item_SystemPort_0 = new Address(0,0,104);
		Address addr_item_SystemPort_1 = new Address(0,0,105);
		
		// actor instance /SubSystemConfigTest/top itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSystemConfigTest_top = new Address(0,0,101);
		// interface items of /SubSystemConfigTest/top
		// actor instance /SubSystemConfigTest/top/testee itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSystemConfigTest_top_testee = new Address(0,0,102);
		// interface items of /SubSystemConfigTest/top/testee
		Address addr_item__SubSystemConfigTest_top_testee_port1 = new Address(0,0,103);

		// instantiate all actor instances
		instances = new ActorClassBase[2];
		instances[0] = new ConfigText_Top(
			this,
			"top",
			// own interface item addresses
			new Address[][] {{addr_item__SubSystemConfigTest_top}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_0}
			}
		); 
		instances[1] = new Testee(
			instances[0],
			"testee",
			// own interface item addresses
			new Address[][] {{addr_item__SubSystemConfigTest_top_testee},
				{
					addr_item__SubSystemConfigTest_top_testee_port1
				}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_1},
				{
					null
				}
			}
		); 
		
		// apply instance attribute configurations
		{
			Testee inst = (Testee) instances[1];
			inst.setBool3(true);
			inst.setInt3(301);
		}

		// create the subsystem system port	
		RTSystemPort = new RTSystemServicesProtocolConjPortRepl(this, "RTSystemPort",
				0, //local ID
				// own addresses
				new Address[]{
					addr_item_SystemPort_0,
					addr_item_SystemPort_1
				},
				// peer addresses
				new Address[]{
					addr_item__SubSystemConfigTest_top,
					addr_item__SubSystemConfigTest_top_testee
				});
				
	}
};
