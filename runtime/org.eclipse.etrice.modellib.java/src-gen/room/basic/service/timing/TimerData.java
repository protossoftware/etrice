package room.basic.service.timing;

import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;
import java.io.Serializable;




public class TimerData implements Serializable {

	private static final long serialVersionUID = 633780889L;


	/*--------------------- attributes ---------------------*/
	public  int time;
	public  int id;

	/* --------------------- attribute setters and getters */
	public void setTime(int time) {
		 this.time = time;
	}
	public int getTime() {
		return this.time;
	}
	public void setId(int id) {
		 this.id = id;
	}
	public int getId() {
		return this.id;
	}

	/*--------------------- operations ---------------------*/

	// default constructor
	public TimerData() {
		super();

		// initialize attributes

		/* user defined constructor body */
	}

	// constructor using fields
	public TimerData(int time, int id) {
		super();

		this.time = time;
		this.id = id;

		/* user defined constructor body */
	}

	// deep copy
	public TimerData deepCopy() {
		TimerData copy = new TimerData();
		copy.time = time;
		copy.id = id;
		return copy;
	}
};
