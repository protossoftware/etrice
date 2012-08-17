package room.basic.service.logging;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;


import room.basic.service.logging.Log.*;

/*--------------------- begin user code ---------------------*/
import java.io.*;
import java.util.*;
/*--------------------- end user code ---------------------*/


public class ALogService extends ActorClassBase {

	/*--------------------- begin user code ---------------------*/
	FileOutputStream file = null;
	PrintStream p = null;
	static long tStart = System.currentTimeMillis();
	/*--------------------- end user code ---------------------*/
	
	//--------------------- ports
	
	//--------------------- saps
	
	//--------------------- services
	protected LogReplPort log = null;

	//--------------------- interface item IDs
	public static final int IFITEM_log = 1;
		
	/*--------------------- attributes ---------------------*/
	/*--------------------- operations ---------------------*/
	public void destroyUser() {
		if (p!= null) {
		p.flush();
		p.close();
		p=null;
		}
	}

	//--------------------- construction
	public ALogService(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){
		super(parent, name, port_addr[0][0], peer_addr[0][0]);
		setClassName("ALogService");
		
		// initialize attributes

		// own ports
		
		// own saps
		
		// own service implementations
		log = new LogReplPort(this, "log", IFITEM_log, port_addr[IFITEM_log], peer_addr[IFITEM_log]); 
	}
	//--------------------- attribute setters and getters
	//--------------------- port getters
	public LogReplPort getLog (){
		return this.log;
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
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__closed = 1;
	public static final int CHAIN_TRANS_open_FROM_closed_TO_opened_BY_openlog = 2;
	public static final int CHAIN_TRANS_tr0_FROM_opened_TO_closed_BY_closelog = 3;
	public static final int CHAIN_TRANS_tr1_FROM_opened_TO_opened_BY_internalLoglog_tr1 = 4;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_log__close = IFITEM_log + EVT_SHIFT*Log.IN_close;
	public static final int TRIG_log__internalLog = IFITEM_log + EVT_SHIFT*Log.IN_internalLog;
	public static final int TRIG_log__open = IFITEM_log + EVT_SHIFT*Log.IN_open;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","closed",
	"opened"
	};
	
	// history
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE,NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		if (stateStrings[new_state]!="Idle") {
			System.out.println(getInstancePath() + " -> " + stateStrings[new_state]);
		}	
		this.state = new_state;
	}
	
	/* Entry and Exit Codes */
	
	/* Action Codes */
	protected void action_TRANS_open_FROM_closed_TO_opened_BY_openlog(InterfaceItemBase ifitem, String fileName) {
		Date d=new Date(tStart);
		try{
		file=new FileOutputStream(fileName);
		p=new PrintStream(file);
		p.println("Log opened at "+ d.toString());
		p.println("--------------------------------------------------");
		} catch (Exception e){
		System.out.println("Log file not opened !");
		}
	}
	protected void action_TRANS_tr0_FROM_opened_TO_closed_BY_closelog(InterfaceItemBase ifitem) {
		p.flush();
		p.close();
		p=null;
	}
	protected void action_TRANS_tr1_FROM_opened_TO_opened_BY_internalLoglog_tr1(InterfaceItemBase ifitem, InternalLogData data) {
		p.println("Timestamp: " + Long.toString(data.timeStamp-tStart) + "ms");
		p.println("SenderInstance: "+ data.sender);
		p.println("UserString: " + data.userString);
		p.println("--------------------------------------------------");
		System.out.printf(data.userString);
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
				return STATE_closed;
			}
			case CHAIN_TRANS_open_FROM_closed_TO_opened_BY_openlog:
			{
				String fileName = (String) generic_data;
				action_TRANS_open_FROM_closed_TO_opened_BY_openlog(ifitem, fileName);
				return STATE_opened;
			}
			case CHAIN_TRANS_tr0_FROM_opened_TO_closed_BY_closelog:
			{
				action_TRANS_tr0_FROM_opened_TO_closed_BY_closelog(ifitem);
				return STATE_closed;
			}
			case CHAIN_TRANS_tr1_FROM_opened_TO_opened_BY_internalLoglog_tr1:
			{
				InternalLogData data = (InternalLogData) generic_data;
				action_TRANS_tr1_FROM_opened_TO_opened_BY_internalLoglog_tr1(ifitem, data);
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
						case TRIG_log__open:
							{
								chain = CHAIN_TRANS_open_FROM_closed_TO_opened_BY_openlog;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_opened:
					switch(trigger) {
						case TRIG_log__close:
							{
								chain = CHAIN_TRANS_tr0_FROM_opened_TO_closed_BY_closelog;
								catching_state = STATE_TOP;
							}
						break;
						case TRIG_log__internalLog:
							{
								chain = CHAIN_TRANS_tr1_FROM_opened_TO_opened_BY_internalLoglog_tr1;
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
