package PiModel;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;

import room.basic.service.timing.*;
import trafficlight.connector.*;

import trafficlight.connector.PMqtt.*;
import room.basic.service.timing.PTimer.*;
import trafficlight.connector.PTrafficLightInterface.*;



public class Comtroller extends ActorClassBase {

	
	//--------------------- ports
	protected PTrafficLightInterfaceConjPort traffic = null;
	protected PMqttConjPort mqtt = null;
	
	//--------------------- saps
	protected PTimerConjPort timer = null;
	
	//--------------------- services

	//--------------------- interface item IDs
	public static final int IFITEM_traffic = 1;
	public static final int IFITEM_mqtt = 2;
	public static final int IFITEM_timer = 3;

	/*--------------------- attributes ---------------------*/
	/*--------------------- operations ---------------------*/

	//--------------------- construction
	public Comtroller(IRTObject parent, String name) {
		super(parent, name);
		setClassName("Comtroller");
		
		// initialize attributes

		// own ports
		traffic = new PTrafficLightInterfaceConjPort(this, "traffic", IFITEM_traffic); 
		mqtt = new PMqttConjPort(this, "mqtt", IFITEM_mqtt); 
		
		// own saps
		timer = new PTimerConjPort(this, "timer", IFITEM_timer, 0); 
		
		// own service implementations
		
		// sub actors

	}
	
	/* --------------------- attribute setters and getters */
	
	
	//--------------------- port getters
	public PTrafficLightInterfaceConjPort getTraffic (){
		return this.traffic;
	}
	public PMqttConjPort getMqtt (){
		return this.mqtt;
	}
	public PTimerConjPort getTimer (){
		return this.timer;
	}

	//--------------------- lifecycle functions
	public void stop(){
		stopUser();
		super.stop();
	}
	

	/* state IDs */
	public static final int STATE_Initialized = 2;
	public static final int STATE_Initialize = 3;
	public static final int STATE_Initialized_On = 4;
	public static final int STATE_Initialized_Off = 5;
	public static final int STATE_MQTTInit = 6;
	public static final int STATE_MAX = 7;
	
