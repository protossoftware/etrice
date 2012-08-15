package org.eclipse.etrice.integration.tests;

import org.eclipse.etrice.runtime.java.messaging.MessageService;
import org.eclipse.etrice.runtime.java.messaging.RTServices;
import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.RTSystemServicesProtocol.*;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;

import room.basic.service.timing.*;



public class SubSystemHFSMTest extends SubSystemClassBase{

	
	public SubSystemHFSMTest(IRTObject parent, String name) {
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
		Address addr_item_SystemPort_0 = new Address(0,0,109);
		Address addr_item_SystemPort_1 = new Address(0,0,110);
		Address addr_item_SystemPort_2 = new Address(0,0,111);
		Address addr_item_SystemPort_3 = new Address(0,0,112);
		Address addr_item_SystemPort_4 = new Address(0,0,113);
		
		// actor instance /SubSystemHFSMTest/application itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSystemHFSMTest_application = new Address(0,0,101);
		// interface items of /SubSystemHFSMTest/application
		// actor instance /SubSystemHFSMTest/application/HFSM_Tests itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSystemHFSMTest_application_HFSM_Tests = new Address(0,0,102);
		// interface items of /SubSystemHFSMTest/application/HFSM_Tests
		// actor instance /SubSystemHFSMTest/application/HFSM_Tests/HFSM itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSystemHFSMTest_application_HFSM_Tests_HFSM = new Address(0,0,103);
		// interface items of /SubSystemHFSMTest/application/HFSM_Tests/HFSM
		Address addr_item__SubSystemHFSMTest_application_HFSM_Tests_HFSM_fct = new Address(0,0,104);
		// actor instance /SubSystemHFSMTest/application/HFSM_Tests/Tester itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSystemHFSMTest_application_HFSM_Tests_Tester = new Address(0,0,105);
		// interface items of /SubSystemHFSMTest/application/HFSM_Tests/Tester
		Address addr_item__SubSystemHFSMTest_application_HFSM_Tests_Tester_testee = new Address(0,0,106);
		// actor instance /SubSystemHFSMTest/services itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSystemHFSMTest_services = new Address(0,0,107);
		// interface items of /SubSystemHFSMTest/services

		// instantiate all actor instances
		instances = new ActorClassBase[5];
		instances[0] = new App_SubSystemHFSMTest(
			this,
			"application",
			// own interface item addresses
			new Address[][] {{addr_item__SubSystemHFSMTest_application}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_0}
			}
		); 
		instances[1] = new a_HFSM_Tests(
			instances[0],
			"HFSM_Tests",
			// own interface item addresses
			new Address[][] {{addr_item__SubSystemHFSMTest_application_HFSM_Tests}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_1}
			}
		); 
		instances[2] = new a_HFSM(
			instances[1],
			"HFSM",
			// own interface item addresses
			new Address[][] {{addr_item__SubSystemHFSMTest_application_HFSM_Tests_HFSM},
				{
					addr_item__SubSystemHFSMTest_application_HFSM_Tests_HFSM_fct
				}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_2},
				{
					addr_item__SubSystemHFSMTest_application_HFSM_Tests_Tester_testee
				}
			}
		); 
		instances[3] = new a_HFSM_Tester(
			instances[1],
			"Tester",
			// own interface item addresses
			new Address[][] {{addr_item__SubSystemHFSMTest_application_HFSM_Tests_Tester},
				{
					addr_item__SubSystemHFSMTest_application_HFSM_Tests_Tester_testee
				}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_3},
				{
					addr_item__SubSystemHFSMTest_application_HFSM_Tests_HFSM_fct
				}
			}
		); 
		instances[4] = new ATimingService(
			this,
			"services",
			// own interface item addresses
			new Address[][] {{addr_item__SubSystemHFSMTest_services},
				null,
				null
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_4},
				null,
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
					addr_item_SystemPort_3,
					addr_item_SystemPort_4
				},
				// peer addresses
				new Address[]{
					addr_item__SubSystemHFSMTest_application,
					addr_item__SubSystemHFSMTest_application_HFSM_Tests,
					addr_item__SubSystemHFSMTest_application_HFSM_Tests_HFSM,
					addr_item__SubSystemHFSMTest_application_HFSM_Tests_Tester,
					addr_item__SubSystemHFSMTest_services
				});
				
	}
};
