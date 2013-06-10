package trafficlight.connector;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;

import room.basic.service.tcp.*;

import room.basic.service.tcp.PTcpControl.*;
import room.basic.service.tcp.PTcpPayload.*;
import trafficlight.connector.PTrafficLightInterface.*;



public class TrafficLightInterface extends ActorClassBase {

	
	//--------------------- ports
	protected PTcpPayloadConjPort payload = null;
	protected PTcpControlConjPort control = null;
	protected PTrafficLightInterfacePort fct = null;
	
	//--------------------- saps
	
	//--------------------- services

	//--------------------- interface item IDs
	public static final int IFITEM_payload = 1;
	public static final int IFITEM_control = 2;
	public static final int IFITEM_fct = 3;

	/*--------------------- attributes ---------------------*/
	DTcpControl tcpConfig;
	/*--------------------- operations ---------------------*/
	public void sendString(String data) {
		payload.send(new DTcpPayload(1, data.length(), data.getBytes()));
	}

	//--------------------- construction
	public TrafficLightInterface(IRTObject parent, String name) {
		super(parent, name);
		setClassName("TrafficLightInterface");
		
		// initialize attributes
		this.setTcpConfig(new DTcpControl());

		// own ports
		payload = new PTcpPayloadConjPort(this, "payload", IFITEM_payload); 
		control = new PTcpControlConjPort(this, "control", IFITEM_control); 
		fct = new PTrafficLightInterfacePort(this, "fct", IFITEM_fct); 
		
		// own saps
		
		// own service implementations
		
		// sub actors

	}
	
	/* --------------------- attribute setters and getters */
	public void setTcpConfig (DTcpControl tcpConfig) {
		 this.tcpConfig = tcpConfig;
	}
	public DTcpControl getTcpConfig () {
		return this.tcpConfig;
	}
	
	
	//--------------------- port getters
	public PTcpPayloadConjPort getPayload (){
		return this.payload;
	}
	public PTcpControlConjPort getControl (){
		return this.control;
	}
	public PTrafficLightInterfacePort getFct (){
		return this.fct;
	}

	//--------------------- lifecycle functions
	public void stop(){
		stopUser();
		super.stop();
	}
	

