package org.eclipse.etrice.integration.ChoicePointTest;

import org.eclipse.etrice.runtime.java.messaging.MessageService;
import org.eclipse.etrice.runtime.java.messaging.RTServices;
import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.RTSystemServicesProtocol.*;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;




public class SubSystem_CPTest extends SubSystemClassBase{

	
	public SubSystem_CPTest(IRTObject parent, String name) {
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
		
		// actor instance /SubSystem_CPTest/HandlerTest_Top itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSystem_CPTest_HandlerTest_Top = new Address(0,0,101);
		// interface items of /SubSystem_CPTest/HandlerTest_Top
		// actor instance /SubSystem_CPTest/HandlerTest_Top/cp_tester itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSystem_CPTest_HandlerTest_Top_cp_tester = new Address(0,0,102);
		// interface items of /SubSystem_CPTest/HandlerTest_Top/cp_tester
		Address addr_item__SubSystem_CPTest_HandlerTest_Top_cp_tester_TestPort1 = new Address(0,0,103);
		// actor instance /SubSystem_CPTest/HandlerTest_Top/cp_user itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSystem_CPTest_HandlerTest_Top_cp_user = new Address(0,0,104);
		// interface items of /SubSystem_CPTest/HandlerTest_Top/cp_user
		Address addr_item__SubSystem_CPTest_HandlerTest_Top_cp_user_TestPort1 = new Address(0,0,105);

		// instantiate all actor instances
		instances = new ActorClassBase[3];
		instances[0] = new CPTest_Top(
			this,
			"HandlerTest_Top",
			// own interface item addresses
			new Address[][] {{addr_item__SubSystem_CPTest_HandlerTest_Top}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_0}
			}
		); 
		instances[1] = new CPTester(
			instances[0],
			"cp_tester",
			// own interface item addresses
			new Address[][] {{addr_item__SubSystem_CPTest_HandlerTest_Top_cp_tester},
				{
					addr_item__SubSystem_CPTest_HandlerTest_Top_cp_tester_TestPort1
				}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_1},
				{
					addr_item__SubSystem_CPTest_HandlerTest_Top_cp_user_TestPort1
				}
			}
		); 
		instances[2] = new CPUser(
			instances[0],
			"cp_user",
			// own interface item addresses
			new Address[][] {{addr_item__SubSystem_CPTest_HandlerTest_Top_cp_user},
				{
					addr_item__SubSystem_CPTest_HandlerTest_Top_cp_user_TestPort1
				}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_2},
				{
					addr_item__SubSystem_CPTest_HandlerTest_Top_cp_tester_TestPort1
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
					addr_item__SubSystem_CPTest_HandlerTest_Top,
					addr_item__SubSystem_CPTest_HandlerTest_Top_cp_tester,
					addr_item__SubSystem_CPTest_HandlerTest_Top_cp_user
				});
				
	}
};
