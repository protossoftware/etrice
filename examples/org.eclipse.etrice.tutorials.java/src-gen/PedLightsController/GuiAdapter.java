package PedLightsController;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;


import PedLightsController.PedControlProtocol.*;

/*--------------------- begin user code ---------------------*/
import org.eclipse.etrice.tutorials.PedLightGUI.*;
/*--------------------- end user code ---------------------*/


public class GuiAdapter extends ActorClassBase {

	/*--------------------- begin user code ---------------------*/
	private PedestrianLightWndNoTcp lights = new PedestrianLightWndNoTcp("Pedestrian Lights","  external port connection ");
	private TrafficLight3 carLights;
	private TrafficLight2 pedLights;
	/*--------------------- end user code ---------------------*/
	
	//--------------------- ports
	protected PedControlProtocolConjPort ControlPort = null;
	
	//--------------------- saps
	
	//--------------------- services

	//--------------------- interface item IDs
	public static final int IFITEM_ControlPort = 1;

	/*--------------------- attributes ---------------------*/
	/*--------------------- operations ---------------------*/
	public void GuiAdapter_dtor() {
		lights.closeWindow();
	}

	//--------------------- construction
	public GuiAdapter(IRTObject parent, String name) {
		super(parent, name);
		setClassName("GuiAdapter");
		
		// initialize attributes

		// own ports
		ControlPort = new PedControlProtocolConjPort(this, "ControlPort", IFITEM_ControlPort); 
		
		// own saps
		
		// own service implementations
		
		// sub actors

	}
	
	//--------------------- attribute setters and getters
	
	
	//--------------------- port getters
	public PedControlProtocolConjPort getControlPort (){
		return this.ControlPort;
	}

	//--------------------- lifecycle functions
	public void stop(){
		stopUser();
		super.stop();
	}
	
	public void destroy(){
		GuiAdapter_dtor();
		super.destroy();
	}

	/* state IDs */
	public static final int STATE_running = 2;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__running = 1;
	public static final int CHAIN_TRANS_tr0_FROM_running_TO_running_BY_setCarLightsControlPort_tr0 = 2;
	public static final int CHAIN_TRANS_tr1_FROM_running_TO_running_BY_setPedLightsControlPort_tr1 = 3;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_ControlPort__setCarLights = IFITEM_ControlPort + EVT_SHIFT*PedControlProtocol.OUT_setCarLights;
	public static final int TRIG_ControlPort__setPedLights = IFITEM_ControlPort + EVT_SHIFT*PedControlProtocol.OUT_setPedLights;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","running"
	};
	
	// history
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE};
	
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
	protected void action_TRANS_INITIAL_TO__running() {
		carLights=lights.getCarLights();
		pedLights=lights.getPedLights();
		carLights.setState(TrafficLight3.OFF);
		pedLights.setState(TrafficLight2.OFF);
		lights.setPort(ControlPort);
	}
	protected void action_TRANS_tr0_FROM_running_TO_running_BY_setCarLightsControlPort_tr0(InterfaceItemBase ifitem, int state) {
		carLights.setState(state);
	}
	protected void action_TRANS_tr1_FROM_running_TO_running_BY_setPedLightsControlPort_tr1(InterfaceItemBase ifitem, int state) {
		pedLights.setState(state);
	}
	
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
				case STATE_running:
					this.history[STATE_TOP] = STATE_running;
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
			case CHAIN_TRANS_INITIAL_TO__running:
			{
				action_TRANS_INITIAL_TO__running();
				return STATE_running;
			}
			case CHAIN_TRANS_tr0_FROM_running_TO_running_BY_setCarLightsControlPort_tr0:
			{
				int state = (Integer) generic_data;
				action_TRANS_tr0_FROM_running_TO_running_BY_setCarLightsControlPort_tr0(ifitem, state);
				return STATE_running;
			}
			case CHAIN_TRANS_tr1_FROM_running_TO_running_BY_setPedLightsControlPort_tr1:
			{
				int state = (Integer) generic_data;
				action_TRANS_tr1_FROM_running_TO_running_BY_setPedLightsControlPort_tr1(ifitem, state);
				return STATE_running;
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
				case STATE_running:
					// in leaf state: return state id
					return STATE_running;
				case STATE_TOP:
					state = this.history[STATE_TOP];
					break;
			}
			skip_entry = false;
		}
		//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
	}
	
	public void executeInitTransition() {
		int chain = CHAIN_TRANS_INITIAL_TO__running;
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
				case STATE_running:
					switch(trigger) {
						case TRIG_ControlPort__setCarLights:
							{
								chain = CHAIN_TRANS_tr0_FROM_running_TO_running_BY_setCarLightsControlPort_tr0;
								catching_state = STATE_TOP;
							}
						break;
						case TRIG_ControlPort__setPedLights:
							{
								chain = CHAIN_TRANS_tr1_FROM_running_TO_running_BY_setPedLightsControlPort_tr1;
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
