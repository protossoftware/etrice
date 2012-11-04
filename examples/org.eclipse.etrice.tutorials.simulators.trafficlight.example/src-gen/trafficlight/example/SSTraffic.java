package trafficlight.example;

import org.eclipse.etrice.runtime.java.messaging.MessageService;
import org.eclipse.etrice.runtime.java.messaging.RTServices;
import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.RTSystemServicesProtocol.*;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;

import room.basic.service.tcp.*;import room.basic.service.timing.*;



public class SSTraffic extends SubSystemClassBase{

	
	public SSTraffic(String name) {
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
		Address addr_item_SystemPort_0 = new Address(0,0,130);
		Address addr_item_SystemPort_1 = new Address(0,0,131);
		Address addr_item_SystemPort_2 = new Address(0,0,132);
		Address addr_item_SystemPort_3 = new Address(0,0,133);
		Address addr_item_SystemPort_4 = new Address(0,0,134);
		Address addr_item_SystemPort_5 = new Address(0,0,135);
		Address addr_item_SystemPort_6 = new Address(0,0,136);
		
		// actor instance /SSTraffic/application itself => Systemport Address
		Address addr_item__SSTraffic_application = new Address(0,0,101);
		// interface items of /SSTraffic/application
		// actor instance /SSTraffic/application/light1 itself => Systemport Address
		Address addr_item__SSTraffic_application_light1 = new Address(0,0,102);
		// interface items of /SSTraffic/application/light1
		Address addr_item__SSTraffic_application_light1_controller = new Address(0,0,103);
		Address addr_item__SSTraffic_application_light1_tcpCtrl = new Address(0,0,104);
		Address addr_item__SSTraffic_application_light1_tcpPayload = new Address(0,0,105);
		Address addr_item__SSTraffic_application_light1_timeout = new Address(0,0,106);
		Address addr_item__SSTraffic_application_light1_blinkerTimeout = new Address(0,0,107);
		// actor instance /SSTraffic/application/light1/trafficLightSocket itself => Systemport Address
		Address addr_item__SSTraffic_application_light1_trafficLightSocket = new Address(0,0,108);
		// interface items of /SSTraffic/application/light1/trafficLightSocket
		Address addr_item__SSTraffic_application_light1_trafficLightSocket_ControlPort = new Address(0,0,109);
		Address addr_item__SSTraffic_application_light1_trafficLightSocket_PayloadPort = new Address(0,0,110);
		// actor instance /SSTraffic/application/light2 itself => Systemport Address
		Address addr_item__SSTraffic_application_light2 = new Address(0,0,111);
		// interface items of /SSTraffic/application/light2
		Address addr_item__SSTraffic_application_light2_controller = new Address(0,0,112);
		Address addr_item__SSTraffic_application_light2_tcpCtrl = new Address(0,0,113);
		Address addr_item__SSTraffic_application_light2_tcpPayload = new Address(0,0,114);
		Address addr_item__SSTraffic_application_light2_timeout = new Address(0,0,115);
		Address addr_item__SSTraffic_application_light2_blinkerTimeout = new Address(0,0,116);
		// actor instance /SSTraffic/application/light2/trafficLightSocket itself => Systemport Address
		Address addr_item__SSTraffic_application_light2_trafficLightSocket = new Address(0,0,117);
		// interface items of /SSTraffic/application/light2/trafficLightSocket
		Address addr_item__SSTraffic_application_light2_trafficLightSocket_ControlPort = new Address(0,0,118);
		Address addr_item__SSTraffic_application_light2_trafficLightSocket_PayloadPort = new Address(0,0,119);
		// actor instance /SSTraffic/application/controller itself => Systemport Address
		Address addr_item__SSTraffic_application_controller = new Address(0,0,120);
		// interface items of /SSTraffic/application/controller
		Address addr_item__SSTraffic_application_controller_light1 = new Address(0,0,121);
		Address addr_item__SSTraffic_application_controller_light2 = new Address(0,0,122);
		Address addr_item__SSTraffic_application_controller_timeout = new Address(0,0,123);
		// actor instance /SSTraffic/TimingService itself => Systemport Address
		Address addr_item__SSTraffic_TimingService = new Address(0,0,124);
		// interface items of /SSTraffic/TimingService
		Address addr_item__SSTraffic_TimingService_timer_0 = new Address(0,0,125);
		Address addr_item__SSTraffic_TimingService_timer_1 = new Address(0,0,126);
		Address addr_item__SSTraffic_TimingService_timer_2 = new Address(0,0,127);
		Address addr_item__SSTraffic_TimingService_timer_3 = new Address(0,0,128);
		Address addr_item__SSTraffic_TimingService_timer_4 = new Address(0,0,129);

		// instantiate all actor instances
		instances = new ActorClassBase[7];
		instances[0] = new TrafficlightExampleApplication(
			this,
			"application",
			// own interface item addresses
			new Address[][] {{addr_item__SSTraffic_application}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_0}
			}
		); 
		instances[1] = new TrafficLight(
			instances[0],
			"light1",
			// own interface item addresses
			new Address[][] {{addr_item__SSTraffic_application_light1},
				{
					addr_item__SSTraffic_application_light1_controller
				},
				{
					addr_item__SSTraffic_application_light1_tcpCtrl
				},
				{
					addr_item__SSTraffic_application_light1_tcpPayload
				},
				{
					addr_item__SSTraffic_application_light1_timeout
				},
				{
					addr_item__SSTraffic_application_light1_blinkerTimeout
				}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_1},
				{
					addr_item__SSTraffic_application_controller_light1
				},
				{
					addr_item__SSTraffic_application_light1_trafficLightSocket_ControlPort
				},
				{
					addr_item__SSTraffic_application_light1_trafficLightSocket_PayloadPort
				},
				{
					addr_item__SSTraffic_TimingService_timer_0
				},
				{
					addr_item__SSTraffic_TimingService_timer_1
				}
			}
		); 
		instances[2] = new ATcpClient(
			instances[1],
			"trafficLightSocket",
			// own interface item addresses
			new Address[][] {{addr_item__SSTraffic_application_light1_trafficLightSocket},
				{
					addr_item__SSTraffic_application_light1_trafficLightSocket_ControlPort
				},
				{
					addr_item__SSTraffic_application_light1_trafficLightSocket_PayloadPort
				}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_2},
				{
					addr_item__SSTraffic_application_light1_tcpCtrl
				},
				{
					addr_item__SSTraffic_application_light1_tcpPayload
				}
			}
		); 
		instances[3] = new TrafficLight(
			instances[0],
			"light2",
			// own interface item addresses
			new Address[][] {{addr_item__SSTraffic_application_light2},
				{
					addr_item__SSTraffic_application_light2_controller
				},
				{
					addr_item__SSTraffic_application_light2_tcpCtrl
				},
				{
					addr_item__SSTraffic_application_light2_tcpPayload
				},
				{
					addr_item__SSTraffic_application_light2_timeout
				},
				{
					addr_item__SSTraffic_application_light2_blinkerTimeout
				}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_3},
				{
					addr_item__SSTraffic_application_controller_light2
				},
				{
					addr_item__SSTraffic_application_light2_trafficLightSocket_ControlPort
				},
				{
					addr_item__SSTraffic_application_light2_trafficLightSocket_PayloadPort
				},
				{
					addr_item__SSTraffic_TimingService_timer_2
				},
				{
					addr_item__SSTraffic_TimingService_timer_3
				}
			}
		); 
		instances[4] = new ATcpClient(
			instances[3],
			"trafficLightSocket",
			// own interface item addresses
			new Address[][] {{addr_item__SSTraffic_application_light2_trafficLightSocket},
				{
					addr_item__SSTraffic_application_light2_trafficLightSocket_ControlPort
				},
				{
					addr_item__SSTraffic_application_light2_trafficLightSocket_PayloadPort
				}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_4},
				{
					addr_item__SSTraffic_application_light2_tcpCtrl
				},
				{
					addr_item__SSTraffic_application_light2_tcpPayload
				}
			}
		); 
		instances[5] = new TrafficController(
			instances[0],
			"controller",
			// own interface item addresses
			new Address[][] {{addr_item__SSTraffic_application_controller},
				{
					addr_item__SSTraffic_application_controller_light1
				},
				{
					addr_item__SSTraffic_application_controller_light2
				},
				{
					addr_item__SSTraffic_application_controller_timeout
				}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_5},
				{
					addr_item__SSTraffic_application_light1_controller
				},
				{
					addr_item__SSTraffic_application_light2_controller
				},
				{
					addr_item__SSTraffic_TimingService_timer_4
				}
			}
		); 
		instances[6] = new ATimingService(
			this,
			"TimingService",
			// own interface item addresses
			new Address[][] {{addr_item__SSTraffic_TimingService},
				{
					addr_item__SSTraffic_TimingService_timer_0,
					addr_item__SSTraffic_TimingService_timer_1,
					addr_item__SSTraffic_TimingService_timer_2,
					addr_item__SSTraffic_TimingService_timer_3,
					addr_item__SSTraffic_TimingService_timer_4
				}
			},
			// peer interface item addresses
			new Address[][] {{addr_item_SystemPort_6},
				{
					addr_item__SSTraffic_application_light1_timeout,
					addr_item__SSTraffic_application_light1_blinkerTimeout,
					addr_item__SSTraffic_application_light2_timeout,
					addr_item__SSTraffic_application_light2_blinkerTimeout,
					addr_item__SSTraffic_application_controller_timeout
				}
			}
		); 
		
		// apply instance attribute configurations
		{
			TrafficLight inst = (TrafficLight) instances[1];
			inst.getIpConfig().setIPAddr("127.0.0.1");
			inst.getIpConfig().setTcpPort(4441);
		}
		{
			TrafficLight inst = (TrafficLight) instances[3];
			inst.getIpConfig().setIPAddr("127.0.0.1");
			inst.getIpConfig().setTcpPort(4442);
		}

		// create the subsystem system port	
		RTSystemPort = new RTSystemServicesProtocolConjPortRepl(this, "RTSystemPort",
				0, //local ID
				// own addresses
				new Address[]{
					addr_item_SystemPort_0,
					addr_item_SystemPort_1,
					addr_item_SystemPort_2,
					addr_item_SystemPort_3,
					addr_item_SystemPort_4,
					addr_item_SystemPort_5,
					addr_item_SystemPort_6
				},
				// peer addresses
				new Address[]{
					addr_item__SSTraffic_application,
					addr_item__SSTraffic_application_light1,
					addr_item__SSTraffic_application_light1_trafficLightSocket,
					addr_item__SSTraffic_application_light2,
					addr_item__SSTraffic_application_light2_trafficLightSocket,
					addr_item__SSTraffic_application_controller,
					addr_item__SSTraffic_TimingService
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
