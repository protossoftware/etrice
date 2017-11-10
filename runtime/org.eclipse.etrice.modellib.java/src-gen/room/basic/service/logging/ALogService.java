package room.basic.service.logging;

import org.eclipse.etrice.runtime.java.messaging.*;
import org.eclipse.etrice.runtime.java.modelbase.*;
import org.eclipse.etrice.runtime.java.debugging.*;

import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;

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

	//--------------------- optional actors

	//--------------------- interface item IDs
	public static final int IFITEM_log = 1;

	/*--------------------- attributes ---------------------*/

	/*--------------------- operations ---------------------*/
	public  void destroyUser() {
		if (p!= null) {
		p.flush();
		p.close();
		p=null;
		}
	}


	//--------------------- construction
	public ALogService(IRTObject parent, String name) {
		super(parent, name);
		setClassName("ALogService");

		// initialize attributes

		// own ports

		// own saps

		// own service implementations
		log = new LogReplPort(this, "log", IFITEM_log);

		// sub actors

		// wiring


		/* user defined constructor body */

	}

	/* --------------------- attribute setters and getters */


	//--------------------- port getters
	public LogReplPort getLog (){
		return this.log;
	}

	//--------------------- lifecycle functions
	public void stop(){
		super.stop();
	}

	public void destroy(){
		/* user defined destructor body */
		DebuggingService.getInstance().addMessageActorDestroy(this);
		super.destroy();
	}

	/* state IDs */
	public static final int STATE_closed = 2;
	public static final int STATE_opened = 3;
	public static final int STATE_MAX = 4;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__closed = 1;
	public static final int CHAIN_TRANS_open_FROM_closed_TO_opened_BY_openlog = 2;
	public static final int CHAIN_TRANS_tr0_FROM_opened_TO_closed_BY_closelog = 3;
	public static final int CHAIN_TRANS_tr1_FROM_opened_TO_opened_BY_internalLoglog_tr1 = 4;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_log__open = IFITEM_log + EVT_SHIFT*Log.IN_open;
	public static final int TRIG_log__close = IFITEM_log + EVT_SHIFT*Log.IN_close;
	public static final int TRIG_log__internalLog = IFITEM_log + EVT_SHIFT*Log.IN_internalLog;
	
	// state names
	protected static final String stateStrings[] = {
		"<no state>",
		"<top>",
		"closed",
		"opened"
	};
	
	// history
	protected int history[] = {NO_STATE, NO_STATE, NO_STATE, NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		this.state = new_state;
	}
	
	/* Entry and Exit Codes */
	
	/* Action Codes */
	protected void action_TRANS_open_FROM_closed_TO_opened_BY_openlog(InterfaceItemBase ifitem, String transitionData) {
	    Date d=new Date(tStart);
	    try{
	    file=new FileOutputStream(transitionData);
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
	protected void action_TRANS_tr1_FROM_opened_TO_opened_BY_internalLoglog_tr1(InterfaceItemBase ifitem, InternalLogData transitionData) {
	    p.println("Timestamp: " + Long.toString(transitionData.timeStamp-tStart) + "ms");
	    p.println("SenderInstance: "+ transitionData.sender);
	    p.println("UserString: " + transitionData.userString);
	    p.println("--------------------------------------------------");
	    System.out.printf(transitionData.userString);
	}
	
	/* State Switch Methods */
	/**
	 * calls exit codes while exiting from the current state to one of its
	 * parent states while remembering the history
	 * @param current__et - the current state
	 * @param to - the final parent state
	 */
	private void exitTo(int current__et, int to) {
		while (current__et!=to) {
			switch (current__et) {
				case STATE_closed:
					this.history[STATE_TOP] = STATE_closed;
					current__et = STATE_TOP;
					break;
				case STATE_opened:
					this.history[STATE_TOP] = STATE_opened;
					current__et = STATE_TOP;
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
	 * @param chain__et - the chain ID
	 * @param generic_data__et - the generic data pointer
	 * @return the +/- ID of the final state either with a positive sign, that indicates to execute the state's entry code, or a negative sign vice versa
	 */
	private int executeTransitionChain(int chain__et, InterfaceItemBase ifitem, Object generic_data__et) {
		switch (chain__et) {
			case ALogService.CHAIN_TRANS_INITIAL_TO__closed:
			{
				return STATE_closed;
			}
			case ALogService.CHAIN_TRANS_open_FROM_closed_TO_opened_BY_openlog:
			{
				String transitionData = (String) generic_data__et;
				action_TRANS_open_FROM_closed_TO_opened_BY_openlog(ifitem, transitionData);
				return STATE_opened;
			}
			case ALogService.CHAIN_TRANS_tr0_FROM_opened_TO_closed_BY_closelog:
			{
				action_TRANS_tr0_FROM_opened_TO_closed_BY_closelog(ifitem);
				return STATE_closed;
			}
			case ALogService.CHAIN_TRANS_tr1_FROM_opened_TO_opened_BY_internalLoglog_tr1:
			{
				InternalLogData transitionData = (InternalLogData) generic_data__et;
				action_TRANS_tr1_FROM_opened_TO_opened_BY_internalLoglog_tr1(ifitem, transitionData);
				return STATE_opened;
			}
				default:
					/* should not occur */
					break;
		}
		return NO_STATE;
	}
	
	/**
	 * calls entry codes while entering a state's history. The ID of the final leaf state is returned
	 * @param state__et - the state which is entered
	 * @return - the ID of the final leaf state
	 */
	private int enterHistory(int state__et) {
		if (state__et >= STATE_MAX) {
			state__et =  (state__et - STATE_MAX);
		}
		while (true) {
			switch (state__et) {
				case STATE_closed:
					/* in leaf state: return state id */
					return STATE_closed;
				case STATE_opened:
					/* in leaf state: return state id */
					return STATE_opened;
				case STATE_TOP:
					state__et = this.history[STATE_TOP];
					break;
				default:
					/* should not occur */
					break;
			}
		}
		/* return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true) */
	}
	
	public void executeInitTransition() {
		int chain__et = ALogService.CHAIN_TRANS_INITIAL_TO__closed;
		int next__et = executeTransitionChain(chain__et, null, null);
		next__et = enterHistory(next__et);
		setState(next__et);
	}
	
	/* receiveEvent contains the main implementation of the FSM */
	public void receiveEventInternal(InterfaceItemBase ifitem, int localId, int evt, Object generic_data__et) {
		int trigger__et = localId + EVT_SHIFT*evt;
		int chain__et = NOT_CAUGHT;
		int catching_state__et = NO_STATE;
	
		if (!handleSystemEvent(ifitem, evt, generic_data__et)) {
			switch (getState()) {
				case STATE_closed:
					switch(trigger__et) {
						case TRIG_log__open:
							{
								chain__et = ALogService.CHAIN_TRANS_open_FROM_closed_TO_opened_BY_openlog;
								catching_state__et = STATE_TOP;
							}
						break;
						default:
							/* should not occur */
							break;
					}
					break;
				case STATE_opened:
					switch(trigger__et) {
						case TRIG_log__close:
							{
								chain__et = ALogService.CHAIN_TRANS_tr0_FROM_opened_TO_closed_BY_closelog;
								catching_state__et = STATE_TOP;
							}
						break;
						case TRIG_log__internalLog:
							{
								chain__et = ALogService.CHAIN_TRANS_tr1_FROM_opened_TO_opened_BY_internalLoglog_tr1;
								catching_state__et = STATE_TOP;
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
		if (chain__et != NOT_CAUGHT) {
			exitTo(getState(), catching_state__et);
			{
				int next__et = executeTransitionChain(chain__et, ifitem, generic_data__et);
				next__et = enterHistory(next__et);
				setState(next__et);
			}
		}
	}
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object generic_data__et) {
		int localId = (ifitem==null)? 0 : ifitem.getLocalId();
		receiveEventInternal(ifitem, localId, evt, generic_data__et);
	}

};
