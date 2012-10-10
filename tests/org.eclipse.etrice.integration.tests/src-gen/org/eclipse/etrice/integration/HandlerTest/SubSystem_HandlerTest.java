package org.eclipse.etrice.integration.HandlerTest;

import org.eclipse.etrice.runtime.java.messaging.MessageService;
import org.eclipse.etrice.runtime.java.messaging.RTServices;
import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.RTSystemServicesProtocol.*;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;




public class SubSystem_HandlerTest extends SubSystemClassBase{

	
	public SubSystem_HandlerTest(String name) {
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
		Address addr_item_SystemPort_0 = new Address(0,0,106);
		Address addr_item_SystemPort_1 = new Address(0,0,107);
		Address addr_item_SystemPort_2 = new Address(0,0,108);
		
		// actor instance /SubSystem_HandlerTest/HandlerTest_Top itself => Systemport Address
		Address addr_item__SubSystem_HandlerTest_HandlerTest_Top = new Address(0,0,101);
		// interface items of /SubSystem_HandlerTest/HandlerTest_Top
		// actor instance /SubSystem_HandlerTest/HandlerTest_Top/tester itself => Systemport Address
		Address addr_item__SubSystem_HandlerTest_HandlerTest_Top_tester = new Address(0,0,102);
		// interface items of /SubSystem_HandlerTest/HandlerTest_Top/tester
		Address addr_item__SubSystem_HandlerTest_HandlerTest_Top_tester_TestPort1 = new Address(0,0,103);
		// actor instance /SubSystem_HandlerTest/HandlerTest_Top/handlerUser itself => Systemport Address
		Address addr_item__SubSystem_HandlerTest_HandlerTest_Top_handlerUser = new Address(0,0,104);
		// interface items of /SubSystem_HandlerTest/HandlerTest_Top/handlerUser
		Address addr_item__SubSystem_HandlerTest_HandlerTest_Top_handlerUser_TestPort1 = new Address(0,0,105);

		// instantiate all actor instances
		instances = new ActorClassBase[3];
		instances[0] = new HandlerTest_Top(
			this,
			"HandlerTest_Top",
			// own interface item addresses
			new Address[][] {{addr_item__SubSystem_HandlerTest_HandlerTest_Top}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_0}
			}
		); 
		instances[1] = new Tester(
			instances[0],
			"tester",
			// own interface item addresses
			new Address[][] {{addr_item__SubSystem_HandlerTest_HandlerTest_Top_tester},
				{
					addr_item__SubSystem_HandlerTest_HandlerTest_Top_tester_TestPort1
				}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_1},
				{
					addr_item__SubSystem_HandlerTest_HandlerTest_Top_handlerUser_TestPort1
				}
			}
		); 
		instances[2] = new HandlerUser(
			instances[0],
			"handlerUser",
			// own interface item addresses
			new Address[][] {{addr_item__SubSystem_HandlerTest_HandlerTest_Top_handlerUser},
				{
					addr_item__SubSystem_HandlerTest_HandlerTest_Top_handlerUser_TestPort1
				}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_2},
				{
					addr_item__SubSystem_HandlerTest_HandlerTest_Top_tester_TestPort1
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
					addr_item__SubSystem_HandlerTest_HandlerTest_Top,
					addr_item__SubSystem_HandlerTest_HandlerTest_Top_tester,
					addr_item__SubSystem_HandlerTest_HandlerTest_Top_handlerUser
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
