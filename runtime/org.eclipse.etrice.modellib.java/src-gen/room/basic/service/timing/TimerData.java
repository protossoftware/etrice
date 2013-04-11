package room.basic.service.timing;

import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;




public class TimerData {
	
	
	/*--------------------- attributes ---------------------*/
	int time;
	int id;
	
	/* --------------------- attribute setters and getters */
	public void setTime (int time) {
		 this.time = time;
	}
	public int getTime () {
		return this.time;
	}
	public void setId (int id) {
		 this.id = id;
	}
	public int getId () {
		return this.id;
	}
	
	/*--------------------- operations ---------------------*/
	
	// default constructor
	public TimerData() {
		super();
		
		// initialize attributes
	}
	
	// constructor using fields
	public TimerData(int time, int id) {
		super();
		
		this.time = time;
		this.id = id;
	}
	
	// deep copy
	public TimerData deepCopy() {
		TimerData copy = new TimerData();
		copy.time = time;
		copy.id = id;
		return copy;
	}
};