	/* transition chains */
	public static final int CHAIN_Initialized_TRANS_tr1_FROM_On_TO_Off_BY_timeouttimer = 1;
	public static final int CHAIN_Initialized_TRANS_tr2_FROM_Off_TO_On_BY_timeouttimer = 2;
	public static final int CHAIN_TRANS_INITIAL_TO__MQTTInit = 3;
	public static final int CHAIN_TRANS_tr0_FROM_Initialize_TO_Initialized_tp0_BY_initializedtraffic = 4;
	public static final int CHAIN_TRANS_tr1_FROM_MQTTInit_TO_Initialize_BY_connectedmqtt = 5;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_mqtt__connected = IFITEM_mqtt + EVT_SHIFT*PMqtt.OUT_connected;
	public static final int TRIG_timer__timeout = IFITEM_timer + EVT_SHIFT*PTimer.OUT_timeout;
	public static final int TRIG_traffic__initialized = IFITEM_traffic + EVT_SHIFT*PTrafficLightInterface.OUT_initialized;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","Initialized",
	"Initialize",
	"Initialized_On",
	"Initialized_Off",
	"MQTTInit"
	};
	
	// history
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		if (stateStrings[new_state]!="Idle") {
			System.out.println("state switch of "+getInstancePath() + ": "
					+ stateStrings[this.state] + " -> " + stateStrings[new_state]);
		}	
		this.state = new_state;
	}
	
	/* Entry and Exit Codes */
	protected void entry_Initialize() {
		traffic.initialize();
	}
	protected void entry_Initialized() {
		traffic.pedRed();
		mqtt.publish(new DMqttMessage("eTrice/TraaficLight/Controller", "State: Initialized", true, 1));
	}
	protected void entry_Initialized_On() {
		traffic.pedRed();
		traffic.carRed();
		timer.startTimeout(1000);
	}
	protected void exit_Initialized_On() {
		traffic.pedOff();
		traffic.carOff();
	}
	protected void entry_Initialized_Off() {
		timer.startTimeout(1000);
	}
	protected void entry_MQTTInit() {
		mqtt.connect(new DMqttConfig("tcp://m2m.eclipse.org:1883", "eTrice-Paho-Tester"));
	}
	
	/* Action Codes */
	
	/**
	 * calls exit codes while exiting from the current state to one of its
	 * parent states while remembering the history
	 * @param current - the current state
	 * @param to - the final parent state
	 */
	private void exitTo(int current, int to) {
		while (current!=to) {
			switch (current) {
				case STATE_Initialize:
					this.history[STATE_TOP] = STATE_Initialize;
					current = STATE_TOP;
					break;
				case STATE_Initialized:
					this.history[STATE_TOP] = STATE_Initialized;
					current = STATE_TOP;
					break;
				case STATE_Initialized_On:
					exit_Initialized_On();
					this.history[STATE_Initialized] = STATE_Initialized_On;
					current = STATE_Initialized;
					break;
				case STATE_Initialized_Off:
					this.history[STATE_Initialized] = STATE_Initialized_Off;
					current = STATE_Initialized;
					break;
				case STATE_MQTTInit:
					this.history[STATE_TOP] = STATE_MQTTInit;
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
			case CHAIN_TRANS_INITIAL_TO__MQTTInit:
			{
				return STATE_MQTTInit;
			}
			case CHAIN_TRANS_tr0_FROM_Initialize_TO_Initialized_tp0_BY_initializedtraffic:
			{
				entry_Initialized();
				return STATE_Initialized_On;
			}
			case CHAIN_TRANS_tr1_FROM_MQTTInit_TO_Initialize_BY_connectedmqtt:
			{
				return STATE_Initialize;
			}
			case CHAIN_Initialized_TRANS_tr1_FROM_On_TO_Off_BY_timeouttimer:
			{
				return STATE_Initialized_Off;
			}
			case CHAIN_Initialized_TRANS_tr2_FROM_Off_TO_On_BY_timeouttimer:
			{
				return STATE_Initialized_On;
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
				case STATE_Initialize:
					if (!(skip_entry)) entry_Initialize();
					/* in leaf state: return state id */
					return STATE_Initialize;
				case STATE_Initialized:
					if (!(skip_entry)) entry_Initialized();
					/* state has a sub graph */
					/* without init transition */
					state = this.history[STATE_Initialized];
					break;
				case STATE_Initialized_On:
					if (!(skip_entry)) entry_Initialized_On();
					/* in leaf state: return state id */
					return STATE_Initialized_On;
				case STATE_Initialized_Off:
					if (!(skip_entry)) entry_Initialized_Off();
					/* in leaf state: return state id */
					return STATE_Initialized_Off;
				case STATE_MQTTInit:
					if (!(skip_entry)) entry_MQTTInit();
					/* in leaf state: return state id */
					return STATE_MQTTInit;
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
		int chain = CHAIN_TRANS_INITIAL_TO__MQTTInit;
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
				case STATE_Initialize:
					switch(trigger) {
							case TRIG_traffic__initialized:
								{
									chain = CHAIN_TRANS_tr0_FROM_Initialize_TO_Initialized_tp0_BY_initializedtraffic;
									catching_state = STATE_TOP;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_Initialized_On:
					switch(trigger) {
							case TRIG_timer__timeout:
								{
									chain = CHAIN_Initialized_TRANS_tr1_FROM_On_TO_Off_BY_timeouttimer;
									catching_state = STATE_Initialized;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_Initialized_Off:
					switch(trigger) {
							case TRIG_timer__timeout:
								{
									chain = CHAIN_Initialized_TRANS_tr2_FROM_Off_TO_On_BY_timeouttimer;
									catching_state = STATE_Initialized;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_MQTTInit:
					switch(trigger) {
							case TRIG_mqtt__connected:
								{
									chain = CHAIN_TRANS_tr1_FROM_MQTTInit_TO_Initialize_BY_connectedmqtt;
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
