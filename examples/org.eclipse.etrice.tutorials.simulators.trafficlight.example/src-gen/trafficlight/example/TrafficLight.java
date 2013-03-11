package trafficlight.example;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;

import room.basic.service.tcp.*;
import room.basic.service.timing.*;

import room.basic.service.tcp.PTcpControl.*;
import room.basic.service.tcp.PTcpPayload.*;
import room.basic.service.timing.PTimer.*;
import trafficlight.example.PTrafficLight.*;



public class TrafficLight extends ActorClassBase {

	
	//--------------------- ports
	protected PTrafficLightPort controller = null;
	protected PTcpControlConjPort tcpCtrl = null;
	protected PTcpPayloadConjPort tcpPayload = null;
	
	//--------------------- saps
	protected PTimerConjPort timeout = null;
	protected PTimerConjPort blinkerTimeout = null;
	
	//--------------------- services

	//--------------------- interface item IDs
	public static final int IFITEM_controller = 1;
	public static final int IFITEM_tcpCtrl = 2;
	public static final int IFITEM_tcpPayload = 3;
	public static final int IFITEM_timeout = 4;
	public static final int IFITEM_blinkerTimeout = 5;

	/*--------------------- attributes ---------------------*/
	DTcpControl ipConfig;
	/*--------------------- operations ---------------------*/
	public void sendString(String text) {
		
						DTcpPayload pl = new DTcpPayload();
						pl.setData(text.getBytes());
						tcpPayload.send(new DTcpPayload(1, text.length(), text.getBytes()));
	}

	//--------------------- construction
	public TrafficLight(IRTObject parent, String name) {
		super(parent, name);
		setClassName("TrafficLight");
		
		// initialize attributes
		this.setIpConfig(new DTcpControl());

		// own ports
		controller = new PTrafficLightPort(this, "controller", IFITEM_controller); 
		tcpCtrl = new PTcpControlConjPort(this, "tcpCtrl", IFITEM_tcpCtrl); 
		tcpPayload = new PTcpPayloadConjPort(this, "tcpPayload", IFITEM_tcpPayload); 
		
		// own saps
		timeout = new PTimerConjPort(this, "timeout", IFITEM_timeout, 0); 
		blinkerTimeout = new PTimerConjPort(this, "blinkerTimeout", IFITEM_blinkerTimeout, 0); 
		
		// own service implementations
		
		// sub actors
		new ATcpClient(this, "trafficLightSocket"); 

	}
	
	//--------------------- attribute setters and getters
	public void setIpConfig (DTcpControl ipConfig) {
		 this.ipConfig = ipConfig;
	}
	public DTcpControl getIpConfig () {
		return this.ipConfig;
	}
	
	
	//--------------------- port getters
	public PTrafficLightPort getController (){
		return this.controller;
	}
	public PTcpControlConjPort getTcpCtrl (){
		return this.tcpCtrl;
	}
	public PTcpPayloadConjPort getTcpPayload (){
		return this.tcpPayload;
	}
	public PTimerConjPort getTimeout (){
		return this.timeout;
	}
	public PTimerConjPort getBlinkerTimeout (){
		return this.blinkerTimeout;
	}

	//--------------------- lifecycle functions
	public void stop(){
		stopUser();
		super.stop();
	}
	

	/* state IDs */
	public static final int STATE_Off_Blinking = 2;
	public static final int STATE_OpenSocket = 3;
	public static final int STATE_CarYellow = 4;
	public static final int STATE_PedRed = 5;
	public static final int STATE_CarGreen = 6;
	public static final int STATE_Off_Blinking_On = 7;
	public static final int STATE_Off_Blinking_Off = 8;
	public static final int STATE_CarYellow2 = 9;
	public static final int STATE_CarRed = 10;
	public static final int STATE_PedGreen = 11;
	
