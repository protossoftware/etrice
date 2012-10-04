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



public class TrafficLight extends ActorClassBase {

	
	
	//--------------------- ports
	protected PTcpControlConjPort tcpCtrl = null;
	protected PTcpPayloadConjPort tcpPayload = null;
	
	//--------------------- saps
	protected PTimerConjPort timeout = null;
	protected PTimerConjPort blinkerTimeout = null;
	
	//--------------------- services

	//--------------------- interface item IDs
	public static final int IFITEM_tcpCtrl = 1;
	public static final int IFITEM_tcpPayload = 2;
	public static final int IFITEM_timeout = 3;
	public static final int IFITEM_blinkerTimeout = 4;

		
	/*--------------------- attributes ---------------------*/
	DTcpControl ipConfig;
	/*--------------------- operations ---------------------*/
	public void sendString(String text) {
		
						DTcpPayload pl = new DTcpPayload();
						pl.setData(text.getBytes());
						tcpPayload.send(new DTcpPayload(1, text.length(), text.getBytes()));
	}

	//--------------------- construction
	public TrafficLight(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){
		super(parent, name, port_addr[0][0], peer_addr[0][0]);
		setClassName("TrafficLight");
		
		// initialize attributes
		ipConfig = new DTcpControl();

		// own ports
		tcpCtrl = new PTcpControlConjPort(this, "tcpCtrl", IFITEM_tcpCtrl, 0, port_addr[IFITEM_tcpCtrl][0], peer_addr[IFITEM_tcpCtrl][0]); 
		tcpPayload = new PTcpPayloadConjPort(this, "tcpPayload", IFITEM_tcpPayload, 0, port_addr[IFITEM_tcpPayload][0], peer_addr[IFITEM_tcpPayload][0]); 
		
		// own saps
		timeout = new PTimerConjPort(this, "timeout", IFITEM_timeout, 0, port_addr[IFITEM_timeout][0], peer_addr[IFITEM_timeout][0]); 
		blinkerTimeout = new PTimerConjPort(this, "blinkerTimeout", IFITEM_blinkerTimeout, 0, port_addr[IFITEM_blinkerTimeout][0], peer_addr[IFITEM_blinkerTimeout][0]); 
		
		// own service implementations
	}

	
	//--------------------- attribute setters and getters
	public void setIpConfig (DTcpControl ipConfig) {
		 this.ipConfig = ipConfig;
	}
	public DTcpControl getIpConfig () {
		return this.ipConfig;
	}
	
	
	//--------------------- port getters
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
	public void init(){
		initUser();
	}

	public void start(){
		startUser();
	}

	public void stop(){
		stopUser();
	}
	
	public void destroy(){
	}

	
	/* state IDs */
	public static final int STATE_Off_Blinking = 2;
	public static final int STATE_OpenSocket = 3;
	public static final int STATE_Yellow = 4;
	public static final int STATE_Red = 5;
	public static final int STATE_Green = 6;
	public static final int STATE_Off_Blinking_On = 7;
	public static final int STATE_Off_Blinking_Off = 8;
	
