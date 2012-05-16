package room.basic.service.tcp;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;


import room.basic.service.tcp.PTcpControl.*;
import room.basic.service.tcp.PTcpPayload.*;

/*--------------------- begin user code ---------------------*/
	import java.net.Socket;
	import java.io.*;
		
			class ClientRxThread extends Thread{
				private Socket sock;
				PTcpPayloadPort port;
				public ClientRxThread (PTcpPayloadPort port, Socket sock){
					this.sock = sock;
					this.port = port;
				}
				public void run(){
					try{
						InputStream in = sock.getInputStream();
						DTcpPayload d = new DTcpPayload();
						d.setConnectionId(0);
						int c;
						while ((c=in.read(d.getData()))!=-1){
							d.setLength(c);
							port.receive(d);
						}
					}catch (IOException e){
						System.err.println("ClientRx: " + e.toString());
					}
				
				}
			}
/*--------------------- end user code ---------------------*/


public class ATcpClient extends ActorClassBase {

	/*--------------------- begin user code ---------------------*/
		Socket socket;
		InputStream in;
		OutputStream out;
	/*--------------------- end user code ---------------------*/
	
	//--------------------- ports
	protected PTcpControlPort ControlPort = null;
	protected PTcpPayloadPort PayloadPort = null;
	
	//--------------------- saps
	
	//--------------------- services

	//--------------------- interface item IDs
	public static final int IFITEM_ControlPort = 1;
	public static final int IFITEM_PayloadPort = 2;
		
	/*--------------------- attributes ---------------------*/
	int lastError;
	/*--------------------- operations ---------------------*/
	public void stopUser() {
		try{
		if(socket != null){
		socket.close();
		}
		}catch(IOException e){
		System.err.println(e.toString());}
	}

	//--------------------- construction
	public ATcpClient(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){
		super(parent, name, port_addr[0][0], peer_addr[0][0]);
		setClassName("ATcpClient");
		
		// initialize attributes
		lastError = 0;

		// own ports
		ControlPort = new PTcpControlPort(this, "ControlPort", IFITEM_ControlPort, 0, port_addr[IFITEM_ControlPort][0], peer_addr[IFITEM_ControlPort][0]); 
		PayloadPort = new PTcpPayloadPort(this, "PayloadPort", IFITEM_PayloadPort, 0, port_addr[IFITEM_PayloadPort][0], peer_addr[IFITEM_PayloadPort][0]); 
		
		// own saps
		
		// own service implementations
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
	public static final int STATE_closed = 2;
	public static final int STATE_opened = 3;
	public static final int STATE_error = 4;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__closed = 1;
	public static final int CHAIN_TRANS_tr0_FROM_closed_TO_cp0_BY_openControlPort = 2;
	public static final int CHAIN_TRANS_tr1_FROM_opened_TO_closed_BY_closeControlPort = 3;
	public static final int CHAIN_TRANS_tr3_FROM_opened_TO_opened_BY_sendPayloadPort_tr3 = 4;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_ControlPort__close = IFITEM_ControlPort + EVT_SHIFT*PTcpControl.IN_close;
	public static final int TRIG_ControlPort__open = IFITEM_ControlPort + EVT_SHIFT*PTcpControl.IN_open;
	public static final int TRIG_PayloadPort__send = IFITEM_PayloadPort + EVT_SHIFT*PTcpPayload.IN_send;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","closed",
	"opened",
	"error"
	};
	
