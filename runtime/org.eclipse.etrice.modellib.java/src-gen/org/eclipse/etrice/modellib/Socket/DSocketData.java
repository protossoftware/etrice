package org.eclipse.etrice.modellib.Socket;

import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;




public class DSocketData {
	
	
	/*--------------------- attributes ---------------------*/
	int size;
	String data;
	
	//--------------------- attribute setters and getters
	public void setSize (int size) {
		 this.size = size;
	}
	public int getSize () {
		return this.size;
	}
	public void setData (String data) {
		 this.data = data;
	}
	public String getData () {
		return this.data;
	}
	
	/*--------------------- operations ---------------------*/
	
	// default constructor
	public DSocketData() {
		super();
		
		// initialize attributes
		this.setData("");
	}
	
	// constructor using fields
	public DSocketData(int size, String data) {
		super();
		
		this.size = size;
		this.data = data;
	}
	
	// deep copy
	public DSocketData deepCopy() {
		DSocketData copy = new DSocketData();
		copy.size = size;
		copy.data = data;
		return copy;
	}
};
