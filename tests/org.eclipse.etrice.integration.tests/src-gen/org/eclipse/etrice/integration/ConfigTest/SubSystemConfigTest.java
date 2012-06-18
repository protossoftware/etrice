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
		Address addr_item_SystemPort_0 = new Address(0,0,106);
		Address addr_item_SystemPort_1 = new Address(0,0,107);
		Address addr_item_SystemPort_2 = new Address(0,0,108);
		
		// actor instance /SubSystemConfigTest/top itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSystemConfigTest_top = new Address(0,0,101);
		// interface items of /SubSystemConfigTest/top
		// actor instance /SubSystemConfigTest/top/testee itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSystemConfigTest_top_testee = new Address(0,0,102);
		// interface items of /SubSystemConfigTest/top/testee
		Address addr_item__SubSystemConfigTest_top_testee_Reg_port = new Address(0,0,103);
		// actor instance /SubSystemConfigTest/top/testee/AR1 itself => Systemport Address
		// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
		Address addr_item__SubSystemConfigTest_top_testee_AR1 = new Address(0,0,104);
		// interface items of /SubSystemConfigTest/top/testee/AR1
		Address addr_item__SubSystemConfigTest_top_testee_AR1_Conj_port = new Address(0,0,105);

		// instantiate all actor instances
		instances = new ActorClassBase[3];
		instances[0] = new ConfigText_Top_ac(
			this,
			"top",
			// own interface item addresses
			new Address[][] {{addr_item__SubSystemConfigTest_top}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_0}
			}
		); 
		instances[1] = new Testee_ac(
			instances[0],
			"testee",
			// own interface item addresses
			new Address[][] {{addr_item__SubSystemConfigTest_top_testee},
				{
					addr_item__SubSystemConfigTest_top_testee_Reg_port
				}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_1},
				{
					addr_item__SubSystemConfigTest_top_testee_AR1_Conj_port
				}
			}
		); 
		instances[2] = new AC1_ac(
			instances[1],
			"AR1",
			// own interface item addresses
			new Address[][] {{addr_item__SubSystemConfigTest_top_testee_AR1},
				{
					addr_item__SubSystemConfigTest_top_testee_AR1_Conj_port
				}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_2},
				{
					addr_item__SubSystemConfigTest_top_testee_Reg_port
				}
			}
		); 
		
		// apply instance attribute configurations
		{
			Testee_ac inst = (Testee_ac) instances[1];
			inst.setBool_i(true);
			inst.setInt_i(301);
			inst.setFloat_i(1.0E-5);
			inst.setChar_i('C');
			inst.setString_i("ROOM 2 Moon".toCharArray());
			{
				int[] array = inst.getArray1_i();
				for (int i=0;i<1;i++){
					array[i] = 4;
				}
			}
			inst.setArray2_i(new boolean[]{ false, true });
			inst.getReg_port().setFloat_i(25);
		}
		{
			AC1_ac inst = (AC1_ac) instances[2];
			{
				float[] array = inst.getConj_port().getArray1_i();
				for (int i=0;i<1;i++){
					array[i] = 256;
				}
			}
			inst.getConj_port().setArray2_i(new long[]{ 1, 2 });
		}

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
					addr_item__SubSystemConfigTest_top,
					addr_item__SubSystemConfigTest_top_testee,
					addr_item__SubSystemConfigTest_top_testee_AR1
				});
				
	}
};