	/* state IDs */
	public static final int STATE_Uninitialized = 2;
	public static final int STATE_Initializing = 3;
	public static final int STATE_Running = 4;
	public static final int STATE_MAX = 5;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__Uninitialized = 1;
	public static final int CHAIN_TRANS_tr0_FROM_Uninitialized_TO_Initializing_BY_initializefct = 2;
	public static final int CHAIN_TRANS_tr1_FROM_Initializing_TO_Running_BY_establishedcontrol = 3;
	public static final int CHAIN_TRANS_tr2_FROM_Running_TO_Running_BY_pedRedfct_tr2 = 4;
	public static final int CHAIN_TRANS_tr3_FROM_Running_TO_Running_BY_pedOfffct_tr3 = 5;
	public static final int CHAIN_TRANS_tr4_FROM_Running_TO_Running_BY_pedGreenfct_tr4 = 6;
	public static final int CHAIN_TRANS_tr5_FROM_Running_TO_Running_BY_carRedfct_tr5 = 7;
	public static final int CHAIN_TRANS_tr6_FROM_Running_TO_Running_BY_carYellowfct_tr6 = 8;
	public static final int CHAIN_TRANS_tr7_FROM_Running_TO_Running_BY_carGreenfct_tr7 = 9;
	public static final int CHAIN_TRANS_tr8_FROM_Running_TO_Running_BY_carOfffct_tr8 = 10;
	public static final int CHAIN_TRANS_tr9_FROM_Running_TO_Running_BY_receivepayload_tr9 = 11;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_control__established = IFITEM_control + EVT_SHIFT*PTcpControl.OUT_established;
	public static final int TRIG_fct__carGreen = IFITEM_fct + EVT_SHIFT*PTrafficLightInterface.IN_carGreen;
	public static final int TRIG_fct__carOff = IFITEM_fct + EVT_SHIFT*PTrafficLightInterface.IN_carOff;
	public static final int TRIG_fct__carRed = IFITEM_fct + EVT_SHIFT*PTrafficLightInterface.IN_carRed;
	public static final int TRIG_fct__carYellow = IFITEM_fct + EVT_SHIFT*PTrafficLightInterface.IN_carYellow;
	public static final int TRIG_fct__initialize = IFITEM_fct + EVT_SHIFT*PTrafficLightInterface.IN_initialize;
	public static final int TRIG_fct__pedGreen = IFITEM_fct + EVT_SHIFT*PTrafficLightInterface.IN_pedGreen;
	public static final int TRIG_fct__pedOff = IFITEM_fct + EVT_SHIFT*PTrafficLightInterface.IN_pedOff;
	public static final int TRIG_fct__pedRed = IFITEM_fct + EVT_SHIFT*PTrafficLightInterface.IN_pedRed;
	public static final int TRIG_payload__receive = IFITEM_payload + EVT_SHIFT*PTcpPayload.OUT_receive;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","Uninitialized",
	"Initializing",
	"Running"
	};
	
	// history
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		if (stateStrings[new_state]!="Idle") {
			System.out.println("state switch of "+getInstancePath() + ": "
					+ stateStrings[this.state] + " -> " + stateStrings[new_state]);
		}	
		this.state = new_state;
	}
	
	/* Entry and Exit Codes */
	
	/* Action Codes */
	protected void action_TRANS_tr0_FROM_Uninitialized_TO_Initializing_BY_initializefct(InterfaceItemBase ifitem) {
		control.open(tcpConfig);
	}
	protected void action_TRANS_tr1_FROM_Initializing_TO_Running_BY_establishedcontrol(InterfaceItemBase ifitem) {
		fct.initialized();
	}
	protected void action_TRANS_tr2_FROM_Running_TO_Running_BY_pedRedfct_tr2(InterfaceItemBase ifitem) {
		sendString(new String("pedLights=red\n"));
	}
	protected void action_TRANS_tr3_FROM_Running_TO_Running_BY_pedOfffct_tr3(InterfaceItemBase ifitem) {
		sendString(new String("pedLights=off\n"));
	}
	protected void action_TRANS_tr4_FROM_Running_TO_Running_BY_pedGreenfct_tr4(InterfaceItemBase ifitem) {
		sendString(new String("pedLights=green\n"));
	}
	protected void action_TRANS_tr5_FROM_Running_TO_Running_BY_carRedfct_tr5(InterfaceItemBase ifitem) {
		sendString(new String("carLights=red\n"));
	}
	protected void action_TRANS_tr6_FROM_Running_TO_Running_BY_carYellowfct_tr6(InterfaceItemBase ifitem) {
		sendString(new String("carLights=yellow\n"));
	}
	protected void action_TRANS_tr7_FROM_Running_TO_Running_BY_carGreenfct_tr7(InterfaceItemBase ifitem) {
		sendString(new String("carLights=green\n"));
	}
	protected void action_TRANS_tr8_FROM_Running_TO_Running_BY_carOfffct_tr8(InterfaceItemBase ifitem) {
		sendString(new String("carLights=off\n"));
	}
	protected void action_TRANS_tr9_FROM_Running_TO_Running_BY_receivepayload_tr9(InterfaceItemBase ifitem, DTcpPayload data) {
		fct.request();
	}
	
	/**
	 * calls exit codes while exiting from the current state to one of its
	 * parent states while remembering the history
	 * @param current - the current state
	 * @param to - the final parent state
	 */
	private void exitTo(int current, int to) {
		while (current!=to) {
			switch (current) {
				case STATE_Uninitialized:
					this.history[STATE_TOP] = STATE_Uninitialized;
					current = STATE_TOP;
					break;
				case STATE_Initializing:
					this.history[STATE_TOP] = STATE_Initializing;
					current = STATE_TOP;
					break;
				case STATE_Running:
					this.history[STATE_TOP] = STATE_Running;
					current = STATE_TOP;
					break;
				default:
					/* should not occur */
					break;
			}
		}
	}
	
	/**
	 * calls action, entry and exit codes along a transition chain. The generic data are cast to typed data
	 * matching the trigger of this chain. The ID of the final state is returned
	 * @param chain - the chain ID
	 * @param generic_data - the generic data pointer
	 * @return the +/- ID of the final state either with a positive sign, that indicates to execute the state's entry code, or a negative sign vice versa
	 */
	private int executeTransitionChain(int chain, InterfaceItemBase ifitem, Object generic_data) {
		switch (chain) {
			case CHAIN_TRANS_INITIAL_TO__Uninitialized:
			{
				return STATE_Uninitialized;
			}
			case CHAIN_TRANS_tr0_FROM_Uninitialized_TO_Initializing_BY_initializefct:
			{
				action_TRANS_tr0_FROM_Uninitialized_TO_Initializing_BY_initializefct(ifitem);
				return STATE_Initializing;
			}
			case CHAIN_TRANS_tr1_FROM_Initializing_TO_Running_BY_establishedcontrol:
			{
				action_TRANS_tr1_FROM_Initializing_TO_Running_BY_establishedcontrol(ifitem);
				return STATE_Running;
			}
			case CHAIN_TRANS_tr2_FROM_Running_TO_Running_BY_pedRedfct_tr2:
			{
				action_TRANS_tr2_FROM_Running_TO_Running_BY_pedRedfct_tr2(ifitem);
				return STATE_Running;
			}
			case CHAIN_TRANS_tr3_FROM_Running_TO_Running_BY_pedOfffct_tr3:
			{
				action_TRANS_tr3_FROM_Running_TO_Running_BY_pedOfffct_tr3(ifitem);
				return STATE_Running;
			}
			case CHAIN_TRANS_tr4_FROM_Running_TO_Running_BY_pedGreenfct_tr4:
			{
				action_TRANS_tr4_FROM_Running_TO_Running_BY_pedGreenfct_tr4(ifitem);
				return STATE_Running;
			}
			case CHAIN_TRANS_tr5_FROM_Running_TO_Running_BY_carRedfct_tr5:
			{
				action_TRANS_tr5_FROM_Running_TO_Running_BY_carRedfct_tr5(ifitem);
				return STATE_Running;
			}
			case CHAIN_TRANS_tr6_FROM_Running_TO_Running_BY_carYellowfct_tr6:
			{
				action_TRANS_tr6_FROM_Running_TO_Running_BY_carYellowfct_tr6(ifitem);
				return STATE_Running;
			}
			case CHAIN_TRANS_tr7_FROM_Running_TO_Running_BY_carGreenfct_tr7:
			{
				action_TRANS_tr7_FROM_Running_TO_Running_BY_carGreenfct_tr7(ifitem);
				return STATE_Running;
			}
			case CHAIN_TRANS_tr8_FROM_Running_TO_Running_BY_carOfffct_tr8:
			{
				action_TRANS_tr8_FROM_Running_TO_Running_BY_carOfffct_tr8(ifitem);
				return STATE_Running;
			}
			case CHAIN_TRANS_tr9_FROM_Running_TO_Running_BY_receivepayload_tr9:
			{
				DTcpPayload data = (DTcpPayload) generic_data;
				action_TRANS_tr9_FROM_Running_TO_Running_BY_receivepayload_tr9(ifitem, data);
				return STATE_Running;
			}
				default:
					/* should not occur */
					break;
		}
		return NO_STATE;
	}
	
	/**
	 * calls entry codes while entering a state's history. The ID of the final leaf state is returned
	 * @param state - the state which is entered
	 * @return - the ID of the final leaf state
	 */
	private int enterHistory(int state) {
		boolean skip_entry = false;
		if (state >= STATE_MAX) {
			state =  (state - STATE_MAX);
			skip_entry = true;
		}
		while (true) {
			switch (state) {
				case STATE_Uninitialized:
					/* in leaf state: return state id */
					return STATE_Uninitialized;
				case STATE_Initializing:
					/* in leaf state: return state id */
					return STATE_Initializing;
				case STATE_Running:
					/* in leaf state: return state id */
					return STATE_Running;
				case STATE_TOP:
					state = this.history[STATE_TOP];
					break;
				default:
					/* should not occur */
					break;
			}
			skip_entry = false;
		}
		/* return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true) */
	}
	
	public void executeInitTransition() {
		int chain = CHAIN_TRANS_INITIAL_TO__Uninitialized;
		int next = executeTransitionChain(chain, null, null);
		next = enterHistory(next);
		setState(next);
	}
	
	/* receiveEvent contains the main implementation of the FSM */
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object generic_data) {
		int trigger = ifitem.getLocalId() + EVT_SHIFT*evt;
		int chain = NOT_CAUGHT;
		int catching_state = NO_STATE;
		
		if (!handleSystemEvent(ifitem, evt, generic_data)) {
			switch (getState()) {
				case STATE_Uninitialized:
					switch(trigger) {
							case TRIG_fct__initialize:
								{
									chain = CHAIN_TRANS_tr0_FROM_Uninitialized_TO_Initializing_BY_initializefct;
									catching_state = STATE_TOP;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_Initializing:
					switch(trigger) {
							case TRIG_control__established:
								{
									chain = CHAIN_TRANS_tr1_FROM_Initializing_TO_Running_BY_establishedcontrol;
									catching_state = STATE_TOP;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_Running:
					switch(trigger) {
							case TRIG_fct__pedRed:
								{
									chain = CHAIN_TRANS_tr2_FROM_Running_TO_Running_BY_pedRedfct_tr2;
									catching_state = STATE_TOP;
								}
							break;
							case TRIG_fct__pedOff:
								{
									chain = CHAIN_TRANS_tr3_FROM_Running_TO_Running_BY_pedOfffct_tr3;
									catching_state = STATE_TOP;
								}
							break;
							case TRIG_fct__pedGreen:
								{
									chain = CHAIN_TRANS_tr4_FROM_Running_TO_Running_BY_pedGreenfct_tr4;
									catching_state = STATE_TOP;
								}
							break;
							case TRIG_fct__carRed:
								{
									chain = CHAIN_TRANS_tr5_FROM_Running_TO_Running_BY_carRedfct_tr5;
									catching_state = STATE_TOP;
								}
							break;
							case TRIG_fct__carYellow:
								{
									chain = CHAIN_TRANS_tr6_FROM_Running_TO_Running_BY_carYellowfct_tr6;
									catching_state = STATE_TOP;
								}
							break;
							case TRIG_fct__carGreen:
								{
									chain = CHAIN_TRANS_tr7_FROM_Running_TO_Running_BY_carGreenfct_tr7;
									catching_state = STATE_TOP;
								}
							break;
							case TRIG_fct__carOff:
								{
									chain = CHAIN_TRANS_tr8_FROM_Running_TO_Running_BY_carOfffct_tr8;
									catching_state = STATE_TOP;
								}
							break;
							case TRIG_payload__receive:
								{
									chain = CHAIN_TRANS_tr9_FROM_Running_TO_Running_BY_receivepayload_tr9;
									catching_state = STATE_TOP;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				default:
					/* should not occur */
					break;
			}
		}
		if (chain != NOT_CAUGHT) {
			exitTo(getState(), catching_state);
			{
				int next = executeTransitionChain(chain, ifitem, generic_data);
				next = enterHistory(next);
				setState(next);
			}
		}
	}
};
