package room.basic.service.logging;

import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;




public class InternalLogData {
	
	
	/*--------------------- attributes ---------------------*/
	String userString;
	String sender;
	long timeStamp;
	
	//--------------------- attribute setters and getters
	public void setUserString (String userString) {
		 this.userString = userString;
	}
	public String getUserString () {
		return this.userString;
	}
	public void setSender (String sender) {
		 this.sender = sender;
	}
	public String getSender () {
		return this.sender;
	}
	public void setTimeStamp (long timeStamp) {
		 this.timeStamp = timeStamp;
	}
	public long getTimeStamp () {
		return this.timeStamp;
	}
	
	/*--------------------- operations ---------------------*/
	
	// default constructor
	public InternalLogData() {
		super();
		
		// initialize attributes
		this.setUserString("");
		this.setSender("");
	}
	
	// constructor using fields
	public InternalLogData(String userString, String sender, long timeStamp) {
		super();
		
		this.userString = userString;
		this.sender = sender;
		this.timeStamp = timeStamp;
	}
	
	// deep copy
	public InternalLogData deepCopy() {
		InternalLogData copy = new InternalLogData();
		copy.userString = userString;
		copy.sender = sender;
		copy.timeStamp = timeStamp;
		return copy;
	}
};
