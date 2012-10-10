package org.eclipse.etrice.integration.ConfigTest;

import org.eclipse.etrice.runtime.java.config.VariableService;
import org.eclipse.etrice.runtime.java.messaging.MessageService;
import org.eclipse.etrice.runtime.java.messaging.RTServices;
import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.RTSystemServicesProtocol.*;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;




public class SubSystemConfigTest extends SubSystemClassBase{

	
	public SubSystemConfigTest(String name) {
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
		
		// actor instance /SubSystemConfigTest/top itself => Systemport Address
		Address addr_item__SubSystemConfigTest_top = new Address(0,0,101);
		// interface items of /SubSystemConfigTest/top
		// actor instance /SubSystemConfigTest/top/testee itself => Systemport Address
		Address addr_item__SubSystemConfigTest_top_testee = new Address(0,0,102);
		// interface items of /SubSystemConfigTest/top/testee
		Address addr_item__SubSystemConfigTest_top_testee_Reg_dynConfigPort = new Address(0,0,103);
		Address addr_item__SubSystemConfigTest_top_testee_Reg_port = new Address(0,0,104);
		// actor instance /SubSystemConfigTest/top/testee/AR1 itself => Systemport Address
		Address addr_item__SubSystemConfigTest_top_testee_AR1 = new Address(0,0,105);
		// interface items of /SubSystemConfigTest/top/testee/AR1
		Address addr_item__SubSystemConfigTest_top_testee_AR1_Conj_port = new Address(0,0,106);
		// actor instance /SubSystemConfigTest/top/testee2 itself => Systemport Address
		Address addr_item__SubSystemConfigTest_top_testee2 = new Address(0,0,107);
		// interface items of /SubSystemConfigTest/top/testee2
		Address addr_item__SubSystemConfigTest_top_testee2_Conj_DynConfigPort = new Address(0,0,108);

		// instantiate all actor instances
		instances = new ActorClassBase[4];
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
					addr_item__SubSystemConfigTest_top_testee_Reg_dynConfigPort
				},
				{
					addr_item__SubSystemConfigTest_top_testee_Reg_port
				}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_1},
				{
					addr_item__SubSystemConfigTest_top_testee2_Conj_DynConfigPort
				},
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
		instances[3] = new DynTestee_ac(
			instances[0],
			"testee2",
			// own interface item addresses
			new Address[][] {{addr_item__SubSystemConfigTest_top_testee2},
				{
					addr_item__SubSystemConfigTest_top_testee2_Conj_DynConfigPort
				}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_3},
				{
					addr_item__SubSystemConfigTest_top_testee_Reg_dynConfigPort
				}
			}
			, variableService
		); 
		
		// apply instance attribute configurations
		{
			Testee_ac inst = (Testee_ac) instances[1];
			inst.setBool_i(true);
			inst.setInt_i(301);
			inst.setFloat_i(1.0E-5d);
			inst.setChar_i('C');
			inst.setCharArray_i("ROOM 2 Moon".toCharArray());
			inst.setString_i(":^]");
			inst.setArray1_i(new int[]{4});
			inst.setArray2_i(new boolean[]{false, true});
			inst.getReg_port().setFloat_i(25f);
		}
		{
			AC1_ac inst = (AC1_ac) instances[2];
			inst.getConj_port().setArray1_i(new float[]{256f});
			inst.getConj_port().setArray2_i(new long[]{1L, 2L});
		}
		{
			DynTestee_ac inst = (DynTestee_ac) instances[3];
			inst.setInt_i(301);
			inst.getDc_i().setInt_i(302);
			inst.getDc_i().setLong_array_i(new long[]{303L});
			inst.getDc_i().getDc_i().setChar_i("instance3".toCharArray());
			inst.getDc_i().getDc_i().setDouble_i(0.304d);
			inst.setBlockMe(0);
			inst.setBlocker(false);
			inst.getDc_dump().getDc_i().setChar_i("dummy".toCharArray());
			inst.getDc_dump().getDc_i().setDouble_i(0.0d);
			inst.getDc_dump().setLong_array_i(new long[]{1000L});
			inst.getDc_dump().setInt_i(123);
			inst.setInt_dump(3);
		}

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
					addr_item__SubSystemConfigTest_top,
					addr_item__SubSystemConfigTest_top_testee,
					addr_item__SubSystemConfigTest_top_testee_AR1,
					addr_item__SubSystemConfigTest_top_testee2
				});
		}
	
		private VariableService variableService;
		
		@Override
		public void init(){
			variableService = new SubSystemConfigTestVariableService(this);
			super.init();
			variableService.init();
		}
			
		@Override
		public void stop(){
			super.stop();
			variableService.stop();
		}
		
};