	// history
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		if (stateStrings[new_state]!="Idle") {
			System.out.println(getInstancePath() + " -> " + stateStrings[new_state]);
		}	
		this.state = new_state;
	}
	
	/* Entry and Exit Codes */
	
	/* Action Codes */
	protected void action_TRANS_INITIAL_TO__closed() {
		System.out.println("Client Init !");
	}
	protected void action_TRANS_tr0_FROM_closed_TO_cp0_BY_openControlPort(InterfaceItemBase ifitem, DTcpControl data) {
		lastError=0;
		try{
		socket = new Socket(data.IPAddr,data.TcpPort);
		(new ClientRxThread(PayloadPort, socket)).start();
		out = socket.getOutputStream();
		}catch(IOException e){
		System.err.println(e.toString());
		lastError=1;
		}
	}
	protected void action_TRANS_tr1_FROM_opened_TO_closed_BY_closeControlPort(InterfaceItemBase ifitem) {
		try{
			if (socket!=null){
				socket.close();
			}
		} catch (IOException e){
		System.err.println(e.toString());
		}
	}
	protected void action_TRANS_tr2_FROM_cp0_TO_opened(InterfaceItemBase ifitem, DTcpControl data) {
		ControlPort.established();
	}
	protected void action_TRANS_socketError_FROM_cp0_TO_error_COND_socketError(InterfaceItemBase ifitem, DTcpControl data) {
		ControlPort.error();
		try{
		socket.close();
		} catch(IOException e){
		System.err.println(e.toString());
		}
	}
	protected void action_TRANS_tr3_FROM_opened_TO_opened_BY_sendPayloadPort_tr3(InterfaceItemBase ifitem, DTcpPayload data) {
		try{
			out.write(data.getData());
			}catch(IOException e){
				System.err.println(e.toString());
			}
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
				case STATE_closed:
					this.history[STATE_TOP] = STATE_closed;
					current = STATE_TOP;
					break;
				case STATE_opened:
					this.history[STATE_TOP] = STATE_opened;
					current = STATE_TOP;
					break;
				case STATE_error:
					this.history[STATE_TOP] = STATE_error;
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
			case CHAIN_TRANS_INITIAL_TO__closed:
			{
				action_TRANS_INITIAL_TO__closed();
				return STATE_closed;
			}
			case CHAIN_TRANS_tr0_FROM_closed_TO_cp0_BY_openControlPort:
			{
				DTcpControl data = (DTcpControl) generic_data;
				action_TRANS_tr0_FROM_closed_TO_cp0_BY_openControlPort(ifitem, data);
				if (lastError!=0) {
				action_TRANS_socketError_FROM_cp0_TO_error_COND_socketError(ifitem, data);
				return STATE_error;}
				else {
				action_TRANS_tr2_FROM_cp0_TO_opened(ifitem, data);
				return STATE_opened;}
			}
			case CHAIN_TRANS_tr1_FROM_opened_TO_closed_BY_closeControlPort:
			{
				action_TRANS_tr1_FROM_opened_TO_closed_BY_closeControlPort(ifitem);
				return STATE_closed;
			}
			case CHAIN_TRANS_tr3_FROM_opened_TO_opened_BY_sendPayloadPort_tr3:
			{
				DTcpPayload data = (DTcpPayload) generic_data;
				action_TRANS_tr3_FROM_opened_TO_opened_BY_sendPayloadPort_tr3(ifitem, data);
				return STATE_opened;
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
				case STATE_closed:
					// in leaf state: return state id
					return STATE_closed;
				case STATE_opened:
					// in leaf state: return state id
					return STATE_opened;
				case STATE_error:
					// in leaf state: return state id
					return STATE_error;
				case STATE_TOP:
					state = this.history[STATE_TOP];
					break;
			}
			skip_entry = false;
		}
		//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
	}
	
	public void executeInitTransition() {
		int chain = CHAIN_TRANS_INITIAL_TO__closed;
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
				case STATE_closed:
					switch(trigger) {
						case TRIG_ControlPort__open:
							{
								chain = CHAIN_TRANS_tr0_FROM_closed_TO_cp0_BY_openControlPort;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_opened:
					switch(trigger) {
						case TRIG_ControlPort__close:
							{
								chain = CHAIN_TRANS_tr1_FROM_opened_TO_closed_BY_closeControlPort;
								catching_state = STATE_TOP;
							}
						break;
						case TRIG_PayloadPort__send:
							{
								chain = CHAIN_TRANS_tr3_FROM_opened_TO_opened_BY_sendPayloadPort_tr3;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_error:
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