	/* transition chains */
	public static final int CHAIN_Off_Blinking_TRANS_tr1_FROM_On_TO_Off_BY_timeoutblinkerTimeout = 1;
	public static final int CHAIN_Off_Blinking_TRANS_tr2_FROM_Off_TO_On_BY_timeoutblinkerTimeout = 2;
	public static final int CHAIN_TRANS_INITIAL_TO__OpenSocket = 3;
	public static final int CHAIN_TRANS_tr0_FROM_OpenSocket_TO_Off_Blinking_tp0_BY_establishedtcpCtrl = 4;
	public static final int CHAIN_TRANS_tr1_FROM_CarYellow_TO_CarGreen_BY_timeouttimeout = 5;
	public static final int CHAIN_TRANS_tr2_FROM_Off_Blinking_TO_PedRed_BY_greenForCarcontroller = 6;
	public static final int CHAIN_TRANS_tr3_FROM_PedRed_TO_CarYellow_BY_timeouttimeout = 7;
	public static final int CHAIN_TRANS_tr4_FROM_Off_Blinking_TO_CarYellow2_BY_greenForPedcontroller = 8;
	public static final int CHAIN_TRANS_tr5_FROM_CarYellow2_TO_CarRed_BY_timeouttimeout = 9;
	public static final int CHAIN_TRANS_tr6_FROM_CarRed_TO_PedGreen_BY_timeouttimeout = 10;
	public static final int CHAIN_TRANS_tr7_FROM_PedGreen_TO_PedRed_BY_greenForCarcontroller = 11;
	public static final int CHAIN_TRANS_tr8_FROM_CarGreen_TO_CarYellow2_BY_greenForPedcontroller = 12;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_blinkerTimeout__timeout = IFITEM_blinkerTimeout + EVT_SHIFT*PTimer.OUT_timeout;
	public static final int TRIG_controller__greenForCar = IFITEM_controller + EVT_SHIFT*PTrafficLight.IN_greenForCar;
	public static final int TRIG_controller__greenForPed = IFITEM_controller + EVT_SHIFT*PTrafficLight.IN_greenForPed;
	public static final int TRIG_tcpCtrl__established = IFITEM_tcpCtrl + EVT_SHIFT*PTcpControl.OUT_established;
	public static final int TRIG_timeout__timeout = IFITEM_timeout + EVT_SHIFT*PTimer.OUT_timeout;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","Off_Blinking",
	"OpenSocket",
	"CarYellow",
	"PedRed",
	"CarGreen",
	"Off_Blinking_On",
	"Off_Blinking_Off",
	"CarYellow2",
	"CarRed",
	"PedGreen"
	};
	
	// history
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		if (stateStrings[new_state]!="Idle") {
			System.out.println("state switch of "+getInstancePath() + ": "
					+ stateStrings[this.state] + " -> " + stateStrings[new_state]);
		}	
		this.state = new_state;
	}
	
	/* Entry and Exit Codes */
	protected void entry_OpenSocket() {
		tcpCtrl.open(ipConfig);
	}
	protected void entry_CarYellow() {
		sendString("carLights=yellow\n");
		timeout.startTimeout(1000);
	}
	protected void entry_PedRed() {
		sendString("pedLights=red\n");
		sendString("carLights=red\n");
		timeout.startTimeout(1000);
	}
	protected void entry_CarGreen() {
		sendString("carLights=green\n");
		controller.greenForCarDone();
	}
	protected void entry_Off_Blinking_On() {
		sendString("carLights=red\n");
		sendString("pedLights=red\n");
		blinkerTimeout.startTimeout(500);
	}
	protected void exit_Off_Blinking_On() {
		sendString("carLights=off\n");
		sendString("pedLights=off\n");
	}
	protected void entry_Off_Blinking_Off() {
		blinkerTimeout.startTimeout(500);
	}
	protected void entry_CarYellow2() {
		sendString("carLights=yellow\n");
		timeout.startTimeout(1000);
	}
	protected void entry_CarRed() {
		sendString("carLights=red\n");
		timeout.startTimeout(1000);
	}
	protected void entry_PedGreen() {
		sendString("pedLights=green\n");
		controller.greenForPedDone();
	}
	
	/* Action Codes */
	
	/**
	 * calls exit codes while exiting from the current state to one of its
	 * parent states while remembering the history
	 * @param current - the current state
	 * @param to - the final parent state
	 * @param handler - entry and exit codes are called only if not handler (for handler TransitionPoints)
	 */
	private void exitTo(int current, int to, boolean handler) {
		while (current!=to) {
			switch (current) {
				case STATE_OpenSocket:
					this.history[STATE_TOP] = STATE_OpenSocket;
					current = STATE_TOP;
					break;
				case STATE_CarYellow:
					this.history[STATE_TOP] = STATE_CarYellow;
					current = STATE_TOP;
					break;
				case STATE_PedRed:
					this.history[STATE_TOP] = STATE_PedRed;
					current = STATE_TOP;
					break;
				case STATE_CarGreen:
					this.history[STATE_TOP] = STATE_CarGreen;
					current = STATE_TOP;
					break;
				case STATE_Off_Blinking:
					this.history[STATE_TOP] = STATE_Off_Blinking;
					current = STATE_TOP;
					break;
				case STATE_Off_Blinking_On:
					if (!handler) exit_Off_Blinking_On();
					this.history[STATE_Off_Blinking] = STATE_Off_Blinking_On;
					current = STATE_Off_Blinking;
					break;
				case STATE_Off_Blinking_Off:
					this.history[STATE_Off_Blinking] = STATE_Off_Blinking_Off;
					current = STATE_Off_Blinking;
					break;
				case STATE_CarYellow2:
					this.history[STATE_TOP] = STATE_CarYellow2;
					current = STATE_TOP;
					break;
				case STATE_CarRed:
					this.history[STATE_TOP] = STATE_CarRed;
					current = STATE_TOP;
					break;
				case STATE_PedGreen:
					this.history[STATE_TOP] = STATE_PedGreen;
					current = STATE_TOP;
					break;
			}
		}
	}
	
	/**
	 * calls action, entry and exit codes along a transition chain. The generic data are cast to typed data
	 * matching the trigger of this chain. The ID of the final state is returned
	 * @param chain - the chain ID
	 * @param generic_data - the generic data pointer
	 * @return the ID of the final state
	 */
	private int executeTransitionChain(int chain, InterfaceItemBase ifitem, Object generic_data) {
		switch (chain) {
			case CHAIN_TRANS_INITIAL_TO__OpenSocket:
			{
				return STATE_OpenSocket;
			}
			case CHAIN_TRANS_tr0_FROM_OpenSocket_TO_Off_Blinking_tp0_BY_establishedtcpCtrl:
			{
				return STATE_Off_Blinking_On;
			}
			case CHAIN_TRANS_tr2_FROM_Off_Blinking_TO_PedRed_BY_greenForCarcontroller:
			{
				return STATE_PedRed;
			}
			case CHAIN_TRANS_tr3_FROM_PedRed_TO_CarYellow_BY_timeouttimeout:
			{
				return STATE_CarYellow;
			}
			case CHAIN_TRANS_tr1_FROM_CarYellow_TO_CarGreen_BY_timeouttimeout:
			{
				return STATE_CarGreen;
			}
			case CHAIN_TRANS_tr4_FROM_Off_Blinking_TO_CarYellow2_BY_greenForPedcontroller:
			{
				return STATE_CarYellow2;
			}
			case CHAIN_TRANS_tr5_FROM_CarYellow2_TO_CarRed_BY_timeouttimeout:
			{
				return STATE_CarRed;
			}
			case CHAIN_TRANS_tr6_FROM_CarRed_TO_PedGreen_BY_timeouttimeout:
			{
				return STATE_PedGreen;
			}
			case CHAIN_TRANS_tr7_FROM_PedGreen_TO_PedRed_BY_greenForCarcontroller:
			{
				return STATE_PedRed;
			}
			case CHAIN_TRANS_tr8_FROM_CarGreen_TO_CarYellow2_BY_greenForPedcontroller:
			{
				return STATE_CarYellow2;
			}
			case CHAIN_Off_Blinking_TRANS_tr1_FROM_On_TO_Off_BY_timeoutblinkerTimeout:
			{
				return STATE_Off_Blinking_Off;
			}
			case CHAIN_Off_Blinking_TRANS_tr2_FROM_Off_TO_On_BY_timeoutblinkerTimeout:
			{
				return STATE_Off_Blinking_On;
			}
		}
		return NO_STATE;
	}
	
	/**
	 * calls entry codes while entering a state's history. The ID of the final leaf state is returned
	 * @param state - the state which is entered
	 * @param handler - entry code is executed if not handler
	 * @return - the ID of the final leaf state
	 */
	private int enterHistory(int state, boolean handler, boolean skip_entry) {
		while (true) {
			switch (state) {
				case STATE_OpenSocket:
					if (!(skip_entry || handler)) entry_OpenSocket();
					// in leaf state: return state id
					return STATE_OpenSocket;
				case STATE_CarYellow:
					if (!(skip_entry || handler)) entry_CarYellow();
					// in leaf state: return state id
					return STATE_CarYellow;
				case STATE_PedRed:
					if (!(skip_entry || handler)) entry_PedRed();
					// in leaf state: return state id
					return STATE_PedRed;
				case STATE_CarGreen:
					if (!(skip_entry || handler)) entry_CarGreen();
					// in leaf state: return state id
					return STATE_CarGreen;
				case STATE_Off_Blinking:
					// state has a sub graph
					// without init transition
					state = this.history[STATE_Off_Blinking];
					break;
				case STATE_Off_Blinking_On:
					if (!(skip_entry || handler)) entry_Off_Blinking_On();
					// in leaf state: return state id
					return STATE_Off_Blinking_On;
				case STATE_Off_Blinking_Off:
					if (!(skip_entry || handler)) entry_Off_Blinking_Off();
					// in leaf state: return state id
					return STATE_Off_Blinking_Off;
				case STATE_CarYellow2:
					if (!(skip_entry || handler)) entry_CarYellow2();
					// in leaf state: return state id
					return STATE_CarYellow2;
				case STATE_CarRed:
					if (!(skip_entry || handler)) entry_CarRed();
					// in leaf state: return state id
					return STATE_CarRed;
				case STATE_PedGreen:
					if (!(skip_entry || handler)) entry_PedGreen();
					// in leaf state: return state id
					return STATE_PedGreen;
				case STATE_TOP:
					state = this.history[STATE_TOP];
					break;
			}
			skip_entry = false;
		}
		//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
	}
	
	public void executeInitTransition() {
		int chain = CHAIN_TRANS_INITIAL_TO__OpenSocket;
		int next = executeTransitionChain(chain, null, null);
		next = enterHistory(next, false, false);
		setState(next);
	}
	
	/* receiveEvent contains the main implementation of the FSM */
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object generic_data) {
		int trigger = ifitem.getLocalId() + EVT_SHIFT*evt;
		int chain = NOT_CAUGHT;
		int catching_state = NO_STATE;
		boolean is_handler = false;
		boolean skip_entry = false;
		
		if (!handleSystemEvent(ifitem, evt, generic_data)) {
			switch (getState()) {
				case STATE_OpenSocket:
					switch(trigger) {
						case TRIG_tcpCtrl__established:
							{
								chain = CHAIN_TRANS_tr0_FROM_OpenSocket_TO_Off_Blinking_tp0_BY_establishedtcpCtrl;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_CarYellow:
					switch(trigger) {
						case TRIG_timeout__timeout:
							{
								chain = CHAIN_TRANS_tr1_FROM_CarYellow_TO_CarGreen_BY_timeouttimeout;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_PedRed:
					switch(trigger) {
						case TRIG_timeout__timeout:
							{
								chain = CHAIN_TRANS_tr3_FROM_PedRed_TO_CarYellow_BY_timeouttimeout;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_CarGreen:
					switch(trigger) {
						case TRIG_controller__greenForPed:
							{
								chain = CHAIN_TRANS_tr8_FROM_CarGreen_TO_CarYellow2_BY_greenForPedcontroller;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_Off_Blinking_On:
					switch(trigger) {
						case TRIG_blinkerTimeout__timeout:
							{
								chain = CHAIN_Off_Blinking_TRANS_tr1_FROM_On_TO_Off_BY_timeoutblinkerTimeout;
								catching_state = STATE_Off_Blinking;
							}
						break;
						case TRIG_controller__greenForCar:
							{
								chain = CHAIN_TRANS_tr2_FROM_Off_Blinking_TO_PedRed_BY_greenForCarcontroller;
								catching_state = STATE_TOP;
							}
						break;
						case TRIG_controller__greenForPed:
							{
								chain = CHAIN_TRANS_tr4_FROM_Off_Blinking_TO_CarYellow2_BY_greenForPedcontroller;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_Off_Blinking_Off:
					switch(trigger) {
						case TRIG_blinkerTimeout__timeout:
							{
								chain = CHAIN_Off_Blinking_TRANS_tr2_FROM_Off_TO_On_BY_timeoutblinkerTimeout;
								catching_state = STATE_Off_Blinking;
							}
						break;
						case TRIG_controller__greenForCar:
							{
								chain = CHAIN_TRANS_tr2_FROM_Off_Blinking_TO_PedRed_BY_greenForCarcontroller;
								catching_state = STATE_TOP;
							}
						break;
						case TRIG_controller__greenForPed:
							{
								chain = CHAIN_TRANS_tr4_FROM_Off_Blinking_TO_CarYellow2_BY_greenForPedcontroller;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_CarYellow2:
					switch(trigger) {
						case TRIG_timeout__timeout:
							{
								chain = CHAIN_TRANS_tr5_FROM_CarYellow2_TO_CarRed_BY_timeouttimeout;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_CarRed:
					switch(trigger) {
						case TRIG_timeout__timeout:
							{
								chain = CHAIN_TRANS_tr6_FROM_CarRed_TO_PedGreen_BY_timeouttimeout;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_PedGreen:
					switch(trigger) {
						case TRIG_controller__greenForCar:
							{
								chain = CHAIN_TRANS_tr7_FROM_PedGreen_TO_PedRed_BY_greenForCarcontroller;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
			}
		}
		if (chain != NOT_CAUGHT) {
			exitTo(getState(), catching_state, is_handler);
			int next = executeTransitionChain(chain, ifitem, generic_data);
			next = enterHistory(next, is_handler, skip_entry);
			setState(next);
		}
	}
		 
	//******************************************
	// END of generated code for FSM
	//******************************************
};
