package trafficlight.connector;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;


import trafficlight.connector.PMqtt.*;

/*--------------------- begin user code ---------------------*/
import de.protos.etrice.automation.m2m.mqtt.*;
/*--------------------- end user code ---------------------*/


public class MqttWrapperActor extends ActorClassBase {

	
	//--------------------- ports
	protected PMqttPort fct = null;
	
	//--------------------- saps
	
	//--------------------- services

	//--------------------- interface item IDs
	public static final int IFITEM_fct = 1;

	/*--------------------- attributes ---------------------*/
	MqttWrapper connectionMQTT;
	boolean open;
	/*--------------------- operations ---------------------*/
	public void MqttWrapperActor_dtor() {
		connectionMQTT.disconnect();
	}

	//--------------------- construction
	public MqttWrapperActor(IRTObject parent, String name) {
		super(parent, name);
		setClassName("MqttWrapperActor");
		
		// initialize attributes
		this.setConnectionMQTT(new MqttWrapper());
		this.setOpen(false);

		// own ports
		fct = new PMqttPort(this, "fct", IFITEM_fct); 
		
		// own saps
		
		// own service implementations
		
		// sub actors

	}
	
	/* --------------------- attribute setters and getters */
	public void setConnectionMQTT (MqttWrapper connectionMQTT) {
		 this.connectionMQTT = connectionMQTT;
	}
	public MqttWrapper getConnectionMQTT () {
		return this.connectionMQTT;
	}
	public void setOpen (boolean open) {
		 this.open = open;
	}
	public boolean getOpen () {
		return this.open;
	}
	
	
	//--------------------- port getters
	public PMqttPort getFct (){
		return this.fct;
	}

	//--------------------- lifecycle functions
	public void stop(){
		stopUser();
		super.stop();
	}
	
	public void destroy(){
		MqttWrapperActor_dtor();
		super.destroy();
	}

	/* state IDs */
	public static final int STATE_NotInitialized = 2;
	public static final int STATE_Connected = 3;
	public static final int STATE_MAX = 4;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__NotInitialized = 1;
	public static final int CHAIN_TRANS_tr0_FROM_NotInitialized_TO_cp0_BY_connectfct = 2;
	public static final int CHAIN_TRANS_tr3_FROM_Connected_TO_Connected_BY_publishfct_tr3 = 3;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_fct__connect = IFITEM_fct + EVT_SHIFT*PMqtt.IN_connect;
	public static final int TRIG_fct__publish = IFITEM_fct + EVT_SHIFT*PMqtt.IN_publish;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","NotInitialized",
	"Connected"
	};
	
	// history
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE,NO_STATE};
	
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
	protected void action_TRANS_tr0_FROM_NotInitialized_TO_cp0_BY_connectfct(InterfaceItemBase ifitem, DMqttConfig config) {
		open=false;
		connectionMQTT.connect(config.url, config.id);
		//connectionMQTT.connect(new DMqttConfig("tcp://m2m.eclipse.org:1883", "eTrice-Paho-Tester"));
		open=true;
	}
	protected void action_TRANS_tr2_FROM_cp0_TO_Connected_COND_tr2(InterfaceItemBase ifitem, DMqttConfig config) {
		fct.connected();
	}
	protected void action_TRANS_tr3_FROM_Connected_TO_Connected_BY_publishfct_tr3(InterfaceItemBase ifitem, DMqttMessage message) {
		connectionMQTT.publishString(message.topic, message.payload, message.retained, message.qos);
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
				case STATE_NotInitialized:
					this.history[STATE_TOP] = STATE_NotInitialized;
					current = STATE_TOP;
					break;
				case STATE_Connected:
					this.history[STATE_TOP] = STATE_Connected;
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
			case CHAIN_TRANS_INITIAL_TO__NotInitialized:
			{
				return STATE_NotInitialized;
			}
			case CHAIN_TRANS_tr0_FROM_NotInitialized_TO_cp0_BY_connectfct:
			{
				DMqttConfig config = (DMqttConfig) generic_data;
				action_TRANS_tr0_FROM_NotInitialized_TO_cp0_BY_connectfct(ifitem, config);
				if (open==true) {
				action_TRANS_tr2_FROM_cp0_TO_Connected_COND_tr2(ifitem, config);
				return STATE_Connected;}
				else {
				return STATE_NotInitialized;}
			}
			case CHAIN_TRANS_tr3_FROM_Connected_TO_Connected_BY_publishfct_tr3:
			{
				DMqttMessage message = (DMqttMessage) generic_data;
				action_TRANS_tr3_FROM_Connected_TO_Connected_BY_publishfct_tr3(ifitem, message);
				return STATE_Connected;
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
				case STATE_NotInitialized:
					/* in leaf state: return state id */
					return STATE_NotInitialized;
				case STATE_Connected:
					/* in leaf state: return state id */
					return STATE_Connected;
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
		int chain = CHAIN_TRANS_INITIAL_TO__NotInitialized;
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
				case STATE_NotInitialized:
					switch(trigger) {
							case TRIG_fct__connect:
								{
									chain = CHAIN_TRANS_tr0_FROM_NotInitialized_TO_cp0_BY_connectfct;
									catching_state = STATE_TOP;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_Connected:
					switch(trigger) {
							case TRIG_fct__publish:
								{
									chain = CHAIN_TRANS_tr3_FROM_Connected_TO_Connected_BY_publishfct_tr3;
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