	/* transition chains */
	public static final int CHAIN_Off_Blinking_TRANS_tr1_FROM_On_TO_Off_BY_timeoutblinkerTimeout = 1;
	public static final int CHAIN_Off_Blinking_TRANS_tr2_FROM_Off_TO_On_BY_timeoutblinkerTimeout = 2;
	public static final int CHAIN_TRANS_INITIAL_TO__OpenSocket = 3;
	public static final int CHAIN_TRANS_tr0_FROM_OpenSocket_TO_Off_Blinking_tp0_BY_establishedtcpCtrl = 4;
	public static final int CHAIN_TRANS_tr1_FROM_Yellow_TO_Green_BY_timeouttimeout = 5;
	public static final int CHAIN_TRANS_tr2_FROM_Off_Blinking_TO_Red_BY_timeouttimeout = 6;
	public static final int CHAIN_TRANS_tr3_FROM_Red_TO_Yellow_BY_timeouttimeout = 7;
	public static final int CHAIN_TRANS_tr4_FROM_Green_TO_Off_Blinking_tp0_BY_timeouttimeout = 8;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_blinkerTimeout__timeout = IFITEM_blinkerTimeout + EVT_SHIFT*PTimer.OUT_timeout;
	public static final int TRIG_tcpCtrl__established = IFITEM_tcpCtrl + EVT_SHIFT*PTcpControl.OUT_established;
	public static final int TRIG_timeout__timeout = IFITEM_timeout + EVT_SHIFT*PTimer.OUT_timeout;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","Off_Blinking",
	"OpenSocket",
	"Yellow",
	"Red",
	"Green",
	"Off_Blinking_On",
	"Off_Blinking_Off"
	};
	
	// history
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		if (stateStrings[new_state]!="Idle") {
			System.out.println(getInstancePath() + " -> " + stateStrings[new_state]);
		}	
		this.state = new_state;
	}
	
	/* Entry and Exit Codes */
	protected void entry_OpenSocket() {
		tcpCtrl.open(ipConfig);
	}
	protected void entry_Yellow() {
		sendString("carLights=yellow\n");
		timeout.startTimeout(1000);
	}
	protected void entry_Red() {
		sendString("carLights=red\n");
		timeout.startTimeout(1000);
	}
	protected void entry_Green() {
		sendString("carLights=green\n");
		timeout.startTimeout(1000);
	}
	protected void entry_Off_Blinking() {
		timeout.startTimeout(6000);
	}
	protected void entry_Off_Blinking_On() {
		sendString("carLights=red\n");
		sendString("pedLights=red\n");
		blinkerTimeout.startTimeout(1000);
	}
	protected void exit_Off_Blinking_On() {
		sendString("carLights=off\n");
		sendString("pedLights=off\n");
	}
	protected void entry_Off_Blinking_Off() {
		blinkerTimeout.startTimeout(1000);
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
				case STATE_Yellow:
					this.history[STATE_TOP] = STATE_Yellow;
					current = STATE_TOP;
					break;
				case STATE_Red:
					this.history[STATE_TOP] = STATE_Red;
					current = STATE_TOP;
					break;
				case STATE_Green:
					this.history[STATE_TOP] = STATE_Green;
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
				entry_Off_Blinking();
				return STATE_Off_Blinking_On;
			}
			case CHAIN_TRANS_tr2_FROM_Off_Blinking_TO_Red_BY_timeouttimeout:
			{
				return STATE_Red;
			}
			case CHAIN_TRANS_tr3_FROM_Red_TO_Yellow_BY_timeouttimeout:
			{
				return STATE_Yellow;
			}
			case CHAIN_TRANS_tr1_FROM_Yellow_TO_Green_BY_timeouttimeout:
			{
				return STATE_Green;
			}
			case CHAIN_TRANS_tr4_FROM_Green_TO_Off_Blinking_tp0_BY_timeouttimeout:
			{
				entry_Off_Blinking();
				return STATE_Off_Blinking_On;
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
				case STATE_Yellow:
					if (!(skip_entry || handler)) entry_Yellow();
					// in leaf state: return state id
					return STATE_Yellow;
				case STATE_Red:
					if (!(skip_entry || handler)) entry_Red();
					// in leaf state: return state id
					return STATE_Red;
				case STATE_Green:
					if (!(skip_entry || handler)) entry_Green();
					// in leaf state: return state id
					return STATE_Green;
				case STATE_Off_Blinking:
					if (!(skip_entry || handler)) entry_Off_Blinking();
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
			switch (this.state) {
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
				case STATE_Yellow:
					switch(trigger) {
						case TRIG_timeout__timeout:
							{
								chain = CHAIN_TRANS_tr1_FROM_Yellow_TO_Green_BY_timeouttimeout;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_Red:
					switch(trigger) {
						case TRIG_timeout__timeout:
							{
								chain = CHAIN_TRANS_tr3_FROM_Red_TO_Yellow_BY_timeouttimeout;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_Green:
					switch(trigger) {
						case TRIG_timeout__timeout:
							{
								chain = CHAIN_TRANS_tr4_FROM_Green_TO_Off_Blinking_tp0_BY_timeouttimeout;
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
						case TRIG_timeout__timeout:
							{
								chain = CHAIN_TRANS_tr2_FROM_Off_Blinking_TO_Red_BY_timeouttimeout;
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
						case TRIG_timeout__timeout:
							{
								chain = CHAIN_TRANS_tr2_FROM_Off_Blinking_TO_Red_BY_timeouttimeout;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
			}
		}
		if (chain != NOT_CAUGHT) {
			exitTo(this.state, catching_state, is_handler);
			int next = executeTransitionChain(chain, ifitem, generic_data);
			next = enterHistory(next, is_handler, skip_entry);
			setState(next);
		}
	}
		 
	//******************************************
	// END of generated code for FSM
	//******************************************
};
