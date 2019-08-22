package etrice.api.timer;

import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;
import java.io.Serializable;
import java.util.Objects;




public class TimerData implements Serializable {

	private static final long serialVersionUID = -1450140988L;


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
	
	// deep equals
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if(other == null || this.getClass() != other.getClass()) {
			return false;
		}
	
		TimerData casted = (TimerData) other;
		return Objects.deepEquals(this.time, casted.time) && Objects.deepEquals(this.id, casted.id);
	}
	
	// deep hashCode
	@Override
	public int hashCode() {
		return Objects.hash(this.time, this.id);
	}
};
